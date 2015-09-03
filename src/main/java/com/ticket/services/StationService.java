package com.ticket.services;

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.ticket.config.connector.TicketClient;
import com.ticket.config.connector.cmd.Command;
import com.ticket.config.connector.cmd.custom_cmd.SearchBookingStationsCmd;
import com.ticket.config.connector.cmd.custom_cmd.SearchUZStationsCmd;
import com.ticket.dto.StationListWithSameTopTwoChars;
import com.ticket.entity.BookingStation;
import com.ticket.repositories.BookingStationsRepository;
import com.ticket.utils.CyrillicCharHelper;
import com.ticket.utils.SmsTicketConstants;

public class StationService {

    @Autowired
    BookingStationsRepository bookingStationsRepository;

    public Collection<BookingStation> loadBookingStations() {
        final Collection<BookingStation> loaded = Lists.newArrayList();
        final ExecutorService executor = Executors.newFixedThreadPool(SmsTicketConstants.NTHREDS);
        for (String twoChars : CyrillicCharHelper.getCharCombinations()) {
            final SearchBookingStationsCmd cmd = new SearchBookingStationsCmd(twoChars);
            executor.execute(new StationSearcher(loaded, cmd));
        }
        executor.shutdown();
        // need some time to finish all threads
        while (!executor.isTerminated()) {
        }
        //TODO refactorig
        nullCurter(loaded);
        bookingStationsRepository.save(loaded);
        return loaded;
    }
//TODO it can be fix ? it make me boring
    private void nullCurter(Collection<BookingStation> stations) {
        Collection<BookingStation> nullable = Lists.newArrayList();
        for (BookingStation station : stations) {
            if (station == null) {
                nullable.add(station);
            }
        }
        stations.removeAll(nullable);
    }

    public Collection<BookingStation> loadUZStations() {
        final Collection<BookingStation> loaded = Lists.newArrayList();
        String answer = (String) new TicketClient().execute(new SearchUZStationsCmd());

        return null;
    }

    private Collection<BookingStation> convertToBookingStation(
            final StationListWithSameTopTwoChars stationsStartWithSameChar) {
        final Collection<BookingStation> stations = Lists.newArrayList();
        for (StationListWithSameTopTwoChars.StationNameAndID stationNameAndID : stationsStartWithSameChar.getValue()) {
            stations.add(new BookingStation(stationNameAndID.getTitle(), stationNameAndID.getStation_id()));
        }
        return stations;
    }

    class StationSearcher implements Runnable {
        final Collection<BookingStation> stations;
        final Command command;

        public StationSearcher(Collection<BookingStation> stations, Command command) {
            this.command = command;
            this.stations = stations;
        }

        @Override
        public void run() {
            StationListWithSameTopTwoChars stationsStartWithSameChar = (StationListWithSameTopTwoChars) new TicketClient()
                    .execute(command);
            stations.addAll(convertToBookingStation(stationsStartWithSameChar));

        }
    }

}
