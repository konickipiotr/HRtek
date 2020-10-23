package com.hrtek.admin.others;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hrtek.db.CompanyRepository;
import com.hrtek.db.FactoryRepository;
import com.hrtek.db.LogRepository;
import com.hrtek.db.worker.DismissRepository;
import com.hrtek.db.worker.ResidencyRepository;
import com.hrtek.db.worker.TimesheetArchRepository;
import com.hrtek.db.worker.TimesheetRepository;
import com.hrtek.db.worker.WorkerBasicRepository;
import com.hrtek.db.worker.WorkerContactRepository;
import com.hrtek.db.worker.WorkerDateRepository;
import com.hrtek.db.worker.WorkerFinanceRepository;
import com.hrtek.db.worker.WorkerNoteRepository;
import com.hrtek.db.worker.WorkerPermintRepository;
import com.hrtek.db.worker.WorkerRepository;
import com.hrtek.enums.LogType;
import com.hrtek.files.FilesService;
import com.hrtek.model.Company;
import com.hrtek.model.Factory;
import com.hrtek.model.Log;
import com.hrtek.model.StatusFC;
import com.hrtek.model.UserInfo;
import com.hrtek.model.worker.Contact;
import com.hrtek.model.worker.Residency;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;
import com.hrtek.settings.Msg;
import com.hrtek.user.accommodation.HouseManagementService;
import com.hrtek.user.dismissed.Dismissed;

@Service
public class WorkerManagementService {
	
	private WorkerRepository workerRepo;
	private WorkerBasicRepository workerBasicRepo;
	private ResidencyRepository residencyRepo;
	private CompanyRepository companyRepo;
	private FactoryRepository factoryRepo;
	private DismissRepository dissmissRepo;
	private WorkerDateRepository workerDateRepo;
	private TimesheetRepository timesheetRepo;
	private WorkerFinanceRepository workerFinanceRepo;
	private WorkerPermintRepository workerPermitRepo;
	private WorkerContactRepository workerContactRepo;
	private WorkerNoteRepository workerNoteRepo;
	private HouseManagementService houseManagmentService;
	private TimesheetArchRepository timesheetArchRepo;
	private FilesService fileService;
	private LogRepository logRepo;
		
	@Autowired
	public WorkerManagementService(WorkerRepository workerRepo, WorkerBasicRepository workerBasicRepo,
			ResidencyRepository residencyRepo, CompanyRepository companyRepo, FactoryRepository factoryRepo,
			DismissRepository dissmissRepo, WorkerDateRepository workerDateRepo, TimesheetRepository timesheetRepo,
			WorkerFinanceRepository workerFinanceRepo, WorkerPermintRepository workerPermitRepo,
			WorkerContactRepository workerContactRepo, WorkerNoteRepository workerNoteRepo,
			HouseManagementService houseManagmentService, TimesheetArchRepository timesheetArchRepo,
			FilesService fileService, LogRepository logRepo) {
		this.workerRepo = workerRepo;
		this.workerBasicRepo = workerBasicRepo;
		this.residencyRepo = residencyRepo;
		this.companyRepo = companyRepo;
		this.factoryRepo = factoryRepo;
		this.dissmissRepo = dissmissRepo;
		this.workerDateRepo = workerDateRepo;
		this.timesheetRepo = timesheetRepo;
		this.workerFinanceRepo = workerFinanceRepo;
		this.workerPermitRepo = workerPermitRepo;
		this.workerContactRepo = workerContactRepo;
		this.workerNoteRepo = workerNoteRepo;
		this.houseManagmentService = houseManagmentService;
		this.timesheetArchRepo = timesheetArchRepo;
		this.fileService = fileService;
		this.logRepo = logRepo;
	}
	
	public void setModel(Model model) {
		model.addAttribute("companies", companyRepo.findByStatus(StatusFC.ENABLED));
		model.addAttribute("factories", factoryRepo.findByStatus(StatusFC.ENABLED));
	}

	public List<WorkerView> getWorkersViewList(){
		List<Worker> worker_list = workerRepo.findAll();
		List<WorkerView> wv_list = new ArrayList<WorkerView>();
		
		for(Worker w : worker_list) {
			wv_list.add(buildSingelWorkerRecord(w));
		}
		return wv_list;
	}
	
