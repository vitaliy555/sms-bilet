package com.dudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/search")
public class SearchController {


    @RequestMapping(method = RequestMethod.POST)
    public String searchByFilter() {
        return "*.jsp";
    }
}
