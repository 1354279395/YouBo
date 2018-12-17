package com.tulun.constant;

import com.tulun.bean.Student;
import com.tulun.dao.StudentMapper;
import com.tulun.util.MyBatisUtils;
import com.tulun.web.controller.StudentController;
import com.tulun.web.controller.TeacherController;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/10 13:50
 */
class ConnectionTest {
    public static void main(String[] args) {
        List<Student> list=new LinkedList<>();
        StudentController st = new StudentController();
       Student student=st.query(2);
        System.out.println(student);
    }
    public static void main2(String[] args) {
       /* int[] array={1,2,3};
        *//*for (int i=0; i <array.length ; i++) {
           test(array[i]);
        }*//*
        test(2);*/

    }
    public static void test(int page){
        List<Student> list=new LinkedList<>();
        StudentController st = new StudentController();
        HashMap<String, Object> map=new HashMap<>();
        int a=(page-1)*3;
        int b=a+3;
        map.put("start",2);
        map.put("end",3);
         list=st.query(map);
        System.out.println(list.size());
        for (Student student:list) {
            System.out.println(student);
        }
        System.out.println("==========");
    }
   // private static Page page;
    
}
