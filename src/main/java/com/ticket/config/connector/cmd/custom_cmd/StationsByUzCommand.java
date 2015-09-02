package com.ticket.config.connector.cmd.custom_cmd;

import com.sun.jersey.api.client.GenericType;
import com.ticket.config.connector.cmd.AbstractJsonCommand;
import com.ticket.config.connector.cmd.Command;
import com.ticket.dto.StationListWithSameTopTwoChars;

public class StationsByUzCommand extends AbstractJsonCommand {
    private static final String SEARCH_STATIONS_URL = "http://www.uz.gov.ua/passengers/timetables/suggest-station/?q=";

    /**
     * Instantiates a new Add product to cart.
     *
     */
    public StationsByUzCommand() {
//        .get(GenericType.getClass(String.class))
        setResponseType(String.class);
        setMethod(Method.GET);
        setPath(SEARCH_STATIONS_URL);
    }
}
