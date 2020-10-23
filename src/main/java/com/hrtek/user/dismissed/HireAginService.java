package com.hrtek.user.dismissed;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrtek.db.CitizenshipRepository;
import com.hrtek.db.worker.DismissRepository;
import com.hrtek.model.Citizenship;
import com.hrtek.user.recruitment.OldWorker;
import com.hrtek.user.recruitment.WorkerAll;

@Service
public class HireAginService {
	
	private DismissRepository dismissRepo;
	private CitizenshipRepository citizenshipRepo;
	
	@Autowired
	public HireAginService(DismissRepository dismissRepo, CitizenshipRepository citizenshipRepo) {
		this.dismissRepo = dismissRepo;
		this.citizenshipRepo = citizenshipRepo;
	}



	public WorkerAll prepareWorkerAll(Long id) {
		Optional<Dismissed> oDis = this.dismissRepo.findById(id);
		if(oDis.isEmpty()) {
			//TODO
		}
		Dismissed dis = oDis.get();
		WorkerAll wall  = new WorkerAll(dis);
		List<Citizenship> cit_list = this.citizenshipRepo.findAll();
		for(Citizenship c : cit_list) {
			if(c.getName().equals(dis.getCitizenship())) {
				wall.setCitizenship(c.getId());
				break;
			}
		}
		return wall;
	}
	
	public List<OldWorker> getUniqeListOfOldWorkers(){
		List<OldWorker> first = new ArrayList<>();
		
		{
			List<Dismissed> all = dismissRepo.findAll();
		
			for(Dismissed d: all) {
				first.add(new OldWorker(d));
			}
		}
		
		List<OldWorker> newlist = new ArrayList<OldWorker>();
		
		if(!first.isEmpty()) {
			String val = first.get(0).getName();
			newlist.add(first.get(0));
			for(OldWorker o : first) {
				if(o.getName().equals(val)) {
					continue;
				}else {
					newlist.add(o);
				}
			}
		}
		return newlist;	
	}
}
