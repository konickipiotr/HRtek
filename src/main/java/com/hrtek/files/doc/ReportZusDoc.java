package com.hrtek.files.doc;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.hrtek.user.report.views.ReportAccommodation;
import com.hrtek.user.report.views.ReportZus;

public class ReportZusDoc implements Doc<Workbook> {
	private Workbook wb = new HSSFWorkbook();  
	private DocType doctype = DocType.EXCELRAPORT;
	private List<ReportZus> rp_list;
	
	@Override
	public void prepareDoc() {
		int rownum = 0;
		Sheet sheet = wb.createSheet("Report");
		sheet.setColumnWidth(0, 1500);
		sheet.setColumnWidth(1, 4000);
		sheet.setColumnWidth(2, 4000);
		sheet.setColumnWidth(3, 4000);
		sheet.setColumnWidth(4, 4000);
		sheet.setColumnWidth(5, 1800);
		sheet.setColumnWidth(6, 4000);
		sheet.setColumnWidth(7, 4000);
		sheet.setColumnWidth(8, 4000);
		sheet.setColumnWidth(9, 9000);
		sheet.setColumnWidth(10, 3500);
		sheet.setColumnWidth(11, 3500);
		sheet.setColumnWidth(12, 11000);
		Row header = sheet.createRow(rownum);
		prepareHeader(header);
		
		
		for(ReportZus rp : rp_list) {
			rownum++;
			Row row = sheet.createRow(rownum);
			perpareRow(row, rp , rownum);
		}		
	}
	
	private void perpareRow(Row row, ReportZus rp, int i) {
		CellStyle datestyle = wb.createCellStyle();
		CreationHelper createHelper = wb.getCreationHelper();
		short dateFormat = createHelper.createDataFormat().getFormat("yyyy-dd-MM");
		datestyle.setDataFormat(dateFormat);
		datestyle.setShrinkToFit(true);
		
		CellStyle toregister = wb.createCellStyle();
		toregister.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		toregister.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		CellStyle style = wb.createCellStyle();
		if(rp.getEndZus() == null) {
			style = toregister;
			datestyle.setFillForegroundColor(toregister.getFillForegroundColor());
			datestyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}
		
		Cell cell0 = row.createCell(0);
		cell0.setCellStyle(style);	
		cell0.setCellValue(i);
		
		Cell cell1 = row.createCell(1);
		cell1.setCellStyle(style);	
		cell1.setCellValue(rp.getCompany());
		
		Cell cell2 = row.createCell(2);
		cell2.setCellStyle(style);	
		cell2.setCellValue(rp.getFacotry());
		
		Cell cell3 = row.createCell(3);
		cell3.setCellStyle(style);	
		cell3.setCellValue(rp.getFirstname());
		
		Cell cell4 = row.createCell(4);
		cell4.setCellStyle(style);	
		cell4.setCellValue(rp.getLastname());
		
		Cell cell5 = row.createCell(5);
		cell5.setCellStyle(style);	
		cell5.setCellValue(rp.getSex());
		
		Cell cell6 = row.createCell(6);
		cell6.setCellStyle(datestyle);
		cell6.setCellValue(rp.getDateofbirth());
		
		Cell cell7 = row.createCell(7);
		cell7.setCellStyle(style);	
		cell7.setCellValue(rp.getPassport());
		
		Cell cell8 = row.createCell(8);
		cell8.setCellStyle(style);	
		cell8.setCellValue(rp.getPesel());
		
		Cell cell9 = row.createCell(9);
		cell9.setCellStyle(style);	
		cell9.setCellValue(rp.getAddress());
		
		Cell cell10 = row.createCell(10);
		cell10.setCellStyle(datestyle);
		cell10.setCellValue(rp.getStartZus());
		
		Cell cell11 = row.createCell(11);
		cell11.setCellStyle(datestyle);
		cell11.setCellValue(rp.getEndZus());
		
		Cell cell12 = row.createCell(12);
		cell12.setCellStyle(datestyle);
		cell12.setCellStyle(style);	
		cell12.setCellValue(rp.getType());
	
	}
	
	private void prepareHeader(Row row) {
		CellStyle headerStyle = wb.createCellStyle();
		headerStyle.setBorderBottom(BorderStyle.THIN);
		headerStyle.setBorderLeft(BorderStyle.THIN);
		headerStyle.setBorderRight(BorderStyle.THIN);
		headerStyle.setBorderTop(BorderStyle.THIN);
		
		byte[] rgb = new byte[3];
		rgb[0] = (byte) 196;
		rgb[0] = (byte) 196;
		rgb[0] = (byte) 196;

		headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		
		String headers[] = {"Lp.", "company", "Factory", "Name", "Surname", "Sex", "Date of birth", "passport", "pesel", "address", "start zus", "end zus", "info" };
		Cell cells[] = new Cell[headers.length];
		
		for(int i = 0; i < cells.length; i++) {
			cells[i] = row.createCell(i);
			cells[i].setCellValue(headers[i]);
			cells[i].setCellStyle(headerStyle);	
		}
	}

	@Override
	public Workbook getDoc() {
		return this.wb;
	}

	@Override
	public String getFilepath() {
		return "/tmp";
	}

	@Override
	public String getFilename() {
		return "Report_Zus_" + rp_list.get(0).getCompany() + "_" + rp_list.get(0).getFacotry() + ".xlsx";
	}

	@Override
	public DocType getType() {
		return this.doctype;
	}

	public ReportZusDoc() {
	}

	public ReportZusDoc(List<ReportZus> rp_list) {
		this.rp_list = rp_list;
	}
}
