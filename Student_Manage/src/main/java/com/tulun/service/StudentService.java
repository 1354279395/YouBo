package com.tulun.service;

import com.tulun.bean.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/9 20:39
 */
public interface StudentService {
    void addStudent(Student s);

    Student queryStudentById(Integer id);

    Student queryStudentByName(String name);
    List<Student> queryAllStudent();
    List<Student> queryStudentPage(HashMap<String, Object> map );

    void removeStudentByName(Student s);

    void modifyStudentByName(Student s);

    int getStudentNumber();

    void removeStudentById(Integer id);
}
