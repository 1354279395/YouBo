package com.tulun.bean;

import java.io.Serializable;

public class Teacher implements Serializable {
    /* */
    private Integer id;

    /* */
    private String name;

    /* */
    private String sex;

    /* */
    private Double sal;

    /* */
    private String extra;

    private static final long serialVersionUID = 1L;
    public Teacher(){}
    public Teacher(Integer id, String name, String sex, Double sal, String extra) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.sal = sal;
        this.extra = extra;
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
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", sal=").append(sal);
        sb.append(", extra=").append(extra);
        sb.append("]");
        return sb.toString();
    }
}