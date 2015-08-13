package com.ticket.controllers;

import com.ticket.hunting.connector.TicketClient;
import com.ticket.hunting.rest.cmd.custom_cmd.StationsCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;

import com.ticket.hunting.model.StationTitleVsId;


@Controller
@RequestMapping("/update")
public class Update {

//    @Autowired
//    UpdateStationsService stationsService;


    @RequestMapping(value = "/stations",method = RequestMethod.GET)
    @Consumes("application/json")
    public String  getAllStations(ModelMap model) {
        try {
            Object result = new TicketClient().execute(new StationsCommand("ly"));
            model.addAttribute("message", result.toString());
        }catch (Throwable ex){
            String stackTrace = null;
            for (StackTraceElement stackTraceElement : ex.getStackTrace()) {
                stackTrace+=stackTraceElement.toString();
            }
            model.addAttribute("message",stackTrace );
        }
        return  "hello"; //"hello";
    }
// public @ResponseBody Collection<StationTitleVsId> getAllStations(ModelMap model) {
//        Collection<StationTitleVsId> result = Lists.newArrayList();
//        Response response = Response.status(201).entity(result).build();
//        return result;
//    }
}
