package com.hrtek.db;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hrtek.model.User;
import com.hrtek.model.UserInfo;
import com.hrtek.model.UserPostions;

@Service
public class DBInit implements CommandLineRunner {

	private UserRepository userRepo;
	private UserInfoRepository userInfoRepo;
	private PasswordEncoder passwordEncoder;
	private UserPositonsRepository userPositionsRepo;

	@Autowired
	public DBInit(UserRepository userRepo, UserInfoRepository userInfoRepo, PasswordEncoder passwordEncoder,
			UserPositonsRepository userPositionsRepo) {
		this.userRepo = userRepo;
		this.userInfoRepo = userInfoRepo;
		this.passwordEncoder = passwordEncoder;
		this.userPositionsRepo = userPositionsRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		this.userInfoRepo.deleteAll();
		this.userRepo.deleteAll();
		this.userPositionsRepo.deleteAll();
		
		UserPostions up1 = new UserPostions("Boss");
		UserPostions up2 = new UserPostions("Admin");
		UserPostions up3 = new UserPostions("Office");
		this.userPositionsRepo.saveAll(Arrays.asList(up1, up2, up3));
		
		User u1 = new User("superadmin", passwordEncoder.encode("123"), "ADMIN", 2);
		User u2 = new User("boss", passwordEncoder.encode("123"), "BOSS", 2);
		User u3 = new User("user1", passwordEncoder.encode("123"), "USER", 2);
		this.userRepo.saveAll(Arrays.asList(u1, u2, u3));
		
		UserInfo ui1 = new UserInfo(u1.getId(), "super", "admin", "", up1.getId() , "", "", 0);
		UserInfo ui2 = new UserInfo(u2.getId(), "Krzysztof", "Jarzyna", "", up2.getId(), "", "", 0);
		UserInfo ui3 = new UserInfo(u3.getId(), "Adam", "Nowak", "", up3.getId() , "adam.nowak@mail.com", "7894891", 0);
		this.userInfoRepo.saveAll(Arrays.asList(ui1, ui2, ui3));
		
		
	}

}

