package com.tulun.web.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tulun.bean.WebUser;
import com.tulun.web.controller.Usercontroller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

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

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends BaseServlet{
    private List<WebUser> acountList;

    public LoginServlet() {
        acountList = new LinkedList<>();
       /* acountList.add(new WebUser("youbo", "123456","student"));
        acountList.add(new WebUser("1354279395", "123456","teacher"));
        acountList.add(new WebUser("admin", "123456","admin"));*/
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }


    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    public void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("username");
        String pwd = req.getParameter("userpwd");
        String identity=req.getParameter("identity");

        HttpSession session = req.getSession();
        Usercontroller user=new Usercontroller();
        WebUser user1=user.query(name);
        if (user1.getUserpwd().equals(pwd)&&user1.getIdentity().equals(identity)){
            // 登录成功  客户端转发
            session.setAttribute(name, pwd);
            session.setAttribute("username",name);
            session.setAttribute("identity",identity);
            session.setAttribute("login_state", true);
            // 在当前会话中记录一下登录状态
            res.sendRedirect("userlist");
            // 如果session有错误信息，进行清除
            session.removeAttribute("errinfo");
            return;
        }
//        }

        // 登录失败  http://www.tulun.com/login  resquest
        session.setAttribute("errinfo", "用户名或者密码错误!");
        res.sendRedirect("login");
    }
    public void ajaxlogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("username");
        String pwd = req.getParameter("userpwd");
        String identity=req.getParameter("identity");

        HttpSession session = req.getSession();
        Usercontroller user=new Usercontroller();
        WebUser user1=user.query(name);
         if (user1.getUserpwd().equals(pwd)&&user1.getIdentity().equals(identity)){

                // 登录成功  客户端转发
                session.setAttribute(name, pwd);
                session.setAttribute("username",name);
                session.setAttribute("identity",identity);
                session.setAttribute("login_state", true);
                ObjectMapper mapper = new ObjectMapper();
                ObjectNode node = mapper.createObjectNode();
                node.put("code", 200);
                node.put("url", "/userlist");
                //node.put("url", "/main");

                // {code:200, url:/userlist}
                res.getWriter().println(node.toString());
                return;
            }

        // 登录失败  http://www.tulun.com/login  resquest

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("code", 100);

        res.getWriter().println(node.toString());

    }

}

