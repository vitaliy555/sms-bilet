package com.ticket.config.connector.cmd.custom_cmd;

import javax.ws.rs.core.Cookie;

import com.ticket.config.connector.cmd.AbstractJsonCommand;
import com.ticket.dto.StationListWithSameTopTwoChars;

public class AllTrainsByRouteCmd extends AbstractJsonCommand {
    private static final String TEMPLATE_URL_SEARCH_TRAINS_BY_ROUTE = "http://www.uz.gov.ua/passengers/timetables/?from_station=%s&to_station=%s";
    private static final String URL_SUFUX = "&select_time=2&time_from=00&time_to=24&by_route=%D0%9F%D0%BE%D1%88%D1%83%D0%BA";

    public AllTrainsByRouteCmd(final String from,final String to) {
        setResponseType(String.class);
        setMethod(Method.GET);
        setPath(buildUrl(from,to));
    }

    private String buildUrl(final String from,final String to){
        return String.format(TEMPLATE_URL_SEARCH_TRAINS_BY_ROUTE,from,to)+URL_SUFUX;
    }
}
