package com.example.sweater.controller;

import com.example.sweater.domen.Message;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageRepo messageRepo;

    @RequestMapping("/messages")
    public String showMessage(Model model){
        Iterable<Message> messages =  messageRepo.findAll();

        model.addAttribute("messages",messages);

        return "messages";
    }

    @RequestMapping
    public Iterable<Message> getList(){
        return messageRepo.findAll();
    }
}
