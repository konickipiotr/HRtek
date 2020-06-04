package com.hrtek.user.display.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hrtek.db.CitizenshipRepository;
import com.hrtek.db.CompanyRepository;
import com.hrtek.db.FactoryRepository;
import com.hrtek.db.worker.ResidencyRepository;
import com.hrtek.db.worker.WorkerBasicRepository;
import com.hrtek.db.worker.WorkerDateRepository;
import com.hrtek.db.worker.WorkerRepository;
import com.hrtek.model.worker.Residency;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;
import com.hrtek.model.worker.WorkerDate;
import com.hrtek.user.display.views.BasicView;



@Service
public class BasicService {

	private WorkerRepository workerRepo;
	private WorkerBasicRepository workerBasicRepo;
	private ResidencyRepository residencyRepo;
	private WorkerDateRepository workerDateRepo;
	private CompanyRepository companyRepo;
	private CitizenshipRepository citizenshipRepo;
	private FactoryRepository factoryRepo;
	
	@Autowired
	public BasicService(WorkerRepository workerRepo, WorkerBasicRepository workerBasicRepo,
			ResidencyRepository residencyRepo, WorkerDateRepository workerDateRepo, CompanyRepository companyRepo,
			CitizenshipRepository citizenshipRepo, FactoryRepository factoryRepo) {
		this.workerRepo = workerRepo;
		this.workerBasicRepo = workerBasicRepo;
		this.residencyRepo = residencyRepo;
		this.workerDateRepo = workerDateRepo;
		this.companyRepo = companyRepo;
		this.citizenshipRepo = citizenshipRepo;
		this.factoryRepo = factoryRepo;
	}
	
	public void setModel(Model model) {
		model.addAttribute("citizenships", citizenshipRepo.findAll());
		model.addAttribute("companies", companyRepo.findAll());
		model.addAttribute("factories", factoryRepo.findAll());
	}

	public List<BasicView> getBasicViewList(){
		List<Worker> worker_list = workerRepo.findAll();
		List<BasicView> bv_list = new ArrayList<BasicView>();
		
		for(Worker w : worker_list) {
			bv_list.add(buildSingelWorkerRecord(w));
		}
		return bv_list;
	}
	
	private BasicView buildSingelWorkerRecord(Worker w) {
		long id = w.getId();
		BasicView bv = new BasicView(w);
		
		WorkerBasic wb = workerBasicRepo.findById(id).get();
		bv.setFromWorkerBasic(wb);
		bv.setFromWorkerDate(workerDateRepo.findById(id).get());
		bv.setFromResidency(residencyRepo.findById(id).get());
		
		if(wb.getCitizenship() != null)
			bv.setCitizenship(citizenshipRepo.findById(wb.getCitizenship()).get().getName());
		
		bv.setFactory(factoryRepo.findById(w.getFactoryid()).get().getShortname());
		bv.setCompany(companyRepo.findById(w.getCompanyid()).get().getShortname());
		return bv;
	}
}
