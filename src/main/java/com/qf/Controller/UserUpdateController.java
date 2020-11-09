package com.qf.Controller;

import com.qf.Service.Impl.UserServiceImpl;
import com.qf.Service.UserService;
import com.qf.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UserUpdateController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Integer ids = id.length() > 0?Integer.valueOf(id):null;
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        int ages = Integer.valueOf(age);
        User user = new User();
        user.setId(ids);
        user.setName(name);
        user.setSex(sex);
        user.setAge(ages);

        Boolean b = userService.update(user);
        if (b){
            resp.sendRedirect("/all");
        }
    }
}
