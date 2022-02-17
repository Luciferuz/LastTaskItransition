package com.antsiferov.lasttaskitransition.controllers;

import com.antsiferov.lasttaskitransition.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

//    @GetMapping("/users")
//    public String table_users(Model model) {
//        Iterable<Users> users = usersRepository.findAll();
//        model.addAttribute("users", users);
//        return "users";
//    }

}