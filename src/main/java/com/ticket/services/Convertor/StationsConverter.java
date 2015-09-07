package com.ticket.services.Convertor;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.ticket.entity.UZStation;

public class StationsConverter {

    public static final String REG_STATION = "\"[]";
    public static final String DELIMITER_TITLE_ID = "~";

    public static Collection<UZStation> convertToUzStations(String stations) {
        Collection<UZStation> uzStations = Lists.newArrayList();
        for (String station : obtainStations(stations)) {
            String[] titleAndId = station.split(DELIMITER_TITLE_ID);
            try {
                uzStations.add(new UZStation(titleAndId[0], titleAndId[1]));
            } catch (Exception e) {
                System.out.println(titleAndId);
            }
        }
        return uzStations;
    }

    private static Collection<String> obtainStations(String stations) {
        Set<String> obtained = new TreeSet();
        obtained.addAll(Splitter.on(CharMatcher.anyOf(REG_STATION)).trimResults().splitToList(stations));
        obtained.remove(",");
        obtained.remove("");
        return obtained;
    }
}
