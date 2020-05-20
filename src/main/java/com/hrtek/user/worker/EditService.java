package com.hrtek.user.worker;

import java.beans.Statement;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hrtek.db.CitizenshipRepository;
import com.hrtek.db.CompanyRepository;
import com.hrtek.db.DepartmentRepository;
import com.hrtek.db.FactoryRepository;
import com.hrtek.db.UserInfoRepository;
import com.hrtek.db.UserPositonsRepository;
import com.hrtek.db.accommodation.BedRepository;
import com.hrtek.db.accommodation.HouseRepository;
import com.hrtek.db.accommodation.RoomRepository;
import com.hrtek.db.worker.ResidencyRepository;
import com.hrtek.db.worker.WorkerBasicRepository;
import com.hrtek.db.worker.WorkerContactRepository;
import com.hrtek.db.worker.WorkerDateRepository;
import com.hrtek.db.worker.WorkerFilesRepository;
import com.hrtek.db.worker.WorkerFinanceRepository;
import com.hrtek.db.worker.WorkerNoteRepository;
import com.hrtek.db.worker.WorkerPermintRepository;
import com.hrtek.db.worker.WorkerRepository;
import com.hrtek.model.Company;
import com.hrtek.model.Factory;
import com.hrtek.model.UserInfo;
import com.hrtek.model.accommodation.Bed;
import com.hrtek.model.accommodation.House;
import com.hrtek.model.accommodation.Room;
import com.hrtek.model.worker.Contact;
import com.hrtek.model.worker.PermitStatement;
import com.hrtek.model.worker.Residency;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;
import com.hrtek.model.worker.WorkerDate;
import com.hrtek.model.worker.WorkerFinance;
import com.hrtek.user.recruitment.WorkerAll;
import com.hrtek.utils.SortFields;

@Service
public class EditService {
	
	private CitizenshipRepository citizenshipRepo;
	private DepartmentRepository departmentRepo;
	private FactoryRepository factroryRepo;
	private CompanyRepository companyRepo;
	private UserInfoRepository userInfoRepo;
	private UserPositonsRepository userPositionRepo;
	private HouseRepository houseRepo;
	private RoomRepository roomRepo;
	private BedRepository bedRepo;
	private WorkerRepository workerRepo;
	private WorkerBasicRepository workerBasicRepo;
	private WorkerDateRepository workerDateRepo;
	private WorkerContactRepository workerContactRepo;
	private WorkerPermintRepository workerPermintRepo;
	private ResidencyRepository residencyRepo;
	private FactoryRepository factoryRepo;
	private WorkerFinanceRepository workerFinanceRepo;
	private WorkerNoteRepository workerNoteRepo;
	private WorkerFilesRepository workerFilesRepo;
	private UserPositonsRepository userPositonsRepo;
	
	@Autowired
	public EditService(CitizenshipRepository citizenshipRepo, DepartmentRepository departmentRepo,
			FactoryRepository factroryRepo, CompanyRepository companyRepo, UserInfoRepository userInfoRepo,
			UserPositonsRepository userPositionRepo, HouseRepository houseRepo, RoomRepository roomRepo,
			BedRepository bedRepo, WorkerRepository workerRepo, WorkerBasicRepository workerBasicRepo,
			WorkerDateRepository workerDateRepo, WorkerContactRepository workerContactRepo,
			WorkerPermintRepository workerPermintRepo, ResidencyRepository residencyRepo, FactoryRepository factoryRepo,
			WorkerFinanceRepository workerFinanceRepo, WorkerNoteRepository workerNoteRepo,
			WorkerFilesRepository workerFilesRepo, UserPositonsRepository userPositonsRepo) {
		this.citizenshipRepo = citizenshipRepo;
		this.departmentRepo = departmentRepo;
		this.factroryRepo = factroryRepo;
		this.companyRepo = companyRepo;
		this.userInfoRepo = userInfoRepo;
		this.userPositionRepo = userPositionRepo;
		this.houseRepo = houseRepo;
		this.roomRepo = roomRepo;
		this.bedRepo = bedRepo;
		this.workerRepo = workerRepo;
		this.workerBasicRepo = workerBasicRepo;
		this.workerDateRepo = workerDateRepo;
		this.workerContactRepo = workerContactRepo;
		this.workerPermintRepo = workerPermintRepo;
		this.residencyRepo = residencyRepo;
		this.factoryRepo = factoryRepo;
		this.workerFinanceRepo = workerFinanceRepo;
		this.workerNoteRepo = workerNoteRepo;
		this.workerFilesRepo = workerFilesRepo;
		this.userPositonsRepo = userPositonsRepo;
	}

