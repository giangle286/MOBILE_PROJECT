package com.example.models;

public class DecoComment {
    private String cmt;
    private String name;

    public DecoComment(String cmt, String name) {
        this.cmt = cmt;
        this.name = name;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
