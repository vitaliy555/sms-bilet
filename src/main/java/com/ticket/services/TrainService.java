package com.ticket.services;


import com.ticket.config.connector.TicketClient;
import com.ticket.config.connector.cmd.custom_cmd.AllTrainsByRouteCmd;
import com.ticket.config.connector.cmd.custom_cmd.SearchUZStationsCmd;
import com.ticket.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class TrainService {

    /**
     * Get all trains through set stations
     * @param from
     * @param to
     * @return
     */
    public Collection getTrainsByRoute(String from , String to){
        String resultHtml = (String) new TicketClient().execute(new AllTrainsByRouteCmd(from, to));
        return null;
    }

    /**
     * Get available trains through set stations
     * @param from
     * @param to
     * @return
     */
    public Collection getAvailableTrainsByRoute(String from , String to){
        return null;
    }
}
