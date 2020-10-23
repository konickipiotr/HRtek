package com.hrtek.admin.others;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrtek.enums.LogType;
import com.hrtek.model.Log;
import com.hrtek.model.UserInfo;
import com.hrtek.settings.Msg;
import com.hrtek.user.display.filters.FilterProcess;
import com.hrtek.user.display.service.SortViewService;
import com.hrtek.user.display.views.ViewFields;

@Controller
@RequestMapping("/admin/workers")
public class WorkerController {
	
	@Autowired
	private WorkerManagementService workerService;
	@Autowired
	private SortViewService sortViewService;
	
	@GetMapping
	public String toWorkersManagment(Model model, HttpSession session) {
		List<WorkerView> workersViewList = workerService.getWorkersViewList();
		session.setAttribute("workersViewList", workersViewList);
		session.setAttribute("listType", "current");
		model.addAttribute("workers", workersViewList);
		model.addAttribute("basicFilters", new WorkerFilters());
		workerService.setModel(model);
		model.addAttribute("styleTab1", "wbutton-active");
		model.addAttribute("styleTab2", "wbutton");
		return "admin/workersmanagement";
	}
	
	@GetMapping("/arch")
	public String toWorkersManagmentArch(Model model, HttpSession session) {
		List<WorkerView> workersViewList = workerService.getArchWorkersViewList();
		session.setAttribute("workersViewList", workersViewList);
		session.setAttribute("listType", "dismissed");
		model.addAttribute("workers", workersViewList);
		model.addAttribute("basicFilters", new WorkerFilters());
		workerService.setModel(model);
		model.addAttribute("styleTab2", "wbutton-active");
		model.addAttribute("styleTab1", "wbutton");
		return "admin/workersmanagement";
	}
	
	@PostMapping(value = "/delete")
	public String deletePernamently(@RequestParam("id") Long id , HttpSession session) {
		String listType = (String) session.getAttribute("listType");

		if(listType.equals("current")) {
			workerService.deleteCurrentWorkerPermanently(id, session);
			return "redirect:/admin/workers";
			
		}else {
			workerService.deleteWorkerFromArchivePermanently(id, session);
			
			return "redirect:/admin/workers/arch";
		}
		
	}
	
	
	@PostMapping(path = "/sort", params = "sortT=up")
	public String sortUpList(@RequestParam("field") ViewFields field, HttpSession session, Model model) {
		List<WorkerView> workersViewList = (List<WorkerView>) session.getAttribute("workersViewList");
		workersViewList = sortViewService.sortWorkerView(field, "up", workersViewList);
		model.addAttribute("workers", workersViewList);
		model.addAttribute("basicFilters", new WorkerFilters());
		workerService.setModel(model);
		return "admin/workersmanagement";
	}
	
	@PostMapping(path = "/sort", params = "sortT=down")
	public String sortDownList(@RequestParam("field") ViewFields field, HttpSession session, Model model) {
		List<WorkerView> workersViewList = (List<WorkerView>) session.getAttribute("workersViewList");
		workersViewList = sortViewService.sortWorkerView(field, "down", workersViewList);
		model.addAttribute("workers", workersViewList);
		model.addAttribute("basicFilters", new WorkerFilters());
		workerService.setModel(model);
		return "admin/workersmanagement";
	}
	
	@PostMapping(path = "/filter", params = "filter=next")
	public String filterNext(WorkerFilters bf,  HttpSession session, Model model) {
		List<WorkerView> workersViewList = (List<WorkerView>) session.getAttribute("workersViewList");
		workersViewList = new FilterProcess<WorkerView, WorkerFilters>( bf)
				.setTextOpertation(new TextWorkerOperation())
				.setDateOperation(new DateWorkerOpertion())
				.setOtherFiletrOperation(new OtherWorkerOperation())
				.filter(workersViewList);
		session.setAttribute("workersViewList", workersViewList);
		model.addAttribute("workers", workersViewList);
		model.addAttribute("basicFilters", bf);
		workerService.setModel(model);
		return "admin/workersmanagement";
	}
	
	@PostMapping(path = "/filter", params = "filter=new")
	public String filterNew(WorkerFilters bf,  HttpSession session, Model model) {
		
		String listType = (String) session.getAttribute("listType");
		List<WorkerView> workersViewList;
		if(listType.equals("current")) {
			workersViewList = workerService.getWorkersViewList();
		}else {
			workersViewList = workerService.getArchWorkersViewList();
		}
			
		workersViewList = new FilterProcess<WorkerView, WorkerFilters>( bf)
				.setTextOpertation(new TextWorkerOperation())
				.setDateOperation(new DateWorkerOpertion())
				.setOtherFiletrOperation(new OtherWorkerOperation())
				.filter(workersViewList);
		session.setAttribute("workersViewList", workersViewList);
		model.addAttribute("workers", workersViewList);
		model.addAttribute("basicFilters", bf);
		workerService.setModel(model);
		return "admin/workersmanagement";
	}
	
	@PostMapping(path = "/filter", params = "filter=reset")
	public String filterReset(HttpSession session) {
		String listType = (String) session.getAttribute("listType");
		if(listType.endsWith("current"))
			return "redirect:/admin/workers";
		else
			return "redirect:/admin/workers/arch";
	}


}
