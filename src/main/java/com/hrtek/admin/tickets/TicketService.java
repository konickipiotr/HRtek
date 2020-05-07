package com.hrtek.admin.tickets;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hrtek.db.TicketRepository;
import com.hrtek.db.UserInfoRepository;
import com.hrtek.db.UserRepository;
import com.hrtek.enums.UserStatus;
import com.hrtek.model.Ticket;
import com.hrtek.model.User;
import com.hrtek.model.UserInfo;

@Service
public class TicketService {
	
	public TicketRepository ticketRepo;
	private UserRepository userRepo;
	private UserInfoRepository userInfoRepo;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public TicketService(TicketRepository ticketRepo, UserRepository userRepo, UserInfoRepository userInfoRepo,
			PasswordEncoder passwordEncoder) {
		this.ticketRepo = ticketRepo;
		this.userRepo = userRepo;
		this.userInfoRepo = userInfoRepo;
		this.passwordEncoder = passwordEncoder;
	}

	public String newpassword(Model model, Long id) {
		
		Optional<Ticket> oTicket = ticketRepo.findById(id);
		if(oTicket.isEmpty()) {
			return "redirect:/admin";
		}
		Ticket ticket = oTicket.get();
		
		User user = userRepo.findById(ticket.getUserId()).get();
		UserInfo userInfo = userInfoRepo.findById(ticket.getUserId()).get();
		
		model.addAttribute("login", user.getUsername());
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("ticketid", id);
		return "admin/tickets/newpassword";
	}
	
	public String changePassword(Model model, Long userid, Long ticketid, String password) {
		User user = userRepo.findById(userid).get();
		UserInfo userInfo = userInfoRepo.findById(userid).get();
		Ticket ticket = ticketRepo.findById(ticketid).get();
		
		user.setPassword(passwordEncoder.encode(password));
		user.setStatus(UserStatus.FIRSTLOGIN);
		this.userRepo.save(user);
		
		this.ticketRepo.delete(ticket);
		
		model.addAttribute("passowrd", password);
		model.addAttribute("login", user.getUsername());
		model.addAttribute("name", userInfo.getName());
		return "admin/tickets/newpasswordsummary";
	}
}
