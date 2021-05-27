package com.hrtek.user.managingfile.excelutils;

import com.hrtek.settings.GlobalSettings;
import com.hrtek.settings.Msg;
import com.hrtek.user.managingfile.ListWrapper;
import com.hrtek.user.managingfile.FactoryElement;
import com.hrtek.user.managingfile.WorkerRecord;
import com.hrtek.user.timesheet.DateTimesheetOperation;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Map;


public class ExcelCreatorFileService {

    private XSSFWorkbook workbook;
    private Sheet sheet;
    private int rowNum;
    private CellStyleCreator cellStyleCreator;

    public ExcelCreatorFileService(){
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Workers");
        cellStyleCreator = new CellStyleCreator(workbook);
        rowNum = 0;
    }

    public String prepareExcelFileAndSave(ListWrapper<FactoryElement> wrapper, int monoffset){

        companyName(wrapper);
        for(FactoryElement element : wrapper.getList()){
            createFactorySection(element);
        }

        for(int i = 0; i < 54; i++)
            sheet.autoSizeColumn(i);

        createHeader(wrapper.getList().get(0));

        for(int i = 15; i < 54; i++)
            sheet.autoSizeColumn(i);

        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(5);
        sheet.autoSizeColumn(12);
        sheet.setColumnWidth(8, 2500);
        sheet.setColumnWidth(10, 2500);
        sheet.setColumnWidth(11, 2000);
        sheet.setColumnWidth(13, 3500);
        sheet.setColumnWidth(14, 1500);
        sheet.setColumnWidth(20, 2300);
        sheet.setColumnWidth(21, 2500);

        sheet.createFreezePane(0, 1);

        rowNum++;
        Row row = sheet.createRow(rowNum);

        return saveFile(workbook, monoffset);
    }

    private void companyName(ListWrapper<FactoryElement> wrapper){
        rowNum++;
        Row row = sheet.createRow(rowNum);
        createCell(row, 0, wrapper.getCompanyname(), cellStyleCreator.getCellStyle(HrCellStyle.COMPANYHEADER));
        sheet.addMergedRegion(new CellRangeAddress(rowNum,rowNum,0,20));
        row.setHeight((short) 600);
        rowNum++;
    }

    private void createHeader(FactoryElement element) {
        Row row = sheet.createRow(0);
        int col = 0;
        for(String s : Msg.mFileHeaders){
            createCell(row, col++, s, cellStyleCreator.getCellStyle(HrCellStyle.HEADER));
        }
        if(element == null)
            return;
        for(Map.Entry<Integer, String> e : element.getMonHeader().getDayH().entrySet()){
            String ss = Integer.toString(e.getKey()) + " " + e.getValue();
            if(e.getValue().equals("Sat"))
                createCell(row, col++, ss, cellStyleCreator.getCellStyle(HrCellStyle.SATURDAY));
            else if(e.getValue().equals("Sun"))
                createCell(row, col++, ss, cellStyleCreator.getCellStyle(HrCellStyle.SUNDAY));
            else
                createCell(row, col++, ss, cellStyleCreator.getCellStyle(HrCellStyle.HEADER));
        }
        row.setHeight((short) 700);
    }

    private void createFactorySection(FactoryElement me){

        rowNum++;
        Row row = sheet.createRow(rowNum);
        createCell(row, 0, me.getFactoryName(), cellStyleCreator.getCellStyle(HrCellStyle.FACTORYHEADER));
        sheet.addMergedRegion(new CellRangeAddress(rowNum,rowNum,0,2));
        rowNum++;

        int nr = 1;
        for(WorkerRecord wr : me.getRecords()){
            createContentRow(wr, nr);
            this.rowNum++;
            nr++;
        }

    }

