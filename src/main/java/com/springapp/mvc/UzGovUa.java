package com.springapp.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.collect.Lists;

public class UzGovUa {

    public static final String SELECT_ALL_TRAIN_ELEMENTS = "#cpn-timetable > table > tbody > tr";
    public static final String SELECT_CELLS = "td";
    public static final int COUNT_CELLS = 9;

    public static void main(String[] args) {

        ArrayList<String> mass = Lists.newArrayList();
        mass.add("a");
        mass.add("b");
        mass.add("c");
        System.out.println(mass);

//
//        Document doc = null;
//        try {
//            doc = Jsoup
//                    .connect(
//                            "http://www.uz.gov.ua/passengers/timetables/?from_station=22700&to_station=23600%2C23629&select_time=2&time_from=00&time_to=24&by_route=%D0%9F%D0%BE%D1%88%D1%83%D0%BA")
//                    .get();
//            Elements elements = doc.select(SELECT_ALL_TRAIN_ELEMENTS);
//            Collection<Train> trains = convertToTrains(elements);
//            System.out.println(trains.size());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(doc.outerHtml());
    }

    private static Collection<Train> convertToTrains(Elements elements) {
        Collection<Train> trains = Lists.newArrayList();
        for (Element element : elements) {
            Elements cells = element.select(SELECT_CELLS);
            if (COUNT_CELLS == cells.size()) {
                // hardcoding because I sure thet all cells are exist :)
                Train train = new Train();
                train.setNumberTrain(cells.get(0).text());
                train.setRoute(cells.get(1).text());
                train.setTimeMove(cells.get(2).text());
                train.setDepartureStation(cells.get(3).text());
                train.setTimeArrivalToDepSt(cells.get(4).text());
                train.setTimeDepartureToDepSt(cells.get(5).text());
                train.setArrivalStation(cells.get(6).text());
                train.setTimeArrivalToArrivSt(cells.get(7).text());
                train.setTimeDepartureToArrivSt(cells.get(8).text());
                trains.add(train);
            }

        }
        return trains;
    }

    static class Train {
        private String numberTrain;
        private String route;
        private String timeMove;
        private String departureStation;
        private String timeArrivalToDepSt;
        private String timeDepartureToDepSt;
        private String arrivalStation;
        private String timeArrivalToArrivSt;
        private String timeDepartureToArrivSt;

        public String getNumberTrain() {
            return numberTrain;
        }

        public void setNumberTrain(String numberTrain) {
            this.numberTrain = numberTrain;
        }

        public String getRoute() {
            return route;
        }

        public void setRoute(String route) {
            this.route = route;
        }

        public String getTimeMove() {
            return timeMove;
        }

        public void setTimeMove(String timeMove) {
            this.timeMove = timeMove;
        }

        public String getDepartureStation() {
            return departureStation;
        }

        public void setDepartureStation(String departureStation) {
            this.departureStation = departureStation;
        }

        public String getTimeArrivalToDepSt() {
            return timeArrivalToDepSt;
        }

        public void setTimeArrivalToDepSt(String timeArrivalToDepSt) {
            this.timeArrivalToDepSt = timeArrivalToDepSt;
        }

        public String getTimeDepartureToDepSt() {
            return timeDepartureToDepSt;
        }

        public void setTimeDepartureToDepSt(String timeDepartureToDepSt) {
            this.timeDepartureToDepSt = timeDepartureToDepSt;
        }

        public String getArrivalStation() {
            return arrivalStation;
        }

        public void setArrivalStation(String arrivalStation) {
            this.arrivalStation = arrivalStation;
        }

        public String getTimeArrivalToArrivSt() {
            return timeArrivalToArrivSt;
        }

        public void setTimeArrivalToArrivSt(String timeArrivalToArrivSt) {
            this.timeArrivalToArrivSt = timeArrivalToArrivSt;
        }

        public String getTimeDepartureToArrivSt() {
            return timeDepartureToArrivSt;
        }

        public void setTimeDepartureToArrivSt(String timeDepartureToArrivSt) {
            this.timeDepartureToArrivSt = timeDepartureToArrivSt;
        }
    }
}