	public void setWorkerModel(Long id, Model model) {
		Optional<Worker> ow = workerRepo.findById(id);
		if(ow.isEmpty())
			throw new IllegalArgumentException();
		
		Worker w = ow.get();
		
		SortFields fs = new SortFields(citizenshipRepo, departmentRepo, factroryRepo, companyRepo, userInfoRepo, userPositionRepo, bedRepo, houseRepo, roomRepo);
		
		model.addAttribute("companies", fs.getCompaniesInOrder(w.getCompanyid()));
		model.addAttribute("factories", fs.getFactoryInOrder(w.getFactoryid()));
		model.addAttribute("recruiters", fs.getOrederAgentsAndCoordinators(w.getRecruiter()));
		model.addAttribute("worker", w);
	}
	
	public void setBasicModel(Long id, Model model) {
		Optional<WorkerBasic> oWb = workerBasicRepo.findById(id);
		if(oWb.isEmpty()) {
			//TODO
			System.out.println("setBasicModel: nieznaleziono id");
		}
		WorkerBasic wb = oWb.get();
		SortFields fs = new SortFields(citizenshipRepo, departmentRepo, factroryRepo, companyRepo, userInfoRepo, userPositionRepo, bedRepo, houseRepo, roomRepo);
		
		model.addAttribute("citizenships", fs.getCitizenshipInOrder(wb.getCitizenship()));
		model.addAttribute("departments", fs.getDepartmentInOrder(wb.getDepartment()));
		model.addAttribute("workerBacic", wb);
	}
	
	public void setStatementModel(Long id, Model model) {
		Optional<PermitStatement> oPs = workerPermintRepo.findById(id);
		if(oPs.isEmpty()) {
			//TODO
			System.out.println("setStatementModel: nieznaleziono id");
		}
		PermitStatement ps = oPs.get();
		model.addAttribute("permitStatement", ps);
	}
	
	public void setPermitModel(Long id, Model model) {
		Optional<PermitStatement> oPs = workerPermintRepo.findById(id);
		if(oPs.isEmpty()) {
			//TODO
			System.out.println("setPermitModel: nieznaleziono id");
		}
		PermitStatement ps = oPs.get();
		model.addAttribute("permitStatement", ps);
	}
	
	public void setDatetModel(Long id, Model model) {
		Optional<WorkerDate> oWd = workerDateRepo.findById(id);
		if(oWd.isEmpty()) {
			//TODO
			System.out.println("setDatetModel: nieznaleziono id");
		}
		WorkerDate wd = oWd.get();
		model.addAttribute("workerDate", wd);
	}
	
	public void setResidencytModel(Long id, Model model) {
		Optional<Residency> oRe = residencyRepo.findById(id);
		if(oRe.isEmpty()) {
			//TODO
			System.out.println("setResidencytModel: nieznaleziono id");
		}
		Residency re = oRe.get();
		model.addAttribute("residency", re);
	}
	
	public void setContactModel(Long id, Model model) {
		Optional<Contact> oCo = workerContactRepo.findById(id);
		if(oCo.isEmpty()) {
			//TODO
			System.out.println("setContacttModel: nieznaleziono id");
		}
		Contact co = oCo.get();
		model.addAttribute("contact", co);
	}
	
	public void setFinanceModel(Long id, Model model) {
		Optional<WorkerFinance> oWf = workerFinanceRepo.findById(id);
		if(oWf.isEmpty()) {
			//TODO
			System.out.println("setContacttModel: nieznaleziono id");
		}
		WorkerFinance wf = oWf.get();
		model.addAttribute("workerFinance", wf);
	}
	
