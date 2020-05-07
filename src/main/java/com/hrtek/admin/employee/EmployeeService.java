package com.hrtek.admin.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrtek.db.LogRepository;
import com.hrtek.db.UserInfoRepository;
import com.hrtek.db.UserPositonsRepository;
import com.hrtek.db.UserRepository;
import com.hrtek.model.Log;
import com.hrtek.model.UserInfo;
import com.hrtek.model.UserPostions;
import com.hrtek.settings.GlobalSettings;

@Service
public class EmployeeService {
	
	private UserInfoRepository userInfoRepo;
	private UserRepository userRepo;
	public LogRepository logRepo;
	public UserPositonsRepository userPositionRepo;

	@Autowired
	public EmployeeService(UserInfoRepository userInfoRepo, UserPositonsRepository userPositionRepo,
			UserRepository userRepo, LogRepository logRepo) {
		this.userInfoRepo = userInfoRepo;
		this.userPositionRepo = userPositionRepo;
		this.userRepo = userRepo;
		this.logRepo = logRepo;
	}
	
	public List<UserPostions> getEmployeePositions(){
		List<UserPostions> upl = userPositionRepo.findAll();
		for(int i = 0; i < upl.size(); i++ ) {
			if(upl.get(i).getPosition().equals(GlobalSettings.boss)) {
				upl.remove(i);
				i--;
			}
		}
		return upl;
	}

	public List<EmployeeView> getEmployeeViewList() {
		List<EmployeeView> employeeViewList = new ArrayList<EmployeeView>();
		
		List<UserInfo> employeeList = userInfoRepo.findAll();
		
		for(UserInfo e : employeeList) {
			EmployeeView ev = new EmployeeView(e);
			Optional<UserPostions> foundposition = userPositionRepo.findById(e.getPosition());
			if(foundposition.isPresent()) {
				UserPostions positon = foundposition.get();
				if(positon.getPosition().equals(GlobalSettings.boss))
					continue;
				ev.setPosition(positon.getPosition());
				ev.setLogin(userRepo.findById(e.getId()).get().getUsername());
			}else {
				this.logRepo.save(new Log("SYSTEM_ERROR", "Unknown position for "+ e.getId()+" - " + e.getFirstname()+ " " + e.getLastname()));
				ev.setPosition("UNKNOWN");
			}
			employeeViewList.add(ev);
		}
		return employeeViewList;
	}
	
	public EmployeeView getEmployee(Long id) {
		UserInfo ui = userInfoRepo.findById(id).get();
		if(ui != null) {
			EmployeeView ev = new EmployeeView(ui);
			ev.setPosition(userPositionRepo.findById(ui.getPosition()).get().getPosition());
			return ev;
		}
		return null;
	}
	
	public void deleteEmployeeById(Long id) {
		this.userInfoRepo.deleteById(id);
		this.userRepo.deleteById(id);
	}
	
	public void updateUser(UserInfo ui) {
		UserInfo userinfo = this.userInfoRepo.findById(ui.getId()).get();
		userinfo.update(ui);
		this.userInfoRepo.save(userinfo);
	}
	

}
