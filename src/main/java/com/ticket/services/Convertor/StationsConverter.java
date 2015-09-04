package com.ticket.services.Convertor;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.ticket.entity.UZStation;
import com.ticket.utils.SmsTicketConstants;

public class StationsConverter {

    public Collection<UZStation> convertToUzStations(String stationsToConvert) {
        Set<String> stations = new TreeSet();
        stations.addAll(Splitter.on(CharMatcher.anyOf(SmsTicketConstants.REG_STATION)).trimResults().splitToList(stationsToConvert));
        stations.remove(",");
        String[] title_id = new String[2];
        for (String station : stations) {
            title_id= station.split(REG_TITLE_ID);
            new UZStation(title_id)
        }
        return ;
    }
}
