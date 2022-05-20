package com.example.postolache_predescu_sandur_sasu.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "jobTable", indices = {@Index(value ="idJob", unique = true)})
public class Job {
    @PrimaryKey()
    public Integer idJob;

    @ColumnInfo(name = "domainOfWork")
    public String domainOfWork;

    public static Integer newIdJob = 1;

    public Job(){}

    public Job(@NonNull String domainOfWork) {
        this.idJob = newIdJob;
        this.domainOfWork = domainOfWork;
        ++newIdJob;
    }

    public Integer getIdJob() {
        return idJob;
    }

    public void setIdJob(Integer idJob) {
        this.idJob = idJob;
    }

    public String getDomainOfWork() {
        return domainOfWork;
    }

    public void setDomainOfWork(String domainOfWork) {
        this.domainOfWork = domainOfWork;
    }

    @Override
    public String toString() {
        return "Job{" +
                "idJob=" + idJob +
                ", domainOfWork='" + domainOfWork + '\'' +
                '}';
    }
}
