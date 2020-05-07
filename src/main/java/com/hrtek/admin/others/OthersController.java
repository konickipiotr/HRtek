package com.hrtek.admin.others;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrtek.db.CitizenshipRepository;
import com.hrtek.db.DepartmentRepository;
import com.hrtek.db.UserPositonsRepository;
import com.hrtek.model.Citizenship;
import com.hrtek.model.Department;
import com.hrtek.model.UserPostions;

@Controller
@RequestMapping("/admin/others")
public class OthersController {
	
	private CitizenshipRepository citizenshipRepo;
	private DepartmentRepository departmentRepo;
	private UserPositonsRepository userPositionsRepo;
	
	@Autowired
	public OthersController(CitizenshipRepository citizenshipRepo, DepartmentRepository departmentRepo,
			UserPositonsRepository userPositionsRepo) {
		this.citizenshipRepo = citizenshipRepo;
		this.departmentRepo = departmentRepo;
		this.userPositionsRepo = userPositionsRepo;
	}

	
	@GetMapping
	public String other(Model model) {
		setModel(model);
		return "admin/others";
	}
	
	
	@PostMapping("/adddepartment")
	public String addDepartment(@RequestParam("department") String department, Model model) {
		
		String message = "";
		if(department== null || department.isBlank()) {
			message = "Nie można dodać pustego działu";
		}else if(departmentRepo.existsByDepartment(department)) {
			message = "Tak dział już istnieje";
		}else {
			departmentRepo.save(new Department(department));
		}
		setModel(model);
		model.addAttribute("department_msg", message);	
		return "admin/others";
	}
	
	
	@GetMapping("/removedepartment/{id}")
	public String removedepartment(@PathVariable("id") Long id, Model model) {
		departmentRepo.deleteById(id);
		//TODO // wyczycić dział u pracwoników
		model.addAttribute("department_msg", "Dział został usunięty");	
		return "admin/others";
	}
	
	
	@PostMapping("/addcitizenship")
	public String addCitizenship(@RequestParam("citizenship") String citizenship,  Model model) {

		String message = "";
		if(citizenship == null || citizenship.isBlank()) {
			message = "Nie można dodać obywatelstwa";
		}else if(citizenshipRepo.existsByName(citizenship)) {
			message = "Takie obywatelstwo już istnieje";
		}else {
			citizenshipRepo.save(new Citizenship(citizenship));
		}
		setModel(model);
		model.addAttribute("citiz_msg", message);	
		return "admin/others";
	}
	
	
	@GetMapping("/removecitizenship/{id}")
	public String removecitizenship(@PathVariable("id") Integer id, Model model) {
		citizenshipRepo.deleteById(id);
		//TODO // wyczycić narodowość u pracwoników
		model.addAttribute("citiz_msg", "obywatelstwo zostało usunięte");	
		return "admin/others";
	}
	
	
	@PostMapping("/addposition")
	public String addEmployeePostion(@RequestParam("userposition") String userposition, Model model) {

		String message = "";
		if(userposition == null || userposition.isBlank()) {
			message = "Nie można dodać stanowisko";
		}else if(userPositionsRepo.existsByPosition(userposition)) {
			message = "Takie stanowisko już istnieje";
		}else {
			userPositionsRepo.save(new UserPostions(userposition));
		}
		setModel(model);
		model.addAttribute("position_msg", message);	
		return "admin/others";
	}
	
	
	@GetMapping("/removeposition/{id}")
	public String removeemppos(@PathVariable("id") Integer id, Model model) {
		userPositionsRepo.deleteById(id);
		//TODO // wyczycić narodowość u pracwoników
		setModel(model);
		model.addAttribute("position_msg", "stanowisko zostało usunięte");	
		return "admin/others";
	}
	
	
	private void setModel(Model model) {
		List<UserPostions> emp_pos = userPositionsRepo.findAll();
		List<Department> dep_list = departmentRepo.findAll();
		List<Citizenship> citz_list = citizenshipRepo.findAll();
		
		for(int i = 0; i < emp_pos.size(); i++) {
			if(emp_pos.get(i).getPosition().equals("Admin") || emp_pos.get(i).getPosition().equals("Boss")) {
				emp_pos.remove(i);
				i--;
			}
		}
		
		model.addAttribute("emp_pos", emp_pos);
		model.addAttribute("dep_list", dep_list);
		model.addAttribute("citiz_list", citz_list);
		
	}
}
