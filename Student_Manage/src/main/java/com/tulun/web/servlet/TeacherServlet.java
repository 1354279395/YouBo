package com.tulun.web.servlet;


import com.tulun.bean.Teacher;
import com.tulun.web.controller.TeacherController;
import com.tulun.web.listen.MyContextListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "TeacherServlet", urlPatterns = "/teacherlist")
public class TeacherServlet extends BaseServlet {

    private MyContextListener myConnectionManager;

   private Map<Integer, Teacher> teacherMap; // class Entry key value

    public TeacherServlet() throws SQLException {

        teacherMap=new ConcurrentHashMap<>();
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
        TeacherController teacher = new TeacherController();
        int size = teacher.quert();
        for (int i = 0; i < size; i++) {
            Teacher teacher1 = teacher.query(i + 1);
            if (teacher1 == null) {
                size++;
                System.out.println(size);
            }else {
                teacherMap.put(i + 1, teacher1);
            }
        }
        request.setAttribute("teachers", teacherMap);
        request.getRequestDispatcher("teacher/teacher.jsp").forward(request, response);
    }
    public void addbefore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("teacher/tea.add.jsp").forward(request,response);
    }

    public void addafter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("uid"));
        String name = request.getParameter("name");
        Double sal = Double.valueOf(request.getParameter("sal"));
        String sex = request.getParameter("sex");
        String extra = request.getParameter("extra");
        if (teacherMap.containsKey(id)){
            request.setAttribute("error", "工号已存在");
            response.sendRedirect("teacherlist");
            return;
        }
        Teacher newTeacher = new Teacher(id, name, sex, sal, extra);
        TeacherController teacher = new TeacherController();
        teacher.add(newTeacher);
        teacherMap.clear();

        response.sendRedirect("teacherlist");
    }

    public void mod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("uid"));
        Teacher teacher = teacherMap.get(id);
            request.setAttribute("teacher", teacher);
            // 修改页面的跳转
            request.getRequestDispatcher("teacher/tea.modify.jsp").forward(request, response);
    }

    public void modifyTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("uid"));
        String name = request.getParameter("name");
        Double sal = Double.valueOf(request.getParameter("sal"));
        String sex = request.getParameter("sex");
        String extra = request.getParameter("extra");

        Teacher newTeacher = new Teacher(id, name, sex, sal, extra);
        TeacherController teacher = new TeacherController();
        teacher.modify(newTeacher);

        /*SqlSession session=MyBatisUtils.getSession();
        WebstudentMapper pm=session.getMapper(WebstudentMapper.class);
        pm.updateByPrimaryKey(Student);*/
        response.sendRedirect("teacherlist");
    }

    public void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("tid"));
        TeacherController teacher = new TeacherController();
        teacher.remove(id);
        teacherMap.clear();

        response.sendRedirect("teacherlist");
    }

}
