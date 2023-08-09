package com.it.pojo;

import java.io.Serializable;

public class SampleTestInfo implements Serializable {
    private int id;
    private String caseNum;
    private double quantity;
    private String testItem;
    private double limitValue;
    private String wino;
    private String remark;

    @Override
    public String toString() {
        return "SampleTestInfo{" +
                "id=" + id +
                ", caseNum='" + caseNum + '\'' +
                ", quantity=" + quantity +
                ", testItem='" + testItem + '\'' +
                ", limitValue=" + limitValue +
                ", wino='" + wino + '\'' +
                ", remark='" + remark + '\'' +
                '}';
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getTestItem() {
        return testItem;
    }

    public void setTestItem(String testItem) {
        this.testItem = testItem;
    }

    public double getLimitValue() {
        return limitValue;
    }

    public void setLimitValue(double limitValue) {
        this.limitValue = limitValue;
    }

    public String getWino() {
        return wino;
    }

    public void setWino(String wino) {
        this.wino = wino;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
