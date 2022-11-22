package com.epa.epadiplom.entities;

public class JobTitle {
    private long id;
    private String job_title_name;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getJobTitleName() {
        return job_title_name;
    }
    public void setJobTitleName(String job_title_name) {
        this.job_title_name = job_title_name;
    }

//
//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("_");
//        sb.append("Job title: '").append(job_title_name).append('\'');
//        sb.append(" - ").append(id).append(" ");
//
//        return sb.toString();
//    }
}
