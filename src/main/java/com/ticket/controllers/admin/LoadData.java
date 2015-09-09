package com.ticket.controllers.admin;

import com.ticket.entity.SelfStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ticket.repositories.CustomRepository;
import com.ticket.services.StationService;

import java.util.Collection;

@Controller
@RequestMapping("load")
public class LoadData {

    @Autowired
    StationService stationService;


    @RequestMapping(value = "/stations", method = RequestMethod.GET)
    public String loadStations(ModelMap model) {
        long startTime = System.currentTimeMillis();
        boolean isLoaded = stationService.loadStations();
        long stopTimeInSec = (System.currentTimeMillis() - startTime) / 1000;
        model.addAttribute("isLoaded", isLoaded);
        model.addAttribute("timeInSec", stopTimeInSec);
        return "load-stations";
    }

    @RequestMapping(value = "/self_stations", method = RequestMethod.GET)
    public String test(ModelMap model) {
        Collection<SelfStation> commonStations = stationService.loadSelfStations();
        return "load-stations";
    }
}