	public List<WorkerView> getArchWorkersViewList(){
		List<Dismissed> worker_list = dissmissRepo.findAll();
		List<WorkerView> wv_list = new ArrayList<WorkerView>();
		
		for(Dismissed w : worker_list) {
			wv_list.add(buildSingelArchWorkerRecord(w));
		}
		return wv_list;
	}
	
	private WorkerView buildSingelWorkerRecord(Worker w) {
		long id = w.getId();
		WorkerView wv = new WorkerView(w);
		
		WorkerBasic wb = workerBasicRepo.findById(id).get();
		wv.setDateofbirth(wb.getDateofbirth());
		wv.setPesel(wb.getPesel());
		
		Residency resid = residencyRepo.findById(w.getId()).get();
		
		wv.setPassport(getPassport(resid));
		
		wv.setFactory(factoryRepo.findById(w.getFactoryid()).get().getShortname());
		wv.setCompany(companyRepo.findById(w.getCompanyid()).get().getShortname());
		return wv;
	}
	
	private WorkerView buildSingelArchWorkerRecord(Dismissed d) {
		WorkerView wv = new WorkerView(d);
		wv.setPassport(getPassport(d));
		return wv;
	}
	
	private String getPassport(Dismissed r) {
		String pas = r.getPassport();
		String bpas = r.getBiopassport();
		
		if(pas != null && !pas.isBlank()) {
			return pas;
		}
		
		if(bpas == null)
			return "";
		return bpas;
	}
	
	private String getPassport(Residency r) {
		String pas = r.getPassport();
		String bpas = r.getBiopassport();
		
		if(pas != null && !pas.isBlank()) {
			return pas;
		}
		
		if(bpas == null)
			return "";
		return bpas;
	}
	
	public void deleteWorkerFromArchivePermanently(Long id, HttpSession session) {
		Dismissed dis = this.dissmissRepo.findById(id).get();
		
		this.fileService.deleteWorkerDirecory(dis);
		try {
			this.timesheetArchRepo.deleteById(id);
			
			UserInfo ui = (UserInfo) session.getAttribute("user");
			String logmsg = Msg.permanentlyRemovedfromArchive + dis.getFirstname() + " " + dis.getLastname() + "  PESEL=" + dis.getPassport() + "  Passport=" + dis.getPassport() + "  Date of birth=" + dis.getDateofbirth().toString();; 
			this.logRepo.save(new Log(ui.getName(),logmsg,LogType.DELETE));
			
		}catch (Exception e) {
			System.err.println("Can't delete timesheet because doesn't exist");
		}
		this.dissmissRepo.deleteById(id);
		
	}
	
	//************************************************************************8
	public void deleteCurrentWorkerPermanently(Long id, HttpSession session) {
		Optional<Worker> oworker = this.workerRepo.findById(id);
		if(oworker.isEmpty()) return;
		
		Worker worker = oworker.get();
		WorkerBasic wb = this.workerBasicRepo.findById(worker.getId()).get();
		
		UserInfo ui = (UserInfo) session.getAttribute("user");
		String logmsg = Msg.permanentlyRemovedfromArchive + worker.getFirstname() + " " + worker.getLastname() + "  PESEL=" + wb.getPesel() + "  Date of birth=" + wb.getDateofbirth().toString(); 
		this.logRepo.save(new Log(ui.getName(),logmsg,LogType.DELETE));
				
		deleteFromCompanyAndFactory(worker);
		removeAdressessAndContact(id);
		fileService.deleteWorkerDirecory(worker);
				
		this.workerBasicRepo.deleteById(id);
		this.workerPermitRepo.deleteById(id);
		this.workerNoteRepo.deleteById(id);
		this.residencyRepo.deleteById(id);
		this.workerDateRepo.deleteById(id);
		this.workerFinanceRepo.deleteById(id);
		this.timesheetRepo.deleteById(id);
		this.workerRepo.deleteById(id);
		
		

	}
	
	private void removeAdressessAndContact(Long id) {
		Contact contact = this.workerContactRepo.findById(id).get();
		Long bedid = contact.getBedid();
		if(bedid != null) {
			houseManagmentService.removePerson(bedid);
		}
		this.workerContactRepo.delete(contact);
		
	}
	
	private void deleteFromCompanyAndFactory(Worker worker) {
		Company company = this.companyRepo.findById(worker.getCompanyid()).get();
		Factory factory = this.factoryRepo.findById(worker.getFactoryid()).get();
		
		company.removePerson();
		factory.removePerson();
		this.companyRepo.save(company);
		this.factoryRepo.save(factory);
	}
	

}
