package com.ticket.services;


import com.ticket.entity.RailroadStation;
import com.ticket.repositories.RailroadStationRepository;
import com.ticket.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RouteService {

    @Autowired
    RailroadStationRepository stationRepository;
    @Autowired
    RouteRepository routeRepository;

    public void UpdateRoutes() {
        Iterable<RailroadStation> stations = stationRepository.findAll();
        for (RailroadStation stationFrom : stations) {
            for (RailroadStation stationTill : stations) {
//TODO request to service
            }
        }
    }
}
