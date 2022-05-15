package com.example.postolache_predescu_sandur_sasu.data;

import androidx.room.ColumnInfo;

import java.util.Date;

public class HistoryModel {

    private String service;
    private String person;
    private Float feedback;
    private Date date;

    public HistoryModel(String service, String person, Float feedback, Date date) {
        this.service = service;
        this.person = person;
        this.feedback = feedback;
        this.date = date;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public Float getFeedback() {
        return feedback;
    }

    public void setFeedback(Float feedback) {
        this.feedback = feedback;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
