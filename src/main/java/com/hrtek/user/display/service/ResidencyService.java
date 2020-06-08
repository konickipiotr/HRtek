package com.hrtek.user.display.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hrtek.db.CompanyRepository;
import com.hrtek.db.FactoryRepository;
import com.hrtek.db.worker.ResidencyRepository;
import com.hrtek.db.worker.WorkerBasicRepository;
import com.hrtek.db.worker.WorkerRepository;
import com.hrtek.model.StatusFC;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;
import com.hrtek.user.display.views.ResidencyView;

@Service
public class ResidencyService {

	private WorkerRepository workerRepo;
	private WorkerBasicRepository workerBasicRepo;
	private ResidencyRepository residencyRepo;
	private CompanyRepository companyRepo;
	private FactoryRepository factoryRepo;
	
	public ResidencyService(WorkerRepository workerRepo, WorkerBasicRepository workerBasicRepo,
			ResidencyRepository residencyRepo, CompanyRepository companyRepo, FactoryRepository factoryRepo) {
		this.workerRepo = workerRepo;
		this.workerBasicRepo = workerBasicRepo;
		this.residencyRepo = residencyRepo;
		this.companyRepo = companyRepo;
		this.factoryRepo = factoryRepo;
	}
	
	public void setModel(Model model) {
		model.addAttribute("companies", companyRepo.findByStatus(StatusFC.ENABLED));
		model.addAttribute("factories", factoryRepo.findByStatus(StatusFC.ENABLED));
	}
	

	public List<ResidencyView> getResidencyViewList(){
		List<Worker> worker_list = workerRepo.findAll();
		List<ResidencyView> re_list = new ArrayList<>(); 
		
		for(Worker w : worker_list) {
			re_list.add(buildSingleResidencyRecord(w));
		}
		return re_list;
	}
	
	private ResidencyView buildSingleResidencyRecord(Worker w) {
		long id = w.getId();
		ResidencyView rv = new ResidencyView(w);
		WorkerBasic wb = workerBasicRepo.findById(id).get();
		rv.setDateofbirth(wb.getDateofbirth());
		rv.setFromResidency(residencyRepo.findById(id).get());
		
		return rv;
	}
	
}
