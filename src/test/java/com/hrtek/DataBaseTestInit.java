package com.hrtek;

import java.util.Arrays;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hrtek.db.CandidateRepository;
import com.hrtek.db.CitizenshipRepository;
import com.hrtek.db.CompanyRepository;
import com.hrtek.db.DepartmentRepository;
import com.hrtek.db.FactoryRepository;
import com.hrtek.db.TicketRepository;
import com.hrtek.db.UserInfoRepository;
import com.hrtek.db.UserPositonsRepository;
import com.hrtek.db.UserRepository;
import com.hrtek.db.accommodation.BedRepository;
import com.hrtek.db.accommodation.HouseRepository;
import com.hrtek.db.accommodation.RoomRepository;
import com.hrtek.db.worker.ResidencyRepository;
import com.hrtek.db.worker.WorkerBasicRepository;
import com.hrtek.db.worker.WorkerContactRepository;
import com.hrtek.db.worker.WorkerDateRepository;
import com.hrtek.db.worker.WorkerFinanceRepository;
import com.hrtek.db.worker.WorkerPermintRepository;
import com.hrtek.db.worker.WorkerRepository;
import com.hrtek.model.Citizenship;
import com.hrtek.model.Company;
import com.hrtek.model.Department;
import com.hrtek.model.Factory;
import com.hrtek.model.StatusFC;

@Service
public class DataBaseTestInit {

	private UserRepository userRepo;
	private UserInfoRepository userInfoRepo;
	private PasswordEncoder passwordEncoder;
	private UserPositonsRepository userPositionsRepo;
	private CompanyRepository companyRepo;
	private TicketRepository ticketRepo;
	private CandidateRepository candidateRepo;
	private HouseRepository houseRepo;
	private RoomRepository roomRepo;
	private BedRepository bedRepo;
	private DepartmentRepository departmentRepo;
	private FactoryRepository factoryRepo;
	private CitizenshipRepository citizenshipRepo;
	
	private WorkerRepository workerRepo;
	private WorkerBasicRepository workerBasicRepo;
	private WorkerContactRepository workerContactRepo;
	private WorkerPermintRepository workerPermitRepo;
	private WorkerDateRepository workerDateRepo;
	private ResidencyRepository residencyRepo;
	private WorkerFinanceRepository workerFinanceRepo;
	public DataBaseTestInit(UserRepository userRepo, UserInfoRepository userInfoRepo, PasswordEncoder passwordEncoder,
			UserPositonsRepository userPositionsRepo, CompanyRepository companyRepo, TicketRepository ticketRepo,
			CandidateRepository candidateRepo, HouseRepository houseRepo, RoomRepository roomRepo,
			BedRepository bedRepo, DepartmentRepository departmentRepo, FactoryRepository factoryRepo,
			CitizenshipRepository citizenshipRepo, WorkerRepository workerRepo, WorkerBasicRepository workerBasicRepo,
			WorkerContactRepository workerContactRepo, WorkerPermintRepository workerPermitRepo,
			WorkerDateRepository workerDateRepo, ResidencyRepository residencyRepo,
			WorkerFinanceRepository workerFinanceRepo) {
		this.userRepo = userRepo;
		this.userInfoRepo = userInfoRepo;
		this.passwordEncoder = passwordEncoder;
		this.userPositionsRepo = userPositionsRepo;
		this.companyRepo = companyRepo;
		this.ticketRepo = ticketRepo;
		this.candidateRepo = candidateRepo;
		this.houseRepo = houseRepo;
		this.roomRepo = roomRepo;
		this.bedRepo = bedRepo;
		this.departmentRepo = departmentRepo;
		this.factoryRepo = factoryRepo;
		this.citizenshipRepo = citizenshipRepo;
		this.workerRepo = workerRepo;
		this.workerBasicRepo = workerBasicRepo;
		this.workerContactRepo = workerContactRepo;
		this.workerPermitRepo = workerPermitRepo;
		this.workerDateRepo = workerDateRepo;
		this.residencyRepo = residencyRepo;
		this.workerFinanceRepo = workerFinanceRepo;
	}
	
	
	public void initConst() {
		Citizenship citiz1 = new Citizenship("ukraińskie");
		Citizenship citiz2 = new Citizenship("polskie");
		Citizenship citiz3 = new Citizenship("białoruskie");
		this.citizenshipRepo.saveAll(Arrays.asList(citiz1, citiz2, citiz3));
		
		Factory f1 = new Factory(StatusFC.ENABLED, "45686", "1597534589", "1165159554", "DongYang", "Dong Yang internatinal sp z o.o.", "Jan 43", "42-548", "Wrocław", 0, 17.25);
		Factory f2 = new Factory(StatusFC.ENABLED, "14326", "1516551129", "4587466611", "Fabryk 2", "zong Yang internatinal sp z o.o.", "Mickiewicza 43", "42-548", "Krocław", 0, 18.25);
		Factory f3 = new Factory(StatusFC.ENABLED, "31586", "1596556689", "1551651854", "Fabryka 3", "bong Yang internatinal sp z o.o.", "Adama 342", "32-548", "Brocław", 0, 16.25);
		Factory f4 = new Factory(StatusFC.DISABLED, "13586", "1561834589", "2987435774", "Fabryka 4", "tong Yang internatinal sp z o.o.", "Kochanowskiego 34", "14-448", "Orocław", 0, 19.25);
		this.factoryRepo.saveAll(Arrays.asList(f1,f2,f3,f4));
		
		
		Company c1 = new Company(StatusFC.ENABLED, "11111", "2222222222", "3333", "444444444", "555", "UWC", "UWC sp. z o.o", "Kutnowska 43", "53-541", "Wrocław", 0, 20.10);
		Company c2 = new Company(StatusFC.ENABLED, "99999", "8888888888", "7777", "666666666", "111", "THE HR", "THE HR sp. z o.o", "Śnieżna 12", "23-311", "Wrocław", 0, 15.10);
		this.companyRepo.saveAll(Arrays.asList(c1, c2));

		Department d1 = new Department("Kierowca");
		Department d2 = new Department("Operator Wtryskarki");
		Department d3 = new Department("Pakowacz");
		this.departmentRepo.saveAll(Arrays.asList(d1, d2, d3));
	}
	
	
	public void clearWorkers() {
		this.workerRepo.deleteAll();
		this.workerBasicRepo.deleteAll();
		this.workerContactRepo.deleteAll();
		this.workerDateRepo.deleteAll();
		this.workerRepo.deleteAll();
		this.residencyRepo.deleteAll();
		this.workerFinanceRepo.deleteAll();
		this.workerPermitRepo.deleteAll();
	}
	
	public void clearDataBase() {
		this.userInfoRepo.deleteAll();
		this.userRepo.deleteAll();
		this.userPositionsRepo.deleteAll();
		this.companyRepo.deleteAll();
		this.ticketRepo.deleteAll();
		this.candidateRepo.deleteAll();
		this.factoryRepo.deleteAll();
		this.departmentRepo.deleteAll();
		this.citizenshipRepo.deleteAll();
		this.candidateRepo.deleteAll();
		
		this.houseRepo.deleteAll();
		this.roomRepo.deleteAll();
		this.bedRepo.deleteAll();
		
		this.clearWorkers();
	}
}
