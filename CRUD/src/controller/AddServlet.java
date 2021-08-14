package controller;

import dao.UserDao;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        String username=request.getParameter("userName");
        String password=request.getParameter("password");
        String sex=request.getParameter("sex");
        String email=request.getParameter("email");

        out.print("账号:"+username+"</br>");
        out.print("密码:"+password+"</br>");
        out.print("性别:"+sex+"</br>");
        out.print("邮箱:"+email+"</br>");

        User user=new User(null,username,password,sex,email);
        UserDao userDao=new UserDao();
        int result=userDao.addUser(user);
        if (result==1){
            response.sendRedirect("/myWeb/login.html");
        }
        if (result==0){
            response.sendRedirect("/myWeb/register.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
