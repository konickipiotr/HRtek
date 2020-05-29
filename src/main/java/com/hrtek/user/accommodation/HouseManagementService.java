package com.hrtek.user.accommodation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.hrtek.db.accommodation.BedRepository;
import com.hrtek.db.accommodation.HouseRepository;
import com.hrtek.db.accommodation.RoomRepository;
import com.hrtek.db.worker.WorkerContactRepository;
import com.hrtek.db.worker.WorkerRepository;
import com.hrtek.model.ListModel;
import com.hrtek.model.accommodation.Bed;
import com.hrtek.model.accommodation.House;
import com.hrtek.model.accommodation.Room;
import com.hrtek.model.worker.Contact;
import com.hrtek.model.worker.Worker;

@Service
@Transactional
public class HouseManagementService {
	
	private HouseRepository houseRepo;
	private RoomRepository roomRepo;
	private BedRepository bedRepo;
	private WorkerRepository workerRepo;
	private WorkerContactRepository contatctRepo;
	
	@Autowired
	public HouseManagementService(HouseRepository houseRepo, RoomRepository roomRepo, BedRepository bedRepo,
			WorkerRepository workerRepo, WorkerContactRepository contatctRepo) {
		this.houseRepo = houseRepo;
		this.roomRepo = roomRepo;
		this.bedRepo = bedRepo;
		this.workerRepo = workerRepo;
		this.contatctRepo = contatctRepo;
	}


	public Long removeBed(Long bedid) {
		Optional<Bed> oBed = bedRepo.findById(bedid);
		if(oBed.isEmpty()) {
			//TODO
		}
		
		Bed b = oBed.get();
		House h = houseRepo.findById(b.getHouseid()).get();
		Room r = roomRepo.findById(b.getRoomid()).get();
		
		if(b.getBedstatus().equals(Bedstatus.OCCUPIED)) {
			r.removePerson();
			h.removePerson();
			clearAddress(b.getWorkerid());
		}
		r.removeBed();
		this.roomRepo.save(r);
		
		h.removeBed();
		this.houseRepo.save(h);
		
		this.bedRepo.delete(b);
		return h.getId();		
	}
	
	public Long addBed(Long roomid) {
		Optional<Room> oRoom = roomRepo.findById(roomid);
		if(oRoom.isEmpty()) {
			//TODO
		}
		
		Room r = oRoom.get();
		House h = houseRepo.findById(r.getHouseid()).get();
		
		r.addBed();
		this.roomRepo.save(r);
		
		h.addBed();
		this.houseRepo.save(h);
		
		this.bedRepo.save(new Bed(r.getId(), h.getId(), null, null, Bedstatus.FREE));
		return h.getId();		
	}
	
	public Long removeRoom(Long roomid) {
		Optional<Room> oRoom = roomRepo.findById(roomid);
		if(oRoom.isEmpty()) {
			//TODO
		}
		
		Room r = oRoom.get();
		House h = houseRepo.findById(r.getHouseid()).get();
		
		List<Bed> beds = r.getBedlist();
		h.removeRoom(r);
		this.houseRepo.save(h);
		this.roomRepo.delete(r);
		
		
		for(Bed be : beds) {
			if(be.getWorkerid()!= null)
				clearAddress(be.getWorkerid());
		}
		this.bedRepo.deleteAll(beds);
		return h.getId();		
	}

	public Long addRoom(Room r) {
		Optional<House> oHouse = houseRepo.findById(r.getHouseid());
		if(oHouse.isEmpty()) {
			//TODO
		}
		
		House h = oHouse.get();
		h.addRoom(r);
		this.houseRepo.save(h);
		
		this.roomRepo.save(r);
		
		for(int i = 0; i < r.getCapacity(); i++) {
			this.bedRepo.save(new Bed(r.getId(), h.getId(), null, null, Bedstatus.FREE));
		}
		
		return h.getId();			
	}
	
	public void saveRoomNote(Long roomid, String remark) {
		Optional<Room> oRoom = roomRepo.findById(roomid);
		if(oRoom.isEmpty()) {
			//TODO
		}
		Room r = oRoom.get();
		r.setRemark(remark);
		this.roomRepo.save(r);
	}
	
	
	public List<ListModel> getPeopleWithoutBed(){
		List<ListModel> list = new ArrayList<>();
		List<Contact> con = contatctRepo.withoutBed();
		System.out.println(">>>>" + con.size());
		
		for(Contact c : con) {
			System.out.println(c);
			Worker w = workerRepo.findById(c.getId()).get();
			list.add(new ListModel(c.getId(), (w.getName()) + (!c.getPladdress().isBlank()? " - Własne" : "")) );
		}
		return list;
	}
	
	public Long addPerson(Bed b) {
		Optional<Bed> oBed = bedRepo.findById(b.getId());
		if(oBed.isEmpty()) {
			//TODO
		}
		Bed nBed = oBed.get();
		nBed.setOccupied(b.getWorkerid(), b.getExpire());
		Room r = roomRepo.findById(nBed.getRoomid()).get();
		House h = houseRepo.findById(nBed.getHouseid()).get();
		
		h.addPerson();
		this.houseRepo.save(h);
		r.addPerson();
		this.roomRepo.save(r);
		
		Contact c = contatctRepo.findById(nBed.getWorkerid()).get();
		c.setaccommodation(nBed.getId(), r.getId(), h.getId());
		c.addFromHouse(h);
		this.contatctRepo.save(c);
		
		this.bedRepo.save(nBed);
		return h.getId();
	}
	
	public Long removePerson(Long id) {
		Optional<Bed> oBed = bedRepo.findById(id);
		if(oBed.isEmpty()) {
			//TODO
		}
		Bed b = oBed.get();
		System.out.println(b);
		House h = houseRepo.findById(b.getHouseid()).get();
		Room r = roomRepo.findById(b.getRoomid()).get();
		
		clearAddress(b.getWorkerid());
		h.removePerson();
		this.houseRepo.save(h);
		r.removePerson();
		this.roomRepo.save(r);
		b.setFree();
		this.bedRepo.save(b);
		System.out.println(b);
		
		
		return h.getId();
	}
	
	private void clearAddress(Long workerid) {
		Worker w = workerRepo.findById(workerid).get();
		Contact c = contatctRepo.findById(w.getId()).get();
		c.removePersonFromHouse();
		this.contatctRepo.save(c);
	}
	
}
