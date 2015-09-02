package com.ticket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Train")
public class Train {
    @Id
    private String numberTrain;
    @Column(nullable = false)
    private String route;
    @Column(nullable = false)
    private String timeMove;
    @Column(nullable = false)
    private String departureStation;
    @Column
    private String timeArrivalToDepSt;
    @Column(nullable = false)
    private String timeDepartureToDepSt;
    @Column(nullable = false)
    private String arrivalStation;
    @Column
    private String timeArrivalToArrivSt;
    @Column(nullable = false)
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
