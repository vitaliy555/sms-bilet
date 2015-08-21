package com.ticket.services;

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.ticket.connector.TicketClient;
import com.ticket.connector.cmd.custom_cmd.StationsCommand;
import com.ticket.dao.RailroadStationRepository;
import com.ticket.dto.StationListWithSameTopTwoChars;
import com.ticket.model.RailroadStation;
import com.ticket.utils.CyrillicCharHelper;

public class UpdateRailroadStationService {
    private static final int NTHREDS = 20;
    @Autowired
    RailroadStationRepository stationRepository;

    public Collection<RailroadStation> updateRailroadStation() {
        doSomeWithDB();
        final Collection<RailroadStation> updatedRailroadStation = Lists.newArrayList();
        final ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
        for (String twoChars : CyrillicCharHelper.getCharCombinations()) {
            executor.execute(new UpdateRailroadStationWorker(twoChars, updatedRailroadStation));
        }
        executor.shutdown();
        // need some time to finish all threads
        while (!executor.isTerminated()) {
        }
        return updatedRailroadStation;
    }

    private Collection<RailroadStation> convertToRailroadStation(
            final StationListWithSameTopTwoChars stationsStartWithSameChar) {
        final Collection<RailroadStation> railroadStations = Lists.newArrayList();
        for (StationListWithSameTopTwoChars.StationNameAndID stationNameAndID : stationsStartWithSameChar.getValue()) {
            railroadStations.add(new RailroadStation(stationNameAndID.getTitle(), stationNameAndID.getStation_id()));
        }
        return railroadStations;
    }

    class UpdateRailroadStationWorker implements Runnable {
        final String twoChars;
        final Collection<RailroadStation> updatedRailroadStation;

        public UpdateRailroadStationWorker(String twoChars, Collection<RailroadStation> updatedRailroadStation) {
            this.twoChars = twoChars;
            this.updatedRailroadStation = updatedRailroadStation;
        }

        @Override
        public void run() {
            StationListWithSameTopTwoChars stationsStartWithSameChar = (StationListWithSameTopTwoChars) new TicketClient()
                    .execute(new StationsCommand(twoChars));
            updatedRailroadStation.addAll(convertToRailroadStation(stationsStartWithSameChar));

        }
    }

    private void doSomeWithDB() {
        Iterable<RailroadStation> all = stationRepository.findAll();
        System.out.println("First station title :"+all.iterator().next().getTitle());
    }
}
