package app.controllers;

import app.models.Officer;
import app.services.OfficerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeAndLoginController {

    private final OfficerService officerService;

    public HomeAndLoginController(OfficerService officerService) {
        this.officerService = officerService;
    }

    @GetMapping(value = {"/", "/home", "/fooldal"})
    public String getHomePage() {
        return "index";
    }

    @GetMapping(value = {"/login", "/bejelentkezes"})
    public String getLoginPage() {
        return "login";
    }

    @GetMapping(value = {"/login-error"})
    public String loginErrorPage(Model model) {
        model.addAttribute("loginError", true);

        return "login";
    }

    @GetMapping(value = {"/register"})
    public String getRegister(Model model) {

        Officer officer = new Officer();

        model.addAttribute("officer", officer);

        return "register";
    }

    @PostMapping(value = {"/register"})
    public String register(Officer officer, Model model) {

        if(officerService.saveOfficer(officer))
        {
            return "redirect:/login";
        } else {
            model.addAttribute("fail","Sikertelen regisztráció! Foglalt felhasználónév!");
            return "register";
        }
    }

}
