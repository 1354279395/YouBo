package com.tulun.web.servlet;

import com.tulun.web.listen.MyContextListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "HelloServlet", urlPatterns = "/userlist")
public class UserServlet extends BaseServlet {

    private MyContextListener myConnectionManager;

    public UserServlet() throws SQLException {


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
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }

    public void loginout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("call LoginServlet.loginout");
        HttpSession session = req.getSession();
        session.invalidate();
        res.sendRedirect("login");
    }
}
