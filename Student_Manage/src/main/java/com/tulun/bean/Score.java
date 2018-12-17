package com.tulun.bean;

public class Score {
    private Integer id;

    private String name;

    private Double mark;

    private Integer sId;

    public Score(Integer id, String name, Double mark, Integer sId) {
        this.id=id;
        this.name=name;
        this.mark=mark;
        this.sId=sId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }
}