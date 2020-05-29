package com.hrtek.user.display.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrtek.user.display.filters.BasicFilters;
import com.hrtek.user.display.filters.FilterProcess;
import com.hrtek.user.display.filters.WorkFilters;
import com.hrtek.user.display.filters.basic.DateBasicOperation;
import com.hrtek.user.display.filters.basic.OtherBasicOperation;
import com.hrtek.user.display.filters.basic.TextBasicOperation;
import com.hrtek.user.display.filters.work.DateWorkOperation;
import com.hrtek.user.display.filters.work.OtherWorkOperation;
import com.hrtek.user.display.filters.work.TextWorkOperation;
import com.hrtek.user.display.service.SortViewService;
import com.hrtek.user.display.service.WorkService;
import com.hrtek.user.display.views.BasicShowedField;
import com.hrtek.user.display.views.BasicView;
import com.hrtek.user.display.views.ViewFields;
import com.hrtek.user.display.views.WorkerShowedFields;
import com.hrtek.user.display.views.WorkersView;

@Controller
@RequestMapping("/showwork")
public class WorkController {
	
	@Autowired
	private WorkService workService;
	@Autowired
	private SortViewService sortViewService;
	
	@GetMapping
	public String toShowWork(Model model, HttpSession session) {
		WorkerShowedFields fd = new WorkerShowedFields(true);
		List<WorkersView> workViewList = workService.getWorkersViewList();
		session.setAttribute("workViewList", workViewList);
		session.setAttribute("fd", fd);
		
		model.addAttribute("fd", fd);
		model.addAttribute("wv_list", workViewList);
		model.addAttribute("workFilters", new WorkFilters());
		workService.setModel(model);
		return "user/display/work";
	}

	@PostMapping(path = "/showhide")
	public String showHideColummn(Model model, WorkerShowedFields fd, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<WorkersView> workViewList = (List<WorkersView>) session.getAttribute("workViewList");
		session.setAttribute("fd", fd);
		
		model.addAttribute("wv_list", workViewList);
		model.addAttribute("fd", fd);
		model.addAttribute("workFilters", new WorkFilters());
		workService.setModel(model);
		return "user/display/work";
	}
	
	@PostMapping(path = "/sort", params = "sortT=up")
	public String sortUpList(@RequestParam("field") ViewFields field, HttpSession session, Model model, BasicFilters basicFilters) {
		@SuppressWarnings("unchecked")
		List<WorkersView> workViewList = (List<WorkersView>) session.getAttribute("workViewList");
		workViewList = sortViewService.sortWorkersView(field, "up", workViewList);
		
		model.addAttribute("wv_list", workViewList);
		model.addAttribute("fd", (WorkerShowedFields)session.getAttribute("fd"));
		model.addAttribute("workFilters", new WorkFilters());
		workService.setModel(model);
		return "user/display/work";
	}
	
	@PostMapping(path = "/sort", params = "sortT=down")
	public String sortDownList(@RequestParam("field") ViewFields field, HttpSession session, Model model) {
		@SuppressWarnings("unchecked")
		List<WorkersView> workViewList = (List<WorkersView>) session.getAttribute("workViewList");
		workViewList = sortViewService.sortWorkersView(field, "down", workViewList);
		
		model.addAttribute("wv_list", workViewList);
		model.addAttribute("fd", (WorkerShowedFields)session.getAttribute("fd"));
		model.addAttribute("workFilters", new WorkFilters());
		workService.setModel(model);
		return "user/display/work";
	}
	
	@PostMapping(path = "/filter", params = "filter=next")
	public String filterNext(WorkFilters wf,  HttpSession session, Model model) {
		@SuppressWarnings("unchecked")
		List<WorkersView> workViewList = (List<WorkersView>) session.getAttribute("workViewList");
		workViewList = new FilterProcess<WorkersView, WorkFilters>( wf)
				.setTextOpertation(new TextWorkOperation())
				.setDateOperation(new DateWorkOperation())
				.setOtherFiletrOperation(new OtherWorkOperation())
				.filter(workViewList);
		
		session.setAttribute("workViewList", workViewList);
		model.addAttribute("wv_list", workViewList);
		model.addAttribute("wf", wf);
		model.addAttribute("fd", (WorkerShowedFields)session.getAttribute("fd"));
		workService.setModel(model);
		return "user/display/work";
	}
	
	@PostMapping(path = "/filter", params = "filter=new")
	public String filterNew(WorkFilters wf,  HttpSession session, Model model) {
		List<WorkersView> workViewList = workService.getWorkersViewList();
		session.setAttribute("basicViewList", workViewList);
		workViewList = new FilterProcess<WorkersView, WorkFilters>(wf)
				.setTextOpertation(new TextWorkOperation())
				.setDateOperation(new DateWorkOperation())
				.setOtherFiletrOperation(new OtherWorkOperation())
				.filter(workViewList);
		
		session.setAttribute("basicViewList", workViewList);
		model.addAttribute("wv_list", workViewList);
		model.addAttribute("wf", wf);
		model.addAttribute("fd", (WorkerShowedFields)session.getAttribute("fd"));
		workService.setModel(model);
		return "user/display/work";
	}
	
	@PostMapping(path = "/filter", params = "filter=reset")
	public String filterReset() {
		return "redirect:/showwork";
	}
}
