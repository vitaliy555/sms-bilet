package com.ticket.services;

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.ticket.config.connector.TicketClient;
import com.ticket.config.connector.cmd.custom_cmd.SearchBookingStationsCmd;
import com.ticket.config.connector.cmd.custom_cmd.SearchUZStationsCmd;
import com.ticket.entity.BookingStation;
import com.ticket.entity.UZStation;
import com.ticket.repositories.BookingStationsRepository;
import com.ticket.repositories.UZStationsRepository;
import com.ticket.services.Convertor.StationsConverter;
import com.ticket.utils.CyrillicCharHelper;
import com.ticket.utils.SmsTicketConstants;
import com.ticket.workers.StationSearcherWorker;

public class StationService {

    @Autowired
    BookingStationsRepository bookingStationsRepository;
    @Autowired
    UZStationsRepository uzStationsRepository;

    /**
     * Loading stations to DB
     * @return true - if completed successful
     */
    public boolean loadStations() {
        Collection<BookingStation> bookingStations = loadBookingStations();
        Collection<UZStation> uzStations = loadUZStations();
        return !(bookingStations.isEmpty() && uzStations.isEmpty());
    }


     Collection<BookingStation> loadBookingStations() {
        final Collection<BookingStation> loaded = Lists.newArrayList();
        final ExecutorService executor = Executors.newFixedThreadPool(SmsTicketConstants.NTHREDS);
        for (String twoChars : CyrillicCharHelper.getCharCombinations()) {
            final SearchBookingStationsCmd cmd = new SearchBookingStationsCmd(twoChars);
            executor.execute(new StationSearcherWorker(loaded, cmd));
        }
        executor.shutdown();
        // need some time to finish all threads
        while (!executor.isTerminated()) {
        }
        // TODO refactorig
        nullCuter(loaded);
        bookingStationsRepository.save(loaded);
        return loaded;
    }

     Collection<UZStation> loadUZStations() {
        final String stations = (String) new TicketClient().execute(new SearchUZStationsCmd());
        final Collection<UZStation> loaded = StationsConverter.convertToUzStations(stations);
        uzStationsRepository.save(loaded);
        return loaded;
    }

    // TODO it can be fix ? it make me boring
    private void nullCuter(Collection<BookingStation> stations) {
        Collection<BookingStation> nullable = Lists.newArrayList();
        for (BookingStation station : stations) {
            if (station == null) {
                nullable.add(station);
            }
        }
        stations.removeAll(nullable);
    }
}
