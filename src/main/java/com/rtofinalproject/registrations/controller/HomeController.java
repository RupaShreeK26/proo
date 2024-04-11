package com.rtofinalproject.registrations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.rtofinalproject.registrations.model.AdminRegisterModel;
import com.rtofinalproject.registrations.model.UserRegisterModel;
import com.rtofinalproject.registrations.repositories.AdminRepository;
import com.rtofinalproject.registrations.repositories.UserRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
public class HomeController {

	@Autowired
private UserRepository userRepo;
	@Autowired
	private AdminRepository adminRepo;

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/adminRegister")
    public String adminRegistrationPage(Model model) {
    	System.out.println("insiddfyghj");
    	AdminRegisterModel adminModel = new AdminRegisterModel();
    	model.addAttribute("adminModel", adminModel);
        return "adminRegister";
    }
    
    @PostMapping("/adminRegister")
    public String saveAdmins(AdminRegisterModel adminRegisterModel) {
    	System.out.println(adminRegisterModel);
    	adminRepo.save(adminRegisterModel);
    	return "redirect:/adminLog";
    }

    @GetMapping("/adminLogin")
    public String adminLoginPage() {
        return "adminLogin";
    }

    @GetMapping("/userRegister")
    public String userRegistrationPage(Model model) {
       UserRegisterModel userModel = new UserRegisterModel();
        model.addAttribute("userModel", userModel);
        return "userRegister";
    }

   
    @PostMapping("/userLogin")
    public String saveUsers(UserRegisterModel userModel) {
    	System.out.println(userModel);
        userRepo.save(userModel);
        return "redirect:/userLog";
    }


	/*
	 * @GetMapping("/userLogin") public String userlogin() { return "userLogin"; }
	 */
}








