package com.hrtek.user.statistic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/statistic")
public class StatisticController {
	
	@Autowired
	private StatisticService statisticService;
	

	@GetMapping
	public String toStatistic(Model  model) {
		List<CompanyStat> statlist = statisticService.getCompaniesStat();
		model.addAttribute("statlist", statlist);
		return "user/stat";
	}
}
