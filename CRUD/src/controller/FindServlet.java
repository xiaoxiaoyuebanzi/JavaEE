package controller;

import dao.UserDao;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        UserDao userDao=new UserDao();
        List<User> userList =new ArrayList();
        userList =userDao.findUser();
        out.print("<center>");
        out.print("<table border=2px>");
        out.print("<tr>");
        out.print("<td>序号</td>"+"<td>账号</td>"+"<td>密码</td>"+"<td>性别</td>"+"<td>邮箱</td>"+"<td>操作</td>");
        out.print("<tr>");

        for (User user:userList) {
            Integer userId=user.getUserId();
            String userName=user.getUserName();
            String password=user.getPassword();
            String sex=user.getSex();
            String email=user.getEmail();
            out.print("<tr>");
            out.print("<td>"+userId+"</td>"+"<td>"+userName+"</td>"+"<td>"+password+"</td>"+"<td>"+sex+"</td>"+"<td>"+email+"</td>"+ "<td>"+"<a href=\"/myWeb/user/delete?userId="+userId+"\">删除用户</a>"+"</td>");
            out.print("<tr>");
        }
        out.print("</table>");
        out.print("</center>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
