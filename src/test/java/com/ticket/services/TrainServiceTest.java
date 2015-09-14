package com.ticket.services;

import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class TrainServiceTest {

    @Test
    public void testGetTrainsByRoute() throws Exception {
TrainService trainService = new TrainService();
        Collection trainsByRoute = trainService.getTrainsByRoute("22720", "22300");
    }

    @Test
    public void testGetAvailableTrainsByRoute() throws Exception {

    }
}