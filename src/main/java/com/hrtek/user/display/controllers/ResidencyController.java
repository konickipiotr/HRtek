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
import com.hrtek.user.display.filters.ResidencyFilter;
import com.hrtek.user.display.filters.residency.DateResidencyOperation;
import com.hrtek.user.display.filters.residency.OtherResidencyOpertion;
import com.hrtek.user.display.filters.residency.TextResidencyOperation;
import com.hrtek.user.display.service.ResidencyService;
import com.hrtek.user.display.service.SortViewService;
import com.hrtek.user.display.views.ResidencyShowedFields;
import com.hrtek.user.display.views.ResidencyView;
import com.hrtek.user.display.views.ViewFields;

@Controller
@RequestMapping("/showresidency")
public class ResidencyController {
	
	@Autowired
	private ResidencyService residencyService;
	@Autowired
	private SortViewService sortViewService;

	@GetMapping
	public String toResidencyView(Model model, HttpSession session) {
		ResidencyShowedFields fd = new ResidencyShowedFields(true);
		List<ResidencyView> residencyViewList = residencyService.getResidencyViewList();
		session.setAttribute("residencyViewList", residencyViewList);
		session.setAttribute("fd", fd);
		
		model.addAttribute("fd", fd);
		model.addAttribute("rv_list", residencyViewList);
		model.addAttribute("residencyFilter", new ResidencyFilter());
		residencyService.setModel(model);
		return "user/display/residency";
	}
	
	@PostMapping(path = "/showhide")
	public String showHideColummn(Model model, ResidencyShowedFields fd, HttpSession session) {
		System.out.println(fd);
		@SuppressWarnings("unchecked")
		List<ResidencyView> residencyViewList = (List<ResidencyView>) session.getAttribute("residencyViewList");
		session.setAttribute("fd", fd);
		model.addAttribute("rv_list", residencyViewList);
		model.addAttribute("fd", fd);
		model.addAttribute("residencyFilter", new ResidencyFilter());
		residencyService.setModel(model);
		return "user/display/residency";
	}
	
	@PostMapping(path = "/sort", params = "sortT=up")
	public String sortUpList(@RequestParam("field") ViewFields field, HttpSession session, Model model, BasicFilters fd) {
		List<ResidencyView> residencyViewList = (List<ResidencyView>) session.getAttribute("residencyViewList");
		residencyViewList = sortViewService.sortResidencyView(field, "up", residencyViewList);
		model.addAttribute("rv_list", residencyViewList);
		model.addAttribute("fd", (ResidencyShowedFields)session.getAttribute("fd"));
		model.addAttribute("residencyFilter", new ResidencyFilter());
		residencyService.setModel(model);
		return "user/display/residency";
	}
	
	@PostMapping(path = "/sort", params = "sortT=down")
	public String sortDownList(@RequestParam("field") ViewFields field, HttpSession session, Model model) {
		List<ResidencyView> residencyViewList = (List<ResidencyView>) session.getAttribute("residencyViewList");
		residencyViewList = sortViewService.sortResidencyView(field, "down", residencyViewList);
		model.addAttribute("rv_list", residencyViewList);
		model.addAttribute("fd", (ResidencyShowedFields)session.getAttribute("fd"));
		model.addAttribute("residencyFilter", new ResidencyFilter());
		residencyService.setModel(model);
		return "user/display/residency";
	}
	
	@PostMapping(path = "/filter", params = "filter=next")
	public String filterNext(ResidencyFilter rf,  HttpSession session, Model model) {
		@SuppressWarnings("unchecked")
		List<ResidencyView> residencyViewList = (List<ResidencyView>) session.getAttribute("residencyViewList");
		residencyViewList = new FilterProcess<ResidencyView, ResidencyFilter>( rf)
				.setTextOpertation(new TextResidencyOperation())
				.setDateOperation(new DateResidencyOperation())
				.setOtherFiletrOperation(new OtherResidencyOpertion())
				.filter(residencyViewList);
		
		session.setAttribute("residencyViewList", residencyViewList);
		model.addAttribute("rv_list", residencyViewList);
		model.addAttribute("rf", rf);
		model.addAttribute("fd", (ResidencyShowedFields)session.getAttribute("fd"));
		residencyService.setModel(model);
		return "user/display/residency";
	}
	
	@PostMapping(path = "/filter", params = "filter=new")
	public String filterNew(ResidencyFilter rf,  HttpSession session, Model model) {
		List<ResidencyView> residencyViewList = residencyService.getResidencyViewList();
		session.setAttribute("residencyViewList", residencyViewList);
		residencyViewList = new FilterProcess<ResidencyView, ResidencyFilter>(rf)
				.setTextOpertation(new TextResidencyOperation())
				.setDateOperation(new DateResidencyOperation())
				.setOtherFiletrOperation(new OtherResidencyOpertion())
				.filter(residencyViewList);
		
		session.setAttribute("residencyViewList", residencyViewList);
		model.addAttribute("rv_list", residencyViewList);
		model.addAttribute("rf", rf);
		model.addAttribute("fd", (ResidencyShowedFields)session.getAttribute("fd"));
		residencyService.setModel(model);
		return "user/display/residency";
	}
	
	@PostMapping(path = "/filter", params = "filter=reset")
	public String filterReset() {
		return "redirect:/showresidency";
	}
}
