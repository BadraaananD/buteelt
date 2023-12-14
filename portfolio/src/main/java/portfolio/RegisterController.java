package portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	public RegisterController(RegisterService registerService) {
		super();
		this.registerService = registerService;
	}
	
	@GetMapping("/register")
	public String register() 
	{
		return "register";
	}
	
//	@PostMapping("/register/save")
//    public String processRegistration(@ModelAttribute Register user, 
//    		BindingResult result, Model m) {
//		Register existingUser = registerService.findByEmail(user.getEmail());
//		
//		if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
//			result.rejectValue("email",null, "Энэ имейл бүртгэгдсэн байна.");
//		}
//		if(result.hasErrors()) {
//			m.addAttribute("user", user);
//			return "register";
//		}
//	     
//		
//		this.registerService.addUser(user);
//        return "redirect:/";
//    }
	@PostMapping("/register")
	public String addUser(@ModelAttribute Register r) {
		this.registerService.addUser(r);
		return "redirect:/";
	}
	
}