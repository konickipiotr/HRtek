package com.hrtek.user.dismissed;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hrtek.files.FilesService;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerDate;

@Controller
@RequestMapping("/dismiss")
public class DismissController {
	
	private DismissedService dismissedService;
	private FilesService filesService;
	

	@Autowired
	public DismissController(DismissedService dismissedService, FilesService filesService) {
		this.dismissedService = dismissedService;
		this.filesService = filesService;
	}

	@PostMapping
	public String setEndDate(@RequestParam("id") Long id, Model model) {
		model.addAttribute("workerDate", dismissedService.getWorkerDate(id));
		return "user/dismiss/setdate";
	}
	
	@PostMapping("/end")
	public String dismissedWorker(WorkerDate wd, Model model, HttpSession session) {
		Dismissed dismissed = dismissedService.movetoArchive(wd, session);
		model.addAttribute("dis", dismissed);
		model.addAttribute("files", filesService.getWorkerArchFiles(dismissed.getId()));
		return "user/dismiss/dismissedprofil";
	}
	
	@GetMapping("{id}")
	public String dismissedProfil(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dis", dismissedService.getDismissed(id));
		model.addAttribute("files", filesService.getWorkerArchFiles(id));
		return "user/dismiss/dismissedprofil";
	}
	
	@PostMapping("/addfile")
	public String addFile(@RequestParam("id")Long id, @RequestParam("uploadFiles") MultipartFile[] uploadFiles) {
		Dismissed dismissed = dismissedService.getDismissed(id);
		if(dismissed != null) {
			filesService.uploadArchiveWorkerFiles(uploadFiles, dismissed);
		}
		return "redirect:/dismiss/" + id;
	}
	
	@GetMapping("/delete/{workerid}/{id}")
	public String deleteFile(@PathVariable("workerid") Long workerid, @PathVariable("id") Long id) {
		filesService.deleteArchiveFile(id);
		return "redirect:/dismiss/" + workerid;
	}
	
	@GetMapping("/download/{id}")
	public String downloadFile(@PathVariable("id") Long id, RedirectAttributes ra) {
		String path = filesService.getArchiveFilepath(id);
		ra.addAttribute("filename", path);
		return "redirect:/download";
	}
	

}
