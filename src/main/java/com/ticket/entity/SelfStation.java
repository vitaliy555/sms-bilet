package com.ticket.entity;

import javax.persistence.*;

@Entity
@Table(name = "SelfStation")
public class SelfStation {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int seq;
    @Column(name = "uz_id")
    private String uzId;
    @Column(name = "uz_title")
    private String uzTitle;
    @Column(name = "booking_id")
    private String bookingId;
    @Column(name = "booking_title")
    private String bookingTitle;

    public SelfStation() {
    }

    public SelfStation(String uzId, String uzTitle, String bookingId, String bookingTitle) {
        this.uzId = uzId;
        this.uzTitle = uzTitle;
        this.bookingId = bookingId;
        this.bookingTitle = bookingTitle;
    }

    public SelfStation(Object o, Object o1, Object o2, Object o3) {
        this.uzId = (String) o;
        this.uzTitle = (String) o1;
        this.bookingId = (String) o2;
        this.bookingTitle = (String) o3;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getUzId() {
        return uzId;
    }

    public void setUzId(String uzId) {
        this.uzId = uzId;
    }

    public String getUzTitle() {
        return uzTitle;
    }

    public void setUzTitle(String uzTitle) {
        this.uzTitle = uzTitle;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingTitle() {
        return bookingTitle;
    }

    public void setBookingTitle(String bookingTitle) {
        this.bookingTitle = bookingTitle;
    }
}
