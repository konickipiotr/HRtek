package com.hrtek.admin.tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;

	@GetMapping
	public String home(Model model) {
		model.addAttribute("tiket_list", ticketService.ticketRepo.findAll());
		return "admin/home";
	}
	
	@GetMapping("/ticket/delete/{id}")
	public String home(@PathVariable("id") Long id) {
		ticketService.ticketRepo.deleteById(id);
		return "redirect:/admin";
	}
	
	@GetMapping("/ticket/action/{event}/{id}")
	public String home(@PathVariable("id") Long id,
						@PathVariable("event") TicketType event,
						Model model) {
		
		String returnPath = "redirect:/admin";
		switch (event) {
		case PASSWORDFORGOTTEN:{
			returnPath = ticketService.newpassword(model, id);
		}break;

		default:
			break;
		}
		return returnPath;
	}
	
	@PostMapping("/ticket/changepassword")
	public String changePassword(@RequestParam("ticketid") Long ticketid,
									@RequestParam("userid") Long userid,
									@RequestParam("password") String password,
									Model model) {
		return ticketService.changePassword(model, userid, ticketid, password);
	}
}
