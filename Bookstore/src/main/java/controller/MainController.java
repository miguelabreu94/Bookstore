package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("")
    public String viewHomePage(){
        System.out.println("home");
        return "index";
    }
    @GetMapping("/admin/login")
    public String viewAdminLoginPage(){
        System.out.println("admin");
        return "admin/admin_login";
    }

    @GetMapping("/user/login")
    public String viewUserLoginPage(){
        System.out.println("user");
        return "user/user_login";
    }

    @GetMapping("/user/registration")
    public String viewUserRegistrationPage(){
        System.out.println("user register");
        return "user/user_registration";
    }



}
