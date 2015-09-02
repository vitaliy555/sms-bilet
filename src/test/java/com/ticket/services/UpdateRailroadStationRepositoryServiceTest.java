package com.ticket.services;

import static org.junit.Assert.assertFalse;

import java.util.Collection;

import org.junit.Test;

import com.ticket.entity.Station;

public class UpdateRailroadStationRepositoryServiceTest {
    private RailroadStationService stationService = new RailroadStationService();

//    @Ignore
    @Test
    public void testUpdateRailroadStation() throws Exception {
        long startTime = System.currentTimeMillis();
        Collection<Station> railroadStations = stationService.updateByBookingStation();
        long stopTimeInSec = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("Summary time in sec = "+stopTimeInSec);
        assertFalse(railroadStations.isEmpty());
    }
}