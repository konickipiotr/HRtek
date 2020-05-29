package com.hrtek.user.recruitment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hrtek.DataBaseTestInit;
import com.hrtek.db.CandidateRepository;
import com.hrtek.db.CitizenshipRepository;
import com.hrtek.db.CompanyRepository;
import com.hrtek.db.DepartmentRepository;
import com.hrtek.db.FactoryRepository;
import com.hrtek.db.UserInfoRepository;
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
import com.hrtek.enums.UserStatus;
import com.hrtek.model.Citizenship;
import com.hrtek.model.Company;
import com.hrtek.model.Department;
import com.hrtek.model.Factory;
import com.hrtek.model.User;
import com.hrtek.model.UserInfo;
import com.hrtek.model.accommodation.Bed;
import com.hrtek.model.accommodation.CostType;
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
import com.hrtek.user.accommodation.Bedstatus;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class IntegrationTestHire {	
	
	private DataBaseTestInit dataBaseTestInit;
	
	private HireService hireService;
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
	
	private CitizenshipRepository citizenshipRepo;
	private DepartmentRepository departmentRepo;
	private UserInfoRepository userInfoRepo;
	private UserRepository userRepository;
	private RecruitmentService recruitmentService;

	@Autowired
	public IntegrationTestHire(DataBaseTestInit dataBaseTestInit, HireService hireService,
			CandidateRepository candidateRepo, HouseRepository houseRepo, RoomRepository roomRepo,
			BedRepository bedRepo, WorkerRepository workerRepo, WorkerBasicRepository workerBasicRepo,
			WorkerDateRepository workerDateRepo, WorkerContactRepository workerContactRepo,
			WorkerPermintRepository workerPermintRepo, ResidencyRepository residencyRepo, FactoryRepository factoryRepo,
			CompanyRepository companyRepo, WorkerFinanceRepository workerFinanceRepo,
			CitizenshipRepository citizenshipRepo, DepartmentRepository departmentRepo, UserInfoRepository userInfoRepo,
			UserRepository userRepository, RecruitmentService recruitmentService) {
		this.dataBaseTestInit = dataBaseTestInit;
		this.hireService = hireService;
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
		this.citizenshipRepo = citizenshipRepo;
		this.departmentRepo = departmentRepo;
		this.userInfoRepo = userInfoRepo;
		this.userRepository = userRepository;
		this.recruitmentService = recruitmentService;
		
		this.dataBaseTestInit.clearDataBase();
		this.bedRepo.deleteAll();
		this.houseRepo.deleteAll();
		this.roomRepo.deleteAll();
		
		User agent = new User("agentBond", "123", "USER", UserStatus.ACTIVE);
		User coordinator = new User("coord", "123", "USER", UserStatus.ACTIVE);
		this.userRepository.saveAll(Arrays.asList(agent, coordinator));
		
		UserInfo ui1 = new UserInfo(agent.getId(), "James", "Bond", "", 1, "james.bondk@mail.com", "7070007", 0);
		UserInfo ui2 = new UserInfo(coordinator.getId(), "Jadwiga", "Koordynariusz", "", 2 , "jadwika.koordynaiusz@mail.com", "3548891", 0);
		this.userInfoRepo.saveAll(Arrays.asList(ui1, ui2));
		usersI = new ArrayList<UserInfo>(Arrays.asList(ui1, ui2));
		
		Citizenship citiz1 = new Citizenship("ukraińskie");
		Citizenship citiz2 = new Citizenship("polskie");
		Citizenship citiz3 = new Citizenship("białoruskie");
		this.citizenshipRepo.saveAll(Arrays.asList(citiz1, citiz2, citiz3));
		citizList = Arrays.asList(citiz1, citiz2, citiz3);
		
		Factory f1 = new Factory("45686", "1597534589", "1165159554", "DongYang", "Dong Yang internatinal sp z o.o.", "Jan 43", "42-548", "Wrocław", 0, 17.25);
		Factory f2 = new Factory("14326", "1516551129", "4587466611", "Fabryk 2", "zong Yang internatinal sp z o.o.", "Mickiewicza 43", "42-548", "Krocław", 0, 18.25);
		this.factoryRepo.saveAll(Arrays.asList(f1,f2));
		factoryList = Arrays.asList(f1,f2);
		
		Company c1 = new Company("11111", "2222222222", "3333", "444444444", "555", "UWC", "UWC sp. z o.o", "Kutnowska 43", "53-541", "Wrocław", 0, 20.10);
		Company c2 = new Company("99999", "8888888888", "7777", "666666666", "111", "XYZ", "XYZ sp. z o.o", "Śnieżna 12", "23-311", "Wrocław", 0, 15.10);
		this.companyRepo.saveAll(Arrays.asList(c1, c2));
		companyList = Arrays.asList(c1, c2);

		Department d1 = new Department("Kierowca");
		Department d2 = new Department("Operator Wtryskarki");
		Department d3 = new Department("Pakowacz");
		this.departmentRepo.saveAll(Arrays.asList(d1, d2, d3));
		departmentList = Arrays.asList(d1, d2, d3);
		
		this.houseRepo.deleteAll();
		this.roomRepo.deleteAll();
		this.bedRepo.deleteAll();

		House h1 = new House();
		h1.setAddress("Chłopska 3");
		h1.setCapacity(4);
		h1.setNoofrooms(1);
		h1.setPostcode("33-222");
		h1.setCity("Smolec");
		h1.setDeposit(3000);
		h1.setRent(6000);
		h1.setMedia(1500);
		h1.setPeriodofnotice(3);
		h1.setRemark("elo");
		h1.setCostType(CostType.MEDIARENT);
		h1.setPerperson((6000+1500)/35);
		this.houseRepo.save(h1);
		
		Room h1_r1 = new Room();
		h1_r1.setCapacity(4);
		h1_r1.setHouseid(h1.getId());
		h1_r1.setOccupied(0);
		h1_r1.setRoomname("100");
		h1_r1.setRemark("prawa strona");
		this.roomRepo.save(h1_r1);
		
		this.bedRepo.save(new Bed(h1_r1.getId(), h1.getId(), null, null, Bedstatus.FREE));
		this.bedRepo.save(new Bed(h1_r1.getId(), h1.getId(), null, null, Bedstatus.FREE));
		this.bedRepo.save(new Bed(h1_r1.getId(), h1.getId(), null, null, Bedstatus.FREE));
		this.bedRepo.save(new Bed(h1_r1.getId(), h1.getId(), null, null, Bedstatus.FREE));
	
		House h2 = new House();
		h2.setAddress("Kochanowskiego 4/54");
		h2.setCapacity(2);
		h2.setNoofrooms(1);
		h2.setPostcode("54-357");
		h2.setCity("Oława");
		h2.setDeposit(2000);
		h2.setRent(3000);
		h2.setMedia(4500);
		h2.setPeriodofnotice(3);
		h2.setRemark("zzz");
		h2.setCostType(CostType.MEDIARENT);
		h2.setPerperson((6000+1500)/35);
		this.houseRepo.save(h2);
		
		Room h2_r1 = new Room();
		h2_r1.setCapacity(4);
		h2_r1.setHouseid(h1.getId());
		h2_r1.setOccupied(0);
		h2_r1.setRoomname("A2");
		h2_r1.setRemark("lewa strona");
		this.roomRepo.save(h2_r1);
		
		this.bedRepo.save(new Bed(h2_r1.getId(), h2.getId(), null, null, Bedstatus.FREE));
		this.bedRepo.save(new Bed(h2_r1.getId(), h2.getId(), null, null, Bedstatus.FREE));
		this.bedRepo.save(new Bed(h2_r1.getId(), h2.getId(), null, null, Bedstatus.FREE));
		this.bedRepo.save(new Bed(h2_r1.getId(), h2.getId(), null, null, Bedstatus.FREE));
		
	}

	private List<UserInfo> usersI;
	private List<Citizenship> citizList;
	private List<Factory> factoryList;
	private List<Company> companyList;
	private List<Department> departmentList;
	
	@BeforeEach
	void setUp() throws Exception {

		
		
	}

	@Test
	void fillFullData() {
		//Step 1
		Candidate expectCan = new Candidate("Jan", "Nowak", "M", "jan.nowak@mail.com", "778954456", usersI.get(0).getId(), "elo elo");
		assertEquals(0, candidateRepo.findAll().size());
		
		Long candidatid = recruitmentService.addCandidate(expectCan);
		Candidate currentCan = candidateRepo.findById(candidatid).get();
		
		assertEquals(expectCan.getFirstname(), currentCan.getFirstname());
		assertEquals(expectCan.getLastname(), currentCan.getLastname());
		assertEquals(expectCan.getSex(), currentCan.getSex());
		assertEquals(expectCan.getEmail(), currentCan.getEmail());
		assertEquals(expectCan.getPhone(), currentCan.getPhone());
		assertEquals(expectCan.getRecruiter(), currentCan.getRecruiter());
		assertEquals(expectCan.getNote(), currentCan.getNote());
		assertEquals(1, candidateRepo.findAll().size());

		// Step 2
		NewWorker nw = new NewWorker(currentCan);
		
		assertEquals(currentCan.getFirstname(), nw.getFirstname());
		assertEquals(currentCan.getLastname(), nw.getLastname());
		assertEquals(currentCan.getSex(), nw.getSex());
		assertEquals(currentCan.getEmail(), nw.getEmail());
		assertEquals(currentCan.getPhone(), nw.getPhone());
		assertEquals(currentCan.getRecruiter(), nw.getRecruiter());
		assertEquals(currentCan.getNote(), nw.getNote());

		assertNull(nw.getIsBiopass());
		assertNull(nw.getPassport());
		assertNull(nw.getDateofbirth());
		assertNull(nw.getFactoryid());
		assertNull(nw.getCompanyid());
		assertNull(nw.getAddress());
		assertNull(nw.getPostcode());
		assertNull(nw.getCity());
		assertNull(nw.getBedid());
		assertNull(nw.getIsOhter());
		assertNull(nw.getPladdress());
		assertNull(nw.getPlpostcode());
		assertNull(nw.getPlcity());
		assertNull(nw.getStartZus());
		assertNull(nw.getEndZus());
		
		/// step 3
		nw.setFirstname("Jakub");
		nw.setLastname("Adamowski");
		nw.setSex("F");
		nw.setEmail("jakub.adamowski@mail.com");
		nw.setPhone("789456");
		nw.setRecruiter(usersI.get(1).getId());
		nw.setNote(nw.getNote() + " zzz");
		nw.setIsBiopass(true);
		nw.setPassport("P123");
		nw.setDateofbirth(LocalDate.of(1990, 06, 20));
		nw.setFactoryid(factoryList.get(0).getId());
		nw.setCompanyid(companyList.get(0).getId());
		nw.setAddress("Mińska 23");
		nw.setPostcode("48-852");
		nw.setCity("Mińsk");
		nw.setIsOhter(true);
		nw.setPladdress("Mickiewicza 1");
		nw.setPlpostcode("35-741");
		nw.setPlcity("Wrocław");
		nw.setStartZus(LocalDate.of(2020, 03, 05));
		nw.setEndZus(LocalDate.of(2021, 01, 01));
		
		
		Long wid = hireService.hire(nw);
		
		Worker w = workerRepo.findById(wid).get();
		WorkerBasic wb = workerBasicRepo.findById(wid).get();
		WorkerFinance wf = workerFinanceRepo.findById(wid).get();
		WorkerDate wd = workerDateRepo.findById(wid).get();
		Contact c = workerContactRepo.findById(wid).get();
		PermitStatement ps = workerPermintRepo.findById(wid).get();
		Residency re = residencyRepo.findById(wid).get();
		Factory f1 = factoryRepo.findById(w.getFactoryid()).get();
		Company c1 = companyRepo.findById(w.getCompanyid()).get();
		
		
		assertEquals(nw.getFirstname(), w.getFirstname());
		assertEquals(nw.getLastname(), w.getLastname());
		assertEquals(StatusWorker.ACTIVE, w.getStatus());
		assertEquals(nw.getFactoryid(), w.getFactoryid());
		assertEquals(nw.getCompanyid(), w.getCompanyid());
		assertEquals(nw.getRecruiter(), w.getRecruiter());
		
		assertEquals(nw.getDateofbirth(), wb.getDateofbirth());
		assertEquals(nw.getSex(), wb.getSex());
		assertNull(wb.getAccountnr());
		assertNull(wb.getCitizenship());
		assertNull(wb.getDepartment());
		assertNull(wb.getPesel());
		
		assertEquals(0, wf.getBonus());
		assertEquals(f1.getHourlyrate(), wf.getHourlyrate());
		
		assertEquals(LocalDate.now(), wd.getAddToSystem());
		assertEquals(nw.getStartZus(), wd.getStartZus());
		assertEquals(nw.getEndZus(), wd.getEndZus());
		assertNull(wd.getStartWork());
		assertNull(wd.getStartMedicalExams());
		assertNull(wd.getEndMedicalExams());
	
		assertEquals(nw.getPassport(), re.getBiopassport());
		assertNull(re.getPassport());
		assertNull(re.getVisa());
		assertNull(re.getVisaValidFrom());
		assertNull(re.getVisaValidTo());
		
		assertNull(ps.getOther());
		assertNull(ps.getPermit());
		assertNull(ps.getPermitValidFrom());
		assertNull(ps.getPermitValidTo());
		assertNull(ps.getStatement());
		assertNull(ps.getStatementType());
		assertNull(ps.getStatementValidFrom());
		assertNull(ps.getStatementValidTo());
		
		assertEquals(nw.getAddress(), c.getAddress());
		assertEquals(nw.getCity(), c.getCity());
		assertEquals(nw.getPostcode(), c.getPostcode());
		assertEquals(nw.getPladdress(), c.getPladdress());
		assertEquals(nw.getPlcity(), c.getPlcity());
		assertEquals(nw.getPlpostcode(), c.getPlpostcode());
		assertEquals(nw.getEmail(), c.getEmail());
		assertEquals(nw.getPhone(), c.getPhone());
		assertNull(c.getBedid());
		assertNull(c.getRoomid());
		assertNull(c.getHouseid());
		
		assertEquals(1, f1.getNumberofwokers());
		assertEquals(1, c1.getNumberofwokers());
		assertEquals(1, workerRepo.findAll().size());
		
		
		//Step 3
		WorkerAll wa = hireService.prepareWorkerAll(wid);
		wa.setAccountnr("555666444");
		
		wa.setIsOhter(false);
		List<Bed> beds = bedRepo.findAll();
		wa.setBedid(beds.get(0).getId());
		
		wa.setCitizenship(citizList.get(0).getId());
		wa.setDepartment(departmentList.get(0).getId());
		wa.setAddress("Zielona 6");
		wa.setPostcode("11-345");
		wa.setCity("Warszawa");
		wa.setDateofbirth(LocalDate.of(1988, 12, 10));
		wa.setFirstname("Jola");
		wa.setLastname("Patola");
		wa.setSex("F");
		wa.setEmail("jola.patols@mail.com");
		wa.setPhone("999");
		wa.setRecruiter(usersI.get(0).getId());
		wa.setNote(wa.getNote() + " 33");
		wa.setBiopassport("Bio1111");
		wa.setPassport("P222");
		Long oldF = wa.getFactoryid();
		Long oldC = wa.getCompanyid();
		wa.setFactoryid(factoryList.get(1).getId());
		wa.setCompanyid(companyList.get(1).getId());
		wa.setWorkerNo(123l);
		
		wa.setStartWork(LocalDate.of(2020, 05, 01));
		wa.setStartZus(null);
		wa.setEndZus(null);
		wa.setStartMedicalExams(LocalDate.of(2020, 05, 03));
		wa.setEndMedicalExams(LocalDate.of(2020, 12, 31));
		
		wa.setPermit("PE8888");
		wa.setPermitValidFrom(LocalDate.of(2020, 05, 04));
		wa.setPermitValidTo(LocalDate.of(2020, 05, 31));
		wa.setStatement("S777");
		wa.setStatementType("WORK");
		wa.setStatementValidFrom(LocalDate.of(2020, 05, 05));
		wa.setStatementValidTo(LocalDate.of(2020, 07, 01));
		
		wa.setPesel("889977");;
		wa.setOther("zzpp");
		
		
		hireService.updateWorker(wa);
		
		w = workerRepo.findById(wid).get();
		wb = workerBasicRepo.findById(wid).get();
		wf = workerFinanceRepo.findById(wid).get();
		wd = workerDateRepo.findById(wid).get();
		c = workerContactRepo.findById(wid).get();
		ps = workerPermintRepo.findById(wid).get();
		re = residencyRepo.findById(wid).get();
		f1 = factoryRepo.findById(oldF).get();
		c1 = companyRepo.findById(oldC).get();
		Factory f2 = factoryRepo.findById(w.getFactoryid()).get();
		Company c2 = companyRepo.findById(w.getCompanyid()).get();
		
		assertEquals(wa.getFirstname(), w.getFirstname());
		assertEquals(wa.getLastname(), w.getLastname());
		assertEquals(StatusWorker.INACTIVE, w.getStatus());
		assertEquals(wa.getFactoryid(), w.getFactoryid());
		assertEquals(wa.getCompanyid(), w.getCompanyid());
		assertEquals(wa.getRecruiter(), w.getRecruiter());
		
		assertEquals(wa.getDateofbirth(), wb.getDateofbirth());
		assertEquals(wa.getSex(), wb.getSex());
		assertEquals(wa.getAccountnr(), wb.getAccountnr());
		assertEquals(wa.getCitizenship(), wb.getCitizenship());
		assertEquals(wa.getDepartment(), wb.getDepartment());
		assertEquals(wa.getPesel(), wb.getPesel());
		
		assertEquals(0, wf.getBonus());
		assertEquals(f2.getHourlyrate(), wf.getHourlyrate());
		
		assertEquals(LocalDate.now(), wd.getAddToSystem());
		assertNull(wd.getStartZus());
		assertNull(wd.getEndZus());
		assertEquals(wa.getStartWork(), wd.getStartWork());
		assertEquals(wa.getStartMedicalExams(), wd.getStartMedicalExams());
		assertEquals(wa.getEndMedicalExams(), wd.getEndMedicalExams());
	
		assertEquals(wa.getBiopassport(), re.getBiopassport());
		assertEquals(wa.getPassport(),re.getPassport());
		assertEquals(wa.getVisa(),re.getVisa());
		assertEquals(wa.getVisaValidFrom(),re.getVisaValidFrom());
		assertEquals(wa.getVisaValidTo(),re.getVisaValidTo());
		
		assertEquals(wa.getOther(),ps.getOther());
		assertEquals(wa.getPermit(),ps.getPermit());
		assertEquals(wa.getPermitValidFrom(),ps.getPermitValidFrom());
		assertEquals(wa.getPermitValidTo(),ps.getPermitValidTo());
		assertEquals(wa.getStatement(),ps.getStatement());
		assertEquals(wa.getStatementType(),ps.getStatementType());
		assertEquals(wa.getStatementValidFrom(),ps.getStatementValidFrom());
		assertEquals(wa.getStatementValidTo(),ps.getStatementValidTo());
		
		assertEquals(beds.get(0).getId(),c.getBedid());
		assertEquals(beds.get(0).getRoomid(), c.getRoomid());
		assertEquals(beds.get(0).getHouseid(), c.getHouseid());
		House h = houseRepo.findById(beds.get(0).getHouseid()).get();
		Room r = roomRepo.findById(beds.get(0).getRoomid()).get();
		assertEquals(h.getOccupied(), 1);
		assertEquals(r.getOccupied(), 1);
		
		assertEquals(wa.getAddress(), c.getAddress());
		assertEquals(wa.getCity(), c.getCity());
		assertEquals(wa.getPostcode(), c.getPostcode());
		assertEquals(h.getAddress(), c.getPladdress());
		assertEquals(h.getCity(), c.getPlcity());
		assertEquals(h.getPostcode(), c.getPlpostcode());
		assertEquals(wa.getEmail(), c.getEmail());
		assertEquals(wa.getPhone(), c.getPhone());

		
		assertEquals(0, f1.getNumberofwokers());
		assertEquals(0, c1.getNumberofwokers());
		
		assertEquals(1, f2.getNumberofwokers());
		assertEquals(1, c2.getNumberofwokers());
		
		
		
//		assertEquals(nw.getAddress(), wb.get);
//		assertEquals(nw.getAddress(), wb.get);
		
//		assertEquals(nw.getAddress(), w.);
//		assertEquals(nw.getAddress(), w.);
//		assertEquals(nw.getAddress(), w.);
//		assertEquals(nw.getAddress(), w.);
//		assertEquals(nw.getAddress(), w.);
		
		
	}


}
