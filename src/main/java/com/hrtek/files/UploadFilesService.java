package com.hrtek.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hrtek.db.worker.WorkerFilesRepository;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerFiles;
import com.hrtek.settings.GlobalSettings;

@Service
public class UploadFilesService {

	@Autowired
	private WorkerFilesRepository workerFilesRepo;
	private String hrtekpath;
	
	
	public UploadFilesService() {
		String userName = System.getProperty("user.name");
		
		this.hrtekpath = "/home/" + userName + GlobalSettings.hrtekRoot + GlobalSettings.hrtekWorkersDir;
	}

	public void uploadWorkerFiles(MultipartFile[] uploadfiles, Worker worker) {
		List<WorkerFiles> wfiles_list = new ArrayList<>();
		List<String> extensions = Arrays.asList(".jpg", ".jpeg", ".png", ".gif", ".tiff", ".bmp");
		
		List<String> orginalnames = new ArrayList<>();
		for(MultipartFile f : uploadfiles)
			orginalnames.add(StringUtils.cleanPath(f.getOriginalFilename()));
		

		String path = hrtekpath + worker.getId() + worker.getLastname() + "/"; 
		Path pp = Paths.get(path);
		Path dirpath = pp.toAbsolutePath();
		new File(dirpath.toString()).mkdirs();
		try {
			for(int i = 0 ; i < uploadfiles.length; i++) {
				String sdirpath = dirpath + "/" +orginalnames.get(i);
				
				
				
				Path fullpath = Paths.get(sdirpath);
				Files.copy(uploadfiles[i].getInputStream(),fullpath, StandardCopyOption.REPLACE_EXISTING);
				
				WorkerFiles wfile = new WorkerFiles();
				
				String fname = orginalnames.get(i);
				int dot = fname.lastIndexOf('.');
				String ext = fname.substring(dot, fname.length());
				if(extensions.contains(ext)) {
					wfile.setType(1);
				}
				
				
				wfile.setWorkerid(worker.getId());
				wfile.setFilename(orginalnames.get(i));
				wfile.setPath(fullpath.toString());
				wfiles_list.add(wfile);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		workerFilesRepo.saveAll(wfiles_list);
	}
}
