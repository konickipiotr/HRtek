package com.hrtek.files.doc;

import com.hrtek.user.report.views.ReportWorkerNote;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.util.List;


public class ReportWorkerNoteDoc implements Doc<Workbook> {

	private Workbook wb = new HSSFWorkbook();
	private DocType doctype = DocType.EXCELRAPORT;
	private List<ReportWorkerNote> rp_list;

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


		for(ReportWorkerNote rp : rp_list) {
			rownum++;
			Row row = sheet.createRow(rownum);
			perpareRow(row, rp , rownum);
		}
	}

	private void perpareRow(Row row, ReportWorkerNote rp, int i) {
		Cell cell0 = row.createCell(0);
		cell0.setCellValue(i);

		Cell cell1 = row.createCell(1);
		cell1.setCellValue(rp.getFirstname());

		Cell cell2 = row.createCell(2);
		cell2.setCellValue(rp.getLastname());

		Cell cell3 = row.createCell(3);
		cell3.setCellValue(rp.getNote());
	}

	private void prepareHeader(Row row) {
		CellStyle headerStyle = wb.createCellStyle();
		headerStyle.setBorderBottom(BorderStyle.THIN);
		headerStyle.setBorderLeft(BorderStyle.THIN);
		headerStyle.setBorderRight(BorderStyle.THIN);
		headerStyle.setBorderTop(BorderStyle.THIN);


		headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);



		String headers[] = {"Lp.", "Name", "Surname", "Note" };
		Cell cells[] = new Cell[headers.length];

		for(int i = 0; i < cells.length; i++) {
			cells[i] = row.createCell(i);
			cells[i].setCellValue(headers[i]);
			cells[i].setCellStyle(headerStyle);
		}
	}


	public ReportWorkerNoteDoc() {
	}

	public ReportWorkerNoteDoc(List<ReportWorkerNote> rp_list) {
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
		return "Report_Notes.xls";
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

	public List<ReportWorkerNote> getRp_list() {
		return rp_list;
	}

	public void setRp_list(List<ReportWorkerNote> rp_list) {
		this.rp_list = rp_list;
	} 
}
