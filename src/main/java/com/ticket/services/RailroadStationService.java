package com.ticket.services;

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.ticket.config.connector.TicketClient;
import com.ticket.config.connector.cmd.Command;
import com.ticket.config.connector.cmd.custom_cmd.StationsByBookingCommand;
import com.ticket.config.connector.cmd.custom_cmd.StationsByUzCommand;
import com.ticket.dto.StationListWithSameTopTwoChars;
import com.ticket.entity.Station;
import com.ticket.repositories.RailroadStationRepository;
import com.ticket.utils.CyrillicCharHelper;
import com.ticket.utils.SmsTicketConstants;

public class RailroadStationService {

    @Autowired
    RailroadStationRepository stationRepository;

    public Collection<Station> updateByBookingStation() {
        final Collection<Station> updatedRailroadStation = Lists.newArrayList();
        final ExecutorService executor = Executors.newFixedThreadPool(SmsTicketConstants.NTHREDS);
        for (String twoChars : CyrillicCharHelper.getCharCombinations()) {
            executor.execute(new StationSearcher(new StationsByBookingCommand(twoChars)));
        }
        executor.shutdown();
        // need some time to finish all threads
        while (!executor.isTerminated()) {
        }
        stationRepository.save(updatedRailroadStation);
        return updatedRailroadStation;
    }

    public Collection<Station> updateByUzStation() {
        final Collection<Station> updatedRailroadStation = Lists.newArrayList();
        String answer = (String) new TicketClient().execute(new StationsByUzCommand());

        return null;
    }

    private Collection<Station> convertToRailroadStation(final StationListWithSameTopTwoChars stationsStartWithSameChar) {
        final Collection<Station> railroadStations = Lists.newArrayList();
        for (StationListWithSameTopTwoChars.StationNameAndID stationNameAndID : stationsStartWithSameChar.getValue()) {
            railroadStations.add(new Station(stationNameAndID.getTitle(), stationNameAndID.getStation_id()));
        }
        return railroadStations;
    }

    class StationSearcher implements Runnable {
        final Collection<Station> stations = Lists.newArrayList();
        final Command command;

        public StationSearcher(Command command) {
            this.command = command;
        }

        @Override
        public void run() {
            StationListWithSameTopTwoChars stationsStartWithSameChar = (StationListWithSameTopTwoChars) new TicketClient()
                    .execute(command);
            stations.addAll(convertToRailroadStation(stationsStartWithSameChar));

        }
    }

}
