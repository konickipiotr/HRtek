package com.hrtek.password;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrtek.admin.tickets.TicketType;
import com.hrtek.db.TicketRepository;
import com.hrtek.db.UserRepository;
import com.hrtek.model.Ticket;
import com.hrtek.model.User;

@Controller
@RequestMapping("/forgotpass")
public class ForgotPasswordController {
	
	private UserRepository userRepo;
	private TicketRepository ticketRepo;

	public ForgotPasswordController(UserRepository userRepo, TicketRepository ticketRepo) {
		this.userRepo = userRepo;
		this.ticketRepo = ticketRepo;
	}

	@GetMapping
	public String forgotPassword() {
		return "forgotpassword";
	}
	
	@PostMapping
	public String sendTicket(@RequestParam("login") String login, Model model) {
		
		User user = userRepo.findByUsername(login);
		if(user == null) {
			model.addAttribute("error_msg", "taki login nie istnieje");
			return "forgotpassword";
		}
		
		Ticket ticket = new Ticket();
		ticket.setEvent(TicketType.PASSWORDFORGOTTEN);
		ticket.setLogin(user.getUsername());
		ticket.setUserId(user.getId());
		this.ticketRepo.save(ticket);
		model.addAttribute("success_msg", "Wysłano ticket o nowe hasło");
		return "login";
	}
	
}
