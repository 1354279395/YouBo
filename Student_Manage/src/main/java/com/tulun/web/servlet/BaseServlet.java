package com.tulun.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * description：
 *
 * @author ajie
 * data 2018/12/9 20:30
 */
@WebServlet(name = "BaseServlet")
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            action = "show";
        }

        Class c = this.getClass();
        try {
            Method method = c.getDeclaredMethod(action, HttpServletRequest.class,
                    HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("404.jsp").forward(request, response);
        }
    }
}
