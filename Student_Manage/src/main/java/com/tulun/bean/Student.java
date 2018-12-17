package com.tulun.bean;

import java.io.Serializable;

public class Student implements Serializable {
    /* */
    private Integer id;

    /* */
    private String name;

    /* */
    private String sex;

    /* */
    private Integer age;

    /* */
    private Integer c_id;
    /* */
    private String s_extra;

    private static final long serialVersionUID = 1L;

    public Student(){}
    public Student(Integer id, String name, String sex, Integer age, Integer c_id, String s_extra) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.c_id = c_id;
        this.s_extra = s_extra;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getc_id() {
        return c_id;
    }

    public void setcId(Integer c_id) {
        this.c_id = c_id;
    }

    public String gets_extra() {
        return s_extra;
    }

    public void sets_extra(String s_extra) {
        this.s_extra = s_extra;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", c_id=").append(c_id);
        sb.append(", s_extra=").append(s_extra);
        return sb.toString();
    }
}