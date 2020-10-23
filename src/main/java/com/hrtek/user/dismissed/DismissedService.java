package com.hrtek.user.dismissed;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrtek.db.CitizenshipRepository;
import com.hrtek.db.CompanyRepository;
import com.hrtek.db.DepartmentRepository;
import com.hrtek.db.FactoryRepository;
import com.hrtek.db.LogRepository;
import com.hrtek.db.UserInfoRepository;
import com.hrtek.db.accommodation.BedRepository;
import com.hrtek.db.accommodation.HouseRepository;
import com.hrtek.db.accommodation.RoomRepository;
import com.hrtek.db.worker.DismissRepository;
import com.hrtek.db.worker.ResidencyRepository;
import com.hrtek.db.worker.TimesheetArchRepository;
import com.hrtek.db.worker.TimesheetRepository;
import com.hrtek.db.worker.WorkerBasicRepository;
import com.hrtek.db.worker.WorkerContactRepository;
import com.hrtek.db.worker.WorkerDateRepository;
import com.hrtek.db.worker.WorkerFilesArchRepository;
import com.hrtek.db.worker.WorkerFilesRepository;
import com.hrtek.db.worker.WorkerFinanceRepository;
import com.hrtek.db.worker.WorkerNoteRepository;
import com.hrtek.db.worker.WorkerPermintRepository;
import com.hrtek.db.worker.WorkerRepository;
import com.hrtek.enums.LogType;
import com.hrtek.files.FilesService;
import com.hrtek.model.Company;
import com.hrtek.model.Factory;
import com.hrtek.model.Log;
import com.hrtek.model.UserInfo;
import com.hrtek.model.accommodation.Bed;
import com.hrtek.model.accommodation.House;
import com.hrtek.model.accommodation.Room;
import com.hrtek.model.worker.Contact;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;
import com.hrtek.model.worker.WorkerDate;
import com.hrtek.model.worker.WorkerFilesArch;
import com.hrtek.model.worker.WorkerFiles;
import com.hrtek.settings.GlobalSettings;
import com.hrtek.user.timesheet.Timesheet;
import com.hrtek.user.timesheet.TimesheetArch;

@Service
@Transactional
public class DismissedService {
	
	private WorkerRepository workerRepo;
	private HouseRepository houseRepo;
	private RoomRepository roomRepo;
	private BedRepository bedRepo;
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
	private CitizenshipRepository citizenshipRepo;
	private DepartmentRepository departmentRepo;
	private UserInfoRepository userInfoRepo;
	private DismissRepository dismissRepo;
	private TimesheetArchRepository timesheetArchRepo;
	private WorkerFilesArchRepository workerFileArchRepo;
	private WorkerFilesRepository workerFileRepo;
	private FilesService filesService;
	private LogRepository logRepo;
	
	@Autowired
	public DismissedService(WorkerRepository workerRepo, HouseRepository houseRepo, RoomRepository roomRepo,
			BedRepository bedRepo, WorkerBasicRepository workerBasicRepo, WorkerDateRepository workerDateRepo,
			WorkerContactRepository workerContactRepo, WorkerPermintRepository workerPermintRepo,
			ResidencyRepository residencyRepo, FactoryRepository factoryRepo, CompanyRepository companyRepo,
			WorkerFinanceRepository workerFinanceRepo, WorkerNoteRepository workerNoteRepo,
			TimesheetRepository timesheetRepo, CitizenshipRepository citizenshipRepo,
			DepartmentRepository departmentRepo, UserInfoRepository userInfoRepo, DismissRepository dismissRepo,
			TimesheetArchRepository timesheetArchRepo, WorkerFilesArchRepository workerFileArchRepo,
			WorkerFilesRepository workerFileRepo, FilesService filesService, LogRepository logRepo) {
		this.workerRepo = workerRepo;
		this.houseRepo = houseRepo;
		this.roomRepo = roomRepo;
		this.bedRepo = bedRepo;
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
		this.citizenshipRepo = citizenshipRepo;
		this.departmentRepo = departmentRepo;
		this.userInfoRepo = userInfoRepo;
		this.dismissRepo = dismissRepo;
		this.timesheetArchRepo = timesheetArchRepo;
		this.workerFileArchRepo = workerFileArchRepo;
		this.workerFileRepo = workerFileRepo;
		this.filesService = filesService;
		this.logRepo = logRepo;
	}

	public WorkerDate getWorkerDate(Long id) {
		Optional<WorkerDate> oWorkerdate = workerDateRepo.findById(id);
		if(oWorkerdate.isEmpty()) {
			//TODO
		}
		return oWorkerdate.get();
	}
	


