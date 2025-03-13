package com.example.fotowettbewerb.controllers;

import com.example.fotowettbewerb.Users;
import com.example.fotowettbewerb.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.time.LocalDate;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private final UserService userservice;

    public RegistrationController(UserService userservice){
        this.userservice = userservice;
    }
    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping
    public String registerUser(@ModelAttribute Users user,Model model){
        try {
            user.setRegistrationDate(LocalDate.now()); // Registrierungsdatum setzen
            userservice.registerUser(user.getUsername(), user.getBirthday());
            System.out.println("Registrierung erfolgreich!");  // Debugging in der Konsole
            return "redirect:/"; // 🚀 Redirect zur Startseite mit Erfolgs-Parameter
        } catch (RuntimeException e) {
            model.addAttribute("message", "Registrierung fehlgeschlagen");
        }
        return "register";
    }
}
