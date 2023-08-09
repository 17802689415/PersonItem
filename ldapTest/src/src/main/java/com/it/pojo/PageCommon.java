package com.it.pojo;

public class PageCommon {
    private int page;
    private int pageSize;
    private String username;
    private String typeValue;
    private String statusValue;

    @Override
    public String toString() {
        return "PageCommon{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", username='" + username + '\'' +
                ", typeValue='" + typeValue + '\'' +
                ", statusValue='" + statusValue + '\'' +
                '}';
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    public String getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(String statusValue) {
        this.statusValue = statusValue;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
