package controller;

import dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out= response.getWriter();
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        int result=0;
        UserDao userDao=new UserDao();
        result=userDao.login(userName,password);
        if (result>0){
            response.sendRedirect("/myWeb/index.html");
        }else{
            response.sendRedirect("/myWeb/login_failure.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
