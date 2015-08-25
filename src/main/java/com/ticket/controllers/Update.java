package com.ticket.controllers;

import java.util.Collection;

import javax.ws.rs.Consumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ticket.entity.RailroadStation;
import com.ticket.services.RailroadStationService;

@Controller
@RequestMapping("/update")
public class Update {

    @Autowired
    RailroadStationService railroadStationService;

    @RequestMapping(value = "/stations", method = RequestMethod.GET)
    @Consumes("application/json")
    public String getAllStations(ModelMap model) {
        long startTime = System.currentTimeMillis();
        Collection<RailroadStation> railroadStations = railroadStationService.updateRailroadStation();
        long stopTimeInSec = (System.currentTimeMillis() - startTime) / 1000;
        model.addAttribute("railroadStations", railroadStations);
        model.addAttribute("countStations", railroadStations.size());
        model.addAttribute("timeInSec", stopTimeInSec);
        return "update-railroad-rtation";
    }
}
