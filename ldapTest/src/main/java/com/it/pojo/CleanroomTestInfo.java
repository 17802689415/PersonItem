package com.it.pojo;

import java.io.Serializable;

public class CleanroomTestInfo implements Serializable {
    private int id;
    private String caseNum;
    private String cleanroomName;
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

    public String getCleanroomName() {
        return cleanroomName;
    }

    public void setCleanroomName(String cleanroomName) {
        this.cleanroomName = cleanroomName;
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
