package com.hrtek.user.recruitment;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrtek.db.CandidateRepository;
import com.hrtek.db.CompanyRepository;
import com.hrtek.db.FactoryRepository;
import com.hrtek.db.LogRepository;
import com.hrtek.db.accommodation.BedRepository;
import com.hrtek.db.accommodation.HouseRepository;
import com.hrtek.db.accommodation.RoomRepository;
import com.hrtek.db.worker.ResidencyRepository;
import com.hrtek.db.worker.TimesheetRepository;
import com.hrtek.db.worker.WorkerBasicRepository;
import com.hrtek.db.worker.WorkerContactRepository;
import com.hrtek.db.worker.WorkerDateRepository;
import com.hrtek.db.worker.WorkerFinanceRepository;
import com.hrtek.db.worker.WorkerNoteRepository;
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
import com.hrtek.model.worker.WorkerNote;
import com.hrtek.settings.Msg;
import com.hrtek.user.accommodation.Bedstatus;
import com.hrtek.user.timesheet.Timesheet;

@Service
@Transactional
public class HireService {

	private CandidateRepository candidateRepo;
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
	private CompanyRepository companyRepo;
	private WorkerFinanceRepository workerFinanceRepo;
	private WorkerNoteRepository workerNoteRepo;
	private TimesheetRepository timesheetRepo;
	private LogRepository logRepo;

	@Autowired
	public HireService(CandidateRepository candidateRepo, HouseRepository houseRepo, RoomRepository roomRepo,
			BedRepository bedRepo, WorkerRepository workerRepo, WorkerBasicRepository workerBasicRepo,
			WorkerDateRepository workerDateRepo, WorkerContactRepository workerContactRepo,
			WorkerPermintRepository workerPermintRepo, ResidencyRepository residencyRepo, FactoryRepository factoryRepo,
			CompanyRepository companyRepo, WorkerFinanceRepository workerFinanceRepo,
			WorkerNoteRepository workerNoteRepo, TimesheetRepository timesheetRepo, LogRepository logRepo) {
		this.candidateRepo = candidateRepo;
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
		this.companyRepo = companyRepo;
		this.workerFinanceRepo = workerFinanceRepo;
		this.workerNoteRepo = workerNoteRepo;
		this.timesheetRepo = timesheetRepo;
		this.logRepo = logRepo;
	}
	
	public Worker hireAgain(WorkerAll wall, HttpSession session) {
		StringBuilder logmsg = new StringBuilder();
		Worker worker = new Worker(wall);
		this.workerRepo.save(worker);
		WorkerBasic wb = new WorkerBasic(worker, wall);
		logmsg.append(Msg.hireWorker + worker.getName() + " date of birth: " + wb.getDateofbirth());
		
		this.workerBasicRepo.save(wb);
		this.workerDateRepo.save(new WorkerDate(worker, wall));
		this.workerPermintRepo.save(new PermitStatement(worker, wall));
		this.residencyRepo.save(new Residency(worker, wall));
		this.workerNoteRepo.save(new WorkerNote(worker.getId(), wall.getNote()));
		this.timesheetRepo.save(new Timesheet(worker, LocalDate.now(ZoneId.systemDefault())));
		setAccommodation(worker, wall, logmsg);
		increasNumberOfWorker(worker, wall.getWage());
		
		UserInfo ui = (UserInfo) session.getAttribute("user");
		this.logRepo.save(new Log(ui.getName(), logmsg.toString(), LogType.CREATE));
		return worker;
	}

	public Long hire(NewWorker nw, HttpSession session) {
		StringBuilder logmsg = new StringBuilder();
		Worker worker = new Worker(nw);
		this.workerRepo.save(worker);
		WorkerBasic wb = new WorkerBasic(worker, nw);
		logmsg.append(Msg.hireWorker + worker.getName() + " date of birth: " + wb.getDateofbirth());
		
		this.workerBasicRepo.save(wb);
		this.workerDateRepo.save(new WorkerDate(worker, nw));
		this.workerPermintRepo.save(new PermitStatement(worker));
		this.residencyRepo.save(new Residency(worker, nw));
		this.workerNoteRepo.save(new WorkerNote(worker.getId(), nw.getNote()));
		this.timesheetRepo.save(new Timesheet(worker, LocalDate.now(ZoneId.systemDefault())));

		setAccommodation(worker, nw, logmsg);
		increasNumberOfWorker(worker, nw.getWage());
		removeCandidate(nw, worker);
		
		UserInfo ui = (UserInfo) session.getAttribute("user");
		this.logRepo.save(new Log(ui.getName(), logmsg.toString(), LogType.CREATE));
		return worker.getId();
	}
	
