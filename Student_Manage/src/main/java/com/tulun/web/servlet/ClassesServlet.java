package com.tulun.web.servlet;


import com.tulun.bean.Clazz;
import com.tulun.web.controller.ClazzController;
import com.tulun.web.listen.MyContextListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
@WebServlet(name = "ClassServlet", urlPatterns = "/classeslist")
public class ClassesServlet extends BaseServlet {

    private MyContextListener myConnectionManager;

   private Map<Integer, Clazz> clazzMap; // class Entry key value

    public ClassesServlet() {
        clazzMap=new ConcurrentHashMap<>();
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
        ClazzController cc = new ClazzController();
        int size = cc.quert();
        for (int i = 0; i < size; i++) {
            Clazz clazz = cc.query(i + 1);
            if (clazz == null) {
                size++;
            }else {
                clazzMap.put(i + 1, clazz);
            }
        }
        request.setAttribute("classes", clazzMap);
        request.getRequestDispatcher("classes/class.jsp").forward(request, response);
    }
    public void addbefore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("classes/class.add.jsp").forward(request,response);
    }

    public void addafter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("uid"));
        String c_name = request.getParameter("c_name");
        String c_teacher = request.getParameter("c_teacher");
        Integer c_s_number = Integer.valueOf(request.getParameter("c_s_number"));
        String c_extra = request.getParameter("c_extra");

        if (clazzMap.containsKey(id)){
            request.setAttribute("error", "班号已存在");
            response.sendRedirect("classeslist");
            return;
        }
        ClazzController cc = new ClazzController();
        Clazz clazz = new Clazz(id, c_name, c_teacher, c_s_number, c_extra);
        cc.add(clazz);
        System.out.println(clazz);
        clazzMap.clear();
        response.sendRedirect("classeslist");
    }

    public void mod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("uid"));
        Clazz clazz = clazzMap.get(id);
        request.setAttribute("clazz", clazz);
            // 修改页面的跳转
            request.getRequestDispatcher("classes/class.modify.jsp").forward(request, response);
    }

    public void modifyClasses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("uid"));
        String c_name = request.getParameter("c_name");
        String c_teacher = request.getParameter("c_teacher");
        Integer c_s_number = Integer.valueOf(request.getParameter("c_s_number"));
        String c_extra = request.getParameter("c_extra");
        ClazzController cc = new ClazzController();
        Clazz clazz = new Clazz(id, c_name, c_teacher, c_s_number, c_extra);
        cc.modify(clazz);
        response.sendRedirect("classeslist");
    }

    public void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("uid"));
        ClazzController cc = new ClazzController();
        cc.remove(id);
        clazzMap.clear();

        response.sendRedirect("classeslist");
    }

}
