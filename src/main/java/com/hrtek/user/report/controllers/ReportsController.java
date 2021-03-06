package com.hrtek.user.report.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.hrtek.user.display.service.SortViewService;
import com.hrtek.user.display.views.ViewFields;
import com.hrtek.user.report.views.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hrtek.user.recruitment.CandidateService;

@Controller
@RequestMapping("/reports")
public class ReportsController {

	private ReportService reportService;
	private CandidateService candidateService;
	private SortViewService sortViewService;

	@Autowired
	public ReportsController(ReportService reportService, CandidateService candidateService, SortViewService sortViewService) {
		this.reportService = reportService;
		this.candidateService = candidateService;
		this.sortViewService = sortViewService;
	}

	@GetMapping
	public String toreports(Model model) {
		ReportWraper<ReportPesel> wraper = new ReportWraper<>();
		model.addAttribute("recruiters", candidateService.getCoordinatorsAndAgents());
		model.addAttribute("wraper", wraper);
		reportService.setCompanyFactoryList(model);
		return "user/report/report";
	}
	
	@PostMapping(params = "action=common")
	public String reports(ReportType reportType, Model model, Long ccompanyid, Long ffactoryid) {
		reportService.setModel(model, reportType, null, true, ccompanyid, ffactoryid);
		model.addAttribute("ccompanyid", ccompanyid);
		model.addAttribute("ffactoryid", ffactoryid);
		return "user/report/report";
	}
	
	@PostMapping(params = "action=recruiter")
	public String recrutiterreports(ReportType reportType, Long recruiterid, Model model) {
		model.addAttribute("wraper", reportService.getReportRecruiters(reportType, recruiterid));
		model.addAttribute("recruiters", candidateService.getCoordinatorsAndAgents());
		reportService.setCompanyFactoryList(model);
		model.addAttribute("others", true);
		model.addAttribute("recruiterid", recruiterid);
		return "user/report/report";
	}
	
	@PostMapping(params = "action=month")
	public String recrutiterreports(ReportType reportType, String month, Model model) {
		
		if(month != null && !month.isBlank()) {
			int year = Integer.parseInt(month.substring(0, 4));
			int mon = Integer.parseInt(month.substring(5, 7));
			LocalDate date = LocalDate.of(year, mon, 1);
			model.addAttribute("wraper", reportService.getReportReportVisaWork(reportType, date));	
			model.addAttribute("month", month);
		}else {
			model.addAttribute("wraper", new ReportWraper<>());
		}
		model.addAttribute("recruiters", candidateService.getCoordinatorsAndAgents());
		reportService.setCompanyFactoryList(model);
		return "user/report/report";
	}
	
	@PostMapping(params = "action=zus")
	public String zusreports(HttpSession session, ReportType reportType, Long companyid, Long factoryid, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate datefrom, Model model, String zusSearchingType) {
		ReportWraper<ReportZus> reportZus = reportService.getReportZus(reportType, companyid, factoryid, datefrom, zusSearchingType);
		session.setAttribute("zusList", reportZus.getReport());
		model.addAttribute("wraper", reportZus);
		if(reportZus.getReport().isEmpty()) {
			model.addAttribute("datefrom", null);
		}else {
			model.addAttribute("datefrom", datefrom);
		}
		
		model.addAttribute("recruiters", candidateService.getCoordinatorsAndAgents());
		model.addAttribute("companyid", companyid);
		model.addAttribute("factoryid", factoryid);
		
		
		reportService.setCompanyFactoryList(model);
		return "user/report/report";
	}
	
	@PostMapping(path = "/download", params = "action=zus")
	public String downloadZusReport(ReportType reportType, HttpSession session, RedirectAttributes ra) {

		List<ReportZus> zusList = (List<ReportZus>) session.getAttribute("zusList");
		String path = reportService.downloadZus(zusList, reportType);
		ra.addAttribute("filename", path);
		return "redirect:/download";
	}
	
	@PostMapping("/download")
	public String downloadFile(ReportType reportType, Long recruiterid, ViewFields sortBy, boolean sortUp, Long ccompanyid, Long ffactoryid, RedirectAttributes ra) {

		String path = reportService.downloadFile(reportType, recruiterid, sortBy, sortUp, ccompanyid, ffactoryid);
		ra.addAttribute("filename", path);
		return "redirect:/download";
	}
	
	@PostMapping(path = "/download", params = "action=month")
	public String downloadVisaWork(ReportType reportType, String month, RedirectAttributes ra, Model model) {
		if(month != null && !month.isBlank()) {
			int year = Integer.parseInt(month.substring(0, 4));
			int mon = Integer.parseInt(month.substring(5, 7));
			LocalDate date = LocalDate.of(year, mon, 1);
			String path = reportService.downloadWorkerWiza(reportType, date);
			ra.addAttribute("filename", path);
			return "redirect:/download";
		}else {
			model.addAttribute("wraper", new ReportWraper<>());
			model.addAttribute("recruiters", candidateService.getCoordinatorsAndAgents());
			reportService.setCompanyFactoryList(model);
			return "user/report/report";
		}
	}


	@PostMapping(path = "/sort", params = "sortT=up")
	public String sortUp(ReportType reportType, ViewFields field, Model model, Long ccompanyid, Long ffactoryid) {
		reportService.setModel(model, reportType, field, true, ccompanyid, ffactoryid);
		return "user/report/report";
	}

	@PostMapping(path = "/sort", params = "sortT=down")
	public String sortDown(ReportType reportType, ViewFields field, Model model, Long ccompanyid, Long ffactoryid) {
		reportService.setModel(model, reportType, field, false, ccompanyid, ffactoryid);
		return "user/report/report";
	}
}
