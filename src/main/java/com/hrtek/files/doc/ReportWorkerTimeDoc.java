package com.hrtek.files.doc;

import com.hrtek.user.report.views.ReportWorkTime;
import com.hrtek.user.report.views.ReportWorkerNote;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.util.List;


public class ReportWorkerTimeDoc implements Doc<Workbook> {

	private Workbook wb = new HSSFWorkbook();
	private DocType doctype = DocType.EXCELRAPORT;
	private List<ReportWorkTime> rp_list;

	@Override
	public void prepareDoc() {
		int rownum = 0;
		Sheet sheet = wb.createSheet("Report");
		sheet.setColumnWidth(0, 1500);
		sheet.setColumnWidth(1, 5000);
		sheet.setColumnWidth(2, 5000);
		sheet.setColumnWidth(3, 5000);
		sheet.setColumnWidth(4, 5000);
		Row header = sheet.createRow(rownum);
		prepareHeader(header);


		for(ReportWorkTime rp : rp_list) {
			rownum++;
			Row row = sheet.createRow(rownum);
			perpareRow(row, rp , rownum);
		}
	}

	private void perpareRow(Row row, ReportWorkTime rp, int i) {
		Cell cell0 = row.createCell(0);
		cell0.setCellValue(i);

		Cell cell1 = row.createCell(1);
		cell1.setCellValue(rp.getFirstname());

		Cell cell2 = row.createCell(2);
		cell2.setCellValue(rp.getLastname());

		Cell cell3 = row.createCell(3);
		cell3.setCellValue(rp.getCompany());

		Cell cell4 = row.createCell(4);
		cell4.setCellValue(rp.getMonths() + " months and " + rp.getDays() + " days");
	}

	private void prepareHeader(Row row) {
		CellStyle headerStyle = wb.createCellStyle();
		headerStyle.setBorderBottom(BorderStyle.THIN);
		headerStyle.setBorderLeft(BorderStyle.THIN);
		headerStyle.setBorderRight(BorderStyle.THIN);
		headerStyle.setBorderTop(BorderStyle.THIN);


		headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);



		String headers[] = {"Lp.", "Name", "Surname", "Company", "cos tam" };
		Cell cells[] = new Cell[headers.length];

		for(int i = 0; i < cells.length; i++) {
			cells[i] = row.createCell(i);
			cells[i].setCellValue(headers[i]);
			cells[i].setCellStyle(headerStyle);
		}
	}


	public ReportWorkerTimeDoc() {
	}

	public ReportWorkerTimeDoc(List<ReportWorkTime> rp_list) {
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
		return "Report_WorkTime.xls";
	}

	@Override
	public DocType getType() {
		return this.doctype;
	}

	public Workbook getWb() {
		return wb;
	}

	public void setWb(Workbook wb) {
		this.wb = wb;
	}

	public DocType getDoctype() {
		return doctype;
	}

	public void setDoctype(DocType doctype) {
		this.doctype = doctype;
	}

	public List<ReportWorkTime> getRp_list() {
		return rp_list;
	}

	public void setRp_list(List<ReportWorkTime> rp_list) {
		this.rp_list = rp_list;
	} 
}
