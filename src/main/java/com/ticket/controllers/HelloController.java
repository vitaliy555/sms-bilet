package com.ticket.controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {


    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(ModelMap model) {
        model.addAttribute("message", "HELLO");
        return "hello";
    }

}