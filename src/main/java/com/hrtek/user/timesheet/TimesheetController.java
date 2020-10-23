package com.hrtek.user.timesheet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/timesheet")
public class TimesheetController {
	
	@Autowired
	private TimesheetService timesheetService;
	
	private static final String[] hoursV = {"12","08","00","NW", "HO","11","10","09","08","07","06","05","04","03","02","01","24","23","22","21","20","19","18","17","16","15","14","13"};

	@GetMapping
	public String totimesheets(Model model) {
		timesheetService.setModel(model);		
		return "user/timesheet/timesheet";
	}
	
	@GetMapping("/{id}")
	String toFactoryTimesheet(@PathVariable("id") Long id, Model model) {
		setModel(model, 0, id, true);
		return "user/timesheet/factorytimesheet";
	}
	
	@GetMapping("/{mon}/{id}")
	String toFactoryTimesheet(@PathVariable("mon")int mon, @PathVariable("id") Long id, Model model) {
		
		setModel(model, mon, id, true);
		return "user/timesheet/factorytimesheet";
	}
	
	@PostMapping(params = "save")
	public String saveRecord(MonthFrom mf, Model model, HttpSession session) {
		WorkerMonthValidator validator = new WorkerMonthValidator(mf);
	
		if(!validator.validate()) {
			model.addAttribute("message", "Wrong value");
		}else {
			timesheetService.saveTimesheet(mf, session);
		}
	
		
		setModel(model, mf.getMon(), mf.getFactoryid(), true);
		return "user/timesheet/factorytimesheet";
	}
	
	@PostMapping(params = "fill")
	public String fillRecord(MonthFrom mf, Model model, HttpSession session) {
		setModel(model, mf.getMon(), mf.getFactoryid(), false);
		
		FactoryView fv = timesheetService.getFactoryTimesheetView(mf.getFactoryid(), mf.getMon());
		fv = timesheetService.fillTweleve(fv, mf.getWorkerid());
		model.addAttribute("fv", fv);
		return "user/timesheet/factorytimesheet";
	}
	
	private void setModel(Model model, int mon, Long id, boolean gettimesheet) {
		timesheetService.setModel(model);
		if(gettimesheet == true)
			model.addAttribute("fv", timesheetService.getFactoryTimesheetView(id, mon));
		model.addAttribute("mon", mon);
		model.addAttribute("hoursV", hoursV);
		
		DateTimesheetOperation dts = new DateTimesheetOperation(mon);
		model.addAttribute("previousIsPossible", dts.previousIsPossible());
		model.addAttribute("nextIsPossible", dts.nextIsPossible());
		model.addAttribute("year", dts.getYear());
		model.addAttribute("month", dts.getMonth());
		model.addAttribute("monLen", dts.getMonthLength());
		
	}

}
