package com.hrtek.files.doc;

import java.util.Optional;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrtek.db.CompanyRepository;
import com.hrtek.db.FactoryRepository;
import com.hrtek.db.worker.ResidencyRepository;
import com.hrtek.db.worker.WorkerBasicRepository;
import com.hrtek.db.worker.WorkerContactRepository;
import com.hrtek.db.worker.WorkerFilesRepository;
import com.hrtek.db.worker.WorkerRepository;
import com.hrtek.model.Company;
import com.hrtek.model.Factory;
import com.hrtek.model.worker.Contact;
import com.hrtek.model.worker.Residency;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;
import com.hrtek.model.worker.WorkerFiles;

@Service
public class DocumentService {
	
	private WorkerRepository workerRepo;
	private ResidencyRepository residencyRepo;
	private CompanyRepository companyRepo;
	private FactoryRepository factoryRepo;
	private WorkerContactRepository contactRepo;
	private WorkerFilesRepository workerFileRepo;
	private WorkerBasicRepository workerBasicRepo;
	
	@Autowired
	public DocumentService(WorkerRepository workerRepo, ResidencyRepository residencyRepo,
			CompanyRepository companyRepo, FactoryRepository factoryRepo, WorkerContactRepository contactRepo,
			WorkerFilesRepository workerFileRepo, WorkerBasicRepository workerBasicRepo) {
		super();
		this.workerRepo = workerRepo;
		this.residencyRepo = residencyRepo;
		this.companyRepo = companyRepo;
		this.factoryRepo = factoryRepo;
		this.contactRepo = contactRepo;
		this.workerFileRepo = workerFileRepo;
		this.workerBasicRepo = workerBasicRepo;
	}

	public String prepareContract(Long id, double wage, String sWage) {
		Optional<Worker> oWorker = workerRepo.findById(id);
		if(oWorker.isEmpty()) {
			//TODO
		}
		
		Worker worker = oWorker.get();
		Company company = companyRepo.findById(worker.getCompanyid()).get();
		Factory factory = factoryRepo.findById(worker.getFactoryid()).get();
		Residency residency = residencyRepo.findById(worker.getId()).get();
		Contact contact = contactRepo.findById(worker.getId()).get();
		WorkerBasic wb = workerBasicRepo.findById(worker.getId()).get();
		
		Doc<XWPFDocument> contract = new Contract(company, worker, residency, contact, factory, wb, wage, sWage);
		contract.prepareDoc();
		
		this.workerFileRepo.save(new WorkerFiles(worker.getId(), contract.getFilename(), contract.getFilepath(), 1));
		return new SaveFile().saveDoc(contract);
		
	}
}
