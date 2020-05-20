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

import com.hrtek.user.display.service.BasicService;
import com.hrtek.user.display.service.SortViewService;
import com.hrtek.user.display.views.BasicShowedField;
import com.hrtek.user.display.views.BasicView;

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
		return "user/display/basic";
	}
	
	@PostMapping(path = "/showhide")
	public String showHideColummn(Model model, BasicShowedField fd, HttpSession session) {
		List<BasicView> basicViewList = (List<BasicView>) session.getAttribute("basicViewList");
		session.setAttribute("bshowfiels", fd);
		model.addAttribute("bv_list", basicViewList);
		model.addAttribute("fd", fd);
		return "user/display/basic";
	}
	
	@PostMapping(path = "/sort", params = "sortT=up")
	public String sortUpList(@RequestParam("field") BasicView.Field field, HttpSession session, Model model) {
		List<BasicView> basicViewList = (List<BasicView>) session.getAttribute("basicViewList");
		basicViewList = sortViewService.sortBasicView(field, "up", basicViewList);
		model.addAttribute("bv_list", basicViewList);
		model.addAttribute("fd", (BasicShowedField)session.getAttribute("bshowfiels"));
		return "user/display/basic";
	}
	
	@PostMapping(path = "/sort", params = "sortT=down")
	public String sortDownList(@RequestParam("field") BasicView.Field field, HttpSession session, Model model) {
		List<BasicView> basicViewList = (List<BasicView>) session.getAttribute("basicViewList");
		basicViewList = sortViewService.sortBasicView(field, "down", basicViewList);
		model.addAttribute("bv_list", basicViewList);
		model.addAttribute("fd", (BasicShowedField)session.getAttribute("bshowfiels"));
		return "user/display/basic";
	}

}
