package com.hrtek.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hrtek.db.CitizenshipRepository;
import com.hrtek.db.CompanyRepository;
import com.hrtek.db.DepartmentRepository;
import com.hrtek.db.FactoryRepository;
import com.hrtek.db.UserInfoRepository;
import com.hrtek.db.UserPositonsRepository;
import com.hrtek.db.accommodation.BedRepository;
import com.hrtek.db.accommodation.HouseRepository;
import com.hrtek.db.accommodation.RoomRepository;
import com.hrtek.model.Citizenship;
import com.hrtek.model.Company;
import com.hrtek.model.Department;
import com.hrtek.model.Factory;
import com.hrtek.model.ListModel;
import com.hrtek.model.StatusFC;
import com.hrtek.model.UserInfo;
import com.hrtek.model.accommodation.Bed;
import com.hrtek.model.accommodation.House;
import com.hrtek.model.accommodation.Room;
import com.hrtek.settings.GlobalSettings;
import com.hrtek.user.accommodation.Bedstatus;

public class SortFields {
	
	private CitizenshipRepository citizenshipRepo;
	private DepartmentRepository departmentRepo;
	private FactoryRepository factroryRepo;
	private CompanyRepository companyRepo;
	private UserInfoRepository userInfoRepo;
	private UserPositonsRepository userPositionRepo;
	private BedRepository bedRepo;
	private HouseRepository houseRepo;
	private RoomRepository roomRepo;

	public SortFields(CitizenshipRepository citizenshipRepo, DepartmentRepository departmentRepo,
			FactoryRepository factroryRepo, CompanyRepository companyRepo, UserInfoRepository userInfoRepo,
			UserPositonsRepository userPositionRepo, BedRepository bedRepo, HouseRepository houseRepo,
			RoomRepository roomRepo) {
		this.citizenshipRepo = citizenshipRepo;
		this.departmentRepo = departmentRepo;
		this.factroryRepo = factroryRepo;
		this.companyRepo = companyRepo;
		this.userInfoRepo = userInfoRepo;
		this.userPositionRepo = userPositionRepo;
		this.bedRepo = bedRepo;
		this.houseRepo = houseRepo;
		this.roomRepo = roomRepo;
	}

	public List<ListModel> getCoordinatorsAndAgents(){
		List<ListModel> recruiters = new ArrayList<>();
		int agenid = userPositionRepo.findByPosition(GlobalSettings.agent).getId();
		int coordinatorsid = userPositionRepo.findByPosition(GlobalSettings.coordinator).getId();
		List<UserInfo> agentsAndcoordinators = userInfoRepo.getAgentsAndCoordinators(agenid, coordinatorsid);
		
		for(UserInfo u : agentsAndcoordinators) {
			String position = u.getPosition() == agenid ? GlobalSettings.agent : GlobalSettings.coordinator;
			recruiters.add(new ListModel(u.getId(), u.getName()+" - " + position));
		}
		return recruiters;
	}

	public List<ListModel> getOrederAgentsAndCoordinators(Long id){
		List<ListModel> recruiters = getCoordinatorsAndAgents(); 
		
		if(id != null) {
			for(int i = 0 ; i < recruiters.size(); i++) {
				if(recruiters.get(i).getId().equals(id)) {
					Collections.swap(recruiters, 0, i);
					break;
				}
			}
		}
		return recruiters;
	}
	
	public List<Factory> getFactoryInOrder(Long id){
		List<Factory> factories = factroryRepo.findByStatus(StatusFC.ENABLED);
		
		if( id != null) {
			for(int i = 0 ; i < factories.size(); i++) {
				if(factories.get(i).getId().equals(id)) {
					Collections.swap(factories, 0, i);
					break;
				}
			}
		}
		return factories;
	}
	
	public List<Citizenship> getCitizenshipInOrder(Integer id){
		List<Citizenship> citizenship = citizenshipRepo.findAll(); 
		
		if( id != null) {
			for(int i = 0 ; i < citizenship.size(); i++) {
				if(citizenship.get(i).getId().equals(id)) {
					Collections.swap(citizenship, 0, i);
					break;
				}
			}
		}
		return citizenship;
	}
	
	public List<Department> getDepartmentInOrder(Long id){
		List<Department> departments = departmentRepo.findAll(); 
		
		if( id != null) {
			for(int i = 0 ; i < departments.size(); i++) {
				if(departments.get(i).getId().equals(id)) {
					Collections.swap(departments, 0, i);
					break;
				}
			}
		}
		return departments;
	}
	
	
	public List<Company> getCompaniesInOrder(Long id){
		List<Company> companies = companyRepo.findByStatus(StatusFC.ENABLED); 
		
		if(id != null) {
			for(int i = 0 ; i < companies.size(); i++) {
				if(companies.get(i).getId().equals(id)) {
					Collections.swap(companies, 0, i);
					break;
				}
			}
		}
		return companies;
	}
	
	public List<ListModel> getBedsInOrder(Long bedid){
		List<Bed> bedsRaw = bedRepo.findByBedstatus(Bedstatus.FREE);
		
		if(bedid != null) {
			bedsRaw.add(bedRepo.findById(bedid).get());
		}
		
		List<ListModel> beds = new ArrayList<ListModel>();
		
		for(Bed b : bedsRaw) {
			House h = houseRepo.findById(b.getHouseid()).get();
			Room r = roomRepo.findById(b.getRoomid()).get();
			String text = h.getAddress() + " - " + h.getCity() + " | room: " + r.getRoomname();
			beds.add(new ListModel(b.getId(), text));
		}
		
		
		if(bedid != null) {
			for(int i = 0 ; i < beds.size(); i++) {
				if(beds.get(i).getId().equals(bedid)) {
					Collections.swap(beds, 0, i);
					break;
				}
			}
		}
		return beds;
	}

}
