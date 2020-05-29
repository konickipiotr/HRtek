package com.hrtek.user.accommodation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrtek.model.ListModel;
import com.hrtek.model.accommodation.Bed;
import com.hrtek.model.accommodation.Room;

@Controller
@RequestMapping("/accomoperation")
public class AccommodationRoomsController {

	@Autowired
	private HouseManagementService houseMenagment;
	
	@GetMapping("/removebed/{id}")
	public String removeBed(@PathVariable("id") Long id) {
		Long houseid = houseMenagment.removeBed(id);
		return "redirect:/accdetail/" + houseid;
	}
	
	@GetMapping("/addbed/{id}")
	public String addBed(@PathVariable("id") Long id) {
		Long houseid = houseMenagment.addBed(id);
		return "redirect:/accdetail/" + houseid;
	}
	
	@GetMapping("/removeroom/{id}")
	public String removerRoom(@PathVariable("id") Long id) {
		Long houseid = houseMenagment.removeRoom(id);
		return "redirect:/accdetail/" + houseid;
	}
	
	@GetMapping("/addroom/{houseid}")
	public String toAddRoom(@PathVariable("houseid") Long houseid, Model model) {
		model.addAttribute("houseid", houseid);
		return "user/accommodation/addRoom";
	}
	
	@PostMapping("/addroom")
	public String AddRoom(Room room) {
		System.out.println(room);
		Long houseid = houseMenagment.addRoom(room);
		return "redirect:/accdetail/" + houseid;
	}
	
	@PostMapping("/saveroomnote")
	public String AddRoom(@RequestParam("roomid") Long roomid, 
						@RequestParam("remark") String remark,
						@RequestParam("houseid") Long houseid) {
		
		houseMenagment.saveRoomNote(roomid, remark);
		return "redirect:/accdetail/" + houseid;
	}
	
	@GetMapping("/addPerson/{bedid}")
	public String toAddPerson(@PathVariable("bedid") Long bedid, Model model) {
		List<ListModel> list = houseMenagment.getPeopleWithoutBed();
		model.addAttribute("list", list);
		model.addAttribute("bedid", bedid);
		return "user/accommodation/addPerson";
	}
	
	@PostMapping("/addPerson")
	public String addPerson(Bed bed) {
		System.out.println("tuuuuu -> " + bed);
		Long houseid = houseMenagment.addPerson(bed);
		return "redirect:/accdetail/" + houseid;
	}
	
	@GetMapping("/removePerson/{id}")
	public String removePerson(@PathVariable("id") Long id) {
		Long houseid = houseMenagment.removePerson(id);
		return "redirect:/accdetail/" + houseid;
	}
	
}
