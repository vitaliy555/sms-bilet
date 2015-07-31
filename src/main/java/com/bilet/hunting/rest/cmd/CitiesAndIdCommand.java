package com.bilet.hunting.rest.cmd;

public class CitiesAndIdCommand extends AbstractJsonCommand {
    private static final String SEARCH_CITIES_AND_ID_URL = "http://booking.uz.gov.ua/ru/purchase/station/";

    /**
     * Instantiates a new Add product to cart.
     *
     */
    public CitiesAndIdCommand(final String parameters) {
        setMethod(Method.GET);
        setPath(SEARCH_CITIES_AND_ID_URL+parameters+"/");
    }
}
