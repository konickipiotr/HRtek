package com.hrtek.user.tikets;

import java.security.Principal;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.hrtek.admin.tickets.TicketType;
import com.hrtek.db.TicketRepository;
import com.hrtek.db.UserRepository;
import com.hrtek.model.Ticket;
import com.hrtek.model.User;
import com.hrtek.model.UserInfo;

@Controller
@RequestMapping("/tickets")
public class UserTiketsController {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private TicketRepository ticketRepo;
	
	@GetMapping
	public String toTickets(Model model) {
		setTicketType(model);
		return "user/tickets";
	}
	
	@PostMapping
	public String sendTicket(Ticket ticket, Model model, Principal principal) {
		User user = userRepo.findByUsername(principal.getName());
		System.out.println(ticket);
		ticket.setLogin(user.getUsername());
		ticket.setUserId(user.getId());
		System.out.println(ticket);
		this.ticketRepo.save(ticket);
		setTicketType(model);
		return "user/tickets";
	}
	
	private void setTicketType(Model model) {
		TicketType[] allvalues = TicketType.values();
		TicketType[] values = new TicketType[allvalues.length-1];
		for(int i = 0, j = 0; i < allvalues.length; i++, j++) {
			if(allvalues[i].equals(TicketType.PASSWORDFORGOTTEN)) {
				j--;
				continue;
			}
			values[j] = allvalues[i];
		}
	
		for(TicketType t : values)
			System.out.println(t);
		
		Map<String, String>  info = new TreeMap<>();
		info.put(TicketType.APPLICATION_ERROR.name(), "Aplikacja przestała działać w którymś momencie? Opisz szczegółowo co się stało i w jakiej sytuacji.");
		info.put(TicketType.WORKING_INCORRECT.name(), "Zauważyłeś błąd w działaniu programu? Jakieś dane są błędne, nie w tym miejscu? W ogóle ich nie ma. Opisz szczegółowo problem i w jakiej sytuacji występuje");
		info.put(TicketType.NEEDED_NEW_VALUE.name(), "Potrzebujesz nowych wartości takich jak np. nowy dział, nową narodowość? Napisz czego potrzebujesz");
		info.put(TicketType.SUGESSTION.name(), "Masz jakieś sugestje co do uleprzenia programu? Coś może usprawnić twoją pracę, aby była wygodniejsza i szybsza? Jakaś funkcjonalnośc jest potrzeba? Opisz sugestje w formularzu");
		
		ObjectMapper mapper = new ObjectMapper();
		String sinfo;
		try {
			sinfo = mapper.writeValueAsString(info);
			model.addAttribute("sinfo", sinfo);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("info", info);
		
		model.addAttribute("values", values);
	}

}
