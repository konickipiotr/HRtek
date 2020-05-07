package com.hrtek.user.accommodation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrtek.db.accommodation.BedRepository;
import com.hrtek.db.accommodation.HouseRepository;
import com.hrtek.db.accommodation.RoomRepository;
import com.hrtek.model.accommodation.Bed;
import com.hrtek.model.accommodation.House;
import com.hrtek.model.accommodation.Room;

@Service
public class AccommodationService {

	@Autowired
	private HouseRepository houseRepo;
	private RoomRepository roomRepo;
	private BedRepository bedRepo;

	@Autowired
	public AccommodationService(HouseRepository houseRepo, RoomRepository roomRepo, BedRepository bedRepo) {
		this.houseRepo = houseRepo;
		this.roomRepo = roomRepo;
		this.bedRepo = bedRepo;
	}

	public List<House> getAllHouses() {
		return houseRepo.findAll();
	}
	
	public void saveHouse(House house){
		String type = house.getTypecost();
		if(type.equals("rent")) {
			house.setPerperson(house.getRent()/house.getCapacity());
		}else if(type.equals("rentmedia")) {
			double result = (house.getRent() + house.getMedia()) / house.getCapacity();
			house.setPerperson(result);
		}
		this.houseRepo.save(house);
	}
	
	public void saveRoomAndBead(House house, String[] roomname, String[] remark, int[] capacity) {
		System.out.println("nnofroom"+house.getNoofrooms());
		System.out.println("capaclen " + capacity.length);
		if(house.getNoofrooms() == roomname.length && roomname.length == remark.length && capacity.length == remark.length) {
			System.out.println("Wszystko ok");
		}else{
			System.out.println("coś nie ok");
		}
		
		for(int i = 0; i < house.getNoofrooms(); i++) {
			Room room = new Room();
			room.setCapacity(capacity[i]);
			room.setHouseid(house.getId());
			room.setOccupied(0);
			room.setRoomname(roomname[i]);
			room.setRemark(remark[i]);
			this.roomRepo.save(room);
			
			for(int j = 0; j < capacity[i]; j++) {
				System.out.println("j = " + j +" -- " + capacity[i]);
				this.bedRepo.save(new Bed(room.getId(), house.getId(), null, null, Bedstatus.FREE));
			}
		}
	}
}
