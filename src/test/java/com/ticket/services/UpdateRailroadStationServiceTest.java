package com.ticket.services;

import static org.junit.Assert.assertFalse;

import java.util.Collection;

import org.junit.Ignore;
import org.junit.Test;

import com.ticket.model.RailroadStation;

public class UpdateRailroadStationServiceTest {
    private UpdateRailroadStationService stationService = new UpdateRailroadStationService();

//    @Ignore
    @Test
    public void testUpdateRailroadStation() throws Exception {
        long startTime = System.currentTimeMillis();
        Collection<RailroadStation> railroadStations = stationService.updateRailroadStation();
        long stopTimeInSec = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("Summary time in sec = "+stopTimeInSec);
        assertFalse(railroadStations.isEmpty());
    }
}