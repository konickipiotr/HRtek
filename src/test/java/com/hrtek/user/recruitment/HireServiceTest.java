package com.hrtek.user.recruitment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hrtek.DataBaseTestInit;
import com.hrtek.db.CandidateRepository;
import com.hrtek.db.CompanyRepository;
import com.hrtek.db.FactoryRepository;
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
import com.hrtek.model.Company;
import com.hrtek.model.Factory;
import com.hrtek.model.worker.StatusWorker;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class HireServiceTest {

	@InjectMocks
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
	
	@Mock
	private FactoryRepository factoryRepo;
	@Mock
	private CompanyRepository companyRepo;
	private WorkerFinanceRepository workerFinanceRepo;
	private DataBaseTestInit dataBaseTestInit;

	@Autowired
	public HireServiceTest(HireService hireService, CandidateRepository candidateRepo, HouseRepository houseRepo,
			RoomRepository roomRepo, BedRepository bedRepo, WorkerRepository workerRepo,
			WorkerBasicRepository workerBasicRepo, WorkerDateRepository workerDateRepo,
			WorkerContactRepository workerContactRepo, WorkerPermintRepository workerPermintRepo,
			ResidencyRepository residencyRepo, FactoryRepository factoryRepo, CompanyRepository companyRepo,
			WorkerFinanceRepository workerFinanceRepo, DataBaseTestInit dataBaseTestInit) {
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
		this.dataBaseTestInit = dataBaseTestInit;
	}

	@BeforeEach
	void setUp() throws Exception {
		dataBaseTestInit.clearDataBase();
		dataBaseTestInit.initConst();
	}

	@Test
	void test() {
		NewWorker expected = createFullNewWorker();
		Factory f = new Factory();
		f.setId(22l);
		f.setHourlyrate(17.50);
		f.setNumberofwokers(0);
		
		Company c = new Company();
		c.setId(33l);
		c.setNumberofwokers(0);
		
		when(factoryRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
		when(companyRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(c));
		Long id = hireService.hire(expected);
		
		Worker w = workerRepo.findById(id).get();
		assertEquals(expected.getFirstname(), w.getFirstname());
		assertEquals(expected.getLastname(), w.getLastname());
		assertEquals(StatusWorker.ACTIVE, w.getStatus());
		assertEquals(100l, w.getRecruiter());
		assertEquals(88l, w.getCompanyid());
		assertEquals(99l, w.getFactoryid());
		
		WorkerBasic wb = workerBasicRepo.findById(id).get();
		
		assertNull(wb.getDepartment());
		assertNull(wb.getCitizenship());
		assertEquals(expected.getSex(), wb.getSex());
		assertNull(wb.getAccountnr());
		assertNull(wb.getPesel());
		assertEquals(expected.getDateofbirth(), wb.getDateofbirth());
	}
	
	public NewWorker createFullNewWorker() {
		NewWorker n = new NewWorker();
		n.setId(1l);
		n.setFirstname("Adam");
		n.setLastname("Kowalski");
		n.setSex("M");
		n.setEmail("adam.nowak@mail.com");
		n.setPhone("234098222");
		n.setRecruiter(100l);
		n.setNote("elo elo");
		n.setDateofbirth(LocalDate.of(1990, 01, 20));
		n.setFactoryid(99l);
		n.setCompanyid(88l);
		n.setPassport("P123123");
		n.setAddress("Mińska 23");
		n.setPostcode("44-874");
		n.setCity("Białoruś");
		n.setStartZus(LocalDate.of(2000, 05, 28));
		n.setEndZus(LocalDate.of(2021, 06, 30));
		n.setIsOhter(true);
		n.setPladdress("Zielona 8");
		n.setPlcity("Konin");
		n.setPladdress("69-448");
		return n;
	}

}
