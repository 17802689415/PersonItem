package com.it.pojo;

import java.io.Serializable;

public class ApplyForm implements Serializable {
    private int id;
    private String caseNum;
    private String testType;
    private String consignorId;
    private String inspectorId;
    private String applyDate;
    private boolean urgent;
    private String step;
    private String status;
    private String updateTime;

    @Override
    public String toString() {
        return "ApplyForm{" +
                "id=" + id +
                ", caseNum='" + caseNum + '\'' +
                ", testType='" + testType + '\'' +
                ", consignorId='" + consignorId + '\'' +
                ", inspectorId='" + inspectorId + '\'' +
                ", applyDate='" + applyDate + '\'' +
                ", urgent=" + urgent +
                ", step='" + step + '\'' +
                ", status='" + status + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }

    public String getConsignorId() {
        return consignorId;
    }

    public void setConsignorId(String consignorId) {
        this.consignorId = consignorId;
    }

    public String getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(String inspectorId) {
        this.inspectorId = inspectorId;
    }

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

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
