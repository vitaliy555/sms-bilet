package com.bilet.hunting.dto;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Stations {

    ArrayList<StationNameAndID> value;

    public ArrayList<StationNameAndID> getValue() {
        return value;
    }

    public void setValue(ArrayList<StationNameAndID> value) {
        this.value = value;
    }

    class StationNameAndID{
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
    }
}
