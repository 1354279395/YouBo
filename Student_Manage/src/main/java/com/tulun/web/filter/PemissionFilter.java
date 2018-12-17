package com.tulun.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "PemissionFilter", urlPatterns = "/*")
public class PemissionFilter implements Filter {

    public PemissionFilter() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        String url = request.getRequestURL().toString();
        String contextPath = request.getServletContext().getContextPath();
        if(url.endsWith(".css") || url.endsWith(".js")
                || url.endsWith(".jpg")||url.endsWith(".ico")){
            chain.doFilter(req, resp);  // 没有自定义的servlet  DefaultServlet url-pattern /
            return;
        }

        HttpSession session = request.getSession();
        String identity=(String) session.getAttribute("identity");
        if(session.getAttribute("login_state") == null){
            // 未登录状态   http://www.tulun.com/login
            if(!url.contains("/login")){
                response.sendRedirect(contextPath + "/login");
                return;
            } else{
                chain.doFilter(req, resp);
            }
        } else{
            // 已登录状态
            if(url.contains( contextPath + "/login")){
                response.sendRedirect(contextPath + "/userlist");
                return;
            } else{
                if (identity.equals("student")){
                    if(url.endsWith(".add.jsp") || url.endsWith(".modify.jsp")){

                   /* if (url.contains(contextPath+"/stuadd.jsp")||url.contains(contextPath+"/stumodify.jsp")
                    ||url.contains(contextPath+"/scroeadd.jsp")||url.contains(contextPath+"/scroeadd.jsp")
                            ||url.contains(contextPath+"/classadd.jsp")||url.contains(contextPath+"/classmodify.jsp")
                            ||url.contains(contextPath+"/teaadd.jsp")||url.contains(contextPath+"/teaadd.jsp") ){*/
                        response.sendRedirect(contextPath + "/userlist");
                        return;
                    }
                }
                if (identity.equals("teacher")){
                    if (url.contains(contextPath+"/stu.add.jsp")||url.contains(contextPath+"/stu.modify.jsp")
                            ||url.contains(contextPath+"/tea.add.jsp")||url.contains(contextPath+"/tea.modify.jsp") ){
                        response.sendRedirect(contextPath + "/userlist");
                        return;
                    }
                }
                chain.doFilter(req, resp);
            }
        }

       // System.out.println("coming AccessFilter");
    }



    public void destroy() {

    }

}
