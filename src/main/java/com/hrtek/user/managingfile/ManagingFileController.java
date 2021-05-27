package com.hrtek.user.managingfile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hrtek.model.ListModel;
import com.hrtek.user.display.service.SortViewService;
import com.hrtek.user.display.views.ViewFields;
import com.hrtek.user.managingfile.excelutils.ExcelCreatorFileService;
import com.hrtek.user.managingfile.excelutils.ExcelUploadUtils;
import org.apache.poi.openxml4j.exceptions.OLE2NotOfficeXmlFileException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/managingfile")
public class ManagingFileController {
	
	private ManagingFileService managingService;
	private SortViewService sortViewService;

	@Autowired
	public ManagingFileController(ManagingFileService managingService, SortViewService sortViewService) {
		this.managingService = managingService;
		this.sortViewService = sortViewService;
	}

	@GetMapping
	public String getFirstCompany(RedirectAttributes ra){
		List<ListModel> companiesNames = managingService.getCompaniesNames();
		if(companiesNames.isEmpty())
			return "redirect:/";

		return "redirect:/managingfile/" + companiesNames.get(0).getId();
	}

	@GetMapping("/{companyid}")
	public String showManagingFile(@PathVariable("companyid") Long companyid,  Model model, String errormsg) {

		ListWrapper<FactoryElement> wrapper = managingService.getManagingFileData(0, companyid);
		managingService.sumColumns(wrapper);

		model.addAttribute("companies", managingService.getCompaniesNames());
		model.addAttribute("wrapper", wrapper);
		model.addAttribute("companyid", companyid);
		model.addAttribute("errormsg", errormsg);
		model.addAttribute("monoffset", 0);
		return "user/managingfile/managingfile";
	}

	@PostMapping("/setallhours")
	public String setHoursForAllWorkersInFactory(Model model, Long companyid, Long factoryid, int value, int monoffset){
		ListWrapper<FactoryElement> wrapper = managingService.getManagingFileData(monoffset, companyid);
		managingService.setHoursForAll(wrapper, factoryid, value, monoffset);
		managingService.sumColumns(wrapper);


		model.addAttribute("companies", managingService.getCompaniesNames());
		model.addAttribute("companyid", companyid);
		model.addAttribute("monoffset", monoffset);
		model.addAttribute("wrapper", wrapper);
		return "user/managingfile/managingfile";
	}

	@PostMapping("/setworkerhours")
	public String setHoursForWorker(Model model, Long companyid, Long factoryid, Long workerid[], int chosenHours[], String salaryForm[], BigDecimal salary[], BigDecimal loan[], BigDecimal bonus[], int monoffset){
		List<WorkVal> workVals = new ArrayList<>();
		for(int i = 0; i < workerid.length; i++)
			workVals.add(new WorkVal(workerid[i], chosenHours[i], salaryForm[i], loan[i], bonus[i], salary[i]));
		ListWrapper<FactoryElement> wrapper = managingService.getManagingFileData(monoffset, companyid);
		for(Long wId : workerid)
			managingService.setHoursForWorker(wrapper, factoryid, workVals, monoffset);
		managingService.sumColumns(wrapper);

		model.addAttribute("companies", managingService.getCompaniesNames());
		model.addAttribute("companyid", companyid);
		model.addAttribute("monoffset", monoffset);
		model.addAttribute("wrapper", wrapper);
		return "user/managingfile/managingfile";
	}

	@PostMapping(path = "/sort", params = "sortT=up")
	public String sortUpList(@RequestParam("field") ViewFields field, Long companyid, Long factoryid, Model model, int monoffset) {
		ListWrapper<FactoryElement> wrapper = managingService.getManagingFileData(monoffset, companyid);

		List<FactoryElement> list = wrapper.getList();
		for(FactoryElement m : list){
			if(m.getFactoryid().equals(factoryid)){
				sortViewService.sortRecords(field, "up", m.getRecords());
				break;
			}
		}
		managingService.sumColumns(wrapper);
		model.addAttribute("companies", managingService.getCompaniesNames());
		model.addAttribute("companyid", companyid);
		model.addAttribute("monoffset", monoffset);
		model.addAttribute("wrapper", wrapper);
		return "user/managingfile/managingfile";
	}

	@PostMapping(path = "/sort", params = "sortT=down")
	public String sortDownList(@RequestParam("field") ViewFields field, Long companyid, Long factoryid, Model model, int monoffset) {
		ListWrapper<FactoryElement> wrapper = managingService.getManagingFileData(monoffset, companyid);

		List<FactoryElement> list = wrapper.getList();
		for(FactoryElement m : list){
			if(m.getFactoryid().equals(factoryid)){
				sortViewService.sortRecords(field, "down", m.getRecords());
				break;
			}
		}
		managingService.sumColumns(wrapper);
		model.addAttribute("companies", managingService.getCompaniesNames());
		model.addAttribute("companyid", companyid);
		model.addAttribute("monoffset", monoffset);
		model.addAttribute("wrapper", wrapper);
		return "user/managingfile/managingfile";
	}


	@PostMapping(path = "/savetofile")
	public String saveTofile(@RequestParam("monoffset") int monoffset, Long companyid, Model model, RedirectAttributes ra){
		ListWrapper<FactoryElement> wrapper = managingService.getManagingFileData(monoffset, companyid);
		String path = new ExcelCreatorFileService().prepareExcelFileAndSave(wrapper, monoffset);
		ra.addAttribute("filename", path);

		return "redirect:/download";
	}

	@PostMapping(path = "/uploadfile")
	public String uploadFile(@RequestParam("monoffset") int monoffset, Long companyid, MultipartFile file, Model model, RedirectAttributes ra){
		ListWrapper<FactoryElement> wrapper = managingService.getManagingFileData(monoffset, companyid);
		try {
			new ExcelUploadUtils().fillWrapper(wrapper, file);
			managingService.saveToDb(wrapper, monoffset);
		}catch (OLE2NotOfficeXmlFileException e){
			ra.addAttribute("errormsg", "Nie można wczytac pliku z hasłem");
		} catch (IOException e) {
			e.printStackTrace();
			ra.addAttribute("errormsg", "Nie udało się otworzyć pliku");
		}
		return "redirect:/managingfile/" + companyid;
	}
}
