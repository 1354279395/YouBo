package com.tulun.service;

import com.tulun.bean.Teacher;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/9 20:40
 */
public interface TeacherService {

    void addTeacher(Teacher t);

    Teacher queryTeacherById(Integer id);

    Teacher queryTeacherByName(String name);

    void removeTeacherById(Integer id);

    void modifyTeacherById(Teacher t);

    int getTeacherNumber();
}
