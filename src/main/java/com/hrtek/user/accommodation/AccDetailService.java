package com.hrtek.user.accommodation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hrtek.db.accommodation.BedRepository;
import com.hrtek.db.accommodation.HouseRepository;
import com.hrtek.db.accommodation.RoomRepository;
import com.hrtek.db.worker.WorkerFinanceRepository;
import com.hrtek.db.worker.WorkerRepository;
import com.hrtek.model.ListModel;
import com.hrtek.model.accommodation.AddressForm;
import com.hrtek.model.accommodation.Bed;
import com.hrtek.model.accommodation.CostType;
import com.hrtek.model.accommodation.FinanceForm;
import com.hrtek.model.accommodation.House;
import com.hrtek.model.accommodation.LiderForm;
import com.hrtek.model.accommodation.Room;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerFinance;

@Service
public class AccDetailService {
	
	private HouseRepository houseRepo;
	private RoomRepository roomRepo;
	private BedRepository bedRepo;
	private WorkerRepository workerRepo;
	private WorkerFinanceRepository workerFinanceRepo;

	@Autowired
	public AccDetailService(HouseRepository houseRepo, RoomRepository roomRepo, BedRepository bedRepo,
			WorkerRepository workerRepo, WorkerFinanceRepository workerFinanceRepo) {
		this.houseRepo = houseRepo;
		this.roomRepo = roomRepo;
		this.bedRepo = bedRepo;
		this.workerRepo = workerRepo;
		this.workerFinanceRepo = workerFinanceRepo;
	}

	public boolean updateView(Model model, Long housid) {
		Optional<House> oHouse = houseRepo.findById(housid);
		if(oHouse.isEmpty()) {
			return false;
		}
		
		House house = oHouse.get();
		List<Room> rooms = roomRepo.findByHouseid(house.getId()); 
		for(Room r : rooms) {
			List<Bed> beds = r.getBedlist();
			List<BedView> bv = new ArrayList<BedView>();
			for(Bed b : beds) {
				BedView nb = new BedView(b);
				if(b.getWorkerid() != null) {
					nb.setWorkername(workerRepo.findById(b.getWorkerid()).get().getName());
				}
				bv.add(nb);
			}
			r.setBedViewList(bv);
			r.setBedlist(null);
		}
		
		model.addAttribute("rooms", rooms);
		model.addAttribute("houshold", getHousehold(house.getId()));
		model.addAttribute("house", house);
		return true;
	}
	
	public void updateAddress(AddressForm af) {
		House house = houseRepo.findById(af.getId()).get();
		house.changeAddress(af);
		this.houseRepo.save(house);
	}
	
	public void updateFinance(FinanceForm ff) {
		House house = houseRepo.findById(ff.getId()).get();
		CostType type = ff.getCostType();
		if(type.equals(CostType.RENT)) {
			ff.setPerperson(ff.getRent().divide(BigDecimal.valueOf(house.getCapacity()), 2, RoundingMode.HALF_UP));
		}else if(type.equals(CostType.MEDIARENT)) {
			BigDecimal result = (ff.getRent().add(ff.getMedia())).divide(BigDecimal.valueOf(house.getCapacity()) , 2, RoundingMode.HALF_UP);
			ff.setPerperson(result);
		}
		house.changeFinance(ff);
		this.houseRepo.save(house);
	}
	
	public void updateRemark(Long id, String remark) {
		House house = houseRepo.findById(id).get();
		house.setRemark(remark);
		this.houseRepo.save(house);
	}
	
	private List<ListModel> getHousehold(Long houseid){
		List<Bed> oBeds = bedRepo.findByBedstatusAndHouseid(Bedstatus.OCCUPIED, houseid);
		List<ListModel> list = new ArrayList<>();

		for(Bed b : oBeds) {
			Worker w = workerRepo.findById(b.getWorkerid()).get();
			list.add(new ListModel(b.getWorkerid(), w.getName()));
		}
		return list;
	}
	
	public void saveLider(LiderForm lf) {
		Long houseid = lf.getId();
		Optional<House> oHouse = houseRepo.findById(houseid);
		if(oHouse.isEmpty()) {
			//TODO
		}
		House h = oHouse.get();
		
		if(h.getLiderid() != null) {
			WorkerFinance oldwf = workerFinanceRepo.findById(h.getLiderid()).get();
			oldwf.setBonus( new BigDecimal("0"));
			this.workerFinanceRepo.save(oldwf);
		}
		
		Worker w = workerRepo.findById(lf.getLiderid()).get();
		WorkerFinance wf = workerFinanceRepo.findById(w.getId()).get();
		
		wf.setBonus(lf.getLiderbonus());
		this.workerFinanceRepo.save(wf);
		
		h.setLiderid(w.getId());
		h.setLidername(w.getName());
		h.setLiderbonus(lf.getLiderbonus());
		this.houseRepo.save(h);		
	}
	

}