    private void createContentRow(WorkerRecord wr, int nr){
        Row row = sheet.createRow(rowNum);

        int col = 0;
        createCell(row, col++, nr, cellStyleCreator.getCellStyle(HrCellStyle.STANDARD));
        createCell(row, col++, "S P", cellStyleCreator.getCellStyle(HrCellStyle.STANDARD)); //TODO
        createCell(row, col++, wr.getName(), cellStyleCreator.getCellStyle(HrCellStyle.STANDARD));
        createCell(row, col++, wr.getPesel(), cellStyleCreator.getCellStyle(HrCellStyle.STANDARD));
        createCell(row, col++, wr.getDateofbirth(), cellStyleCreator.getCellStyle(HrCellStyle.STANDARD));

        if(wr.isBelove26())
            createCell(row, col++, wr.getAge(), cellStyleCreator.getCellStyle(HrCellStyle.AGEBELLOW26));
        else
            createCell(row, col++, wr.getAge(), cellStyleCreator.getCellStyle(HrCellStyle.STANDARD));

        String startZus = wr.getStartZus();
        if(startZus.equals("IN PROGRESS")){
            createCell(row, col++, wr.getStartZus(), cellStyleCreator.getCellStyle(HrCellStyle.INPROCESS));
        }else if(wr.getStartZusStyle().equals(GlobalSettings.lightGreenCellColor)){
            createCell(row, col++, wr.getStartZus(), cellStyleCreator.getCellStyle(HrCellStyle.ZUSJUSTSTART));
        }else {
            createCell(row, col++, wr.getStartZus(), cellStyleCreator.getCellStyle(HrCellStyle.STANDARD));
        }

        String endZus = wr.getEndZus();
        if(endZus.equals("IN PROGRESS")){
            createCell(row, col++, wr.getEndZus(), cellStyleCreator.getCellStyle(HrCellStyle.INPROCESS));
        }else if(wr.getEndZusStyle().equals(GlobalSettings.lightRedCellColor)){
            createCell(row, col++, wr.getEndZus(), cellStyleCreator.getCellStyle(HrCellStyle.ZUSSOONEND));
        }else {
            createCell(row, col++, wr.getEndZus(), cellStyleCreator.getCellStyle(HrCellStyle.STANDARD));
        }


        createCell(row, col++, wr.getDocumentType(), cellStyleCreator.getCellStyle(HrCellStyle.STANDARD));
        createCell(row, col++, wr.getValidTo(), cellStyleCreator.getCellStyle(HrCellStyle.STANDARD));
        createCell(row, col++, wr.getSumOfHours(), cellStyleCreator.getCellStyle(HrCellStyle.STANDARD));
        createCell(row, col++, wr.getChosenHours(), cellStyleCreator.getCellStyle(HrCellStyle.STANDARD));
        createCell(row, col++, wr.getSuperplus(), cellStyleCreator.getCellStyle(HrCellStyle.STANDARD));

        if(wr.getSalary().doubleValue() < 0)
            createCell(row, col++, wr.getSalary(), cellStyleCreator.getCellStyle(HrCellStyle.MINUSVAL));
        else
            createCell(row, col++, wr.getSalary(), cellStyleCreator.getCellStyle(HrCellStyle.SALARY));

        if(wr.isBelove26())
            createCell(row, col++, wr.isBelove26(), cellStyleCreator.getCellStyle(HrCellStyle.AGEBELLOW26));
        else
            createCell(row, col++, wr.isBelove26(), cellStyleCreator.getCellStyle(HrCellStyle.STANDARD));

        createCell(row, col++, wr.getCz1(), cellStyleCreator.getCellStyle(HrCellStyle.CZ1));
        createCell(row, col++, wr.getCz2(), cellStyleCreator.getCellStyle(HrCellStyle.CZ2));
        createCell(row, col++, wr.getFlatcost(), cellStyleCreator.getCellStyle(HrCellStyle.STANDARD));
        createCell(row, col++, wr.getLoan(), cellStyleCreator.getCellStyle(HrCellStyle.STANDARD));
        createCell(row, col++, wr.getBonus(), cellStyleCreator.getCellStyle(HrCellStyle.STANDARD));
        createCell(row, col++, wr.getSalaryForm(), cellStyleCreator.getCellStyle(HrCellStyle.STANDARD));
        createCell(row, col++, wr.getResult(), cellStyleCreator.getCellStyle(HrCellStyle.STANDARD));

        for(String h : wr.getHourlList()){
            if(h.equals("HO"))
                createCell(row, col++, h , cellStyleCreator.getCellStyle(HrCellStyle.HOLIDAY));
            else if(h.equals("12"))
                createCell(row, col++, h , cellStyleCreator.getCellStyle(HrCellStyle.FULLWORKDAY));
            else if(h.equals("NW") || h.equals("XX"))
                createCell(row, col++, h , cellStyleCreator.getCellStyle(HrCellStyle.STANDARD));
            else
                createCell(row, col++, h , cellStyleCreator.getCellStyle(HrCellStyle.WORKDAY));
        }
    }

    private void createCell(Row row, int colNum, boolean val, CellStyle style){
        Cell cell = row.createCell(colNum);
        if(val){
            cell.setCellValue("YES");
            cell.setCellStyle(style);
        }
    }

    private void createCell(Row row, int colNum, String val, CellStyle style){
        Cell cell = row.createCell(colNum);
        cell.setCellValue(val);
        cell.setCellStyle(style);
    }

    private void createCell(Row row, int colNum, int val, CellStyle style){
        Cell cell = row.createCell(colNum);
        cell.setCellValue(val);
        cell.setCellStyle(style);
    }

    private void createCell(Row row, int colNum, BigDecimal val, CellStyle style){
        Cell cell = row.createCell(colNum);
        cell.setCellValue(val.setScale(2, RoundingMode.HALF_UP).doubleValue());
        cell.setCellStyle(style);
    }

    private String saveFile(Workbook workbook, int monoffset){
        String userName = System.getProperty("user.name");
        String hrtekpath = "/home/" + userName + GlobalSettings.hrtekRoot + "/tmp";

        LocalDate date = new DateTimesheetOperation(monoffset).getSelected();
        String filename = "managing_file_" + date.getYear() + "_" + date.getMonthValue() + ".xlsx";

        File currDir = new File(hrtekpath);
        if(!currDir.exists())
            currDir.mkdirs();
        String path = currDir.getAbsolutePath();
        String fileLocation = path + "/" + filename;

        FileOutputStream outputStream = null;


        try {
            outputStream = new FileOutputStream(fileLocation);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileLocation;
    }
}
