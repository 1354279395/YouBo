package com.tulun.bean;

import java.io.Serializable;

public class Clazz implements Serializable {
    /* */
    private Integer id;

    /* */
    private String c_name;

    /* */
    private String c_teacher;

    /* */
    private Integer c_s_number;

    /* */
    private String c_extra;

    private static final long serialVersionUID = 1L;

    public Clazz() {
    }

    public Clazz(Integer id, String c_name, String c_teacher, Integer c_s_number, String c_extra) {
        this.id = id;
        this.c_name = c_name;
        this.c_teacher = c_teacher;
        this.c_s_number = c_s_number;
        this.c_extra = c_extra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getc_name() {
        return c_name;
    }

    public void setcName(String c_name) {
        this.c_name = c_name;
    }

    public String getc_teacher() {
        return c_teacher;
    }

    public void setc_teacher(String c_teacher) {
        this.c_teacher = c_teacher;
    }

    public Integer getc_s_number() {
        return c_s_number;
    }

    public void setc_s_number(Integer c_s_number) {
        this.c_s_number = c_s_number;
    }

    public String getc_extra() {
        return c_extra;
    }

    public void setc_extra(String c_extra) {
        this.c_extra = c_extra;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", c_name=").append(c_name);
        sb.append(", c_teacher=").append(c_teacher);
        sb.append(", c_s_number=").append(c_s_number);
        sb.append(", c_extra=").append(c_extra);
        sb.append("]");
        return sb.toString();
    }
}