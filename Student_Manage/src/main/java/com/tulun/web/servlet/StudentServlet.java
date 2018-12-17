package com.tulun.web.servlet;


import com.tulun.bean.Student;
import com.tulun.web.controller.StudentController;
import com.tulun.web.listen.MyContextListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述: 创建的第一个Servlet
 * 1.需要知道Servlet的继承结构
 *
 * 借助后面spring mvc框架的思想
 * url  =》   servlet类上
 * url  =》   action方法上
 *
 * @Author shilei
 * @Date 2018/11/24
 */
@WebServlet(name = "StudentServlet", urlPatterns = "/studentlist")
public class StudentServlet extends BaseServlet {

    private MyContextListener myConnectionManager;
    private Map<Integer, Student> studentMap=new ConcurrentHashMap<>();
    private HashMap<String, Object> map=new HashMap<>();
    private  int totalpageStudent;


    public StudentServlet() {

    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 实现浏览器客户端发送的请求的具体逻辑
        // 添加编码格式的处理   Tomcat  iso-8859-1编码方式
        super.service(request, response);
    }

    /**
     * 显示用户列表
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        studentMap.clear();
        StudentController st = new StudentController();
        int pagenow=0;
        //显示第一页时候，request.getParameter("pagenow")==null；
        if (request.getParameter("pagenow")==null){
            pagenow=1;
        }else {
            pagenow = Integer.parseInt(request.getParameter("pagenow"));
        }

        int size = st.quert();
        if (size%3==0){
            totalpageStudent=size/3;
        }else {
            totalpageStudent=size/3+1;
        }
        //第一页的上一页，最后一页的下一页处理
        if (pagenow==0){
            pagenow=1;
        }
        if (pagenow==totalpageStudent+1){
            pagenow=totalpageStudent;
        }

        int a=(pagenow-1)*3;
        map.put("start",a);
        map.put("end",3);
        //通过调取FyServiceImpl中的selectAll(page.getOffsetone(), page.getSlide())，返回每页查询的数据集合
        List<Student> list= st.query(map);
        int i=a;
        for (Student student:list) {
            System.out.println();
            i++;
            studentMap.put(i,student);
        }
        request.setAttribute("page",pagenow);
        request.setAttribute("totalpageStudent",totalpageStudent);
        request.setAttribute("students", studentMap);
        request.getRequestDispatcher("student/student.jsp").forward(request, response);

    }
    public void showpage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        studentMap.clear();
        StudentController st = new StudentController();
        int pagenow = Integer.parseInt(request.getParameter("pagenow"));
        if (pagenow==0){
            pagenow=1;
        }
        if (pagenow==totalpageStudent+1){
            pagenow=totalpageStudent;
        }
        int a=(pagenow-1)*3;
        map.put("start",a);
        map.put("end",3);
        List<Student> list= st.query(map);
        int i=a;
        for (Student student:list) {
            i++;
            studentMap.put(i,student);
        }
        int size = st.quert();
        request.setAttribute("page",pagenow);
        request.setAttribute("totalpageStudent",totalpageStudent);
        request.setAttribute("students", studentMap);
        request.getRequestDispatcher("student/student.jsp").forward(request, response);

    }
    public void addbefore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("student/stu.add.jsp").forward(request,response);
    }

    public void addafter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("uid"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        Integer age = Integer.valueOf(request.getParameter("age"));
        Integer c_id = Integer.valueOf(request.getParameter("c_id"));
        String extra = request.getParameter("s_extra");
        if (studentMap.containsKey(id)){
            request.setAttribute("error", "学号已存在");
            response.sendRedirect("studentlist");
            return;
        }
        Student student = new Student(id, name, sex,age, c_id, extra);
        StudentController sc = new StudentController();
        sc.add(student);
        System.out.println(student);
        studentMap.clear();
        response.sendRedirect("studentlist");
    }

    public void mod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("uid"));
        Student student = studentMap.get(id);
            request.setAttribute("student", student);
            // 修改页面的跳转
            request.getRequestDispatcher("student/stu.modify.jsp").forward(request, response);
    }

    public void modifyStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("uid"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        Integer age = Integer.valueOf(request.getParameter("age"));
        Integer c_id = Integer.valueOf(request.getParameter("c_id"));
        String extra = request.getParameter("s_extra");

        Student student = new Student(id, name, sex,age, c_id, extra);
        StudentController sc = new StudentController();
        System.out.println(student);
        sc.modify(student);
        response.sendRedirect("studentlist");
    }

    public void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("uid"));
        StudentController sc = new StudentController();
        sc.remove(id);
        studentMap.clear();

        response.sendRedirect("studentlist");
    }

}