	public void setAddressPlModel(Long id, Model model) {
		Optional<Contact> oCo = workerContactRepo.findById(id);
		if(oCo.isEmpty()) {
			//TODO
			System.out.println("setContacttModel: nieznaleziono id");
		}
		SortFields sf = new SortFields(citizenshipRepo, departmentRepo, factroryRepo, companyRepo, userInfoRepo, userPositionRepo, bedRepo, houseRepo, roomRepo);
		Contact co = oCo.get();
		if(co.getBedid() == null) {
			co.setIsOhter(true);
		}
		model.addAttribute("contact", co);
		model.addAttribute("beds", sf.getBedsInOrder(co.getBedid()));
	}

	public void update(UsedTable usedTable, WorkerAll all) {
		
		switch (usedTable) {
		case WORKER: updateWorker(all); break;
		case BASIC: updateBasic(all); break;
		case STATEMENT: updateStatement(all); break;
		case PERMIT: updatePermit(all); break;
		case DATE: updateDate(all); break;
		case RESIDENCY: updateResidency(all); break;
		case FINANCE: updateFinance(all); break;
		case CONTACT: updateContact(all); break;
		case ADDRESS: updateAddress(all); break;
		case ADDRESSPL: updateAddressPl(all); break;
		default:
			break;
		}
	}
	
	public void updateAddressPl(WorkerAll all) {
		Optional<Contact> oCo = workerContactRepo.findById(all.getId());
		if(oCo.isEmpty()) {
			//TODO
			System.out.println("setContacttModel: nieznaleziono id");
		}
		Contact co = oCo.get();
		
		if(co.getBedid() == null && all.getBedid() == null) {
			co.setAddressPl(all);
			co.setaccommodation(null, null, null);
		}else if(co.getBedid() == null && all.getBedid() != null) {
			addBed(all.getBedid(), co);
		}else if(co.getBedid() != null && all.getBedid() == null) {
			removeBed(co.getBedid());
			co.setAddressPl(all);
			co.setaccommodation(null, null, null);
		}else {
			removeBed(co.getBedid());
			addBed(all.getBedid(), co);
		}
		this.workerContactRepo.save(co);
	}
	
	private void addBed(Long bedid, Contact c) {
		Bed b = bedRepo.findById(bedid).get();
		Room r = roomRepo.findById(b.getRoomid()).get();
		House h = houseRepo.findById(b.getHouseid()).get();
		h.addPerson();
		this.houseRepo.save(h);
		r.addPerson();
		this.roomRepo.save(r);
		b.setOccupied(c.getId(), null);
		this.bedRepo.save(b);
		
		c.setPladdress(h.getAddress());
		c.setPlpostcode(h.getPostcode());
		c.setPlcity(h.getCity());
		c.setaccommodation(b.getId(), r.getId(), h.getId());
	}
	
	private void removeBed(Long bedid) {
		Bed b = bedRepo.findById(bedid).get();
		Room r = roomRepo.findById(b.getRoomid()).get();
		House h = houseRepo.findById(b.getHouseid()).get();
		h.removePerson();
		this.houseRepo.save(h);
		r.removePerson();
		this.roomRepo.save(r);
		b.setFree();
		this.bedRepo.save(b);
	}
	
	
	public void updateFinance(WorkerAll all) {
		Optional<WorkerFinance> oWf = workerFinanceRepo.findById(all.getId());
		if(oWf.isEmpty()) {
			//TODO
			System.out.println("setContacttModel: nieznaleziono id");
		}
		WorkerFinance wf = oWf.get();
		wf.setBonus(all.getBonus());
		this.workerFinanceRepo.save(wf);
	}
	
	public void updateAddress(WorkerAll all) {
		Optional<Contact> oCo = workerContactRepo.findById(all.getId());
		if(oCo.isEmpty()) {
			//TODO
			System.out.println("setContacttModel: nieznaleziono id");
		}
		Contact co = oCo.get();
		co.setAddressAbroad(all);
		this.workerContactRepo.save(co);
	}
	
