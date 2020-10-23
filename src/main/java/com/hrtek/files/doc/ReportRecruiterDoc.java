package com.hrtek.files.doc;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.hrtek.user.report.views.ReportRecruiters;

public class ReportRecruiterDoc implements Doc<Workbook> {

	private Workbook wb = new HSSFWorkbook();  
	private DocType doctype = DocType.EXCELRAPORT;
	private List<ReportRecruiters> rp_list;
	
	@Override
	public void prepareDoc() {
		int rownum = 0;
		Sheet sheet = wb.createSheet("Report");
		sheet.setColumnWidth(0, 1500);
		sheet.setColumnWidth(1, 5000);
		sheet.setColumnWidth(2, 5000);
		sheet.setColumnWidth(3, 5000);
		sheet.setColumnWidth(4, 5000);
		sheet.setColumnWidth(5, 4200);
		Row header = sheet.createRow(rownum);
		prepareHeader(header);
		
		
		for(ReportRecruiters rp : rp_list) {
			rownum++;
			Row row = sheet.createRow(rownum);
			perpareRow(row, rp , rownum);
		}		
	}
	
	private void perpareRow(Row row, ReportRecruiters rp, int i) {
		CellStyle datestyle = wb.createCellStyle();
		CreationHelper createHelper = wb.getCreationHelper();
		short dateFormat = createHelper.createDataFormat().getFormat("yyyy-dd-MM");
		datestyle.setDataFormat(dateFormat);
		datestyle.setShrinkToFit(true);
		
		Cell cell0 = row.createCell(0);
		cell0.setCellValue(i);
		
		Cell cell1 = row.createCell(1);
		cell1.setCellValue(rp.getRfirstname());
		
		Cell cell2 = row.createCell(2);
		cell2.setCellValue(rp.getRlastname());
		
		Cell cell3 = row.createCell(3);
		cell3.setCellValue(rp.getWfirstname());
		
		Cell cell4 = row.createCell(4);
		cell4.setCellValue(rp.getWlastname());
		
		Cell cell5 = row.createCell(5);
		cell5.setCellStyle(datestyle);
		cell5.setCellValue(rp.getAddtosystem());
		

	}
	
	private void prepareHeader(Row row) {
		CellStyle headerStyle = wb.createCellStyle();
		headerStyle.setBorderBottom(BorderStyle.THIN);
		headerStyle.setBorderLeft(BorderStyle.THIN);
		headerStyle.setBorderRight(BorderStyle.THIN);
		headerStyle.setBorderTop(BorderStyle.THIN);

		headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		
		
		String headers[] = {"Lp.", "Recruiter name", "Recruiter surname", "Worker name", "Worker surename", "date" };
		Cell cells[] = new Cell[headers.length];
		
		for(int i = 0; i < cells.length; i++) {
			cells[i] = row.createCell(i);
			cells[i].setCellValue(headers[i]);
			cells[i].setCellStyle(headerStyle);	
		}
	}
	
	public ReportRecruiterDoc() {
	}

	public ReportRecruiterDoc(List<ReportRecruiters> rp_list) {
		this.rp_list = rp_list;
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
		return "Report_withPesel.xls";
	}

	@Override
	public DocType getType() {
		return this.doctype;
	}





}
