package com.ticket.entity;

import com.ticket.utils.SmsTicketConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UZStation")
public class UZStation {
    @Id
    @Column(name = "uz_id")
    private String id;
    @Column(name = "uz_title")
    private String title;

    public UZStation() {
    }

    public UZStation(String id, String title) {
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
