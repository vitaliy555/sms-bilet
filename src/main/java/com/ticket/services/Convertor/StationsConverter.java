package com.ticket.services.Convertor;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.ticket.dto.StationListWithSameTopTwoChars;
import com.ticket.entity.BookingStation;
import com.ticket.entity.UZStation;

public class StationsConverter {

    public static final String STATION_SEPARATOR = "\",";
    public static final String RESULT_TRIMMER = "[ \"";
    public static final String DELIMITER_TITLE_ID = "~";
    public static final String STATION_COUNTRY_SEPARATOR = "\\(";


    public static Collection<UZStation> convertToUzStations(String stations) {
        Collection<UZStation> uzStations = Lists.newArrayList();
        for (String station : obtainStations(stations)) {
            final String[] titleAndId = station.split(DELIMITER_TITLE_ID);
            final String titleWithCountry = titleAndId[0];
            String title = titleWithCountry.split(STATION_COUNTRY_SEPARATOR)[0].trim();
            uzStations.add(new UZStation(titleAndId[1],title ));
        }
        return uzStations;
    }

    private static Collection<String> obtainStations(String stations) {
        Set<String> obtained = new TreeSet();
        obtained.addAll(Splitter.on(STATION_SEPARATOR).trimResults(CharMatcher.anyOf(RESULT_TRIMMER))
                .splitToList(stations));
        return obtained;
    }

    public static Collection<BookingStation> convertToBookingStation(
            final StationListWithSameTopTwoChars stationsStartWithSameChar) {
        final Collection<BookingStation> stations = Lists.newArrayList();
        for (StationListWithSameTopTwoChars.StationNameAndID stationNameAndID : stationsStartWithSameChar.getValue()) {
            stations.add(new BookingStation( stationNameAndID.getStation_id(),stationNameAndID.getTitle()));
        }
        return stations;
    }
}
