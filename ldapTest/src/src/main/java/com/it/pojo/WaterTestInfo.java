package com.it.pojo;

import java.io.Serializable;

public class WaterTestInfo implements Serializable {
    private int id;
    private String caseNum;
    private String waterNum;
    private String testItem;
    private String wino;

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

    public String getWaterNum() {
        return waterNum;
    }

    public void setWaterNum(String waterNum) {
        this.waterNum = waterNum;
    }

    public String getTestItem() {
        return testItem;
    }

    public void setTestItem(String testItem) {
        this.testItem = testItem;
    }

    public String getWino() {
        return wino;
    }

    public void setWino(String wino) {
        this.wino = wino;
    }
}
