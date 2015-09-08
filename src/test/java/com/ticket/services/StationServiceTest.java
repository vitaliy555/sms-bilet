package com.ticket.services;

import com.ticket.config.DBConfig;
import com.ticket.config.MvcConfig;
import com.ticket.config.connector.TicketClient;
import com.ticket.config.connector.cmd.custom_cmd.SearchBookingStationsCmd;
import com.ticket.dto.StationListWithSameTopTwoChars;
import com.ticket.repositories.BookingStationsRepository;
import com.ticket.repositories.UZStationsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from AppConfig and TestConfig
@ContextConfiguration(classes={MvcConfig.class, DBConfig.class})
public class StationServiceTest {

    @Autowired
    BookingStationsRepository bookingStationsRepository;
    @Autowired
    UZStationsRepository uzStationsRepository;

    @Test
    public void shouldLoadBookingStations() throws Exception {
        //TODO create normal tests
        final SearchBookingStationsCmd cmd = new SearchBookingStationsCmd("ly");
        StationListWithSameTopTwoChars stationsStartWithSameChar = (StationListWithSameTopTwoChars) new TicketClient()
                .execute(cmd);
    }

    @Test
    public void testLoadUZStations() throws Exception {

    }
}