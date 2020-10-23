package com.hrtek.user.display.service;

import java.util.Collections;
import java.util.List;

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

}
