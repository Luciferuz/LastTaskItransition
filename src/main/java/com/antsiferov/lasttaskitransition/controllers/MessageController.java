package com.antsiferov.lasttaskitransition.controllers;

import com.antsiferov.lasttaskitransition.entity.Message;
import com.antsiferov.lasttaskitransition.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping("/save")
    public String saveNewMessage(@RequestParam String subject, @RequestParam String text, @RequestParam String recipient, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String sender = auth.getName();
        Message message = new Message(subject, text, sender, recipient);
        messageRepository.save(message);
        return "redirect:/lk";
    }

}