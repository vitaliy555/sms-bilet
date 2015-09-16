package com.ticket.services;

import java.io.IOException;
import java.util.Collection;

import com.ticket.config.connector.cmd.custom_cmd.AllTrainsByFromToCmd;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.ticket.entity.Train;
import com.ticket.parsers.TrainParser;
import com.ticket.services.convertor.TrainConverter;

public class TrainService {

    /**
     * Get all trains through set stations
     * @param from
     * @param to
     * @return
     */
    public Collection<Train> getTrainsByRoute(String from, String to) throws IOException {
        final Document fullHtml = Jsoup.connect(new AllTrainsByFromToCmd(from, to).getPath()).get();
        Elements trainsInHtml = TrainParser.parsTrainsByRoute(fullHtml);
        return TrainConverter.convertToTrains(trainsInHtml);
    }

    /**
     * Get available trains through set stations
     * @param from
     * @param to
     * @return
     */
    public Collection getAvailableTrainsByRoute(String from, String to) {
        return null;
    }
}
