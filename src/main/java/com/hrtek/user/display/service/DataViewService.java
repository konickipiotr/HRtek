package com.hrtek.user.display.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hrtek.db.CompanyRepository;
import com.hrtek.db.FactoryRepository;
import com.hrtek.db.UserInfoRepository;
import com.hrtek.db.UserPositonsRepository;
import com.hrtek.db.worker.WorkerBasicRepository;
import com.hrtek.db.worker.WorkerDateRepository;
import com.hrtek.db.worker.WorkerRepository;
import com.hrtek.model.ListModel;
import com.hrtek.model.UserInfo;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;
import com.hrtek.settings.GlobalSettings;
import com.hrtek.user.display.views.DataView;

@Service
public class DataViewService {

	private WorkerRepository workerRepo;
	private WorkerBasicRepository workerBasicRepo;
	private CompanyRepository companyRepo;
	private FactoryRepository factoryRepo;
	private WorkerDateRepository workerDateRepo;
	private UserInfoRepository userInfoRepo;	
	private UserPositonsRepository userPositionRepo;
	
	@Autowired
	public DataViewService(WorkerRepository workerRepo, WorkerBasicRepository workerBasicRepo,
			CompanyRepository companyRepo, FactoryRepository factoryRepo, WorkerDateRepository workerDateRepo,
			UserInfoRepository userInfoRepo, UserPositonsRepository userPositionRepo) {
		this.workerRepo = workerRepo;
		this.workerBasicRepo = workerBasicRepo;
		this.companyRepo = companyRepo;
		this.factoryRepo = factoryRepo;
		this.workerDateRepo = workerDateRepo;
		this.userInfoRepo = userInfoRepo;
		this.userPositionRepo = userPositionRepo;
	}
	
	public void setModel(Model model) {
		model.addAttribute("companies", companyRepo.findAll());
		model.addAttribute("factories", factoryRepo.findAll());
		
		int agentpId = userPositionRepo.findByPosition(GlobalSettings.agent).getId();
		int coorPId = userPositionRepo.findByPosition(GlobalSettings.coordinator).getId();
		List<UserInfo> rec = userInfoRepo.getAgentsAndCoordinators(agentpId, coorPId);
		List<ListModel> list = new ArrayList<>();
		for(UserInfo u : rec) {
			list.add(new ListModel(u.getId(), u.getName()));
		}
		model.addAttribute("recruiters", list);
	}
	
	public List<DataView> getWorkersViewList(){
		List<Worker> worker_list = workerRepo.findAll();
		List<DataView> wv_list = new ArrayList<DataView>();
		
		for(Worker w : worker_list) {
			wv_list.add(buildSingelWorkerRecord(w));
		}
		return wv_list;
	}
	
	private DataView buildSingelWorkerRecord(Worker w) {
		long id = w.getId();
		DataView wv = new DataView(w);
		
		WorkerBasic wb = workerBasicRepo.findById(id).get();
		wv.setDateofbirth(wb.getDateofbirth());
		
		wv.setFromWorkerDate(workerDateRepo.findById(id).get());
		wv.setFactory(factoryRepo.findById(w.getFactoryid()).get().getShortname());
		wv.setCompany(companyRepo.findById(w.getCompanyid()).get().getShortname());
		wv.setRecruiter(userInfoRepo.findById(w.getRecruiter()).get().getName());
		
		return wv;
	}
}
