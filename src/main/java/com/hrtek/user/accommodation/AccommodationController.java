package com.hrtek.user.accommodation;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrtek.model.accommodation.House;

@Controller
@RequestMapping("/accommodation")
public class AccommodationController {
	
	@Autowired
	private AccommodationService accommodationService;
	
	@GetMapping
	public String showAllHouses(Model model, String message) {
		model.addAttribute("error_msg", message);
		model.addAttribute("houses", accommodationService.getAllHouses());
		return "user/accommodation/houses";
	}
	
	@GetMapping("/newaccommodation")
	public String toNewHouse(Model model) {
		model.addAttribute("house", new House());
		return "user/accommodation/newhouse";
	}
	
	@PostMapping("/rooms")
	public String toSetRoom(@ModelAttribute("house") House house, Model model, HttpSession session) {
		
		if(house.getNoofrooms()>house.getCapacity()) {
			model.addAttribute("wrong_capacity", "ilość miejsc musi wynosić minmum liczba pokoi");
			model.addAttribute("house", house);
			return "user/accommodation/newhouse";
		}
		session.setAttribute("house", house);
		model.addAttribute("house", house);
		return "user/accommodation/setrooms";
	}
	
	@PostMapping("/saverooms")
	public String saveRooms(String[] roomname, int[] capacity, String[] remark, Long houseid, HttpSession session) {
		
		House house = (House)session.getAttribute("house");
		accommodationService.saveHouse(house);
		session.removeAttribute("house");
		accommodationService.saveRoomAndBead(house, roomname, remark, capacity);
		
		return "redirect:/accommodation";
	}

}
