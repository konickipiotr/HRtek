package com.hrtek.user.timesheet;

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

	@GetMapping
	public String totimesheets(Model model) {
		timesheetService.setModel(model);		
		return "user/timesheet/timesheet";
	}
	
	@GetMapping("/{id}")
	String toFactoryTimesheet(@PathVariable("id") Long id, Model model) {
		setModel(model, 0, id);
		return "user/timesheet/factorytimesheet";
	}
	
	@GetMapping("/{mon}/{id}")
	String toFactoryTimesheet(@PathVariable("mon")int mon, @PathVariable("id") Long id, Model model) {
		
		setModel(model, mon, id);
		return "user/timesheet/factorytimesheet";
	}
	

	
	@PostMapping
	public String saveRecord(MonthFrom mf, Model model) {
		WorkerMonthValidator validator = new WorkerMonthValidator(mf);
		if(!validator.validate()) {
			model.addAttribute("message", validator.getMessge());
		}else{
			timesheetService.saveTimesheet(mf);
		}
		setModel(model, mf.getMon(), mf.getFactoryid());
		return "user/timesheet/factorytimesheet";
	}
	
	private void setModel(Model model, int mon, Long id) {
		timesheetService.setModel(model);
		model.addAttribute("fv", timesheetService.getFactoryTimesheetView(id, mon));
		model.addAttribute("mon", mon);
		
		DateTimesheetOperation dts = new DateTimesheetOperation(mon);
		model.addAttribute("previousIsPossible", dts.previousIsPossible());
		model.addAttribute("nextIsPossible", dts.nextIsPossible());
		model.addAttribute("year", dts.getYear());
		model.addAttribute("month", dts.getMonth());
		model.addAttribute("monLen", dts.getMonthLength());
		
	}

}
