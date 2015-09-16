package com.ticket.parsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TrainParser {
    public static final String TRAINS_SELECTOR ="#cpn-timetable > table > tbody > tr";

    public static Elements parsTrainsByRoute(final Document fullHtml) throws IOException {
        return fullHtml.select(TRAINS_SELECTOR);
    }
    public static void parsAvailableTrainsByRoute(){

    }
}
