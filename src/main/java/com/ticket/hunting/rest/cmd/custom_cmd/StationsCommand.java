package com.ticket.hunting.rest.cmd.custom_cmd;

import com.ticket.hunting.dto.Stations;
import com.ticket.hunting.rest.cmd.AbstractJsonCommand;

public class StationsCommand extends AbstractJsonCommand {
    private static final String SEARCH_STATIONS_URL = "http://booking.uz.gov.ua/ru/purchase/station/";

    /**
     * Instantiates a new Add product to cart.
     *
     */
    public StationsCommand(final String parameters) {
        setResponseType(Stations.class);
        setMethod(Method.GET);
        setPath(SEARCH_STATIONS_URL+parameters+"/");
    }
}
