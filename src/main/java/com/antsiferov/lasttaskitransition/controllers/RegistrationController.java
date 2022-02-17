package com.antsiferov.lasttaskitransition.controllers;

import com.antsiferov.lasttaskitransition.entity.Users;
import com.antsiferov.lasttaskitransition.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        String encryptedPwd = passwordEncoder.encode(password);
        Users user = new Users(name, email, encryptedPwd);
        usersRepository.save(user);
        return "redirect:/home";
    }

}