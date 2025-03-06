package com.example.fotowettbewerb.controllers;

//import ch.qos.logback.core.model.Model;                                    achtungAutoImport
import com.example.fotowettbewerb.Users;
import com.example.fotowettbewerb.repositories.UsersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class UsersController {

    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @GetMapping("/users")
    public String listUser(Model model) {
        List<Users> users = usersRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }
}
