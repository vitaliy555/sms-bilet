package com.bilet;

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