	private void setAccommodation(Worker w, WorkerAll nw, StringBuilder logmsg) {
		Contact contact = new Contact(w);
		contact.setAddressAbroad(nw);
		contact.setContact(nw);
		
		if(nw.getIsOhter() == null) {
			Bed bed = bedRepo.findById(nw.getBedid()).get();
			House house = houseRepo.findById(bed.getHouseid()).get();
			Room room = roomRepo.findById(bed.getRoomid()).get();
			
			contact.setPladdress(house.getAddress());
			contact.setPlpostcode(house.getPostcode());
			contact.setPlcity(house.getCity());
			contact.setaccommodation(bed.getId(), room.getId(), house.getId());
			
			house.addPerson();
			this.houseRepo.save(house);
			room.addPerson();
			this.roomRepo.save(room);
			bed.setBedstatus(Bedstatus.OCCUPIED);
			bed.setWorkerid(w.getId());
			System.out.println(nw.getAcomdate());
			bed.setExpire(nw.getAcomdate());
			this.bedRepo.save(bed);
			logmsg.append("<br />assigned to: house - " + house.getAddress() + " : room - " +  room.getRoomname()); 
		}else{
			contact.setAddressPl(nw);
		}
		this.workerContactRepo.save(contact);
	}
	
	private void setAccommodation(Worker w, NewWorker nw, StringBuilder logmsg) {
		Contact contact = new Contact(w);
		contact.setAddressAbroad(nw);
		contact.setContact(nw);
		
		if(nw.getIsOhter() == null) {
			Bed bed = bedRepo.findById(nw.getBedid()).get();
			House house = houseRepo.findById(bed.getHouseid()).get();
			Room room = roomRepo.findById(bed.getRoomid()).get();
			
			nw.setPladdress(house.getAddress());
			nw.setPlpostcode(house.getPostcode());
			nw.setPlcity(house.getCity());
			contact.setPladdress(house.getAddress());
			contact.setPlpostcode(house.getPostcode());
			contact.setPlcity(house.getCity());
			contact.setaccommodation(bed.getId(), room.getId(), house.getId());
			
			house.addPerson();
			this.houseRepo.save(house);
			room.addPerson();
			this.roomRepo.save(room);
			bed.setBedstatus(Bedstatus.OCCUPIED);
			bed.setWorkerid(w.getId());
			bed.setExpire(nw.getAcomdate());
			this.bedRepo.save(bed);
			logmsg.append("<br />assigned to: house - " + house.getAddress() + " : room - " +  room.getRoomname()); 
		}else{
			contact.setAddressPl(nw);
		}
		this.workerContactRepo.save(contact);
	}	
	

	
	private void increasNumberOfWorker(Worker w, double wage) {
		Factory factory = factoryRepo.findById(w.getFactoryid()).get();
		factory.addPerson();
		this.workerFinanceRepo.save(new WorkerFinance(w.getId(), factory.getHourlyrate(), wage));
		this.factoryRepo.save(factory);
		
		Company company = companyRepo.findById(w.getCompanyid()).get();
		company.addPerson();
		this.companyRepo.save(company);
	}
	
	private void removeCandidate(NewWorker nw , Worker w) {
		if(nw.getId() != null) {
			if(this.candidateRepo.existsById(nw.getId())) {
				this.candidateRepo.deleteById(nw.getId());
			}
		}
		nw.setId(w.getId());
	}

	public WorkerAll prepareWorkerAll(Long id) {
		WorkerAll w = new WorkerAll();
		Worker worker = workerRepo.findById(id).orElseThrow();
		w.setWorker(worker);
		
		w.setWorkerBasic(workerBasicRepo.findById(worker.getId()).get());
		w.setFromWorkerDate(workerDateRepo.findById(worker.getId()).get());
		w.setFromPermitStatement(workerPermintRepo.findById(worker.getId()).get());
		w.setFromResidency(residencyRepo.findById(worker.getId()).get());
		w.setFromContact(workerContactRepo.findById(worker.getId()).get());
		w.setNote(workerNoteRepo.findById(worker.getId()).get().getText());
		w.setWage(workerFinanceRepo.findById(worker.getId()).get().getWage());
		
		Contact c = workerContactRepo.findById(worker.getId()).get();
		
		if(c.getBedid() != null) {
			Bed bed = bedRepo.findById(c.getBedid()).get();
			w.setAcomdate(bed.getExpire());
		}
		

		return w;
	}

