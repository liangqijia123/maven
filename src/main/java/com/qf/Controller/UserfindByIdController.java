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

@WebServlet("/findById")
public class UserfindByIdController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int ids = Integer.valueOf(id);
        User user = userService.findById(ids);
        req.setAttribute("user",user);
        req.getRequestDispatcher("/update.jsp").forward(req,resp);
    }
}
