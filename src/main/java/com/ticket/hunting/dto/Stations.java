package com.ticket.hunting.dto;

import java.util.Collection;

public class Stations {

    Collection<StationNameAndID> value;

    public Collection<StationNameAndID> getValue() {
        return value;
    }

    public void setValue(Collection<StationNameAndID> value) {
        this.value = value;
    }

    public static class StationNameAndID {
        String title;
        String station_id;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getStation_id() {
            return station_id;
        }

        public void setStation_id(String station_id) {
            this.station_id = station_id;
        }

        @Override
        public String toString() {
            return "StationNameAndID{" +
                    "title='" + title + '\'' +
                    ", station_id='" + station_id + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Stations{" +
                "value=" + value +
                '}';
    }
}
