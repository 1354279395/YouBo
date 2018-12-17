package com.tulun.dao;

import com.tulun.bean.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    int getStudentNum();

    List<Student> getPageStudent(HashMap<String, Object> map);
    List<Student> getAllStudent();
}