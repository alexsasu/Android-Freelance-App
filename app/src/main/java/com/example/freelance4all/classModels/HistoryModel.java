package com.example.freelance4all.classModels;

public class HistoryModel {

    private Integer idUtility;
    private String date;
    private String job;
    private String person;
    private Float feedback;

    public HistoryModel(Integer idUtility, String job, String person, Float feedback, String date) {
        this.idUtility = idUtility;
        this.job = job;
        this.person = person;
        this.feedback = feedback;
        this.date = date;
    }

    public Integer getIdUtility() {
        return idUtility;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "HistoryModel{" +
                "idUtility=" + idUtility +
                ", date='" + date + '\'' +
                ", job='" + job + '\'' +
                ", person='" + person + '\'' +
                ", feedback=" + feedback +
                '}';
    }
}
