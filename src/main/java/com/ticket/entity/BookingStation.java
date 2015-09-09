package com.ticket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BookingStation")
public class BookingStation {

    @Id
    @Column(name = "booking_id")
    private String id;
    @Column(name = "booking_title")
    private String title;

    public BookingStation() {
    }

    public BookingStation(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
