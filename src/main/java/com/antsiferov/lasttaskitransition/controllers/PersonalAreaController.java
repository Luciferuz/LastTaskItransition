package com.antsiferov.lasttaskitransition.controllers;

import com.antsiferov.lasttaskitransition.entity.Message;
import com.antsiferov.lasttaskitransition.entity.Users;
import com.antsiferov.lasttaskitransition.repository.MessageRepository;
import com.antsiferov.lasttaskitransition.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonalAreaController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/lk")
    public String lk(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String recipient = auth.getName();
        Iterable<Message> messages = messageRepository.findAllByRecipient(recipient);
        model.addAttribute("messages", messages);
        return "lk";
    }

    @GetMapping("/new")
    public String write(Model model) {
        Iterable<Users> recipients = usersRepository.findAll();
        model.addAttribute("recipients", recipients);
        return "new_message";
    }

}