	public Worker updateWorker(WorkerAll workerAll, HttpSession session) {
		Optional<Worker> oWorker = workerRepo.findById(workerAll.getId());
		
		if(oWorker.isEmpty()) {
			System.out.println("updateWorker: Nie odnaleziono pracownika");
			return null;
		}
		StringBuilder logmsg = new StringBuilder("Update worker data:");
		
		Worker worker = oWorker.get();
		Long id = worker.getId();
		uWorker(workerAll, worker);
		logmsg.append("<br />" + worker.toString());
		
		WorkerBasic wb = workerBasicRepo.findById(id).get();
		wb.update(workerAll);
		this.workerBasicRepo.save(wb);
		logmsg.append("<br />" + wb.toString());
		
		WorkerDate wd = workerDateRepo.findById(id).get();
		wd.update(workerAll);
		this.workerDateRepo.save(wd);
		logmsg.append("<br />" + wd.toString());
		
		Residency res = residencyRepo.findById(id).get();
		res.update(workerAll);
		this.residencyRepo.save(res);
		logmsg.append("<br />" + res.toString());
		
		PermitStatement ps = workerPermintRepo.findById(id).get();
		ps.update(workerAll);
		this.workerPermintRepo.save(ps);
		logmsg.append("<br />" + ps.toString());
		
		uContact(workerAll, id, logmsg);
		
		WorkerFinance wf = workerFinanceRepo.findById(id).get();
		wf.setWage(workerAll.getWage());
		this.workerFinanceRepo.save(wf);
		
		WorkerNote wn = workerNoteRepo.findById(id).get();
		wn.setText(workerAll.getNote());
		this.workerNoteRepo.save(wn);
		logmsg.append("<br />" + wn.getText());
		
		UserInfo ui = (UserInfo) session.getAttribute("user");
		this.logRepo.save(new Log(ui.getName(), logmsg.toString() , LogType.MODIFY));
		
		return worker;
	}
	
	private void uContact(WorkerAll all, Long id, StringBuilder sb) {
		
		Contact contact = workerContactRepo.findById(id).get();
		contact.setAddressAbroad(all);
		contact.setContact(all);
		
		if(contact.getBedid() == null && all.getBedid() == null) {
			contact.setAddressPl(all);
			contact.setaccommodation(null, null, null);
		}else if(contact.getBedid() == null && all.getBedid() != null) {
			addBed(all, contact);
		}else if(contact.getBedid() != null && all.getBedid() == null) {
			removeBed(contact.getBedid());
			contact.setAddressPl(all);
			contact.setaccommodation(null, null, null);
		}else {
			removeBed(contact.getBedid());
			addBed(all, contact);
		}
		
		sb.append("<br />" + contact.toString());
		this.workerContactRepo.save(contact);		
	}
	
	private void uWorker(WorkerAll all,Worker worker) {
		worker.setFirstname(all.getFirstname());
		worker.setLastname(all.getLastname());
		if(all.getStartZus() != null && all.getEndZus() == null)
			worker.setStatus(StatusWorker.ACTIVE);
		else
			worker.setStatus(StatusWorker.INACTIVE);
		
		if(!worker.getFactoryid().equals(all.getFactoryid())) {
			Optional<Factory> oold = factoryRepo.findById(worker.getFactoryid());
			if(oold.isPresent()) {
				Factory old = oold.get();
				old.removePerson();
				this.factoryRepo.save(old);
			}
			Factory newFactory = factoryRepo.findById(all.getFactoryid()).get();
			newFactory.addPerson();
			worker.setFactoryid(newFactory.getId());
			WorkerFinance fin = workerFinanceRepo.findById(worker.getId()).get();
			fin.setHourlyrate(newFactory.getHourlyrate());
			this.workerFinanceRepo.save(fin);
			this.factoryRepo.save(newFactory);
		}
		
		if(!worker.getCompanyid().equals(all.getCompanyid())) {
			Optional<Company> oold = companyRepo.findById(worker.getCompanyid());
			if(oold.isPresent()) {
				Company old = oold.get();
				old.removePerson();
				this.companyRepo.save(old);
			}
			
			Company newComp = this.companyRepo.findById(all.getCompanyid()).get();
			newComp.addPerson();
			worker.setCompanyid(newComp.getId());
			this.companyRepo.save(newComp);
		}
		
		if(!worker.getRecruiter().equals(all.getRecruiter())) {
			worker.setRecruiter(all.getRecruiter());
		}
		workerRepo.save(worker);
	}

	private void addBed(WorkerAll all, Contact c) {
		Bed b = bedRepo.findById(all.getBedid()).get();
		Room r = roomRepo.findById(b.getRoomid()).get();
		House h = houseRepo.findById(b.getHouseid()).get();
		h.addPerson();
		this.houseRepo.save(h);
		r.addPerson();
		this.roomRepo.save(r);
		b.setOccupied(c.getId(), all.getAcomdate());
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
	
}
