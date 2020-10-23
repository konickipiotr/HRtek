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

import com.hrtek.user.display.filters.DismissedFilters;
import com.hrtek.user.display.filters.FilterProcess;
import com.hrtek.user.display.filters.dismiss.DateDismissOperation;
import com.hrtek.user.display.filters.dismiss.OtherDismissOperation;
import com.hrtek.user.display.filters.dismiss.TextDismissedOperation;
import com.hrtek.user.display.service.DismissedDisplayService;
import com.hrtek.user.display.service.SortViewService;
import com.hrtek.user.display.views.DismissShowedField;
import com.hrtek.user.display.views.DismissedView;
import com.hrtek.user.display.views.ViewFields;

@Controller
@RequestMapping("/showdismissed")
public class DismissDisplayController {
	
	@Autowired
	private SortViewService sortViewService;
	@Autowired
	private DismissedDisplayService dismissService;
	
	@GetMapping
	public String showdismissed(Model model, HttpSession session) {
		List<DismissedView> dissmisedViewList = dismissService.getDismissedViewList();
		DismissShowedField dismissShowedField = new DismissShowedField(true);
		session.setAttribute("dissmisedViewList", dissmisedViewList);
		session.setAttribute("bshowfiels", dismissShowedField);
		model.addAttribute("dv_list", dissmisedViewList);
		model.addAttribute("fd", dismissShowedField);
		model.addAttribute("dismissedFilters", new DismissedFilters());

		return "user/display/dismiss";
	}
	
	@PostMapping(path = "/showhide")
	public String showHideColummn(Model model, DismissShowedField fd, HttpSession session) {
		List<DismissedView> dissmisedViewList = (List<DismissedView>) session.getAttribute("dissmisedViewList");
		session.setAttribute("bshowfiels", fd);
		model.addAttribute("dv_list", dissmisedViewList);
		model.addAttribute("fd", fd);
		model.addAttribute("dismissedFilters", new DismissedFilters());

		return "user/display/dismiss";
	}
	
	@PostMapping(path = "/sort", params = "sortT=up")
	public String sortUpList(@RequestParam("field") ViewFields field, HttpSession session, Model model, DismissedFilters dismissedFilters) {
		List<DismissedView> dissmisedViewList = (List<DismissedView>) session.getAttribute("dissmisedViewList");
		dissmisedViewList = sortViewService.sortDismissedView(field, "up", dissmisedViewList);
		model.addAttribute("dv_list", dissmisedViewList);
		model.addAttribute("fd", (DismissShowedField)session.getAttribute("bshowfiels"));
		model.addAttribute("dismissedFilters", new DismissedFilters());

		return "user/display/dismiss";
	}
	
	@PostMapping(path = "/sort", params = "sortT=down")
	public String sortDownList(@RequestParam("field") ViewFields field, HttpSession session, Model model) {
		List<DismissedView> dissmisedViewList = (List<DismissedView>) session.getAttribute("dissmisedViewList");
		dissmisedViewList = sortViewService.sortDismissedView(field, "down", dissmisedViewList);
		model.addAttribute("dv_list", dissmisedViewList);
		model.addAttribute("fd", (DismissShowedField)session.getAttribute("bshowfiels"));
		model.addAttribute("dismissedFilters", new DismissedFilters());

		return "user/display/dismiss";
	}

	@PostMapping(path = "/filter", params = "filter=next")
	public String filterNext(DismissedFilters df,  HttpSession session, Model model) {
		List<DismissedView> dissmisedViewList = (List<DismissedView>) session.getAttribute("dissmisedViewList");
		dissmisedViewList = new FilterProcess<DismissedView, DismissedFilters>(df)
				.setTextOpertation(new TextDismissedOperation())
				.setDateOperation(new DateDismissOperation())
				.setOtherFiletrOperation(new OtherDismissOperation())
				.filter(dissmisedViewList);
		session.setAttribute("dissmisedViewList", dissmisedViewList);
		model.addAttribute("dv_list", dissmisedViewList);
		model.addAttribute("dismissedFilters", df);
		model.addAttribute("fd", (DismissShowedField)session.getAttribute("bshowfiels"));
	
		return "user/display/dismiss";
	}
	
	@PostMapping(path = "/filter", params = "filter=new")
	public String filterNew(DismissedFilters df,  HttpSession session, Model model) {
		List<DismissedView> dissmisedViewList = dismissService.getDismissedViewList();
		session.setAttribute("dissmisedViewList", dissmisedViewList);
		dissmisedViewList = new FilterProcess<DismissedView, DismissedFilters>( df)
				.setTextOpertation(new TextDismissedOperation())
				.setDateOperation(new DateDismissOperation())
				.setOtherFiletrOperation(new OtherDismissOperation())
				.filter(dissmisedViewList);
		session.setAttribute("dissmisedViewList", dissmisedViewList);
		model.addAttribute("dv_list", dissmisedViewList);
		model.addAttribute("dismissedFilters", df);
		model.addAttribute("fd", (DismissShowedField)session.getAttribute("bshowfiels"));
		
		return "user/display/dismiss";
	}
	
	@PostMapping(path = "/filter", params = "filter=reset")
	public String filterReset() {
		return "redirect:/showdismissed";
	}
}
