package controller;

import dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        Integer deleteUserId=Integer.valueOf(request.getParameter("userId"));
        out.print("被删除的userId为："+deleteUserId);
        UserDao userDao=new UserDao();
        int result=userDao.delete(deleteUserId);
        if (result==1){
            out.print(deleteUserId+"号信息删除成功");
            response.sendRedirect("find");
        }
        else{
            out.print(deleteUserId+"删除失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
