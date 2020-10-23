package com.hrtek.user.statistic;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrtek.db.CompanyRepository;
import com.hrtek.db.FactoryRepository;
import com.hrtek.db.worker.WorkerBasicRepository;
import com.hrtek.db.worker.WorkerRepository;
import com.hrtek.model.Company;
import com.hrtek.model.Factory;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;

@Service
public class StatisticService {

	private CompanyRepository companyRepo;
	private FactoryRepository facotoryRepo;
	private WorkerBasicRepository workerBasicRepo;
	private WorkerRepository workerRepo;
	
	@Autowired
	public StatisticService(CompanyRepository companyRepo, FactoryRepository facotoryRepo,
			WorkerBasicRepository workerBasicRepo,WorkerRepository workerRepo) {
		this.companyRepo = companyRepo;
		this.facotoryRepo = facotoryRepo;
		this.workerBasicRepo = workerBasicRepo;
		this.workerRepo = workerRepo;
	}

	public List<CompanyStat> getCompaniesStat() {
		List<Company> companies = companyRepo.findAll();
		List<CompanyStat> statlist = new ArrayList<>();
		
		for(Company c : companies) {
			statlist.add(prepareCompanyStat(c));
		}
		
		return statlist;
	}
	
	private CompanyStat prepareCompanyStat(Company c){
		CompanyStat companyStat = new CompanyStat(c);
		List<Long> workersId = getComanyWorkersIdList(c.getId());
		
		int less26 = countWorkersBelow26(workersId);
		
		companyStat.setCurrentnumofworkers(workersId.size());
		
		companyStat.setLess26(less26);
		companyStat.setMore26(workersId.size() - less26);
		companyStat.setFactorystat(getFactoriesStat(c.getId()));
		return companyStat;
	}
	
	private List<Long> getComanyWorkersIdList(Long companyid){
		List<Worker> workers = workerRepo.findByCompanyid(companyid);
		List<Long> workersId = workers.stream()
									.map(Worker::getId)
									.collect(Collectors.toList());
		return workersId;
	}
	
	private int countWorkersBelow26(List<Long> ids) {
		List<WorkerBasic> list = workerBasicRepo.findAllById(ids);
		LocalDate date = LocalDate.now(ZoneId.systemDefault());
		date = date.minusYears(26);
		
		int num = 0;
		for(WorkerBasic w : list) {
			if(w.getDateofbirth().isBefore(date)) {
				num++;
			}
		}
		return num;
	}
	
	private List<FactoryStat> getFactoriesStat(Long companyid){
		List<Factory> list = facotoryRepo.findAll();
		List<FactoryStat> fstatlist = new ArrayList<>();
		
		for(Factory f : list) {
			int numW = workerRepo.countByCompanyidAndFactoryid(companyid, f.getId());
			FactoryStat fs = new FactoryStat(f);
			fs.setNumofworkers(numW);
			fstatlist.add(fs);
		}
		return fstatlist;		
	}
	
	
}
