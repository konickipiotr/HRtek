package com.hrtek.user.display.service;

import java.util.Collections;
import java.util.List;

import com.hrtek.user.managingfile.WorkerRecord;
import com.hrtek.user.report.controllers.ReportWraper;
import com.hrtek.user.report.views.*;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import com.hrtek.admin.others.WorkerView;
import com.hrtek.model.Log;
import com.hrtek.user.display.views.BasicView;
import com.hrtek.user.display.views.ContactViewDis;
import com.hrtek.user.display.views.DataView;
import com.hrtek.user.display.views.DismissedView;
import com.hrtek.user.display.views.ResidencyView;
import com.hrtek.user.display.views.ViewFields;
import com.hrtek.user.display.views.WorkersView;

@Service
public class SortViewService {

	public List<BasicView> sortBasicView(ViewFields field, String sortT, List<BasicView> basicViewList) {
		BasicView.field = field;
		BasicView.isup = sortT.equals("up");
		Collections.sort(basicViewList);
		return basicViewList;
	}
	
	public List<WorkersView> sortWorkersView(ViewFields field, String sortT, List<WorkersView> workViewList) {
		WorkersView.field = field;
		WorkersView.isup = sortT.equals("up");
		Collections.sort(workViewList);
		return workViewList;
	}
	
	public List<ResidencyView> sortResidencyView(ViewFields field, String sortT, List<ResidencyView> residencyViewList) {
		ResidencyView.field = field;
		ResidencyView.isup = sortT.equals("up");
		Collections.sort(residencyViewList);
		return residencyViewList;
	}
	
	public List<ContactViewDis> sortContactView(ViewFields field, String sortT, List<ContactViewDis> contactViewList) {
		ContactViewDis.field = field;
		ContactViewDis.isup = sortT.equals("up");
		Collections.sort(contactViewList);
		return contactViewList;
	}
	
	public List<DataView> sortDateView(ViewFields field, String sortT, List<DataView> dateViewList) {
		DataView.field = field;
		DataView.isup = sortT.equals("up");
		Collections.sort(dateViewList);
		return dateViewList;
	}
	
	public List<DismissedView> sortDismissedView(ViewFields field, String sortT, List<DismissedView> dismissedViewList) {
		DismissedView.field = field;
		DismissedView.isup = sortT.equals("up");
		Collections.sort(dismissedViewList);
		return dismissedViewList;
	}
	
	public List<WorkerView> sortWorkerView(ViewFields field, String sortT, List<WorkerView> workerViewList) {
		WorkerView.field = field;
		WorkerView.isup = sortT.equals("up");
		Collections.sort(workerViewList);
		return workerViewList;
	}
	
	public List<Log> sortLogs(ViewFields field, String sortT, List<Log> loglist) {
		Log.field = field;
		Log.isup = sortT.equals("up");
		Collections.sort(loglist);
		return loglist;
	}

	public List<WorkerRecord> sortRecords(ViewFields field, String sortT, List<WorkerRecord> wrList) {
		WorkerRecord.field = field;
		WorkerRecord.isup = sortT.equals("up");
		Collections.sort(wrList);
		return wrList;
	}

	public void sortReportPesel(ViewFields field, String sortT, ReportWraper<ReportPesel> wrapper) {
		wrapper.setSortUp(sortT.equals("up") ? true: false);
		wrapper.setSortBy(field);
		ReportPesel.field = field;
		ReportPesel.isup = sortT.equals("up");
		Collections.sort(wrapper.getReport());
	}

	public void sortReportMedical(ViewFields field, String sortT, ReportWraper<ReportMedical> wrapper) {
		wrapper.setSortUp(sortT.equals("up") ? true: false);
		wrapper.setSortBy(field);
		ReportMedical.field = field;
		ReportMedical.isup = sortT.equals("up");
		Collections.sort(wrapper.getReport());
	}

	public void sortReportAccommodation(ViewFields field, String sortT, ReportWraper<ReportAccommodation> wrapper) {
		wrapper.setSortUp(sortT.equals("up") ? true: false);
		wrapper.setSortBy(field);
		ReportAccommodation.field = field;
		ReportAccommodation.isup = sortT.equals("up");
		Collections.sort(wrapper.getReport());
	}

	public void sortReportStartWork(ViewFields field, String sortT, ReportWraper<ReportStartWork> wrapper) {
		wrapper.setSortUp(sortT.equals("up") ? true: false);
		wrapper.setSortBy(field);
		ReportStartWork.field = field;
		ReportStartWork.isup = sortT.equals("up");
		Collections.sort(wrapper.getReport());
	}

	public void sortReportRecruiters(ViewFields field, String sortT, ReportWraper<ReportRecruiters> wrapper) {
		wrapper.setSortUp(sortT.equals("up") ? true: false);
		wrapper.setSortBy(field);
		ReportRecruiters.field = field;
		ReportRecruiters.isup = sortT.equals("up");
		Collections.sort(wrapper.getReport());
	}

	public void sortReportVisaWork(ViewFields field, String sortT, ReportWraper<ReportVisaWork> wrapper) {
		wrapper.setSortUp(sortT.equals("up") ? true: false);
		wrapper.setSortBy(field);
		ReportVisaWork.field = field;
		ReportVisaWork.isup = sortT.equals("up");
		Collections.sort(wrapper.getReport());
	}

	public void sortReportWorkerNote(ViewFields field, String sortT, ReportWraper<ReportWorkerNote> wrapper) {
		wrapper.setSortUp(sortT.equals("up") ? true: false);
		wrapper.setSortBy(field);
		ReportWorkerNote.field = field;
		ReportWorkerNote.isup = sortT.equals("up");
		Collections.sort(wrapper.getReport());
	}

	public void sortReportWorkTime(ViewFields field, String sortT, ReportWraper<ReportWorkTime> wrapper) {
		wrapper.setSortUp(sortT.equals("up") ? true: false);
		wrapper.setSortBy(field);
		ReportWorkTime.field = field;
		ReportWorkTime.isup = sortT.equals("up");
		Collections.sort(wrapper.getReport());
	}

	public void sortReportZus(ViewFields field, String sortT, ReportWraper<ReportZus> wrapper) {
		wrapper.setSortUp(sortT.equals("up") ? true: false);
		wrapper.setSortBy(field);
		ReportZus.field = field;
		ReportZus.isup = sortT.equals("up");
		Collections.sort(wrapper.getReport());
	}
}
