package com.qf.Dao.Impl;

import com.qf.Dao.UserDao;
import com.qf.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @Override
    public List<User> all() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavendata?characterEncoding=utf8", "root", "root");
            String sql = "SELECT u_id id,u_name NAME,u_sex sex,u_age age FROM USER";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);
            List  list = new ArrayList<>();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSex(resultSet.getString("sex"));
                user.setAge(resultSet.getInt("age"));
                list.add(user);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
}

    @Override
    public Boolean deleteById(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavendata?characterEncoding=utf8", "root", "root");
            String sql = "delete from user where u_id=?";
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setObject(1,id);
            int i = preparedStatement.executeUpdate();
            if (i > 0){
               return true;
            }else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public User findById(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavendata?characterEncoding=utf8", "root", "root");
            String sql = "SELECT u_id id,u_name NAME,u_sex sex,u_age age FROM USER where u_id="+id;
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);
            User user = new User();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSex(resultSet.getString("sex"));
                user.setAge(resultSet.getInt("age"));
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Boolean update(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavendata?characterEncoding=utf8", "root", "root");
            if (user.getId()!=null){
                String sql = "update user set u_name=?,u_sex=?,u_age=? where u_id=?";
                preparedStatement= connection.prepareStatement(sql);
                preparedStatement.setObject(1,user.getName());
                preparedStatement.setObject(2,user.getSex());
                preparedStatement.setObject(3,user.getAge());
                preparedStatement.setObject(4,user.getId());
            }else {
                String sql = "INSERT INTO USER VALUES(?,?,?,?)";
                preparedStatement= connection.prepareStatement(sql);
                preparedStatement.setObject(1,user.getId());
                preparedStatement.setObject(2,user.getName());
                preparedStatement.setObject(3,user.getSex());
                preparedStatement.setObject(4,user.getAge());
            }



            int i = preparedStatement.executeUpdate();
            if (i > 0){
                return true;
            }else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
