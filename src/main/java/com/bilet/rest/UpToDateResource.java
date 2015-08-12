package com.bilet.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by CHVE on 8/12/2015.
 */

@Path("message")
public class UpToDateResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getStations(){
        return null;
    }
}
