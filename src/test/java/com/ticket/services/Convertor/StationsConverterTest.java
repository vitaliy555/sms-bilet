package com.ticket.services.convertor;

import com.ticket.config.connector.TicketClient;
import com.ticket.config.connector.cmd.custom_cmd.SearchUZStationsCmd;
import com.ticket.entity.UZStation;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class StationsConverterTest {

    @Test
    public void shouldReturnCollectionOfUzStations() throws Exception {
        String inputValue = new String(new TicketClient().<String>execute(new SearchUZStationsCmd()));
        Collection<UZStation> uzStations = StationsConverter.convertToUzStations(inputValue);
        assertFalse(uzStations.isEmpty());
    }
}