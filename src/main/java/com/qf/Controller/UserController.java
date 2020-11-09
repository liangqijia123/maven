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
import java.util.List;

@WebServlet("/all")
public class UserController extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = userService.all();
        req.setAttribute("ulist",list);
        req.getRequestDispatcher("/user.jsp").forward(req,resp);
    }
}
