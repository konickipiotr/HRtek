package com.hrtek.user.accommodation;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hrtek.db.accommodation.BedRepository;
import com.hrtek.db.accommodation.HouseRepository;
import com.hrtek.db.accommodation.RoomRepository;
import com.hrtek.model.accommodation.AddressForm;
import com.hrtek.model.accommodation.FinanceForm;
import com.hrtek.model.accommodation.House;
import com.hrtek.model.accommodation.Room;

@Service
public class AccDetailService {
	
	private HouseRepository houseRepo;
	private RoomRepository roomRepo;
	private BedRepository bedRepo;
	
	@Autowired
	public AccDetailService(HouseRepository houseRepo, RoomRepository roomRepo, BedRepository bedRepo) {
		super();
		this.houseRepo = houseRepo;
		this.roomRepo = roomRepo;
		this.bedRepo = bedRepo;
	}

	public boolean updateView(Model model, Long housid) {
		Optional<House> oHouse = houseRepo.findById(housid);
		if(oHouse.isEmpty()) {
			return false;
		}
		
		House house = oHouse.get();
		
		List<Room> rooms = roomRepo.findByHouseid(house.getId()); 
		
		model.addAttribute("rooms", rooms);
		
		System.out.println(rooms);
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
		String type = ff.getTypecost();
		if(type.equals("rent")) {
			ff.setPerperson(ff.getRent()/house.getCapacity());
		}else if(type.equals("rentmedia")) {
			double result = (ff.getRent() + ff.getMedia()) / house.getCapacity();
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

}
