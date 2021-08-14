package dao;

import entity.User;
import utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {
    public int addUser(User user){
        String sql="insert into users(userName,password,sex,email) values(?,?,?,?)";
        int result=0;
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn=JdbcUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            result=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }

        return result;
    }

    public List findUser(){
        String sql="select userId,userName,password,sex,email from users";
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        User user=null;
        List userList=new ArrayList();
        try {
            conn=JdbcUtil.getConn();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Integer userId=rs.getInt("userId");
                String userName=rs.getString("userName");
                String password=rs.getString("password");
                String sex=rs.getString("sex");
                String email=rs.getString("email");
                user=new User(userId,userName,password,sex,email);
                userList.add(user);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
        return userList;
    }

    public int delete(Integer deleteUserId){
        String sql="delete from users where userId=?";
        Connection conn=null;
        PreparedStatement ps=null;
        int result=0;
        try {
            conn=JdbcUtil.getConn();
            ps=conn.prepareStatement(sql);
            String id=String.valueOf(deleteUserId);
            ps.setString(1, id);
            result=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
        return result;
    }

    public int login(String userName,String password) {
        String sql="select count(*) from users where userName=? and password=?";
        int result=0;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=JdbcUtil.getConn();
            ps=conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs=ps.executeQuery();
            if (rs.next()){
                result=rs.getInt("count(*)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(ps,conn);
        }
        return result;
    }
}
