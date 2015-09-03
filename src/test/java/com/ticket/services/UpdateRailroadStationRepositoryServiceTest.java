package com.ticket.services;

import static org.junit.Assert.assertFalse;

import java.util.Collection;

import org.junit.Test;

import com.ticket.entity.BookingStation;

public class UpdateRailroadStationRepositoryServiceTest {
    private StationService stationService = new StationService();

//    @Ignore
    @Test
    public void testUpdateRailroadStation() throws Exception {
        long startTime = System.currentTimeMillis();
        Collection<BookingStation> railroadStations = stationService.loadBookingStations();
        long stopTimeInSec = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("Summary time in sec = "+stopTimeInSec);
        assertFalse(railroadStations.isEmpty());
    }
}