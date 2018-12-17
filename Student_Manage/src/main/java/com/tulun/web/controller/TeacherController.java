package com.tulun.web.controller;

import com.tulun.bean.Teacher;
import com.tulun.service.TeacherService;
import com.tulun.service.serviceimpl.TeacherServiceImpl;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/10 23:27
 */
public class TeacherController {

    private TeacherService ts;

    public TeacherController() {
        ts = new TeacherServiceImpl();
    }

    public void add(Teacher t) {
        ts.addTeacher(t);
    }

    public int quert() {
        return ts.getTeacherNumber();
    }

    public Teacher query(String name) {
        return ts.queryTeacherByName(name);
    }
    public Teacher query(Integer id) {
        return ts.queryTeacherById(id);
    }

    public void remove(Integer id) {
        ts.removeTeacherById(id);
    }

    public void modify(Teacher t) {
        ts.modifyTeacherById(t);
    }
}
