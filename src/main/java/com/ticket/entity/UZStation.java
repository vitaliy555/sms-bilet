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
    private String uzId;
    @Column(nullable = false)
    private String title;

    public UZStation() {
    }

    public UZStation(String uzId, String title) {
        this.uzId = uzId;
        this.title = title;
    }

    public UZStation(String titleAndId) {
        String[] splitedTitleFromId = titleAndId.split(SmsTicketConstants.DELIMITER_TITLE_ID);
        this.uzId = splitedTitleFromId[0];
        this.title = splitedTitleFromId[1];
    }

    public String getIdUZ() {
        return uzId;
    }

    public void setIdUZ(String uzId) {
        this.uzId = uzId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
