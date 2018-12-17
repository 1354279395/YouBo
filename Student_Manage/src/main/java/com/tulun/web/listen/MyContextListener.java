package com.tulun.web.listen; /**
 * 描述:
 *
 * @Author shilei
 * @Date 2018/12/1
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener()
public class MyContextListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // 统计用户数量
    private AtomicInteger userCount;
    // 统计后台每个页面的访问量
    private Map<String, Integer> requestUrlMap;

    // Public constructor is required by servlet spec
    public MyContextListener() {
        userCount = new AtomicInteger(0);
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // 下面两个方式是在Tomcat给当前App应用创建Context对象初始化的时候和
    // Tomcat关闭或者重启的时候才调用的 <= 监听上下文的创建和关闭
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
         request : 一次请求过程中
         session ： 用户整个会话的周期内
         context ： 整个webapp应用内所有用户，所有servlet都共享的数据
      */
//        sce.getServletContext().setAttribute("UsersNumber", 0);

    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // 监听每一个用户的会话创建的，Tomcat给一个新用户创建session会话，
    // sessionCreated这个函数会被调用到； sessionDestroyed在当前
    // 用户会话超时或者失效(session.invalidate();)的时候会被调用到
    // el表达式，如：${UsersNumber}，默认就会去request，session，context
    // 里面的属性去寻找
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
//        ServletContext context = se.getSession().getServletContext();
//
//        synchronized (Object.class){
//            Integer num = (Integer)context.getAttribute("UsersNumber");
//            num++;
//            context.setAttribute("UsersNumber", num);
//        }
       // userCount.getAndIncrement();
       // System.out.println("当前的： "+userCount);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
//        ServletContext context = se.getSession().getServletContext();
//
//        synchronized (Object.class){
//            Integer num = (Integer)context.getAttribute("UsersNumber");
//            num--;
//            context.setAttribute("UsersNumber", num);
//        }
        userCount.getAndDecrement();
        se.getSession().setAttribute("userCount",userCount.get());
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // attributeAdded  session.setAttribute(key, Object) 新添加属性
    // attributeRemoved  session.removeAttribute(key) 删除属性
    // attributeReplaced session.setAttribute(key, Object) 属性修改
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
        String key = sbe.getName();
        Object value = sbe.getValue();
        if("login_state".equals(key)){
            userCount.getAndIncrement();
            sbe.getSession().setAttribute("userCount",userCount.get());
        }
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
