package com.ticket.services;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class BookingSearchTrainServiceTest {

    @Test
    public void testGetData() throws Exception {
        BookingSearchTrainService bookingSearchTrainService = new BookingSearchTrainService();
        bookingSearchTrainService.getData("2208001","2218000",new SimpleDateFormat("MM.dd.yyyy").format(new Date()));
    }
}