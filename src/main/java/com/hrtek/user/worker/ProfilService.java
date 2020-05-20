package com.hrtek.user.worker;

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
import com.hrtek.model.Citizenship;
import com.hrtek.model.Company;
import com.hrtek.model.Department;
import com.hrtek.model.Factory;
import com.hrtek.model.UserInfo;
import com.hrtek.model.UserPostions;
import com.hrtek.model.accommodation.Bed;
import com.hrtek.model.accommodation.House;
import com.hrtek.model.accommodation.Room;
import com.hrtek.model.worker.Contact;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;
import com.hrtek.view.worker.ContactView;
import com.hrtek.view.worker.WorkerBasicView;
import com.hrtek.view.worker.WorkerView;

@Service
public class ProfilService {

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
	private WorkerFilesRepository workerFilesRepo;
	private UserInfoRepository userInfoRepo;
	private UserPositonsRepository userPositonsRepo;
	private CitizenshipRepository citizenshipRepo;
	private DepartmentRepository departmentRepo;
	
	@Autowired
	public ProfilService(HouseRepository houseRepo, RoomRepository roomRepo, BedRepository bedRepo,
			WorkerRepository workerRepo, WorkerBasicRepository workerBasicRepo, WorkerDateRepository workerDateRepo,
			WorkerContactRepository workerContactRepo, WorkerPermintRepository workerPermintRepo,
			ResidencyRepository residencyRepo, FactoryRepository factoryRepo, CompanyRepository companyRepo,
			WorkerFinanceRepository workerFinanceRepo, WorkerNoteRepository workerNoteRepo,
			WorkerFilesRepository workerFilesRepo, UserInfoRepository userInfoRepo,
			UserPositonsRepository userPositonsRepo, CitizenshipRepository citizenshipRepo,
			DepartmentRepository departmentRepo) {
		super();
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
		this.workerFilesRepo = workerFilesRepo;
		this.userInfoRepo = userInfoRepo;
		this.userPositonsRepo = userPositonsRepo;
		this.citizenshipRepo = citizenshipRepo;
		this.departmentRepo = departmentRepo;
	}

	public boolean setmodel(Long workerid, Model model) {
		Optional<Worker> oWorker = workerRepo.findById(workerid);
		if(oWorker.isEmpty()) {
			model.addAttribute("error_msg", "Użytkownik o takim id nie istnieje");
			return false;
		}
		Worker w = oWorker.get();
		Long id = w.getId();
		
		model.addAttribute("wv", prepareWorekrView(w));
		model.addAttribute("wb", prepareWorkerBasicView(id) );
		model.addAttribute("wd", workerDateRepo.findById(id).get());
		model.addAttribute("ps", workerPermintRepo.findById(id).get());
		model.addAttribute("re", residencyRepo.findById(id).get());
		model.addAttribute("workerNote", workerNoteRepo.findById(id).get());
		model.addAttribute("wf", workerFinanceRepo.findById(id).get());
		model.addAttribute("cv", prepareContactView(id));
		//model.addAttribute("", );
		return true;
	}
	
	private ContactView prepareContactView(Long id) {
		Contact c = workerContactRepo.findById(id).get();
		ContactView cv = new ContactView(c);
		
		if(c.getBedid() != null) {
			Bed bed = bedRepo.findById(c.getBedid()).get();
			Room room = roomRepo.findById(c.getRoomid()).get();
			House house = houseRepo.findById(c.getHouseid()).get();
			
			cv.setHouse(house.getAddress());
			cv.setHouseid(house.getId());
			cv.setRoom(room.getRoomname());
			cv.setExpire(bed.getExpire());
		}
		return cv;
	}
	
	private WorkerBasicView prepareWorkerBasicView(Long id) {
		WorkerBasic wb = workerBasicRepo.findById(id).get();
		WorkerBasicView wbv = new WorkerBasicView(wb);
		
		Optional<Citizenship> oCitizenship = citizenshipRepo.findById(wb.getCitizenship());
		if(oCitizenship.isPresent()) {
			wbv.setCitizenship(oCitizenship.get().getName());
		}
		
		Optional<Department> oDep = departmentRepo.findById(wb.getDepartment());
		if(oDep.isPresent()) {
			wbv.setDepartment(oDep.get().getDepartment());
		}
		return wbv;
	}
	
	private WorkerView prepareWorekrView(Worker w) {
		WorkerView wv = new WorkerView(w);
		Optional<Factory> oFactroy = factoryRepo.findById(w.getFactoryid());
		if(oFactroy.isPresent()) {
			wv.setFactory((oFactroy.get().getShortname()));
		}
		
		Optional<Company> oComapny = companyRepo.findById(w.getCompanyid());
		if(oComapny.isPresent()) {
			wv.setCompany(oComapny.get().getShortname());
		}
		
		Optional<UserInfo> oUserInfo = userInfoRepo.findById(w.getRecruiter());
		if(oUserInfo.isPresent()) {
			String text  = oUserInfo.get().getName();
			Optional<UserPostions> oPosition = userPositonsRepo.findById(oUserInfo.get().getPosition());
			if(oPosition.isPresent()) {
				text += " - " + oPosition.get().getPosition();
			}
			wv.setRecruiter(text);
		} 
		return wv;
	}
	
	
}
