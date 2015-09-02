package com.ticket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Station")
public class Station {

    @Id
    private String bookingId;
    @Column(nullable = false)
    private String uzId;
    @Column(nullable = false)
    private String title;

    public Station() {
    }

    public Station(String title, String bookingId) {
        this.title = title;
        this.bookingId = bookingId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getUzId() {
        return uzId;
    }

    public void setUzId(String uzId) {
        this.uzId = uzId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
