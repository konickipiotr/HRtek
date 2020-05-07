package com.hrtek.db;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hrtek.admin.tickets.TicketType;
import com.hrtek.db.accommodation.BedRepository;
import com.hrtek.db.accommodation.HouseRepository;
import com.hrtek.db.accommodation.RoomRepository;
import com.hrtek.enums.UserStatus;
import com.hrtek.model.Company;
import com.hrtek.model.Ticket;
import com.hrtek.model.User;
import com.hrtek.model.UserInfo;
import com.hrtek.model.UserPostions;
import com.hrtek.model.accommodation.House;
import com.hrtek.settings.GlobalSettings;

@Service
public class DBInit implements CommandLineRunner {

	private UserRepository userRepo;
	private UserInfoRepository userInfoRepo;
	private PasswordEncoder passwordEncoder;
	private UserPositonsRepository userPositionsRepo;
	private TestDB testDB;
	private CompanyRepository companyRepo;
	private TicketRepository ticketRepo;
	private CandidateRepository candidateRepo;
	private HouseRepository houseRepo;
	private RoomRepository roomRepo;
	private BedRepository bedRepo;

	
	@Autowired
	public DBInit(UserRepository userRepo, UserInfoRepository userInfoRepo, PasswordEncoder passwordEncoder,
			UserPositonsRepository userPositionsRepo, TestDB testDB, CompanyRepository companyRepo,
			TicketRepository ticketRepo, CandidateRepository candidateRepo, HouseRepository houseRepo,
			RoomRepository roomRepo, BedRepository bedRepo) {
		super();
		this.userRepo = userRepo;
		this.userInfoRepo = userInfoRepo;
		this.passwordEncoder = passwordEncoder;
		this.userPositionsRepo = userPositionsRepo;
		this.testDB = testDB;
		this.companyRepo = companyRepo;
		this.ticketRepo = ticketRepo;
		this.candidateRepo = candidateRepo;
		this.houseRepo = houseRepo;
		this.roomRepo = roomRepo;
		this.bedRepo = bedRepo;
	}



	@Override
	public void run(String... args) throws Exception {
		this.userInfoRepo.deleteAll();
		this.userRepo.deleteAll();
		this.userPositionsRepo.deleteAll();
		this.companyRepo.deleteAll();
		this.ticketRepo.deleteAll();
		this.candidateRepo.deleteAll();
		
		Company c1 = new Company("11111", "2222222222", "3333", "444444444", "555", "UWC", "UWC sp. z o.o", "Kutnowska 43", "53-541", "Wrocław", 0, 20.10);
		Company c2 = new Company("99999", "8888888888", "7777", "666666666", "111", "XYZ", "XYZ sp. z o.o", "Śnieżna 12", "23-311", "Wrocław", 0, 15.10);
		this.companyRepo.saveAll(Arrays.asList(c1, c2));
		
		testDB.fill();
		
		UserPostions up1 = new UserPostions("Admin");
		UserPostions up2 = new UserPostions("Boss");
		UserPostions up3 = new UserPostions("Office");
		UserPostions up4 = new UserPostions(GlobalSettings.agent);
		UserPostions up5 = new UserPostions(GlobalSettings.coordinator);
		this.userPositionsRepo.saveAll(Arrays.asList(up1, up2, up3, up4, up5));
		
		User u1 = new User("superadmin", passwordEncoder.encode("123"), "ADMIN", UserStatus.ACTIVE);
		User u2 = new User("boss", passwordEncoder.encode("123"), "BOSS",  UserStatus.ACTIVE);
		User u3 = new User("user1", passwordEncoder.encode("123"), "USER",  UserStatus.ACTIVE);
		User u4 = new User("user2", passwordEncoder.encode("123"), "USER",  UserStatus.ACTIVE);
		User u5 = new User("user3", passwordEncoder.encode("123"), "USER",  UserStatus.ACTIVE);
		this.userRepo.saveAll(Arrays.asList(u1, u2, u3, u4, u5));
		
		UserInfo ui1 = new UserInfo(u1.getId(), "super", "admin", "", up1.getId() , "", "", 0);
		UserInfo ui2 = new UserInfo(u2.getId(), "Krzysztof", "Jarzyna", "", up2.getId(), "krzysztof.jarzyna@mail.com", "7598421", 1);
		UserInfo ui3 = new UserInfo(u3.getId(), "Adam", "Nowak", "", up3.getId() , "adam.nowak@mail.com", "7894891", 0);
		UserInfo ui4 = new UserInfo(u4.getId(), "James", "Bond", "", up4.getId() , "james.bondk@mail.com", "7070007", 0);
		UserInfo ui5 = new UserInfo(u5.getId(), "Jadwiga", "Koordynariusz", "", up5.getId() , "jadwika.koordynaiusz@mail.com", "3548891", 0);
		this.userInfoRepo.saveAll(Arrays.asList(ui1, ui2, ui3, ui4, ui5));
		
		this.ticketRepo.save(new Ticket(TicketType.PASSWORDFORGOTTEN, u3.getUsername(), u3.getId(), ""));
		
		this.houseRepo.deleteAll();
		this.roomRepo.deleteAll();
		this.bedRepo.deleteAll();

	}

}

