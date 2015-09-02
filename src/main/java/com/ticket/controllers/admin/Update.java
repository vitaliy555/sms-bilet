package com.ticket.controllers.admin;

import java.util.Collection;

import javax.ws.rs.Consumes;

import com.ticket.entity.Train;
import com.ticket.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ticket.entity.Station;
import com.ticket.services.RailroadStationService;

@Controller
@RequestMapping("admin/update")
public class Update {

    @Autowired
    RailroadStationService railroadStationService;
    @Autowired
    TrainService trainService;

    @RequestMapping(value = "/stations", method = RequestMethod.GET)
    @Consumes("application/json")
    public String updateStations(ModelMap model) {
        long startTime = System.currentTimeMillis();
        Collection<Station> railroadStations = railroadStationService.updateByBookingStation();
        long stopTimeInSec = (System.currentTimeMillis() - startTime) / 1000;
        model.addAttribute("railroadStations", railroadStations);
        model.addAttribute("countStations", railroadStations.size());
        model.addAttribute("timeInSec", stopTimeInSec);
        return "update-railroad-rtation";
    }

    @RequestMapping(value = "/stationsUZ", method = RequestMethod.GET)
     @Consumes("application/json")
     public String updateStationsUZ(ModelMap model) {
        long startTime = System.currentTimeMillis();
        Collection<Station> railroadStations = railroadStationService.updateByUzStation();
        long stopTimeInSec = (System.currentTimeMillis() - startTime) / 1000;
        model.addAttribute("railroadStations", railroadStations);
        model.addAttribute("countStations", railroadStations.size());
        model.addAttribute("timeInSec", stopTimeInSec);
        return "update-railroad-rtation";
    }
}
