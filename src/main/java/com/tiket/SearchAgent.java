package com.tiket;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/search")
public class SearchAgent {

    @RequestMapping(value = "/runAgent", method = RequestMethod.GET)
    public String runAgent(ModelMap model) {
        model.addAttribute("message", "Agent is runed");
        return "hello";
    }
}
//http://booking.uz.gov.ua/ru/purchase/station/%D0%B4%D0%BD/