package com.hrtek.user.recruitment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.hrtek.db.CandidateRepository;
import com.hrtek.db.CitizenshipRepository;
import com.hrtek.db.CompanyRepository;
import com.hrtek.db.DepartmentRepository;
import com.hrtek.db.FactoryRepository;
import com.hrtek.db.UserInfoRepository;
import com.hrtek.db.UserPositonsRepository;
import com.hrtek.db.accommodation.BedRepository;
import com.hrtek.db.accommodation.HouseRepository;
import com.hrtek.db.accommodation.RoomRepository;
import com.hrtek.model.UserInfo;
import com.hrtek.model.UserPostions;
import com.hrtek.settings.GlobalSettings;

@SpringBootTest
@Transactional
class RecruitmentServiceTest {

	private RecruitmentService recruitemenService;
	private CandidateRepository candidateRepo;
	private UserInfoRepository userInfoRepo;
	private UserPositonsRepository userPositionRepo;
	private FactoryRepository factroryRepo;
	private CompanyRepository companyRepo;
	private BedRepository bedRepo;
	private HouseRepository houseRepo;
	private RoomRepository roomRepo;
	private CitizenshipRepository citizenshipRepo;
	private DepartmentRepository departmentRepo;
	
	
	@Autowired	
	public RecruitmentServiceTest(RecruitmentService recruitemenService, CandidateRepository candidateRepo,
			UserInfoRepository userInfoRepo, UserPositonsRepository userPositionRepo, FactoryRepository factroryRepo,
			CompanyRepository companyRepo, BedRepository bedRepo, HouseRepository houseRepo, RoomRepository roomRepo,
			CitizenshipRepository citizenshipRepo, DepartmentRepository departmentRepo) {
		this.recruitemenService = recruitemenService;
		this.candidateRepo = candidateRepo;
		this.userInfoRepo = userInfoRepo;
		this.userPositionRepo = userPositionRepo;
		this.factroryRepo = factroryRepo;
		this.companyRepo = companyRepo;
		this.bedRepo = bedRepo;
		this.houseRepo = houseRepo;
		this.roomRepo = roomRepo;
		this.citizenshipRepo = citizenshipRepo;
		this.departmentRepo = departmentRepo;
	}


	@BeforeEach void setUp() throws Exception { 
		this.userInfoRepo.deleteAll();
		this.userPositionRepo.deleteAll(); 
		this.candidateRepo.deleteAll();
		this.userInfoRepo.deleteAll();
		this.userPositionRepo.deleteAll();
		this.factroryRepo.deleteAll();
		this.companyRepo.deleteAll();
		this.bedRepo.deleteAll();
		this.houseRepo.deleteAll();
		this.roomRepo.deleteAll();
		this.citizenshipRepo.deleteAll();
		this.departmentRepo.deleteAll();
	}
	

	@Test
	void empty_db_return_empty_candidate_list() {
		List<CandidateView> candidateViewList = recruitemenService.getCandidateViewList();
		assertTrue(candidateViewList.isEmpty());
	}
	
	@Test
	void db_contains_two_candidates() {
		UserPostions position = new UserPostions(GlobalSettings.agent);
		this.userPositionRepo.save(position);
		UserInfo u1 = new UserInfo(1l, "James", "Bond", position.getId(), "james.bond@mail", "342656511", 1);
		this.userInfoRepo.save(u1);
		
		Candidate c1 = new Candidate("Jan", "Nowak", "M", "jan.nowak@mail", "7894568", u1.getId(), "");
		Candidate c2 = new Candidate("Magdalena", "Jakubowska", "F", "magdalena.jakubowska@mail", "2346564", u1.getId(), "");
		this.candidateRepo.saveAll(Arrays.asList(c1, c2));
		
		List<CandidateView> candidateViewList = recruitemenService.getCandidateViewList();
		assertFalse(candidateViewList.isEmpty());
		assertEquals(c1.getLastname(), candidateViewList.get(0).getLastname());
		assertEquals(c2.getLastname(), candidateViewList.get(1).getLastname());
	}
	
	@Test
	void db_contains_two_candidates_but_recruiter_doesnt_exist() {
		UserPostions position = new UserPostions(GlobalSettings.agent);
		this.userPositionRepo.save(position);
		UserInfo u1 = new UserInfo(1l, "James", "Bond", position.getId(), "james.bond@mail", "342656511", 1);
		this.userInfoRepo.save(u1);
		
		Candidate c1 = new Candidate("Jan", "Nowak", "M", "jan.nowak@mail", "7894568", u1.getId(), "");
		Candidate c2 = new Candidate("Magdalena", "Jakubowska", "F", "magdalena.jakubowska@mail", "2346564", u1.getId(), "");
		this.candidateRepo.saveAll(Arrays.asList(c1, c2));
		
		this.userInfoRepo.deleteById(u1.getId());
		
		List<CandidateView> candidateViewList = recruitemenService.getCandidateViewList();
		assertFalse(candidateViewList.isEmpty());
		assertEquals("ERR: DOESN'T EXIST", candidateViewList.get(0).getRecruiter());
		
	}

}
