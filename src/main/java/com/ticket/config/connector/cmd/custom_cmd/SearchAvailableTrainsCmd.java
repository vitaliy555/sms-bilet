package com.ticket.config.connector.cmd.custom_cmd;

import com.ticket.config.connector.cmd.AbstractJsonCommand;
import com.ticket.config.connector.cmd.Command;

import java.util.Map;

public class SearchAvailableTrainsCmd extends AbstractJsonCommand {
    public static final String AVAILABE_TRAINS_SEARCH_URL= "http://booking.uz.gov.ua/en/purchase/search/";

    public SearchAvailableTrainsCmd(Map<String,Object> props) {
        setResponseType(String.class);
        setMethod(Method.POST);
        setPath(AVAILABE_TRAINS_SEARCH_URL);
        setProperties(props);
    }
}
