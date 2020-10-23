package com.hrtek.user.display.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrtek.db.worker.DismissRepository;
import com.hrtek.user.dismissed.Dismissed;
import com.hrtek.user.display.views.DismissedView;

@Service
public class DismissedDisplayService {
	
	@Autowired
	private DismissRepository dismissedRepo;
	
	public List<DismissedView> getDismissedViewList(){
		List<Dismissed> dismissed_list = dismissedRepo.findAll();
		
		List<DismissedView> dv_list = new ArrayList<>();
		
		for(Dismissed d : dismissed_list)
			dv_list.add(new DismissedView(d));
		
		return dv_list;
	}
	


}
