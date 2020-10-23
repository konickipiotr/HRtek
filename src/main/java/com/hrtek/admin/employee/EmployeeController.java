package com.hrtek.admin.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hrtek.model.UserInfo;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/admin/employees")
	public String employees(Model model) {
		model.addAttribute("employeeList",employeeService.getEmployeeViewList());
		return "admin/employees";
	}
	
	@GetMapping("/admin/employees/edit/{id}")
	public String editEmployee(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes ) {
		EmployeeView emp = employeeService.getEmployee(id);
		if(emp == null) {
			return "redirect:/admin/employees";
		}
		model.addAttribute("emp",emp);
		model.addAttribute("edit","E");
		model.addAttribute("employeeList",employeeService.getEmployeeViewList());
		model.addAttribute("positons_list", employeeService.getEmployeePositions(id));
		return "admin/employees";
	}
	
	@GetMapping("/admin/employees/delete/{id}")
	public String deleteEmployee(@PathVariable("id") Long id, Model model, HttpSession session) {
		UserInfo ui = (UserInfo) session.getAttribute("user");
		employeeService.deleteEmployeeById(id, ui);
		return "redirect:/admin/employees";
	}
	
	@PostMapping("admin/employees/modify")
	public String modifyEmployee(UserInfo employee, HttpSession session) {
		UserInfo ui = (UserInfo) session.getAttribute("user");
		employeeService.updateUser(employee, ui);
		return "redirect:/admin/employees";
	}
}
