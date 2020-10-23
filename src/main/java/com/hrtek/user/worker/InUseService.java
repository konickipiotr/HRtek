package com.hrtek.user.worker;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrtek.db.InUseRepository;
import com.hrtek.model.UserInfo;
import com.hrtek.settings.GlobalSettings;

@Service
@Transactional
public class InUseService {
	
	@Autowired
	private InUseRepository inUseRepo;
	

	public Available getAvailable(long id) {
		Available available = new Available();
		inUseRepo.deleteByExpiredBefore(LocalDateTime.now(GlobalSettings.zid));
		List<InUse> inUseList = inUseRepo.findByWorkerid(id);
		
		for(InUse i : inUseList) {
			switch (i.getUsedTable()) {
			case WORKER: available.setWorker(i);break;
			case BASIC: available.setBasic(i);break;
			case DATE: available.setDate(i);break;
			case RESIDENCY: available.setResidency(i);break;
			case FINANCE: available.setFinance(i);break;
			case PERMIT: available.setPermit(i);break;
			case STATEMENT: available.setStatement(i);break;
			case CONTACT: available.setContact(i);break;
			case ADDRESSPL: available.setAddresspl(i);break;
			case ADDRESS: available.setAddress(i);break;
			}
		}
		return available;
	}
	
	public void updateInUser() {
		
	}

	public LocalDateTime lockup(UserInfo user, Long workerid, UsedTable usedTable) {
		LocalDateTime now = LocalDateTime.now(GlobalSettings.zid);

		LocalDateTime lock = LocalDateTime.now(GlobalSettings.zid).plusMinutes(GlobalSettings.lockupminue);
		
		InUse iu = new InUse(workerid, user.getId(), usedTable, lock, user.getName());
		this.inUseRepo.deleteByExpiredBefore(now);
		if(this.inUseRepo.existsByWorkeridAndUsedTable(workerid, usedTable)) {
			if(this.inUseRepo.findByWorkeridAndUsedTable(workerid, usedTable).getId().equals(user.getId())) {
				return null;
			}
			return lock;
		}
		this.inUseRepo.save(iu);
		return lock;
	}
	
	public void unlock(Long workerid, UsedTable usedTable, Long userid) {
		this.inUseRepo.deleteByWorkeridAndUsedTableAndUserid(workerid, usedTable, userid);
	}

	
}
