package com.ticket.services;


import com.ticket.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TrainService {

    @Autowired
    TrainRepository routeRepository;

    public void updateTrains(){
        routeRepository.findAll();
    }

//    public void UpdateRoutes() {
//        Iterable<RailroadStation> stations = stationRepository.findAll();
//        for (RailroadStation stationFrom : stations) {
//            for (RailroadStation stationTill : stations) {
////TODO request to service
//            }
//        }
//    }
}
