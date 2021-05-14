package com.hrtek.db;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hrtek.Tasks.Task;
import com.hrtek.Tasks.TaskOwner;
import com.hrtek.Tasks.TaskPriority;
import com.hrtek.Tasks.TaskStatus;
import com.hrtek.admin.tickets.TicketType;
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
import com.hrtek.enums.UserStatus;
import com.hrtek.model.Citizenship;
import com.hrtek.model.Company;
import com.hrtek.model.Department;
import com.hrtek.model.Factory;
import com.hrtek.model.MyNote;
import com.hrtek.model.StatusFC;
import com.hrtek.model.Ticket;
import com.hrtek.model.User;
import com.hrtek.model.UserInfo;
import com.hrtek.model.UserPostions;
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
import com.hrtek.model.worker.WorkerNote;
import com.hrtek.settings.GlobalSettings;
import com.hrtek.user.accommodation.Bedstatus;
import com.hrtek.user.recruitment.Candidate;
import com.hrtek.user.timesheet.Timesheet;


@Service
public class DBInit implements CommandLineRunner {

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
	private WorkerNoteRepository workerNoteRepo;
	private TimesheetRepository timesheetRepo;
	private MyNoteRepository myNoteRepo;
	private WorkerFilesRepository wokreFilesRerpo;
	private WorkerFilesArchRepository workerFilesArchRepo;
	private DismissRepository dismissedRepo;
	private LogRepository logRepo;
	
	private TaskRepository taskRepo;
	private TimesheetArchRepository timesheetArchRepo;
	
	
	public DBInit(UserRepository userRepo, UserInfoRepository userInfoRepo, PasswordEncoder passwordEncoder,
			UserPositonsRepository userPositionsRepo, CompanyRepository companyRepo, TicketRepository ticketRepo,
			CandidateRepository candidateRepo, HouseRepository houseRepo, RoomRepository roomRepo,
			BedRepository bedRepo, DepartmentRepository departmentRepo, FactoryRepository factoryRepo,
			CitizenshipRepository citizenshipRepo, WorkerRepository workerRepo, WorkerBasicRepository workerBasicRepo,
			WorkerContactRepository workerContactRepo, WorkerPermintRepository workerPermitRepo,
			WorkerDateRepository workerDateRepo, ResidencyRepository residencyRepo,
			WorkerFinanceRepository workerFinanceRepo, WorkerNoteRepository workerNoteRepo,
			TimesheetRepository timesheetRepo, MyNoteRepository myNoteRepo, WorkerFilesRepository wokreFilesRerpo,
			WorkerFilesArchRepository workerFilesArchRepo, DismissRepository dismissedRepo, LogRepository logRepo,
			TaskRepository taskRepo, TimesheetArchRepository timesheetArchRepo) {
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
		this.workerNoteRepo = workerNoteRepo;
		this.timesheetRepo = timesheetRepo;
		this.myNoteRepo = myNoteRepo;
		this.wokreFilesRerpo = wokreFilesRerpo;
		this.workerFilesArchRepo = workerFilesArchRepo;
		this.dismissedRepo = dismissedRepo;
		this.logRepo = logRepo;
		this.taskRepo = taskRepo;
		this.timesheetArchRepo = timesheetArchRepo;
	}




