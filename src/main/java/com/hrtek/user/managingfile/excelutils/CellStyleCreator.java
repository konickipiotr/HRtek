package com.hrtek.user.managingfile.excelutils;

import com.hrtek.model.worker.Worker;
import com.hrtek.user.managingfile.WorkerRecord;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.diagram.CTColors;

public class CellStyleCreator {

    private XSSFWorkbook workbook;

    public CellStyleCreator(XSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    public CellStyle getCellStyle(HrCellStyle hrCellStyle){

        switch (hrCellStyle){
            case HEADER: return headerStyle();
            case FACTORYHEADER: return factoryHeaderStyle();
            case CZ1: return cz1Style();
            case CZ2: return cz2Style();
            case SALARY: return salaryStyle();
            case SUNDAY: return sundayStyle();
            case SATURDAY: return saturdayStyle();
            case HOLIDAY: return holidayStyle();
            case WORKDAY: return workdayStyle();
            case FULLWORKDAY: return fullWorkdayStyle();
            case INPROCESS: return inProcessStyle();
            case ZUSSOONEND: return zusSoonEndStyle();
            case ZUSJUSTSTART: return zusJustStartStyle();
            case AGEBELLOW26: return below26Style();
            case MINUSVAL: return minusValStyle();
            case COMPANYHEADER: return companyHeaderStyle();
        }
        return standardStyle();
    }

    private CellStyle companyHeaderStyle(){
        CellStyle style = workbook.createCellStyle();

        style.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 18);
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);

        style.setAlignment(HorizontalAlignment.CENTER);

        style.setWrapText(false);
        return style;
    }



    private CellStyle minusValStyle(){
        CellStyle style = workbook.createCellStyle();

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 10);
        font.setColor(IndexedColors.RED.getIndex());
        style.setFont(font);

        style.setWrapText(false);
        return style;
    }

    private CellStyle sundayStyle(){
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 10);
        font.setColor(IndexedColors.RED.getIndex());
        style.setFont(font);

        style.setWrapText(false);
        return style;
    }

    private CellStyle saturdayStyle(){
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 10);
        font.setColor(IndexedColors.LIGHT_BLUE.getIndex());
        style.setFont(font);

        style.setWrapText(false);
        return style;
    }

    private CellStyle holidayStyle(){
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIME.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 10);
        style.setFont(font);

        style.setWrapText(false);
        return style;
    }

    private CellStyle fullWorkdayStyle(){
        CellStyle style = workbook.createCellStyle();

        style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 10);
        style.setFont(font);

        style.setWrapText(false);
        return style;
    }

    private CellStyle workdayStyle(){
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 10);
        style.setFont(font);

        style.setWrapText(false);
        return style;
    }

    private CellStyle below26Style(){
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 10);
        style.setFont(font);

        style.setWrapText(false);
        return style;
    }

    private CellStyle salaryStyle(){
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 10);
        style.setFont(font);

        style.setWrapText(false);
        return style;
    }

    private CellStyle zusSoonEndStyle(){
        XSSFCellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.CORAL.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 10);
        style.setFont(font);

        style.setWrapText(false);
        return style;
    }


    private CellStyle zusJustStartStyle(){
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 10);
        style.setFont(font);

        style.setWrapText(false);
        return style;
    }

    private CellStyle inProcessStyle(){
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 10);
        style.setFont(font);

        style.setWrapText(false);
        return style;
    }

    private CellStyle cz2Style(){
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 10);
        style.setFont(font);

        style.setWrapText(false);
        return style;
    }

    private CellStyle cz1Style(){
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.ROSE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 10);
        style.setFont(font);

        style.setWrapText(false);
        return style;
    }

    private CellStyle factoryHeaderStyle(){
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 14);
        font.setBold(true);
        style.setFont(font);

        style.setWrapText(false);
        return style;
    }

    private CellStyle headerStyle(){
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 10);
        font.setBold(true);
        style.setFont(font);

        style.setWrapText(true);
        return style;
    }

    private CellStyle standardStyle(){
        CellStyle style = workbook.createCellStyle();

        style.setWrapText(false);
        return style;
    }
}
