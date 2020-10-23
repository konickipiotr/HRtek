package com.hrtek.user.accommodation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hrtek.model.accommodation.AddressForm;
import com.hrtek.model.accommodation.FinanceForm;
import com.hrtek.model.accommodation.LiderForm;

@Controller
@RequestMapping("/accdetail")
public class AccommDetailController {
	@Autowired
	private AccDetailService accDetailService;

	@GetMapping("/{id}")
	public String aDetails(@PathVariable("id") Long id, Model model,  RedirectAttributes ra) {
		if(!accDetailService.updateView(model, id)) {
			ra.addFlashAttribute("message", "Nie znaleziono domu");
			return "redirect:/accommodation";
		}
		return "user/accommodation/housedetail";
	}
	
	@PostMapping(params = "edit=reset")
	public String rest(@RequestParam("id") Long id) {
		return "redirect:/accdetail/" + id;
	}
	
	@PostMapping(params = "edit=address")
	public String editAddres(AddressForm af) {
		accDetailService.updateAddress(af);
		return "redirect:/accdetail/" + af.getId();
	}
	
	@PostMapping(params = "edit=finance")
	public String editFinance(FinanceForm ff) {
		accDetailService.updateFinance(ff);
		return "redirect:/accdetail/" + ff.getId();
	}
	
	@PostMapping(params = "edit=lider")
	public String editLider(LiderForm lf) {
		accDetailService.saveLider(lf);
		return "redirect:/accdetail/" + lf.getId();
	}
	
	@PostMapping(params = "edit=remark")
	public String editLider(@RequestParam("id") Long id, @RequestParam("remark") String remark) {
		accDetailService.updateRemark(id, remark);
		return "redirect:/accdetail/" + id;
	}
	
	

}
