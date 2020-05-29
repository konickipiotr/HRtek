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
import com.hrtek.user.display.filters.DataFilters;
import com.hrtek.user.display.filters.FilterProcess;
import com.hrtek.user.display.filters.contact.DateContactOperation;
import com.hrtek.user.display.filters.contact.OtherContactOperation;
import com.hrtek.user.display.filters.contact.TextContactOperation;
import com.hrtek.user.display.filters.data.DateDataOperation;
import com.hrtek.user.display.filters.data.OtherDataOperation;
import com.hrtek.user.display.filters.data.TextDataOperation;
import com.hrtek.user.display.service.ContactService;
import com.hrtek.user.display.service.DataViewService;
import com.hrtek.user.display.service.SortViewService;
import com.hrtek.user.display.views.DataShowedFields;
import com.hrtek.user.display.views.DataView;
import com.hrtek.user.display.views.ViewFields;

@Controller
@RequestMapping("/showdata")
public class DataViewController {
	
	@Autowired
	private SortViewService sortViewService;
	@Autowired
	private DataViewService dataViewService;
	
	@GetMapping
	public String toShowWork(Model model, HttpSession session) {
		DataShowedFields fd = new DataShowedFields(true);
		List<DataView> dataViewList = dataViewService.getWorkersViewList();
		session.setAttribute("dataViewList", dataViewList);
		session.setAttribute("fd", fd);
		
		model.addAttribute("fd", fd);
		model.addAttribute("dv_list", dataViewList);
		model.addAttribute("dataFilters", new DataFilters());
		dataViewService.setModel(model);
		return "user/display/dataview";
	}

	@PostMapping(path = "/showhide")
	public String showHideColummn(Model model, DataShowedFields fd, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<DataView> dataViewList = (List<DataView>) session.getAttribute("dataViewList");
		session.setAttribute("fd", fd);
		
		model.addAttribute("dv_list", dataViewList);
		model.addAttribute("fd", fd);
		model.addAttribute("dataFilters", new DataFilters());
		dataViewService.setModel(model);
		return "user/display/dataview";
	}
	
	@PostMapping(path = "/sort", params = "sortT=up")
	public String sortUpList(@RequestParam("field") ViewFields field, HttpSession session, Model model, BasicFilters basicFilters) {
		@SuppressWarnings("unchecked")
		List<DataView> dataViewList = (List<DataView>) session.getAttribute("dataViewList");
		dataViewList = sortViewService.sortDateView(field, "up", dataViewList);
		
		model.addAttribute("dv_list", dataViewList);
		model.addAttribute("fd", (DataShowedFields)session.getAttribute("fd"));
		model.addAttribute("dataFilters", new DataFilters());
		dataViewService.setModel(model);
		return "user/display/dataview";
	}
	
	@PostMapping(path = "/sort", params = "sortT=down")
	public String sortDownList(@RequestParam("field") ViewFields field, HttpSession session, Model model) {
		@SuppressWarnings("unchecked")
		List<DataView> dataViewList = (List<DataView>) session.getAttribute("dataViewList");
		dataViewList = sortViewService.sortDateView(field, "down", dataViewList);
		
		model.addAttribute("dv_list", dataViewList);
		model.addAttribute("fd", (DataShowedFields)session.getAttribute("fd"));
		model.addAttribute("dataFilters", new DataFilters());
		dataViewService.setModel(model);
		return "user/display/dataview";
	}
	
	@PostMapping(path = "/filter", params = "filter=next")
	public String filterNext(DataFilters df,  HttpSession session, Model model) {
		System.out.println(df);
		@SuppressWarnings("unchecked")
		List<DataView> dataViewList = (List<DataView>) session.getAttribute("dataViewList");
		dataViewList = new FilterProcess<DataView, DataFilters>( df)
				.setTextOpertation(new TextDataOperation())
				.setDateOperation(new DateDataOperation())
				.setOtherFiletrOperation(new OtherDataOperation())
				.filter(dataViewList);
		
		session.setAttribute("dataViewList", dataViewList);
		model.addAttribute("dv_list", dataViewList);
		model.addAttribute("df", df);
		model.addAttribute("fd", (DataShowedFields)session.getAttribute("fd"));
		dataViewService.setModel(model);
		return "user/display/dataview";
	}
	
	@PostMapping(path = "/filter", params = "filter=new")
	public String filterNew(DataFilters df,  HttpSession session, Model model) {
		System.out.println(df);
		List<DataView> dataViewList = dataViewService.getWorkersViewList();
		session.setAttribute("dataViewList", dataViewList);
		dataViewList = new FilterProcess<DataView, DataFilters>(df)
				.setTextOpertation(new TextDataOperation())
				.setDateOperation(new DateDataOperation())
				.setOtherFiletrOperation(new OtherDataOperation())
				.filter(dataViewList);
		
		session.setAttribute("basicViewList", dataViewList);
		model.addAttribute("dv_list", dataViewList);
		model.addAttribute("df", df);
		model.addAttribute("fd", (DataShowedFields)session.getAttribute("fd"));
		dataViewService.setModel(model);
		return "user/display/dataview";
	}
	
	@PostMapping(path = "/filter", params = "filter=reset")
	public String filterReset() {
		return "redirect:/showdata";
	}

}