	public Dismissed getDismissed(Long id) {
		Optional<Dismissed> oDismissed = dismissRepo.findById(id);
		if(oDismissed.isEmpty()) {
			//TODO
		}
		return oDismissed.get();
	}

	public Dismissed movetoArchive(WorkerDate wd, HttpSession session) {
		
		saveDate(wd);
		Long id = wd.getId();
		Dismissed dismissed = saveInDissmised(id);
		
		String logmsg = "Fired(moved to archive): <br />"+ dismissed.toString();
		UserInfo ui = (UserInfo) session.getAttribute("user");
		this.logRepo.save(new Log(ui.getName(), logmsg , LogType.DELETE));
		
		removeFromDB(id);
		return dismissed;
	}
	
	private void saveDate(WorkerDate wd) {
		WorkerDate w = workerDateRepo.findById(wd.getId()).get();
		w.setEndWork(wd.getEndWork());
		w.setEndZus(wd.getEndZus());
		this.workerDateRepo.save(w);
	}
	
	private Dismissed saveInDissmised(Long id) {
		Optional<Worker> oWorker = workerRepo.findById(id);
		if(oWorker.isEmpty()) {
			return null;
			//TODO
		}
		Worker w = oWorker.get();
		Dismissed dismissed = new Dismissed();
		dismissed.fromWorker(w);
		WorkerBasic wb = workerBasicRepo.findById(id).get();
		dismissed.fromWorkerBasic(wb);
		dismissed.fromWorkerDate(workerDateRepo.findById(id).get());
		dismissed.fromResidency(residencyRepo.findById(id).get());
		dismissed.fromWorkerFinance(workerFinanceRepo.findById(id).get());
		dismissed.fromPermitStatement(workerPermintRepo.findById(id).get());
		dismissed.fromContact(workerContactRepo.findById(id).get());
		dismissed.setNote(workerNoteRepo.findById(id).get().getText());
		dismissed.setFactory(factoryRepo.findById(w.getFactoryid()).get().getShortname());
		dismissed.setCompany(companyRepo.findById(w.getCompanyid()).get().getShortname());
		if(wb.getCitizenship() != null)
			dismissed.setCitizenship(citizenshipRepo.findById(wb.getCitizenship()).get().getName());
		if(wb.getDepartment() != null)
			dismissed.setDepartment(departmentRepo.findById(wb.getDepartment()).get().getDepartment());
		dismissed.setRecruiter(userInfoRepo.findById(w.getRecruiter()).get().getName());
		dismissed.setDismisseddate(LocalDate.now(GlobalSettings.zid));
		this.dismissRepo.save(dismissed);
	
		
		Timesheet t1 = this.timesheetRepo.findById(w.getId()).get();
		TimesheetArch t2 = new TimesheetArch(t1);
		t2.setWorkerid(dismissed.getId());
		t2.setFactory(dismissed.getFactory());
		this.timesheetArchRepo.save(t2);
		
		List<WorkerFiles> wf_files = this.workerFileRepo.findByWorkerid(w.getId());
		if(!wf_files.isEmpty()) {
			List<WorkerFilesArch> newPath = filesService.copyUserDataToArchive(w, wf_files, dismissed.getId());
			this.workerFileArchRepo.saveAll(newPath);
		}
		
		return dismissed;
	}
	
	private void releaseBed(Long bedid) {
		Bed bed = bedRepo.findById(bedid).get();
		Room room = roomRepo.findById(bed.getRoomid()).get();
		House house = houseRepo.findById(bed.getHouseid()).get();
		
		house.removePerson();
		this.houseRepo.save(house);
		
		room.removePerson();
		this.roomRepo.save(room);
		
		bed.setFree();
		this.bedRepo.save(bed);		
	}
	
	private void removeFromDB(Long id) {
		Worker worker = workerRepo.findById(id).get();
		
		Contact c = workerContactRepo.findById(id).get();
		if(c.getBedid() != null) {
			releaseBed(c.getBedid());
		}
		
		Factory factory = factoryRepo.findById(worker.getFactoryid()).get();
		factory.removePerson();
		this.factoryRepo.save(factory);
		
		Company company = companyRepo.findById(worker.getCompanyid()).get();
		company.removePerson();
		this.companyRepo.save(company);
		
		workerContactRepo.deleteById(id);
		workerPermintRepo.deleteById(id);
		workerFinanceRepo.deleteById(id);
		workerDateRepo.deleteById(id);
		workerBasicRepo.deleteById(id);
		workerNoteRepo.deleteById(id);
		timesheetRepo.deleteById(id);
		filesService.deleteWorkerDirecory(worker);
		workerRepo.deleteById(id);
		
		
	}
	
}
