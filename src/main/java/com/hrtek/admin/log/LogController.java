package com.hrtek.admin.log;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrtek.db.LogRepository;
import com.hrtek.model.Log;
import com.hrtek.user.display.filters.BasicFilters;
import com.hrtek.user.display.filters.FilterProcess;
import com.hrtek.user.display.filters.basic.DateBasicOperation;
import com.hrtek.user.display.filters.basic.OtherBasicOperation;
import com.hrtek.user.display.filters.basic.TextBasicOperation;
import com.hrtek.user.display.service.SortViewService;
import com.hrtek.user.display.views.BasicShowedField;
import com.hrtek.user.display.views.BasicView;
import com.hrtek.user.display.views.ViewFields;

@Controller
@RequestMapping("/admin/logs")
public class LogController {

	@Autowired
	private LogService logService;
	@Autowired
	private SortViewService sortViewService;
	
	
	@GetMapping
	public String toLogs(Model model, HttpSession session) {
		List<Log> logs = logService.getAllLogsOrderByTimestamp();
		session.setAttribute("logs", logs);
		model.addAttribute("logs", logs);
		model.addAttribute("logFilter", new LogFilter());
		model.addAttribute("emplyees", logService.getEmployeeList());
		return "admin/logs";
	}
	
	@PostMapping(path = "/filter", params = "filter=next")
	public String filterNext(LogFilter bf,  HttpSession session, Model model) {
		List<Log> logs = (List<Log>) session.getAttribute("logs");
		logs = new FilterProcess<Log, LogFilter>( bf)
				.setTextOpertation(new TextLogOperation())
				.setDateOperation(new DateLogOperation())
				.setOtherFiletrOperation(new OtherLogOperation())
				.filter(logs);
		session.setAttribute("logs", logs);
		model.addAttribute("logs", logs);
		model.addAttribute("logFilter", bf);
		model.addAttribute("emplyees", logService.getEmployeeList());
		return "admin/logs";
	}
	
	@PostMapping(path = "/filter", params = "filter=new")
	public String filterNew(LogFilter bf,  HttpSession session, Model model) {
		List<Log> logs = logService.getAllLogsOrderByTimestamp();
		logs = new FilterProcess<Log, LogFilter>( bf)
				.setTextOpertation(new TextLogOperation())
				.setDateOperation(new DateLogOperation())
				.setOtherFiletrOperation(new OtherLogOperation())
				.filter(logs);
		session.setAttribute("logs", logs);
		model.addAttribute("logs", logs);
		model.addAttribute("logFilter", bf);
		model.addAttribute("emplyees", logService.getEmployeeList());
		return "admin/logs";
	}
	
	@PostMapping(path = "/sort", params = "sortT=up")
	public String sortUpList(@RequestParam("field") ViewFields field, HttpSession session, Model model) {
		List<Log> logs = (List<Log>) session.getAttribute("logs");
		logs = sortViewService.sortLogs(field, "up", logs);
		model.addAttribute("logs", logs);
		model.addAttribute("logFilter", new LogFilter());
		model.addAttribute("emplyees", logService.getEmployeeList());
		return "admin/logs";
	}
	
	@PostMapping(path = "/sort", params = "sortT=down")
	public String sortDownList(@RequestParam("field") ViewFields field, HttpSession session, Model model) {
		List<Log> logs = (List<Log>) session.getAttribute("logs");
		logs = sortViewService.sortLogs(field, "down", logs);
		model.addAttribute("logs", logs);
		model.addAttribute("logFilter", new LogFilter());
		model.addAttribute("emplyees", logService.getEmployeeList());
		return "admin/logs";
	}
	
	@PostMapping(path = "/filter", params = "filter=reset")
	public String filterReset() {
		return "redirect:/admin/logs";
	}
}
