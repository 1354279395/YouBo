package com.tulun.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 描述:
 *
 * @Author shilei
 * @Date 2018/12/1
 */
@WebFilter(filterName = "CharactorFilter", urlPatterns = "/*")
public class CharacterFilter implements Filter {

    // Tomcat初始化的时候生成Filter对象
    public void init(FilterConfig config) throws ServletException {

    }

    //
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setCharacterEncoding("utf8");

        //System.out.println("coming CharacterFilter");

        // 这句代码的上面，是请求到达filter，但是还没交给servlet的时候
        chain.doFilter(req, resp);
        // 这句代码的下面，是请求处理完了，响应到达的时候

       // System.out.println("going CharacterFilter");
    }

    // Tomcat关闭或者重启的时候，会调用filter的destroy函数
    public void destroy() {
    }
}
