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
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hrtek.db.worker.WorkerFilesArchRepository;
import com.hrtek.db.worker.WorkerFilesRepository;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerFilesArch;
import com.hrtek.model.worker.WorkerFiles;
import com.hrtek.settings.GlobalSettings;
import com.hrtek.user.dismissed.Dismissed;

@Service
@Transactional
public class FilesService {

	@Autowired
	private WorkerFilesRepository workerFilesRepo;
	@Autowired
	private WorkerFilesArchRepository workerFilesArchRepo;
	private String hrtekpath;
	
	
	public FilesService() {
		String userName = System.getProperty("user.name");
		
		this.hrtekpath = "/home/" + userName + GlobalSettings.hrtekRoot;
	}
	
	public List<WorkerFiles> getWorkerFiles(Long id){
		List<WorkerFiles> wf_files = workerFilesRepo.findByWorkerid(id);
		return wf_files;
	}
	
	public List<WorkerFilesArch> getWorkerArchFiles(Long id){
		List<WorkerFilesArch> wf_files = workerFilesArchRepo.findByWorkerid(id);
		return wf_files;
	}

	public void uploadWorkerFiles(MultipartFile[] uploadfiles, Worker worker) {
		if(uploadfiles.length < 1) return;
		if(uploadfiles[0].isEmpty()) return;
		List<WorkerFiles> wfiles_list = new ArrayList<>();
		List<String> extensions = Arrays.asList(".jpg", ".jpeg", ".png", ".gif", ".tiff", ".bmp");
		
		List<String> orginalnames = new ArrayList<>();
		for(MultipartFile f : uploadfiles)
			orginalnames.add(StringUtils.cleanPath(f.getOriginalFilename()));
		

		String path = hrtekpath + GlobalSettings.hrtekWorkersDir + worker.getId()+ "_" + worker.getLastname() + "/"; 
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
	
	public void uploadArchiveWorkerFiles(MultipartFile[] uploadfiles, Dismissed dismissed) {
		if(uploadfiles.length < 1) return;
		if(uploadfiles[0].isEmpty()) return;
		List<WorkerFilesArch> wfiles_list = new ArrayList<>();
		List<String> extensions = Arrays.asList(".jpg", ".jpeg", ".png", ".gif", ".tiff", ".bmp");
		
		List<String> orginalnames = new ArrayList<>();
		for(MultipartFile f : uploadfiles)
			orginalnames.add(StringUtils.cleanPath(f.getOriginalFilename()));
		

		String path = hrtekpath + "/Archive/" + dismissed.getId()+ "_" + dismissed.getLastname() + "/"; 
		Path pp = Paths.get(path);
		Path dirpath = pp.toAbsolutePath();
		new File(dirpath.toString()).mkdirs();
		try {
			for(int i = 0 ; i < uploadfiles.length; i++) {
				String sdirpath = dirpath + "/" +orginalnames.get(i);
				
				
				
				Path fullpath = Paths.get(sdirpath);
				Files.copy(uploadfiles[i].getInputStream(),fullpath, StandardCopyOption.REPLACE_EXISTING);
				
				WorkerFilesArch wfile = new WorkerFilesArch();
				
				String fname = orginalnames.get(i);
				int dot = fname.lastIndexOf('.');
				String ext = fname.substring(dot, fname.length());
				if(extensions.contains(ext)) {
					wfile.setType(1);
				}
				
				
				wfile.setWorkerid(dismissed.getId());
				wfile.setFilename(orginalnames.get(i));
				wfile.setPath(fullpath.toString());
				wfiles_list.add(wfile);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		workerFilesArchRepo.saveAll(wfiles_list);
		
	}
	
	
	public void deleteFile(Long id) {
		Optional<WorkerFiles> oFile = workerFilesRepo.findById(id);
		if(oFile.isEmpty()) {
			//TODO
		}
		
		WorkerFiles file = oFile.get();
		
		String ss = file.getPath();
		
		File f = new File(ss);
		f.delete();
		this.workerFilesRepo.delete(file);
	}
	
	public void deleteArchiveFile(Long id) {
		Optional<WorkerFilesArch> oFile = workerFilesArchRepo.findById(id);
		if(oFile.isEmpty()) {
			//TODO
		}
		
		WorkerFilesArch file = oFile.get();
		
		String ss = file.getPath();
		
		File f = new File(ss);
		f.delete();
		this.workerFilesArchRepo.delete(file);
	}
	
	public void deleteWorkerDirecory(Worker worker) {
		List<WorkerFiles> files = this.workerFilesRepo.findByWorkerid(worker.getId());
		if(files.isEmpty()) return;
		
		String dirName = hrtekpath + GlobalSettings.hrtekWorkersDir + worker.getId()+ "_" + worker.getLastname() + "/";
		try {
			FileUtils.deleteDirectory(new File(dirName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.workerFilesRepo.deleteByWorkerid(worker.getId());
	}
	
	public void deleteWorkerDirecory(Dismissed worker) {
		List<WorkerFilesArch> files = this.workerFilesArchRepo.findByWorkerid(worker.getId());
		if(files.isEmpty()) return;
		
		String dirName = hrtekpath + "/Archive/" + worker.getId()+ "_" + worker.getLastname() + "/";
		try {
			FileUtils.deleteDirectory(new File(dirName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.workerFilesArchRepo.deleteByWorkerid(worker.getId());
	}
	
	public String getFilepath(Long id) {
		Optional<WorkerFiles> oFile = workerFilesRepo.findById(id);
		if(oFile.isEmpty()) {
			//TODO
		}
		
		WorkerFiles file = oFile.get();
		return file.getPath();
	}
	
	public String getArchiveFilepath(Long id) {
		Optional<WorkerFilesArch> oFile = workerFilesArchRepo.findById(id);
		if(oFile.isEmpty()) {
			//TODO
		}
		
		WorkerFilesArch file = oFile.get();
		return file.getPath();
	}
	
	public List<WorkerFilesArch> copyUserDataToArchive(Worker worker, List<WorkerFiles> files, Long newid){
		List<WorkerFilesArch> newFiles = new ArrayList<>();
		String newWorkerdir = newid + "_" +  worker.getLastname() + "/"; 
		String newPath = hrtekpath + "/Archive/" + newWorkerdir;
		new File(newPath).mkdirs();
		
		for(WorkerFiles f : files) {
			File source = new File(f.getPath());
			File dest = new File(newPath + f.getFilename());
			try {
			    FileUtils.copyFile(source, dest);
			    WorkerFilesArch wf = new WorkerFilesArch(f);
			    wf.setWorkerid(newid);
			    wf.setPath(dest.getAbsolutePath());
			    newFiles.add(wf);
			} catch (IOException e) {
			    e.printStackTrace();
			}
		}
		return newFiles;		
	}
	
	public void copyWorkerDate_HireAgain(Worker worker, Long oldid){
		List<WorkerFilesArch> fArch = this.workerFilesArchRepo.findByWorkerid(oldid);
		if(fArch.isEmpty())
			return;
		List<WorkerFiles> cFiles = this.workerFilesRepo.findByWorkerid(worker.getId());
		String newWorkerdir = worker.getId() + "_" +  worker.getLastname() + "/"; 
		String newPath = hrtekpath + GlobalSettings.hrtekWorkersDir + newWorkerdir;
		File file = new File(newPath);
		if(!file.exists())
			file.mkdirs();
		
		
		
		for(WorkerFilesArch f : fArch) {
			File source = new File(f.getPath());
			File dest = new File(newPath + f.getFilename());
			try {
			    FileUtils.copyFile(source, dest);
			    WorkerFiles wf = new WorkerFiles(f);
			    wf.setWorkerid(worker.getId());
			    wf.setPath(dest.getAbsolutePath());
			    cFiles.add(wf);
			} catch (IOException e) {
			    e.printStackTrace();
			}
		}
		this.workerFilesRepo.saveAll(cFiles);
	}
}
