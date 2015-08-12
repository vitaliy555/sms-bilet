package com.bilet.controllers;

import java.util.Collection;

import com.bilet.hunting.services.UpdateStationsService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;

import com.bilet.hunting.model.StationTitleVsId;


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
