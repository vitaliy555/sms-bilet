package com.ticket.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by CHVE on 8/26/2015.
 */

@Entity
@Table(name = "RouteRepository")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column(nullable = false)
    private String routeNumber;
    @Column(nullable = false)
    private RailroadStation from;
    @Column(nullable = false)
    private RailroadStation till;
    @Column(nullable = false)
    private Date departureDate;

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public RailroadStation getFrom() {
        return from;
    }

    public void setFrom(RailroadStation from) {
        this.from = from;
    }

    public RailroadStation getTill() {
        return till;
    }

    public void setTill(RailroadStation till) {
        this.till = till;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
}
