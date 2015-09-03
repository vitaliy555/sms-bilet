package com.ticket.config.connector.cmd.custom_cmd;

import com.ticket.dto.StationListWithSameTopTwoChars;
import com.ticket.config.connector.cmd.AbstractJsonCommand;

import javax.ws.rs.core.Cookie;

public class SearchBookingStationsCmd extends AbstractJsonCommand {
    private static final String SEARCH_STATIONS_URL = "http://booking.uz.gov.ua/purchase/station/";
    // for geting info on Ukraine lang
    private static final Cookie cookie = new Cookie("_gv_lang","ua");
    /**
     * Instantiates a new Add product to cart.
     *
     */
    public SearchBookingStationsCmd(final String parameters) {
        setResponseType(StationListWithSameTopTwoChars.class);
        setCookie(cookie);
        setMethod(Method.GET);
        setPath(SEARCH_STATIONS_URL+parameters+"/");
    }
}
