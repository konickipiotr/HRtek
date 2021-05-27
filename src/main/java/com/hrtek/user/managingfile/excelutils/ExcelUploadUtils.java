package com.hrtek.user.managingfile.excelutils;

import com.hrtek.user.managingfile.ListWrapper;
import com.hrtek.user.managingfile.FactoryElement;
import com.hrtek.user.managingfile.WorkerRecord;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class ExcelUploadUtils {

    private int rowNum = 0;
    private int nettoCel = -1;

    public void fillWrapper(ListWrapper<FactoryElement> wrapper, MultipartFile file) throws IOException {

        try {
            ZipSecureFile.setMinInflateRatio(0);
            Workbook workbook = new XSSFWorkbook(file.getInputStream());
            workbook.setMissingCellPolicy(Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
            Sheet sheet = workbook.getSheetAt(0);

            nettoCel = findNettoCol(sheet);
            if(nettoCel < 0)
                throw new ParseExcelFileException("Not found netto column");


            Map<String, List<Row>> fMap = createListExistingFactories(wrapper);
            if(fMap.isEmpty())
                return;

            groupData(fMap, sheet);
            processData(fMap, wrapper);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void processData(Map<String, List<Row>> fMap, ListWrapper<FactoryElement> wrapper){
        List<FactoryElement> list = wrapper.getList();

        for(FactoryElement el : list){
            if(fMap.containsKey(el.getFactoryName())){
                List<Row> rowList = fMap.get(el.getFactoryName());
                List<WorkerRecord> records = el.getRecords();
                process2(rowList, records);
            }
        }
    }

    private void process2(List<Row> rows, List<WorkerRecord> records){
        for(WorkerRecord wr : records){
            String[] splitNameR = wr.getName().toLowerCase().split(" ");
            if(splitNameR.length == 0) continue;
            for(Row row: rows){
                if(!doNamesMatch(splitNameR, row))
                    continue;

                Cell cell = row.getCell(nettoCel);
                if(cell == null) break;
                if(!cell.getCellType().equals(CellType.NUMERIC)) break;

                BigDecimal netto = BigDecimal.valueOf(cell.getNumericCellValue());
                wr.setSalary(netto);
                break;
            }
        }
    }

    private boolean doNamesMatch(String[] splitNameR, Row row){
        Cell cell = row.getCell(2);
        if(cell == null) return false;
        String fileName = cell.getStringCellValue().toLowerCase();

        if(splitNameR.length == 1){
            return fileName.contains(splitNameR[0]);
        }else if(splitNameR.length == 2){
            boolean val1 = fileName.contains(splitNameR[0]);
            boolean val2 = fileName.contains(splitNameR[1]);

            if(val1 && val2) return true;
            else return false;
        }else if(splitNameR.length == 3){
            boolean val1 = fileName.contains(splitNameR[0]);
            boolean val2 = fileName.contains(splitNameR[1]);
            boolean val3 = fileName.contains(splitNameR[2]);

            if(val1 && val2 && val3) return true;
            else return false;
        }else if(splitNameR.length == 4){
            boolean val1 = fileName.contains(splitNameR[0]);
            boolean val2 = fileName.contains(splitNameR[1]);
            boolean val3 = fileName.contains(splitNameR[2]);
            boolean val4 = fileName.contains(splitNameR[3]);

            if(val1 && val2 && val3 && val4) return true;
            else return false;
        }
        return false;
    }

    private void groupData(Map<String, List<Row>> fMap, Sheet sheet){

        String currentFactory = "";
        int blankrows = 0;

        List<Row> rowList = new ArrayList<>();
        for(Row row : sheet){
            if(isNewLineFactory(row) && factoryRecognized(row, fMap)){
                if(!currentFactory.isBlank()){
                    fMap.put(currentFactory, rowList);
                }
                currentFactory = row.getCell(1).getStringCellValue();
                blankrows = 0;
                rowList = new ArrayList<>();
                continue;
            }

            Cell cell = row.getCell(1);
            if(cell == null || cell.getCellType().equals(CellType.BLANK)){
                if(blankrows > 5){
                    if(!currentFactory.isBlank()){
                        fMap.put(currentFactory, rowList);
                    }
                    break;
                }


                blankrows++;
                continue;
            }else {
                blankrows = 0;
                rowList.add(row);
            }
        }
    }

    private boolean factoryRecognized(Row row, Map<String, List<Row>> fMap){
        String factoryname = row.getCell(1).getStringCellValue();
        return fMap.containsKey(factoryname);
    }

    private Map<String, List<Row>> createListExistingFactories(ListWrapper<FactoryElement> wrapper){
        List<FactoryElement> list = wrapper.getList();
        Map<String, List<Row>> fMap= new HashMap<>();
        for(FactoryElement e : list){
            fMap.put(e.getFactoryName(), new ArrayList<>());
        }
        return fMap;
    }

    private int findNettoCol(Sheet sheet){
        Row row = sheet.getRow(0);
        for(int i = 0; i < 20; i++){
            Cell cell = row.getCell(i);
            if(cell == null || !cell.getCellType().equals(CellType.STRING))
                continue;
            if(cell.getStringCellValue().toLowerCase().equals("netto")){
                return i;
            }
        }
        return -1;
    }

    private boolean isNewLineFactory(Row row){
        Cell cell = row.getCell(1);
        if(cell == null) return false;

        CellType cellType = cell.getCellType();

        boolean correctPattern = true;
        if(!row.getCell(1).getCellType().equals(CellType.STRING)) return false;
        for(int i = 2; i < 7; i++){
            if(row.getCell(i) != null) return false;
        }
        return correctPattern;
    }
}
