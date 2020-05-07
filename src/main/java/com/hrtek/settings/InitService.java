package com.hrtek.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrtek.db.UserPositonsRepository;
import com.hrtek.model.UserPostions;

@Service
public class InitService {
	
	@Autowired
	private UserPositonsRepository userPositionsRepo;
	
	public void initHRtek() {
		
		if(!userPositionsRepo.existsByPosition(GlobalSettings.agent)) {
			userPositionsRepo.save(new UserPostions(GlobalSettings.agent));
		}
		
		if(!userPositionsRepo.existsByPosition(GlobalSettings.coordinator)) {
			userPositionsRepo.save(new UserPostions(GlobalSettings.coordinator));
		}
	}

}
