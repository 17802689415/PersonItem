package com.it.pojo;

import java.io.Serializable;

public class ConsignorInfo implements Serializable {
    private int id;

    private String caseNum;
    private String jobId;
    private String phoneNum;
    private String workCell;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(String caseNum) {
        this.caseNum = caseNum;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getWorkCell() {
        return workCell;
    }

    public void setWorkCell(String workCell) {
        this.workCell = workCell;
    }

    @Override
    public String toString() {
        return "ConsignorInfo{" +
                "id=" + id +
                ", caseNum='" + caseNum + '\'' +
                ", jobId='" + jobId + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", workCell='" + workCell + '\'' +
                '}';
    }
}
