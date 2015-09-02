package com.ticket.config.connector.cmd.custom_cmd;

import com.ticket.dto.StationListWithSameTopTwoChars;
import com.ticket.config.connector.cmd.AbstractJsonCommand;

public class StationsByBookingCommand extends AbstractJsonCommand {
    private static final String SEARCH_STATIONS_URL = "http://booking.uz.gov.ua/purchase/station/";

    /**
     * Instantiates a new Add product to cart.
     *
     */
    public StationsByBookingCommand(final String parameters) {
        setResponseType(StationListWithSameTopTwoChars.class);
        setMethod(Method.GET);
        setPath(SEARCH_STATIONS_URL+parameters+"/");
    }
}
