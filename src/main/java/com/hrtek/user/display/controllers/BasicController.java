package com.hrtek.user.display.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrtek.user.display.filters.FilterProcess;
import com.hrtek.user.display.filters.OtherFilterOperation;
import com.hrtek.user.display.filters.basic.DateBasicOperation;
import com.hrtek.user.display.filters.basic.OtherBasicOperation;
import com.hrtek.user.display.filters.basic.TextBasicOperation;
import com.hrtek.user.display.filters.BasicFilters;
import com.hrtek.user.display.service.BasicService;
import com.hrtek.user.display.service.SortViewService;
import com.hrtek.user.display.views.BasicShowedField;
import com.hrtek.user.display.views.BasicView;
import com.hrtek.user.display.views.ViewFields;

@Controller
@RequestMapping("/showbasic")
public class BasicController {
	
	@Autowired
	private BasicService basicService;
	@Autowired
	private SortViewService sortViewService;
	
	@GetMapping
	public String showbasci(Model model, HttpSession session) {
		List<BasicView> basicViewList = basicService.getBasicViewList();
		BasicShowedField basicShowedField = new BasicShowedField(true);
		session.setAttribute("basicViewList", basicViewList);
		session.setAttribute("bshowfiels", basicShowedField);
		model.addAttribute("bv_list", basicViewList);
		model.addAttribute("fd", basicShowedField);
		model.addAttribute("basicFilters", new BasicFilters());
		basicService.setModel(model);
		return "user/display/basic";
	}
	
	@PostMapping(path = "/showhide")
	public String showHideColummn(Model model, BasicShowedField fd, HttpSession session) {
		List<BasicView> basicViewList = (List<BasicView>) session.getAttribute("basicViewList");
		session.setAttribute("bshowfiels", fd);
		model.addAttribute("bv_list", basicViewList);
		model.addAttribute("fd", fd);
		model.addAttribute("basicFilters", new BasicFilters());
		basicService.setModel(model);
		return "user/display/basic";
	}
	
	@PostMapping(path = "/sort", params = "sortT=up")
	public String sortUpList(@RequestParam("field") ViewFields field, HttpSession session, Model model, BasicFilters basicFilters) {
		List<BasicView> basicViewList = (List<BasicView>) session.getAttribute("basicViewList");
		basicViewList = sortViewService.sortBasicView(field, "up", basicViewList);
		model.addAttribute("bv_list", basicViewList);
		model.addAttribute("fd", (BasicShowedField)session.getAttribute("bshowfiels"));
		model.addAttribute("basicFilters", new BasicFilters());
		basicService.setModel(model);
		return "user/display/basic";
	}
	
	@PostMapping(path = "/sort", params = "sortT=down")
	public String sortDownList(@RequestParam("field") ViewFields field, HttpSession session, Model model) {
		List<BasicView> basicViewList = (List<BasicView>) session.getAttribute("basicViewList");
		basicViewList = sortViewService.sortBasicView(field, "down", basicViewList);
		model.addAttribute("bv_list", basicViewList);
		model.addAttribute("fd", (BasicShowedField)session.getAttribute("bshowfiels"));
		model.addAttribute("basicFilters", new BasicFilters());
		basicService.setModel(model);
		return "user/display/basic";
	}
	
	@PostMapping(path = "/filter", params = "filter=next")
	public String filterNext(BasicFilters bf,  HttpSession session, Model model) {
		List<BasicView> basicViewList = (List<BasicView>) session.getAttribute("basicViewList");
		basicViewList = new FilterProcess<BasicView, BasicFilters>( bf)
				.setTextOpertation(new TextBasicOperation())
				.setDateOperation(new DateBasicOperation())
				.setOtherFiletrOperation(new OtherBasicOperation())
				.filter(basicViewList);
		session.setAttribute("basicViewList", basicViewList);
		model.addAttribute("bv_list", basicViewList);
		model.addAttribute("basicFilters", bf);
		model.addAttribute("fd", (BasicShowedField)session.getAttribute("bshowfiels"));
		basicService.setModel(model);
		return "user/display/basic";
	}
	
	@PostMapping(path = "/filter", params = "filter=new")
	public String filterNew(BasicFilters bf,  HttpSession session, Model model) {
		List<BasicView> basicViewList = basicService.getBasicViewList();
		session.setAttribute("basicViewList", basicViewList);
		basicViewList = new FilterProcess<BasicView, BasicFilters>( bf)
				.setTextOpertation(new TextBasicOperation())
				.setDateOperation(new DateBasicOperation())
				.setOtherFiletrOperation(new OtherBasicOperation())
				.filter(basicViewList);
		session.setAttribute("basicViewList", basicViewList);
		model.addAttribute("bv_list", basicViewList);
		model.addAttribute("basicFilters", bf);
		model.addAttribute("fd", (BasicShowedField)session.getAttribute("bshowfiels"));
		basicService.setModel(model);
		return "user/display/basic";
	}
	
	@PostMapping(path = "/filter", params = "filter=reset")
	public String filterReset() {
		return "redirect:/showbasic";
	}
}
