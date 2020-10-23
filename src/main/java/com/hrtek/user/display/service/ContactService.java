package com.hrtek.user.display.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hrtek.db.CompanyRepository;
import com.hrtek.db.FactoryRepository;
import com.hrtek.db.accommodation.BedRepository;
import com.hrtek.db.accommodation.HouseRepository;
import com.hrtek.db.worker.WorkerBasicRepository;
import com.hrtek.db.worker.WorkerContactRepository;
import com.hrtek.db.worker.WorkerRepository;
import com.hrtek.model.ListModel;
import com.hrtek.model.StatusFC;
import com.hrtek.model.accommodation.House;
import com.hrtek.model.worker.Contact;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;
import com.hrtek.user.display.views.ContactViewDis;

@Service
public class ContactService {
	
	private WorkerRepository workerRepo;
	private WorkerBasicRepository workerBasicRepo;
	private CompanyRepository companyRepo;
	private FactoryRepository factoryRepo;
	private WorkerContactRepository contactRepo;
	private BedRepository bedRepo;
	private HouseRepository houseRepo;
	
	
	@Autowired
	public ContactService(WorkerRepository workerRepo, WorkerBasicRepository workerBasicRepo,
			CompanyRepository companyRepo, FactoryRepository factoryRepo, WorkerContactRepository contactRepo,
			BedRepository bedRepo, HouseRepository houseRepo) {
		this.workerRepo = workerRepo;
		this.workerBasicRepo = workerBasicRepo;
		this.companyRepo = companyRepo;
		this.factoryRepo = factoryRepo;
		this.contactRepo = contactRepo;
		this.bedRepo = bedRepo;
		this.houseRepo = houseRepo;
	}
	
	public void setModel(Model model) {
		model.addAttribute("companies", companyRepo.findByStatus(StatusFC.ENABLED));
		model.addAttribute("factories", factoryRepo.findByStatus(StatusFC.ENABLED));
		
		List<House> hlist = houseRepo.findAll();
		List<ListModel> houses = new ArrayList<ListModel>();
		
		for(House h : hlist) {
			houses.add(new ListModel(h.getId(), h.getAddress()));
		}
		model.addAttribute("houses", houses);
	}
	
	public List<ContactViewDis> getContactViewList(){
		List<Worker> worker_list = workerRepo.findAll();
		List<ContactViewDis> bv_list = new ArrayList<ContactViewDis>();
		
		for(Worker w : worker_list) {
			bv_list.add(buildSingelWorkerRecord(w));
		}
		return bv_list;
	}
	
	private ContactViewDis buildSingelWorkerRecord(Worker w) {
		long id = w.getId();
		ContactViewDis cv = new ContactViewDis(w);
		WorkerBasic wb = workerBasicRepo.findById(id).get();
		cv.setDateofbirth(wb.getDateofbirth());
		
		Contact c = contactRepo.findById(id).get();
		cv.setFromContact(c);
		
		cv.setFactory(factoryRepo.findById(w.getFactoryid()).get().getShortname());
		cv.setCompany(companyRepo.findById(w.getCompanyid()).get().getShortname());
		return cv;
	}

}
