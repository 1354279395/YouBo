package com.tulun.web.servlet;


import com.tulun.bean.Score;
import com.tulun.web.controller.Scorecontroller;
import com.tulun.web.listen.MyContextListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;



@WebServlet(name = "ScoreServlet", urlPatterns = "/scorelist")
public class ScoreServlet extends BaseServlet {

    private MyContextListener myConnectionManager;

   private Map<Integer, Score> scoreMap; // class Entry key value

    public ScoreServlet() throws SQLException {

        scoreMap=new ConcurrentHashMap<>();
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 实现浏览器客户端发送的请求的具体逻辑
        // 添加编码格式的处理   Tomcat  iso-8859-1编码方式
        super.service(request, response);
    }


    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Scorecontroller sc = new Scorecontroller();
        int size = sc.quert();
        for (int i = 0; i < size; i++) {
            Score score = sc.query(i + 1);
            if (score == null) {
                size++;
            }else {
                scoreMap.put(i + 1, score);
            }
        }
        request.setAttribute("scores", scoreMap);
        request.getRequestDispatcher("score/score.jsp").forward(request, response);
    }
    public void addbefore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("101");
        request.getRequestDispatcher("score/scroe.add.jsp").forward(request,response);
    }

    public void addafter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("uid"));
        String name = request.getParameter("name");
        Double mark = Double.parseDouble(request.getParameter("mark"));
        Integer sId = Integer.parseInt(request.getParameter("sId"));
        if (scoreMap.containsKey(id)){
            request.setAttribute("error", "班号已存在");
            response.sendRedirect("scorelist");
            return;
        }
        Scorecontroller sc = new Scorecontroller();
        Score score = new Score(id, name, mark, sId);
        sc.add(score);
        System.out.println(score);
        scoreMap.clear();

        response.sendRedirect("scorelist");
    }

    public void mod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("uid"));
        Score score = scoreMap.get(id);
            request.setAttribute("score", score);
            // 修改页面的跳转
            request.getRequestDispatcher("score/scroe.modify.jsp").forward(request, response);
    }

    public void modifyScore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("uid"));
        String name = request.getParameter("name");
        Double mark = Double.parseDouble(request.getParameter("mark"));
        Integer sId = Integer.parseInt(request.getParameter("sId"));
        Scorecontroller sc = new Scorecontroller();
        Score score = new Score(id, name, mark, sId);
        sc.modify(score);
        response.sendRedirect("scorelist");
    }

    public void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("uid"));
        Scorecontroller sc = new Scorecontroller();
        sc.remove(id);
        scoreMap.clear();

        response.sendRedirect("scorelist");
    }

}
