package com.hrtek.user.worker;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hrtek.db.CitizenshipRepository;
import com.hrtek.db.CompanyRepository;
import com.hrtek.db.DepartmentRepository;
import com.hrtek.db.FactoryRepository;
import com.hrtek.db.LogRepository;
import com.hrtek.db.UserInfoRepository;
import com.hrtek.db.UserPositonsRepository;
import com.hrtek.db.accommodation.BedRepository;
import com.hrtek.db.accommodation.HouseRepository;
import com.hrtek.db.accommodation.RoomRepository;
import com.hrtek.db.worker.ResidencyRepository;
import com.hrtek.db.worker.TimesheetRepository;
import com.hrtek.db.worker.WorkerBasicRepository;
import com.hrtek.db.worker.WorkerContactRepository;
import com.hrtek.db.worker.WorkerDateRepository;
import com.hrtek.db.worker.WorkerFinanceRepository;
import com.hrtek.db.worker.WorkerPermintRepository;
import com.hrtek.db.worker.WorkerRepository;
import com.hrtek.enums.LogType;
import com.hrtek.model.Company;
import com.hrtek.model.Factory;
import com.hrtek.model.Log;
import com.hrtek.model.UserInfo;
import com.hrtek.model.accommodation.Bed;
import com.hrtek.model.accommodation.House;
import com.hrtek.model.accommodation.Room;
import com.hrtek.model.worker.Contact;
import com.hrtek.model.worker.PermitStatement;
import com.hrtek.model.worker.Residency;
import com.hrtek.model.worker.StatusWorker;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;
import com.hrtek.model.worker.WorkerDate;
import com.hrtek.model.worker.WorkerFinance;
import com.hrtek.user.recruitment.WorkerAll;
import com.hrtek.user.timesheet.Timesheet;
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
	private LogRepository logRepo;
	private TimesheetRepository timesheetRepo;

	@Autowired
	public EditService(CitizenshipRepository citizenshipRepo, DepartmentRepository departmentRepo,
			FactoryRepository factroryRepo, CompanyRepository companyRepo, UserInfoRepository userInfoRepo,
			UserPositonsRepository userPositionRepo, HouseRepository houseRepo, RoomRepository roomRepo,
			BedRepository bedRepo, WorkerRepository workerRepo, WorkerBasicRepository workerBasicRepo,
			WorkerDateRepository workerDateRepo, WorkerContactRepository workerContactRepo,
			WorkerPermintRepository workerPermintRepo, ResidencyRepository residencyRepo, FactoryRepository factoryRepo,
			WorkerFinanceRepository workerFinanceRepo, LogRepository logRepo, TimesheetRepository timesheetRepo) {
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
		this.logRepo = logRepo;
		this.timesheetRepo = timesheetRepo;
	}

	public Worker getWorker(Long id) {
		Optional<Worker> oWorker = this.workerRepo.findById(id);
		if(oWorker.isEmpty())
			return null;
		return oWorker.get();
	}

	public void setWorkerModel(Worker worker, Model model) {

		
		SortFields fs = new SortFields(citizenshipRepo, departmentRepo, factroryRepo, companyRepo, userInfoRepo, userPositionRepo, bedRepo, houseRepo, roomRepo);
		model.addAttribute("name", worker.getName());
		model.addAttribute("companies", fs.getCompaniesInOrder(worker.getCompanyid()));
		model.addAttribute("factories", fs.getFactoryInOrder(worker.getFactoryid()));
		model.addAttribute("recruiters", fs.getOrederAgentsAndCoordinators(worker.getRecruiter()));
		model.addAttribute("worker", worker);
	}
	
	public void setBasicModel(Worker worker, Model model) {
		Optional<WorkerBasic> oWb = workerBasicRepo.findById(worker.getId());
		if(oWb.isEmpty()) {
			//TODO
			System.out.println("setBasicModel: nieznaleziono id");
		}
		WorkerBasic wb = oWb.get();
		SortFields fs = new SortFields(citizenshipRepo, departmentRepo, factroryRepo, companyRepo, userInfoRepo, userPositionRepo, bedRepo, houseRepo, roomRepo);
		
		model.addAttribute("name", worker.getName());
		model.addAttribute("citizenships", fs.getCitizenshipInOrder(wb.getCitizenship()));
		model.addAttribute("departments", fs.getDepartmentInOrder(wb.getDepartment()));
		model.addAttribute("workerBacic", wb);
	}
	
	public void setStatementModel(Worker worker, Model model) {
		Optional<PermitStatement> oPs = workerPermintRepo.findById(worker.getId());
		if(oPs.isEmpty()) {
			//TODO
			System.out.println("setStatementModel: nieznaleziono id");
		}
		PermitStatement ps = oPs.get();
		model.addAttribute("name", worker.getName());
		model.addAttribute("permitStatement", ps);
	}
	
	public void setPermitModel(Worker worker, Model model) {
		Optional<PermitStatement> oPs = workerPermintRepo.findById(worker.getId());
		if(oPs.isEmpty()) {
			//TODO
			System.out.println("setPermitModel: nieznaleziono id");
		}
		PermitStatement ps = oPs.get();
		model.addAttribute("name", worker.getName());
		model.addAttribute("permitStatement", ps);
	}
	
	public void setDatetModel(Worker worker, Model model) {
		Optional<WorkerDate> oWd = workerDateRepo.findById(worker.getId());
		if(oWd.isEmpty()) {
			//TODO
			System.out.println("setDatetModel: nieznaleziono id");
		}
		WorkerDate wd = oWd.get();
		model.addAttribute("name", worker.getName());
		model.addAttribute("workerDate", wd);
	}
	
	public void setResidencytModel(Worker worker, Model model) {
		Optional<Residency> oRe = residencyRepo.findById(worker.getId());
		if(oRe.isEmpty()) {
			//TODO
			System.out.println("setResidencytModel: nieznaleziono id");
		}
		Residency re = oRe.get();
		model.addAttribute("name", worker.getName());
		model.addAttribute("residency", re);
	}
	
	public void setContactModel(Worker worker, Model model) {
		Optional<Contact> oCo = workerContactRepo.findById(worker.getId());
		if(oCo.isEmpty()) {
			//TODO
			System.out.println("setContacttModel: nieznaleziono id");
		}
		Contact co = oCo.get();
		model.addAttribute("name", worker.getName());
		model.addAttribute("contact", co);
	}
	
	public void setFinanceModel(Worker worker, Model model) {
		Optional<WorkerFinance> oWf = workerFinanceRepo.findById(worker.getId());
		if(oWf.isEmpty()) {
			//TODO
			System.out.println("setContacttModel: nieznaleziono id");
		}
		WorkerFinance wf = oWf.get();
		model.addAttribute("name", worker.getName());
		model.addAttribute("workerFinance", wf);
	}
	
	public void setAddressPlModel(Worker worker, Model model) {
		Optional<Contact> oCo = workerContactRepo.findById(worker.getId());
		if(oCo.isEmpty()) {
			//TODO
			System.out.println("setContacttModel: nieznaleziono id");
		}
		SortFields sf = new SortFields(citizenshipRepo, departmentRepo, factroryRepo, companyRepo, userInfoRepo, userPositionRepo, bedRepo, houseRepo, roomRepo);
		Contact co = oCo.get();
		if(co.getBedid() == null) {
			co.setIsOhter(true);
		}else {
			co.setAcomdate(bedRepo.findById(co.getBedid()).get().getExpire());
		}
		model.addAttribute("name", worker.getName());
		model.addAttribute("contact", co);
		model.addAttribute("beds", sf.getBedsInOrder(co.getBedid()));
	}

	public void update(UsedTable usedTable, WorkerAll all, UserInfo user) {
		
		switch (usedTable) {
		case WORKER: updateWorker(all, user); break;
		case BASIC: updateBasic(all, user); break;
		case STATEMENT: updateStatement(all, user); break;
		case PERMIT: updatePermit(all, user); break;
		case DATE: updateDate(all, user); break;
		case RESIDENCY: updateResidency(all, user); break;
		case FINANCE: updateFinance(all, user); break;
		case CONTACT: updateContact(all, user); break;
		case ADDRESS: updateAddress(all, user); break;
		case ADDRESSPL: updateAddressPl(all, user); break;
		default:
			break;
		}
	}
	
	public void updateAddressPl(WorkerAll all, UserInfo user) {
		
		Optional<Contact> oCo = workerContactRepo.findById(all.getId());
		if(oCo.isEmpty()) {
			//TODO
			System.out.println("setContacttModel: nieznaleziono id");
		}
		Contact co = oCo.get();
		StringBuilder sb = new StringBuilder();
		sb.append("Modify: <br />" + co.toString() + "<br /> to: <br />");
		
		if(co.getBedid() == null && all.getBedid() == null) {
			co.setAddressPl(all);
			co.setaccommodation(null, null, null);
		}else if(co.getBedid() == null && all.getBedid() != null) {
			addBed(all, co);
		}else if(co.getBedid() != null && all.getBedid() == null) {
			removeBed(co.getBedid());
			co.setAddressPl(all);
			co.setaccommodation(null, null, null);
		}else {
			removeBed(co.getBedid());
			addBed(all, co);
		}
		
		this.workerContactRepo.save(co);
		sb.append(co.toString());
		this.logRepo.save(new Log(user.getName(), sb.toString(), LogType.MODIFY));
	}
	
	private void addBed(WorkerAll all, Contact c) {
		Bed b = bedRepo.findById(all.getBedid()).get();
		Room r = roomRepo.findById(b.getRoomid()).get();
		House h = houseRepo.findById(b.getHouseid()).get();
		h.addPerson();
		this.houseRepo.save(h);
		r.addPerson();
		this.roomRepo.save(r);
		b.setOccupied(c.getId(), all.getAcomdateTo());
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
	
	
	public void updateFinance(WorkerAll all, UserInfo user) {
		Optional<WorkerFinance> oWf = workerFinanceRepo.findById(all.getId());
		if(oWf.isEmpty()) {
			//TODO
			System.out.println("setContacttModel: nieznaleziono id");
		}
		WorkerFinance wf = oWf.get();
		StringBuilder sb = new StringBuilder();
		sb.append("Modify: <br />" + wf.toString() + "<br /> to: <br />");
		
		wf.setBonus(all.getBonus());
		wf.setWage(all.getWage());
		this.workerFinanceRepo.save(wf);
		
		sb.append(wf.toString());
		this.logRepo.save(new Log(user.getName(), sb.toString(), LogType.MODIFY));
	}
	
	public void updateAddress(WorkerAll all, UserInfo user) {
		Optional<Contact> oCo = workerContactRepo.findById(all.getId());
		if(oCo.isEmpty()) {
			//TODO
			System.out.println("setContacttModel: nieznaleziono id");
		}
		Contact co = oCo.get();
		StringBuilder sb = new StringBuilder();
		sb.append("Modify: <br />" + co.toString() + "<br /> to: <br />");
		
		co.setAddressAbroad(all);
		this.workerContactRepo.save(co);
		
		sb.append(co.toString());
		this.logRepo.save(new Log(user.getName(), sb.toString(), LogType.MODIFY));
	}
	
	public void updateContact(WorkerAll all, UserInfo user) {
		Optional<Contact> oCo = workerContactRepo.findById(all.getId());
		if(oCo.isEmpty()) {
			//TODO
			System.out.println("setContacttModel: nieznaleziono id");
		}
		Contact co = oCo.get();
		StringBuilder sb = new StringBuilder();
		sb.append("Modify: <br />" + co.toString() + "<br /> to: <br />");
		
		co.setContact(all);
		this.workerContactRepo.save(co);
		
		sb.append(co.toString());
		this.logRepo.save(new Log(user.getName(), sb.toString(), LogType.MODIFY));
	}
	
	public void updateResidency(WorkerAll all, UserInfo user) {
		Optional<Residency> oRe = residencyRepo.findById(all.getId());
		if(oRe.isEmpty()) {
			//TODO
			System.out.println("setPermitModel: nieznaleziono id");
		}
		Residency re = oRe.get();
		StringBuilder sb = new StringBuilder();
		sb.append("Modify: <br />" + re.toString() + "<br /> to: <br />");
		
		re.update(all);
		this.residencyRepo.save(re);
		
		sb.append(re.toString());
		this.logRepo.save(new Log(user.getName(), sb.toString(), LogType.MODIFY));
	}
	
	public void updateDate(WorkerAll all, UserInfo user) {
		Optional<WorkerDate> oWd = workerDateRepo.findById(all.getId());
		if(oWd.isEmpty()) {
			//TODO
			System.out.println("setPermitModel: nieznaleziono id");
		}
		WorkerDate wd = oWd.get();
		StringBuilder sb = new StringBuilder();
		sb.append("Modify: <br />" + wd.toString() + "<br /> to: <br />");
		
		wd.update(all);
		Worker worker = this.workerRepo.findById(all.getId()).get();
		if(all.getStartZus() != null && all.getEndZus() == null) 
			worker.setStatus(StatusWorker.ACTIVE);
		else
			worker.setStatus(StatusWorker.INACTIVE);
		
		this.workerDateRepo.save(wd);
		
		sb.append(wd.toString());
		this.logRepo.save(new Log(user.getName(), sb.toString(), LogType.MODIFY));
	}
	
	public void updatePermit(WorkerAll all, UserInfo user) {
		Optional<PermitStatement> oPs = workerPermintRepo.findById(all.getId());
		if(oPs.isEmpty()) {
			//TODO
			System.out.println("setPermitModel: nieznaleziono id");
		}
		PermitStatement ps = oPs.get();
		StringBuilder sb = new StringBuilder();
		sb.append("Modify: <br />" + ps.toString() + "<br /> to: <br />");
		
		ps.updatePermit(all);
		this.workerPermintRepo.save(ps);
		
		sb.append(ps.toString());
		this.logRepo.save(new Log(user.getName(), sb.toString(), LogType.MODIFY));
	}
	
	public void updateStatement(WorkerAll all, UserInfo user) {
		Optional<PermitStatement> oPs = workerPermintRepo.findById(all.getId());
		if(oPs.isEmpty()) {
			//TODO
			System.out.println("setStatementModel: nieznaleziono id");
		}
		PermitStatement ps = oPs.get();
		StringBuilder sb = new StringBuilder();
		sb.append("Modify: <br />" + ps.toString() + "<br /> to: <br />");
		
		ps.updateStatement(all);
		this.workerPermintRepo.save(ps);
		
		sb.append(ps.toString());
		this.logRepo.save(new Log(user.getName(), sb.toString(), LogType.MODIFY));
	}
	
	private void updateBasic(WorkerAll all, UserInfo user) {
		Optional<WorkerBasic> oWb = workerBasicRepo.findById(all.getId());
		if(oWb.isEmpty()) {
			//TODO
			System.out.println("updateBasic: nieznaleziono id");
		}
		WorkerBasic wb = oWb.get();
		StringBuilder sb = new StringBuilder();
		sb.append("Modify: <br />" + wb.toString() + "<br /> to: <br />");
		
		wb.update(all);
		this.workerBasicRepo.save(wb);
		
		sb.append(wb.toString());
		this.logRepo.save(new Log(user.getName(), sb.toString(), LogType.MODIFY));
	}
	
	private void updateWorker(WorkerAll all, UserInfo user) {
		Optional<Worker> oWorker = workerRepo.findById(all.getId());
		if(oWorker.isEmpty()) {
			//TODO
			System.out.println("updateWorker(): nieznalezion ");
			return;
		}
		
		Worker w = oWorker.get();
		StringBuilder sb = new StringBuilder();
		sb.append("Modify: <br />" + w.toString() + "<br /> to: <br />");
		
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
			Timesheet ts = this.timesheetRepo.findById(w.getId()).get();
			ts.setFactoryid(newF.getId());
			this.timesheetRepo.save(ts);
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
		
		sb.append(w.toString());
		this.logRepo.save(new Log(user.getName(), sb.toString(), LogType.MODIFY));
	}
	
	
	

}