	@Override
	public void run(String... args) throws Exception {
		this.userInfoRepo.deleteAll();
		this.userRepo.deleteAll();
		this.userPositionsRepo.deleteAll();
		this.companyRepo.deleteAll();
		this.ticketRepo.deleteAll();
		this.candidateRepo.deleteAll();
		this.factoryRepo.deleteAll();
		this.departmentRepo.deleteAll();
		this.citizenshipRepo.deleteAll();
		
		this.workerRepo.deleteAll();
		this.workerBasicRepo.deleteAll();
		this.workerContactRepo.deleteAll();
		this.workerDateRepo.deleteAll();
		this.workerRepo.deleteAll();
		this.residencyRepo.deleteAll();
		this.workerFinanceRepo.deleteAll();
		this.workerPermitRepo.deleteAll();
		
		this.taskRepo.deleteAll();
		this.myNoteRepo.deleteAll();
		this.timesheetRepo.deleteAll();
		this.wokreFilesRerpo.deleteAll();
		this.workerFilesArchRepo.deleteAll();
		this.dismissedRepo.deleteAll();
		this.logRepo.deleteAll();
		
		this.timesheetRepo.deleteAll();
		this.timesheetArchRepo.deleteAll();
		
		this.houseRepo.deleteAll();
		this.roomRepo.deleteAll();
		this.bedRepo.deleteAll();

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
		
		UserPostions up1 = new UserPostions("Admin");
		UserPostions up2 = new UserPostions("Boss");
		UserPostions up3 = new UserPostions("Office");
		UserPostions up4 = new UserPostions(GlobalSettings.agent);
		UserPostions up5 = new UserPostions(GlobalSettings.coordinator);
		this.userPositionsRepo.saveAll(Arrays.asList(up1, up2, up3, up4, up5));

		
		
		User u1 = new User("superadmin", passwordEncoder.encode("123"), "ADMIN", UserStatus.ACTIVE);
		User u2 = new User("bosss", passwordEncoder.encode("123"), "BOSS",  UserStatus.FIRSTLOGIN);
		User u3 = new User("sazonavadzina", passwordEncoder.encode("123"), "ADMIN",  UserStatus.FIRSTLOGIN);
		
		this.userRepo.save(u1);
		this.userRepo.save(u2);
		this.userRepo.save(u3);
		
		this.myNoteRepo.save(new MyNote(u1.getId()));
		this.myNoteRepo.save(new MyNote(u2.getId()));
		this.myNoteRepo.save(new MyNote(u3.getId()));
		
		UserInfo ui1 = new UserInfo(u1.getId(), "super", "admin", up1.getId() , "", "", 1);
		this.userInfoRepo.save(ui1);

		
		UserInfo ui2 = new UserInfo(u2.getId(), "Chae", "Sung Yun",up2.getId(), "", "", 1);
		this.userInfoRepo.save(ui2);
		
		UserInfo ui3 = new UserInfo(u3.getId(), "Dzina", "Sazonava",up1.getId(), "", "", 0);
		this.userInfoRepo.save(ui3);
		
		
		/////////////////////////////////////////////////////////////////////
		User u4 = new User("adamnowak", passwordEncoder.encode("123"), "USER", UserStatus.ACTIVE);
		User u5 = new User("jamesbond", passwordEncoder.encode("123"), "USER",  UserStatus.FIRSTLOGIN);
		User u6 = new User("jadwigakoordynaiusz", passwordEncoder.encode("123"), "USER",  UserStatus.FIRSTLOGIN);
		
		this.userRepo.save(u4);
		this.userRepo.save(u5);
		this.userRepo.save(u6);
	
		UserInfo ui4 = new UserInfo(u4.getId(), "Adam", "Nowak", up3.getId() , "adam.nowak@mail.com", "7894891", 0);
		UserInfo ui5 = new UserInfo(u5.getId(), "James", "Bond", up4.getId() , "james.bondk@mail.com", "7070007", 0);
		UserInfo ui6 = new UserInfo(u6.getId(), "Jadwiga", "Koordynariusz", up5.getId() , "jadwika.koordynaiusz@mail.com", "3548891", 0);
		this.userInfoRepo.saveAll(Arrays.asList(ui6, ui4, ui5));
		
		this.ticketRepo.save(new Ticket(TicketType.PASSWORDFORGOTTEN, u6.getUsername(), u6.getId(), ""));
		
		this.candidateRepo.save(new Candidate("Jola", "Fasola", "F", "jola.fasola@mail.com", "775418125", u5.getId(), "Może zacząć dopiero do grudnia"));
		this.candidateRepo.save(new Candidate("Hubert", "Malinowski", "M", "hubert.malinowski@mail.com", "951753456", u6.getId(), "Podejrzany typ"));
		
	
		this.houseRepo.deleteAll();
		this.roomRepo.deleteAll();
		this.bedRepo.deleteAll();

		House h1 = new House();
		h1.setAddress("Chłopska 3");
		h1.setCapacity(10);
		h1.setNoofrooms(3);
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
		
		Bed h1r1b1 = new Bed(h1_r1.getId(), h1.getId(), null, null, Bedstatus.FREE);
		Bed h1r1b2 = new Bed(h1_r1.getId(), h1.getId(), null, null, Bedstatus.FREE);
		Bed h1r1b3 = new Bed(h1_r1.getId(), h1.getId(), null, null, Bedstatus.FREE);
		Bed h1r1b4 = new Bed(h1_r1.getId(), h1.getId(), null, null, Bedstatus.FREE);
		this.bedRepo.saveAll(Arrays.asList(h1r1b1, h1r1b2, h1r1b3, h1r1b4));
		h1_r1.setBedlist(Arrays.asList(h1r1b1, h1r1b2, h1r1b3, h1r1b4));
		this.roomRepo.save(h1_r1);
		
		
		Room h1_r2 = new Room();
		h1_r2.setCapacity(4);
		h1_r2.setHouseid(h1.getId());
		h1_r2.setOccupied(0);
		h1_r2.setRoomname("101");
		h1_r2.setRemark("lewa strona");
		this.roomRepo.save(h1_r2);
		
		Bed h1r2b1 = new Bed(h1_r2.getId(), h1.getId(), null, null, Bedstatus.FREE);
		Bed h1r2b2 = new Bed(h1_r2.getId(), h1.getId(), null, null, Bedstatus.FREE);
		Bed h1r2b3 = new Bed(h1_r2.getId(), h1.getId(), null, null, Bedstatus.FREE);
		Bed h1r2b4 = new Bed(h1_r2.getId(), h1.getId(), null, null, Bedstatus.FREE);
		this.bedRepo.saveAll(Arrays.asList(h1r2b1, h1r2b2, h1r2b3, h1r2b4));
		h1_r2.setBedlist(Arrays.asList(h1r2b1, h1r2b2, h1r2b3, h1r2b4));
		this.roomRepo.save(h1_r2);
		
		
		
		Room h1_r3 = new Room();
		h1_r3.setCapacity(2);
		h1_r3.setHouseid(h1.getId());
		h1_r3.setOccupied(0);
		h1_r3.setRoomname("102");
		h1_r3.setRemark("środkek strona");
		this.roomRepo.save(h1_r3);
		
		Bed h1r3b1 = new Bed(h1_r3.getId(), h1.getId(), null, null, Bedstatus.FREE);
		Bed h1r3b2 = new Bed(h1_r3.getId(), h1.getId(), null, null, Bedstatus.FREE);
		this.bedRepo.saveAll(Arrays.asList(h1r3b1, h1r3b2));
		h1_r3.setBedlist(Arrays.asList(h1r3b1, h1r3b2));
		this.roomRepo.save(h1_r3);
		
		
		
		///*******************************************
		
		Worker w1 = new Worker();
		w1.setFirstname("Jola");
		w1.setLastname("Patola");
		w1.setStatus(StatusWorker.ACTIVE);
		w1.setCompanyid(c1.getId()); // UWC
		w1.setFactoryid(f1.getId()); //Dong Yang
		w1.setRecruiter(ui4.getId()); //James Bond
		this.workerRepo.save(w1);
		this.timesheetRepo.save(new Timesheet(w1, LocalDate.of(2020, 9, 15)));
		f1.addPerson();
		this.factoryRepo.save(f1);
		c1.addPerson();
		this.companyRepo.save(c1);
		
		WorkerBasic wb1 = new WorkerBasic();
		wb1.setId(w1.getId());
		wb1.setAccountnr("4856 4885 8468 4883");
		wb1.setCitizenship(citiz1.getId()); //ukranina
		wb1.setDateofbirth(LocalDate.of(1990, 8, 25));
		wb1.setDepartment(d1.getId()); //Kierowca
		wb1.setPesel("75535184884");
		wb1.setSex("F");
		wb1.setWorkerNo("1555");
		this.workerBasicRepo.save(wb1);
		
		WorkerDate wd1 = new WorkerDate();
		wd1.setId(w1.getId());
		wd1.setAddToSystem(LocalDate.of(2020, 01, 18));
		wd1.setStartWork(LocalDate.of(2020, 01, 19));
		wd1.setStartZus(LocalDate.of(2019, 04, 19));
		wd1.setStartMedicalExams(LocalDate.of(2020, 01, 19));
		wd1.setEndMedicalExams(LocalDate.of(2021, 01, 19));
		wd1.setEndZus(LocalDate.of(2022, 06, 01));
		this.workerDateRepo.save(wd1);
		
		Residency r1 = new Residency();
		r1.setId(w1.getId());
		r1.setBiopassport("BIO456789");
		r1.setPassport("P147852");
		r1.setVisa("V112233");
		r1.setVisaValidFrom(LocalDate.of(2020, 01, 01));
		r1.setVisaValidTo(LocalDate.of(2022, 01, 01));
		this.residencyRepo.save(r1);
		
		PermitStatement ps1 = new PermitStatement();
		ps1.setId(w1.getId());
		ps1.setStatementType("VISA");
		ps1.setStatement("S123456");
		ps1.setStatementValidFrom(LocalDate.of(2020, 05, 30));
		ps1.setStatementValidTo(LocalDate.of(2021, 03, 20));
		ps1.setPermit("SAN34219");
		ps1.setPermitValidFrom(LocalDate.of(2020, 03, 05));
		ps1.setPermitValidTo(LocalDate.of(2023, 01, 10));
		ps1.setOther("Kara polaka");
		this.workerPermitRepo.save(ps1);
		
		WorkerFinance fw1 = new WorkerFinance(w1.getId(), f1.getHourlyrate(), 15.20);
		this.workerFinanceRepo.save(fw1);
		
		this.workerNoteRepo.save(new WorkerNote(w1.getId(), "coś tam, coś tam"));
		
		Contact co1 = new Contact();
		co1.setId(w1.getId());
		co1.setAddress("Długa 34");
		co1.setCity("Kijów");
		co1.setPostcode("78-514");
		co1.setBedid(h1r2b1.getId());
		co1.setPladdress(h1.getAddress());
		co1.setPlpostcode(h1.getPostcode());
		co1.setPlcity(h1.getCity());
		co1.setPhone("775489214");
		co1.setEmail("jola.patola@mail.com");
		co1.setaccommodation(h1r2b1.getId(), h1_r2.getId(), h1.getId());
		this.workerContactRepo.save(co1);
		h1.addPerson();
		this.houseRepo.save(h1);
		h1_r2.addPerson();
		this.roomRepo.save(h1_r2);
		h1r2b1.setOccupied(w1.getId(), LocalDate.of(2020, 8, 01));
		this.bedRepo.save(h1r2b1);		
		
		/// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		Worker w2 = new Worker();
		w2.setFirstname("Adam");
		w2.setLastname("Minimum");
		w2.setStatus(StatusWorker.INACTIVE);
		w2.setCompanyid(c2.getId()); // XYZ
		w2.setFactoryid(f2.getId()); //Fabryka 2
		w2.setRecruiter(ui5.getId()); //Jadwiga Koordynariusz
		this.workerRepo.save(w2);
		this.timesheetRepo.save(new Timesheet(w2, LocalDate.of(2020, 01, 19)));
		f2.addPerson();
		this.factoryRepo.save(f2);
		c2.addPerson();
		this.companyRepo.save(c2);
		
		WorkerBasic wb2 = new WorkerBasic();
		wb2.setId(w2.getId());
		wb2.setCitizenship(citiz2.getId()); //ukranina
		wb2.setDateofbirth(LocalDate.of(1985, 2, 03));
		wb2.setDepartment(d2.getId()); //Kierowca
		wb2.setSex("M");
		this.workerBasicRepo.save(wb2);
		
		WorkerDate wd2 = new WorkerDate();
		wd2.setId(w2.getId());
		wd2.setAddToSystem(LocalDate.of(2020, 01, 18));
		this.workerDateRepo.save(wd2);
		
		Residency r2 = new Residency();
		r2.setId(w2.getId());
		r2.setPassport("P88997722");
		this.residencyRepo.save(r2);
		
		PermitStatement ps2 = new PermitStatement();
		ps2.setId(w2.getId());
		this.workerPermitRepo.save(ps2);
		
		WorkerFinance fw2 = new WorkerFinance(w2.getId(), f2.getHourlyrate(), 14.15);
		this.workerFinanceRepo.save(fw2);
		
		this.workerNoteRepo.save(new WorkerNote(w2.getId(), "spoko gość"));
		
		Contact co2 = new Contact();
		co2.setId(w2.getId());
		co2.setPladdress("Zielona 34/4");
		co2.setPlpostcode("35-345");
		co2.setPlcity("Wrocław");
		co2.setPhone("85262184");
		this.workerContactRepo.save(co2);		
		

		///*******************************************
		
		Worker w3 = new Worker();
		w3.setFirstname("Marek");
		w3.setLastname("Borowiecki");
		w3.setStatus(StatusWorker.ACTIVE);
		w3.setCompanyid(c1.getId());
		w3.setFactoryid(f3.getId());
		w3.setRecruiter(ui4.getId()); //James Bond
		this.workerRepo.save(w3);
		this.timesheetRepo.save(new Timesheet(w3, LocalDate.of(2020, 8, 1)));
		f3.addPerson();
		this.factoryRepo.save(f3);
		c1.addPerson();
		this.companyRepo.save(c1);
		
		WorkerBasic wb3 = new WorkerBasic();
		wb3.setId(w3.getId());
		wb3.setCitizenship(citiz3.getId()); //ukranina
		wb3.setDateofbirth(LocalDate.of(1995, 10, 18));
		wb3.setDepartment(d3.getId()); //Kierowca
		wb3.setPesel("666845924");
		wb3.setSex("M");
		wb3.setWorkerNo("485");
		this.workerBasicRepo.save(wb3);
		
		WorkerDate wd3 = new WorkerDate();
		wd3.setId(w3.getId());
		wd3.setAddToSystem(LocalDate.of(2020, 05, 01));
		wd3.setStartWork(LocalDate.of(2020, 05, 19));
		wd3.setStartZus(LocalDate.of(2019, 04, 20));
		wd3.setStartMedicalExams(LocalDate.of(2020, 05, 19));
		wd3.setEndMedicalExams(LocalDate.of(2021, 06, 19));
		this.workerDateRepo.save(wd3);
		
		Residency r3 = new Residency();
		r3.setId(w3.getId());
		r3.setBiopassport("BIO456789");
		r3.setVisa("V112233");
		r3.setVisaValidFrom(LocalDate.of(2020, 01, 01));
		r3.setVisaValidTo(LocalDate.of(2022, 01, 01));
		this.residencyRepo.save(r3);
		
		PermitStatement ps3 = new PermitStatement();
		ps3.setId(w3.getId());
		ps3.setStatementType("WORK");
		ps3.setStatement("S8899774");
		ps3.setStatementValidFrom(LocalDate.of(2020, 03, 5));
		ps3.setStatementValidTo(LocalDate.of(2021, 06, 6));
		this.workerPermitRepo.save(ps3);
		
		WorkerFinance fw3 = new WorkerFinance(w3.getId(), f3.getHourlyrate(), 16.47);
		this.workerFinanceRepo.save(fw3);
		
		this.workerNoteRepo.save(new WorkerNote(w3.getId(), ""));
		
		Contact co3 = new Contact();
		co3.setId(w3.getId());
		co3.setAddress("Północna");
		co3.setCity("Mińsk");
		co3.setPostcode("75-845");
		co3.setBedid(h1r3b2.getId());
		co3.setPladdress(h1.getAddress());
		co3.setPlpostcode(h1.getPostcode());
		co3.setPlcity(h1.getCity());
		co3.setEmail("marek.borowiecki@mail.com");
		co3.setaccommodation(h1r3b2.getId(), h1_r3.getId(), h1.getId());
		this.workerContactRepo.save(co3);
		h1.addPerson();
		this.houseRepo.save(h1);
		h1_r3.addPerson();
		this.roomRepo.save(h1_r3);
		h1r3b2.setOccupied(w3.getId(), LocalDate.of(2020, 12, 22));
		this.bedRepo.save(h1r3b2);		
		
		/// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		Task t1 = new Task();
		t1.setEmployeeid(u3.getId());
		t1.setTaskname("Zakupy");;
		t1.setDescription("Kupić jajka");
		t1.setDeadlinedate(LocalDate.now().plusDays(1));
		t1.setPriority(TaskPriority.NORMAL);
		t1.setOwner(TaskOwner.BOSS);
		t1.setStatus(TaskStatus.ONGOING);
		this.taskRepo.save(t1);
		
		Task t2 = new Task();
		t2.setEmployeeid(u3.getId());
		t2.setTaskname("Załatwić sprawę");;
		t2.setDescription("Załatwić ważna spawę");
		t2.setDeadlinedate(LocalDate.now().plusDays(-1));
		t2.setPriority(TaskPriority.HIGH);
		t2.setOwner(TaskOwner.BOSS);
		t2.setStatus(TaskStatus.DELAY);
		this.taskRepo.save(t2);
		
		Task t3 = new Task();
		t3.setEmployeeid(u3.getId());
		t3.setTaskname("Zatrudnić");;
		t3.setDescription("Zatrudniń");
		t3.setDeadlinedate(LocalDate.now().plusDays(1));
		t3.setPriority(TaskPriority.LOW);
		t3.setOwner(TaskOwner.ME);
		t3.setStatus(TaskStatus.ONGOING);
		this.taskRepo.save(t3);
		
	}

}

