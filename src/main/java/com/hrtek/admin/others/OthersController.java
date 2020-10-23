package com.hrtek.admin.others;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

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
import com.hrtek.db.LogRepository;
import com.hrtek.db.UserInfoRepository;
import com.hrtek.db.UserPositonsRepository;
import com.hrtek.db.worker.WorkerBasicRepository;
import com.hrtek.enums.LogType;
import com.hrtek.model.Citizenship;
import com.hrtek.model.Department;
import com.hrtek.model.Log;
import com.hrtek.model.UserInfo;
import com.hrtek.model.UserPostions;
import com.hrtek.settings.Msg;

@Controller
@RequestMapping("/admin/others")
public class OthersController {
	
	private CitizenshipRepository citizenshipRepo;
	private DepartmentRepository departmentRepo;
	private UserPositonsRepository userPositionsRepo;
	
	private WorkerBasicRepository workerBasicRepo;
	private UserInfoRepository userinfoRepo;
	private LogRepository logRepo;

	@Autowired
	public OthersController(CitizenshipRepository citizenshipRepo, DepartmentRepository departmentRepo,
			UserPositonsRepository userPositionsRepo, WorkerBasicRepository workerBasicRepo,
			UserInfoRepository userinfoRepo, LogRepository logRepo) {
		this.citizenshipRepo = citizenshipRepo;
		this.departmentRepo = departmentRepo;
		this.userPositionsRepo = userPositionsRepo;
		this.workerBasicRepo = workerBasicRepo;
		this.userinfoRepo = userinfoRepo;
		this.logRepo = logRepo;
	}


	@GetMapping
	public String other(Model model) {
		setModel(model);
		return "admin/others";
	}
	
	
	@PostMapping("/adddepartment")
	public String addDepartment(@RequestParam("department") String department, Model model, HttpSession session) {
		
		String message = "";
		if(department== null || department.isBlank()) {
			message = "Nie można dodać pustego działu";
		}else if(departmentRepo.existsByDepartment(department)) {
			message = "Tak dział już istnieje";
		}else {
			departmentRepo.save(new Department(department));
			UserInfo ui = (UserInfo) session.getAttribute("user");
			this.logRepo.save(new Log(ui.getName(), Msg.newDepartment + department , LogType.CREATE));
			
		}
		setModel(model);
		model.addAttribute("department_msg", message);	
		return "admin/others";
	}
	
	
	@GetMapping("/removedepartment/{id}")
	public String removedepartment(@PathVariable("id") Long id, Model model, HttpSession session) {
		
		if(workerBasicRepo.findByDepartment(id).size() == 0) {
			Optional<Department> oDepo = departmentRepo.findById(id);
			if(oDepo.isPresent()) {
				departmentRepo.deleteById(id);
				model.addAttribute("department_msg", "Dział został usunięty");
				UserInfo ui = (UserInfo) session.getAttribute("user");
				this.logRepo.save(new Log(ui.getName(), Msg.removeDepartment + oDepo.get().getDepartment() , LogType.DELETE));
			}
		}else {
			model.addAttribute("department_msg", "Nie można usunąć działu dopóki przynajmniej 1 pracownik jest do niego przypisany");
		}
		setModel(model);
		return "admin/others";
	}
	
	
	@PostMapping("/addcitizenship")
	public String addCitizenship(@RequestParam("citizenship") String citizenship,  Model model, HttpSession session) {

		String message = "";
		if(citizenship == null || citizenship.isBlank()) {
			message = "Nie można dodać obywatelstwa";
		}else if(citizenshipRepo.existsByName(citizenship)) {
			message = "Takie obywatelstwo już istnieje";
		}else {
			citizenshipRepo.save(new Citizenship(citizenship));
			UserInfo ui = (UserInfo) session.getAttribute("user");
			this.logRepo.save(new Log(ui.getName(), Msg.newCitizenship + citizenship, LogType.CREATE));
		}
		setModel(model);
		model.addAttribute("citiz_msg", message);	
		return "admin/others";
	}
	
	
	@GetMapping("/removecitizenship/{id}")
	public String removecitizenship(@PathVariable("id") Integer id, Model model, HttpSession session) {
		if(workerBasicRepo.findByCitizenship(id).size() == 0) {
			Optional<Citizenship> oCitiz = citizenshipRepo.findById(id);
			if(oCitiz.isPresent()) {
				citizenshipRepo.deleteById(id);
				model.addAttribute("citiz_msg", "obywatelstwo zostało usunięte");
				UserInfo ui = (UserInfo) session.getAttribute("user");
				this.logRepo.save(new Log(ui.getName(), Msg.removeCitizenship + oCitiz.get().getName(), LogType.DELETE));	
			}
		}
		else {
			model.addAttribute("citiz_msg", "Nie można usunąć obywatelstwa dopóki przynajmniej 1 pracownik jest do niego przypisany");
		}
		setModel(model);
		return "admin/others";
	}
	
	
	@PostMapping("/addposition")
	public String addEmployeePostion(@RequestParam("userposition") String userposition, Model model, HttpSession session) {

		String message = "";
		if(userposition == null || userposition.isBlank()) {
			message = "Nie można dodać stanowisko";
		}else if(userPositionsRepo.existsByPosition(userposition)) {
			message = "Takie stanowisko już istnieje";
		}else {
			userPositionsRepo.save(new UserPostions(userposition));
			UserInfo ui = (UserInfo) session.getAttribute("user");
			this.logRepo.save(new Log(ui.getName(), Msg.newPosition + userposition, LogType.CREATE));
		}
		setModel(model);
		model.addAttribute("position_msg", message);	
		return "admin/others";
	}
	
	
	@GetMapping("/removeposition/{id}")
	public String removeemppos(@PathVariable("id") Integer id, Model model, HttpSession session) {
		if(userinfoRepo.findByPosition(id).size() == 0) {
			Optional<UserPostions> oPos = userPositionsRepo.findById(id);
			if(oPos.isPresent()) {
				userPositionsRepo.deleteById(id);
				model.addAttribute("position_msg", "stanowisko zostało usunięte");
				UserInfo ui = (UserInfo) session.getAttribute("user");
				this.logRepo.save(new Log(ui.getName(), Msg.removePosition + oPos.get().getPosition(), LogType.DELETE));	
			}
		}
		else {
			model.addAttribute("position_msg", "Nie można usunąć stanowiska dopóki przynajmniej 1 pracownik jest do niego przypisany");
		}
			
		setModel(model);
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
