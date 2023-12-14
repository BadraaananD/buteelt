package portfolio;


import java.util.Collection;

import javax.persistence.OrderBy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PortfolioController {
	@Autowired	
	private PortfolioService portfolioService;
	
	public PortfolioController(PortfolioService portfolioService){
		super();
		this.portfolioService = portfolioService;
	}
	
	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/index")
	public String index(Model m) {
		Collection<Portfolio> portfolios = this.portfolioService.getPortfolios();
		m.addAttribute("portfolios", portfolios);
		return "index";
	}
	
	@GetMapping("/add-form")
	public String addForm() {
		return "add_form";
	}
	
	@PostMapping("/add-form")
	public String addPortfolio(@ModelAttribute Portfolio p) {
		this.portfolioService.addPortfolio(p);
		return "redirect:/index";
	}
	
	@GetMapping("/portfolios")
	public String getPortfolios() {
		this.portfolioService.getPortfolios();
		return "index";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePortfolio(@PathVariable Long id) {
		this.portfolioService.deletePortfolio(id);
		return "redirect:/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editPortfolio(@PathVariable Long id, Model model) {
		Portfolio editPortfolio = this.portfolioService.getPortfolio(id);
		model.addAttribute("por", editPortfolio);
		return "edit";
	}
	
	@PostMapping("/edit/")
	public String updatePortfolio(@ModelAttribute("por") Portfolio por) {
		this.portfolioService.updatePortfolio(por);
		return "redirect:/index";
	}
	
	@GetMapping("/portfolio/{id}")
	public String viewPortfolio(@PathVariable Long id, Model model) {
		Portfolio viewPortfolio = this.portfolioService.getPortfolio(id);
		model.addAttribute("por", viewPortfolio);
		return "view";
	}
}
	




//@PostMapping("/register/save")
//public String processRegistration(@ModelAttribute Register user, 
//		BindingResult result, Model m) {
//	Register existingUser = registerService.findByEmail(user.getEmail());
//	
//	if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
//		result.rejectValue("email",null, "Энэ имейл бүртгэгдсэн байна.");
//	}
//	if(result.hasErrors()) {
//		m.addAttribute("user", user);
//		return "register";
//	}
//     
//	
//	this.registerService.addUser(user);
//    return "redirect:/";
//}

