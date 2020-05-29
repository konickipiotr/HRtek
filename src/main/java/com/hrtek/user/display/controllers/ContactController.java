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
import com.hrtek.user.display.filters.ContactFilters;
import com.hrtek.user.display.filters.FilterProcess;
import com.hrtek.user.display.filters.contact.DateContactOperation;
import com.hrtek.user.display.filters.contact.OtherContactOperation;
import com.hrtek.user.display.filters.contact.TextContactOperation;
import com.hrtek.user.display.service.ContactService;
import com.hrtek.user.display.service.SortViewService;
import com.hrtek.user.display.views.ContactShowedFields;
import com.hrtek.user.display.views.ContactViewDis;
import com.hrtek.user.display.views.ViewFields;

@Controller
@RequestMapping("/showcontact")
public class ContactController {

	@Autowired
	private SortViewService sortViewService;
	@Autowired
	private ContactService contactService;
	
	@GetMapping
	public String toShowWork(Model model, HttpSession session) {
		ContactShowedFields fd = new ContactShowedFields(true);
		List<ContactViewDis> contactViewList = contactService.getContactViewList();
		session.setAttribute("contactViewList", contactViewList);
		session.setAttribute("fd", fd);
		
		model.addAttribute("fd", fd);
		model.addAttribute("cv_list", contactViewList);
		model.addAttribute("contactFilters", new ContactFilters());
		contactService.setModel(model);
		return "user/display/contact";
	}

	@PostMapping(path = "/showhide")
	public String showHideColummn(Model model, ContactShowedFields fd, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<ContactViewDis> contactViewList = (List<ContactViewDis>) session.getAttribute("contactViewList");
		session.setAttribute("fd", fd);
		
		model.addAttribute("cv_list", contactViewList);
		model.addAttribute("fd", fd);
		model.addAttribute("contactFilters", new ContactFilters());
		contactService.setModel(model);
		return "user/display/contact";
	}
	
	@PostMapping(path = "/sort", params = "sortT=up")
	public String sortUpList(@RequestParam("field") ViewFields field, HttpSession session, Model model, BasicFilters basicFilters) {
		@SuppressWarnings("unchecked")
		List<ContactViewDis> contactViewList = (List<ContactViewDis>) session.getAttribute("contactViewList");
		contactViewList = sortViewService.sortContactView(field, "up", contactViewList);
		
		model.addAttribute("cv_list", contactViewList);
		model.addAttribute("fd", (ContactShowedFields)session.getAttribute("fd"));
		model.addAttribute("contactFilters", new ContactFilters());
		contactService.setModel(model);
		return "user/display/contact";
	}
	
	@PostMapping(path = "/sort", params = "sortT=down")
	public String sortDownList(@RequestParam("field") ViewFields field, HttpSession session, Model model) {
		@SuppressWarnings("unchecked")
		List<ContactViewDis> contactViewList = (List<ContactViewDis>) session.getAttribute("contactViewList");
		contactViewList = sortViewService.sortContactView(field, "down", contactViewList);
		
		model.addAttribute("cv_list", contactViewList);
		model.addAttribute("fd", (ContactShowedFields)session.getAttribute("fd"));
		model.addAttribute("contactFilters", new ContactFilters());
		contactService.setModel(model);
		return "user/display/contact";
	}
	
	@PostMapping(path = "/filter", params = "filter=next")
	public String filterNext(ContactFilters cf,  HttpSession session, Model model) {
		System.out.println(cf);
		@SuppressWarnings("unchecked")
		List<ContactViewDis> contactViewList = (List<ContactViewDis>) session.getAttribute("contactViewList");
		contactViewList = new FilterProcess<ContactViewDis, ContactFilters>( cf)
				.setTextOpertation(new TextContactOperation())
				.setDateOperation(new DateContactOperation())
				.setOtherFiletrOperation(new OtherContactOperation())
				.filter(contactViewList);
		
		session.setAttribute("contactViewList", contactViewList);
		model.addAttribute("cv_list", contactViewList);
		model.addAttribute("cf", cf);
		model.addAttribute("fd", (ContactShowedFields)session.getAttribute("fd"));
		contactService.setModel(model);
		return "user/display/contact";
	}
	
	@PostMapping(path = "/filter", params = "filter=new")
	public String filterNew(ContactFilters cf,  HttpSession session, Model model) {
		List<ContactViewDis> contactViewList = contactService.getContactViewList();
		session.setAttribute("contactViewList", contactViewList);
		contactViewList = new FilterProcess<ContactViewDis, ContactFilters>(cf)
				.setTextOpertation(new TextContactOperation())
				.setDateOperation(new DateContactOperation())
				.setOtherFiletrOperation(new OtherContactOperation())
				.filter(contactViewList);
		
		session.setAttribute("basicViewList", contactViewList);
		model.addAttribute("cv_list", contactViewList);
		model.addAttribute("cf", cf);
		model.addAttribute("fd", (ContactShowedFields)session.getAttribute("fd"));
		contactService.setModel(model);
		return "user/display/contact";
	}
	
	@PostMapping(path = "/filter", params = "filter=reset")
	public String filterReset() {
		return "redirect:/showcontact";
	}
}
