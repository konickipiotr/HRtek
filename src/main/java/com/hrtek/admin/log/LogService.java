package com.hrtek.admin.log;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrtek.db.LogRepository;
import com.hrtek.db.UserInfoRepository;
import com.hrtek.model.ListModel;
import com.hrtek.model.Log;
import com.hrtek.model.UserInfo;

@Service
public class LogService {
	
	@Autowired
	private LogRepository logRepo;
	@Autowired
	private UserInfoRepository userInfoRepo;
	
	public List<Log> getAllLogsOrderByTimestamp(){
		List<Log> list = logRepo.findAllByOrderByTstampDesc();
		list.forEach(i -> i.covert());
		return list;
	}	
	public Map<String, String> getEmployeeList(){
		List<UserInfo> userinfo = this.userInfoRepo.findAll();
		Map<String, String> result = new HashedMap<>();
		
		for(UserInfo u : userinfo) {
			result.put(u.getName(), u.getName());
		}
		return result;		
	}

}
