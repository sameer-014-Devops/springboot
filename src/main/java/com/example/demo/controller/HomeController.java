package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    
    private final MessageService messageService;
    
    @Autowired
    public HomeController(MessageService messageService) {
        this.messageService = messageService;
    }
    
    @GetMapping("/")
    public String home(Model model) {
        Message message = messageService.getWelcomeMessage();
        model.addAttribute("message", message.getContent());
        return "index";
    }
}
