package com.hrtek.user.timesheet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hrtek.db.CompanyRepository;
import com.hrtek.db.DepartmentRepository;
import com.hrtek.db.FactoryRepository;
import com.hrtek.db.worker.TimesheetRepository;
import com.hrtek.db.worker.WorkerBasicRepository;
import com.hrtek.db.worker.WorkerFinanceRepository;
import com.hrtek.db.worker.WorkerRepository;
import com.hrtek.model.Company;
import com.hrtek.model.Department;
import com.hrtek.model.Factory;
import com.hrtek.model.ListModel;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;
import com.hrtek.model.worker.WorkerFinance;

@Service
public class TimesheetService {
	
	private FactoryRepository factoryRepo;
	private TimesheetRepository timesheetRepo;
	private WorkerRepository workerRepo;
	private WorkerBasicRepository workerBacicRepo;
	private DepartmentRepository departmentRepo;
	private WorkerFinanceRepository workerFinanceRepo; //  ???TO'
	private CompanyRepository companyRepo;
	
	@Autowired
	public TimesheetService(FactoryRepository factoryRepo, TimesheetRepository timesheetRepo,
			WorkerRepository workerRepo, WorkerBasicRepository workerBacicRepo, DepartmentRepository departmentRepo,
			WorkerFinanceRepository workerFinanceRepo, CompanyRepository companyRepo) {
		this.factoryRepo = factoryRepo;
		this.timesheetRepo = timesheetRepo;
		this.workerRepo = workerRepo;
		this.workerBacicRepo = workerBacicRepo;
		this.departmentRepo = departmentRepo;
		this.workerFinanceRepo = workerFinanceRepo;
		this.companyRepo = companyRepo;
	}

	public void setModel(Model model) {
		List<Factory> fac = factoryRepo.findAll();
		List<ListModel> factories = new ArrayList<ListModel>();
		for(Factory f : fac) {
			factories.add(new ListModel(f.getId(), f.getShortname()));
		}
		model.addAttribute("factories", factories);
	}
	
	public FactoryView getFactoryTimesheetView(Long id, int mon) {
		Optional<Factory> oFactory = factoryRepo.findById(id);
		if(oFactory.isEmpty()) {
			//TODO
		}
		Factory factory = oFactory.get();
		FactoryView fw = new FactoryView(factory);
		
		
		List<WorkerTimesheet> wts_list = new ArrayList<>();
		List<Timesheet> ts_list = timesheetRepo.findByFactoryid(id);
		DateTimesheetOperation dts = new DateTimesheetOperation(mon);
		TimesheetOperation tso = new TimesheetOperation(dts);
		
		for(Timesheet t : ts_list) {
			WorkerTimesheet wts = tso.getWorkerTimesheet(t);
			if(wts == null )
				continue;
			Worker w = workerRepo.findById(t.getWorkerid()).get();
			WorkerBasic wb = workerBacicRepo.findById(w.getId()).get();
			if(wb.getDepartment() != null) {
				Department dep = departmentRepo.findById(wb.getDepartment()).get();
				wts.setDepartment(dep.getDepartment());
			}else {
				wts.setDepartment("");
			}
						
			wts.setName(w.getName());
			double total = wts.getHsum() * factory.getHourlyrate();
			wts.setTotal(BigDecimal.valueOf(total).setScale(2, RoundingMode.HALF_UP).doubleValue());
			
			wts.setWorkernr(wb.getWorkerNo());
			Company company = this.companyRepo.findById(w.getCompanyid()).get();
			wts.setCompanyname(company.getShortname());
			wts_list.add(wts);
		}
		Collections.sort(wts_list);
		
		fw.setWts(wts_list);
		return fw;
	}
	
	public int getMonthLength(int mon) {
		return new DateTimesheetOperation(mon).getMonthLength();
	}

	
	public void saveTimesheet(MonthFrom mf, HttpSession session) {
		Timesheet ts = timesheetRepo.findById(mf.getWorkerid()).get();
	
		DateTimesheetOperation dts = new DateTimesheetOperation(mf.getMon());
		String syear = "y" + dts.getYear();

		String currentYear = ts.getCurrentYear(syear);
		StringBuilder sb = new StringBuilder();
		for(String s : mf.getHour()) {
			if(s.length() < 2)
				sb.append("0" + s);
			else
				sb.append(s);
		}
		
		String smonth = sb.toString();

		int firstOfMonth = dts.getFirstDayOfMonth();
		
		sb = new StringBuilder(currentYear);
		sb.replace(firstOfMonth * 2, (2 * firstOfMonth + 2 * dts.getMonthLength()), smonth);
		currentYear = sb.toString();
		
		ts.setCurrentYear(syear, currentYear);
		this.timesheetRepo.save(ts);

	}
	
	public FactoryView fillTweleve(FactoryView fv, Long workerid) {
		List<WorkerTimesheet> wts = fv.getWts();
		int worker_position = -1;
		for(int i = 0; i < wts.size(); i++) {
			if(wts.get(i).getId().equals(workerid)) {
				worker_position = i;
				break;
			}
		}
		
		WorkerTimesheet wtimeshet = wts.get(worker_position);
		List<String> hourlList = wtimeshet.getHourlList();
		for(int i = 0; i < hourlList.size(); i++) {
			if(hourlList.get(i).equals("XX")) continue;
			
			hourlList.set(i, "12");
		}
		List<Integer> integerHourList = TimesheetOperation.getIntegerHourList(hourlList);
		int sum = TimesheetOperation.calculateHours(integerHourList);
		
		wtimeshet.setHsum(sum);
		
		WorkerFinance wf = workerFinanceRepo.findById(workerid).get();
		double total = wf.getWage() * sum;
		wtimeshet.setTotal(BigDecimal.valueOf(total).setScale(2, RoundingMode.HALF_UP).doubleValue());
		
		
		wts.get(worker_position).setHourlList(hourlList);
		fv.setWts(wts);
		return fv;
	}
}
