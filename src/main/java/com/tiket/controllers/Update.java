package com.tiket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;

import com.tiket.hunting.model.StationTitleVsId;


@Controller
@RequestMapping("/update")
public class Update {

//    @Autowired
//    UpdateStationsService stationsService;


    @RequestMapping(value = "/stations",method = RequestMethod.GET)
    @Consumes("application/json")
    public Response  getAllStations(ModelMap model) {
        StationTitleVsId vsId = new StationTitleVsId();
        vsId.setId("1");
        vsId.setTitle("first");


        return  Response.status(200).entity(vsId).build(); //"hello";
    }
// public @ResponseBody Collection<StationTitleVsId> getAllStations(ModelMap model) {
//        Collection<StationTitleVsId> result = Lists.newArrayList();
//        Response response = Response.status(201).entity(result).build();
//        return result;
//    }
}