	public void updateContact(WorkerAll all) {
		Optional<Contact> oCo = workerContactRepo.findById(all.getId());
		if(oCo.isEmpty()) {
			//TODO
			System.out.println("setContacttModel: nieznaleziono id");
		}
		Contact co = oCo.get();
		co.setContact(all);
		this.workerContactRepo.save(co);
	}
	
	public void updateResidency(WorkerAll all) {
		Optional<Residency> oRe = residencyRepo.findById(all.getId());
		if(oRe.isEmpty()) {
			//TODO
			System.out.println("setPermitModel: nieznaleziono id");
		}
		Residency re = oRe.get();
		re.update(all);
		this.residencyRepo.save(re);
	}
	
	public void updateDate(WorkerAll all) {
		Optional<WorkerDate> oWd = workerDateRepo.findById(all.getId());
		if(oWd.isEmpty()) {
			//TODO
			System.out.println("setPermitModel: nieznaleziono id");
		}
		WorkerDate wd = oWd.get();
		wd.update(all);
		this.workerDateRepo.save(wd);
	}
	
	public void updatePermit(WorkerAll all) {
		Optional<PermitStatement> oPs = workerPermintRepo.findById(all.getId());
		if(oPs.isEmpty()) {
			//TODO
			System.out.println("setPermitModel: nieznaleziono id");
		}
		PermitStatement ps = oPs.get();
		ps.updatePermit(all);
		this.workerPermintRepo.save(ps);
	}
	
	public void updateStatement(WorkerAll all) {
		Optional<PermitStatement> oPs = workerPermintRepo.findById(all.getId());
		if(oPs.isEmpty()) {
			//TODO
			System.out.println("setStatementModel: nieznaleziono id");
		}
		PermitStatement ps = oPs.get();
		ps.updateStatement(all);
		this.workerPermintRepo.save(ps);
	}
	
	private void updateBasic(WorkerAll all) {
		Optional<WorkerBasic> oWb = workerBasicRepo.findById(all.getId());
		if(oWb.isEmpty()) {
			//TODO
			System.out.println("updateBasic: nieznaleziono id");
		}
		WorkerBasic wb = oWb.get();
		wb.update(all);
		this.workerBasicRepo.save(wb);
	}
	
	private void updateWorker(WorkerAll all) {
		Optional<Worker> oWorker = workerRepo.findById(all.getId());
		if(oWorker.isEmpty()) {
			//TODO
			System.out.println("updateWorker(): nieznalezion ");
			return;
		}
		
		Worker w = oWorker.get();
		w.setFirstname(all.getFirstname());
		w.setLastname(all.getLastname());
		
		if(!w.getFactoryid().equals(all.getFactoryid())) {
			Factory newF = factoryRepo.findById(all.getFactoryid()).get();
			WorkerFinance wf = workerFinanceRepo.findById(w.getId()).get();
			wf.setHourlyrate(newF.getHourlyrate());
			newF.addPerson();
			this.workerFinanceRepo.save(wf);
			this.factoryRepo.save(newF);
			
			if(w.getFactoryid() != null) {
				Factory old = factoryRepo.findById(w.getFactoryid()).get();
				old.removePerson();
				this.factoryRepo.save(old);
			}
			w.setFactoryid(newF.getId());
		}
		
		if(!w.getCompanyid().equals(all.getCompanyid())) {
			Company newC = companyRepo.findById(all.getCompanyid()).get();
			newC.addPerson();
			this.companyRepo.save(newC);
			
			if(w.getCompanyid() != null) {
				Company oldC = this.companyRepo.findById(w.getCompanyid()).get();
				oldC.removePerson();
				this.companyRepo.save(oldC);
			}
			w.setCompanyid(newC.getId());
		}
		
		if(!w.getRecruiter().equals(all.getRecruiter())) {
			UserInfo newUi = userInfoRepo.findById(all.getRecruiter()).get();
			w.setRecruiter(newUi.getId());
		}
		this.workerRepo.save(w);
	}
	
	
	

}
