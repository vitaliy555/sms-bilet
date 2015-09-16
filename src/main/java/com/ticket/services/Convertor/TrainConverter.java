package com.ticket.services.convertor;

import java.util.Collection;

import com.google.common.collect.Lists;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ticket.entity.Train;

public class TrainConverter {

    public static Collection<Train> convertToTrains(final Elements trainsInHtml) {
        Collection<Train> trains = Lists.newArrayList();
        for (Element element : trainsInHtml) {
            Elements children = element.children();
            Train train = new Train();
            train.setNumber(children.get(0).text());
            train.setRoute(children.get(1).text());
            train.setSchedule(children.get(2).text());
            train.setDispatchStation(children.get(3).text());
            train.setArrivalStation(children.get(6).text());
            train.setSchedule(children.get(2).text());
            trains.add(train);
        }
        return trains;

    }
}
