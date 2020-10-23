package com.hrtek.user.worker;

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

@Controller
@RequestMapping("/profil")
public class WorkerProfilController {
	
	private ProfilService profileService;
	private InUseService inUserService;
	private FilesService filesService;
	
	@Autowired
	public WorkerProfilController(ProfilService profileService, InUseService inUserService,
			FilesService filesService) {
		this.profileService = profileService;
		this.inUserService = inUserService;
		this.filesService = filesService;
	}

	@GetMapping("{id}")
	public String toProfil(@PathVariable("id") Long id, Model model) {
		Available av = inUserService.getAvailable(id);
		model.addAttribute("av", av);
		if(av!=null)
			System.out.println(av);
		profileService.setmodel(id, model);
		model.addAttribute("files", filesService.getWorkerFiles(id));
		return "user/profil/profil";
	}
	
	@PostMapping
	public String addFile(@RequestParam("id")Long id, @RequestParam("uploadFiles") MultipartFile[] uploadFiles) {
		Worker worker = profileService.getWorker(id);
		if(worker != null) {
			filesService.uploadWorkerFiles(uploadFiles, worker);
		}
		return "redirect:/profil/" + id;
	}
	
	@GetMapping("/delete/{workerid}/{id}")
	public String deleteFile(@PathVariable("workerid") Long workerid, @PathVariable("id") Long id) {
		filesService.deleteFile(id);
		return "redirect:/profil/" + workerid;
	}
	
	@GetMapping("/download/{id}")
	public String downloadFile(@PathVariable("id") Long id, RedirectAttributes ra) {
		String path = filesService.getFilepath(id);
		ra.addAttribute("filename", path);
		return "redirect:/download";
	}
	
	@PostMapping("/updatenote")
	public String updateNote(@RequestParam("id")Long id, @RequestParam("workerNote") String note) {
		profileService.updateNote(id, note);
		return "redirect:/profil/" + id;		
	}
}
