package com.it.pojo;

import java.io.Serializable;

public class SampleInfo implements Serializable {
    private int id;
    private String caseNum;
    private String sampleName;
    private String testPurpose;
    private double totalQuantity;
    private String model;
    private String batchNum;
    private String disposal;
    private String storageCondition;
    private String sendSampleDate;

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

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public String getTestPurpose() {
        return testPurpose;
    }

    public void setTestPurpose(String testPurpose) {
        this.testPurpose = testPurpose;
    }

    public double getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public String getDisposal() {
        return disposal;
    }

    public void setDisposal(String disposal) {
        this.disposal = disposal;
    }

    public String getStorageCondition() {
        return storageCondition;
    }

    public void setStorageCondition(String storageCondition) {
        this.storageCondition = storageCondition;
    }

    public String getSendSampleDate() {
        return sendSampleDate;
    }

    public void setSendSampleDate(String sendSampleDate) {
        this.sendSampleDate = sendSampleDate;
    }

    @Override
    public String toString() {
        return "SampleInfo{" +
                "id=" + id +
                ", caseNum='" + caseNum + '\'' +
                ", sampleName='" + sampleName + '\'' +
                ", testPurpose='" + testPurpose + '\'' +
                ", totalQuantity=" + totalQuantity +
                ", model='" + model + '\'' +
                ", batchNum='" + batchNum + '\'' +
                ", disposal='" + disposal + '\'' +
                ", storageCondition='" + storageCondition + '\'' +
                ", sendSampleDate='" + sendSampleDate + '\'' +
                '}';
    }
}
