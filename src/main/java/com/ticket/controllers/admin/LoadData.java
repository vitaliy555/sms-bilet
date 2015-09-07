package com.ticket.controllers.admin;

import java.util.Collection;

import javax.ws.rs.Consumes;

import com.ticket.entity.UZStation;
import com.ticket.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ticket.entity.BookingStation;
import com.ticket.services.StationService;

@Controller
@RequestMapping("load/st")
public class LoadData {

    @Autowired
    StationService stationService;
    @Autowired
    TrainService trainService;

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    @Consumes("application/json")
    public String updateStations(ModelMap model) {
        long startTime = System.currentTimeMillis();
        Collection<BookingStation> railroadStations = stationService.loadBookingStations();
        long stopTimeInSec = (System.currentTimeMillis() - startTime) / 1000;
        model.addAttribute("stations", railroadStations);
        model.addAttribute("countStations", railroadStations.size());
        model.addAttribute("timeInSec", stopTimeInSec);
        return "load-stations";
    }

    @RequestMapping(value = "/uz", method = RequestMethod.GET)
     @Consumes("application/json")
     public String updateStationsUZ(ModelMap model) {
        long startTime = System.currentTimeMillis();
        Collection<UZStation> railroadStations = stationService.loadUZStations();
        long stopTimeInSec = (System.currentTimeMillis() - startTime) / 1000;
        model.addAttribute("railroadStations", railroadStations);
        model.addAttribute("countStations", railroadStations.size());
        model.addAttribute("timeInSec", stopTimeInSec);
        return "load-stations";
    }
}
