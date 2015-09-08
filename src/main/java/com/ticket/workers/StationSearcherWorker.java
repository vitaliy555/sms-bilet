package com.ticket.workers;

import com.ticket.config.connector.TicketClient;
import com.ticket.config.connector.cmd.Command;
import com.ticket.dto.StationListWithSameTopTwoChars;
import com.ticket.entity.BookingStation;
import com.ticket.services.Convertor.StationsConverter;

import java.util.Collection;

public class StationSearcherWorker implements Runnable {
    final Collection<BookingStation> stations;
    final Command command;

    public StationSearcherWorker(Collection<BookingStation> stations, Command command) {
        this.command = command;
        this.stations = stations;
    }

    @Override
    public void run() {
        StationListWithSameTopTwoChars stationsStartWithSameChar = (StationListWithSameTopTwoChars) new TicketClient()
                .execute(command);
        stations.addAll(StationsConverter.convertToBookingStation(stationsStartWithSameChar));

    }
}