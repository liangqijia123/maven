package com.qf.Controller;

import com.qf.Service.Impl.UserServiceImpl;
import com.qf.Service.UserService;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/deleteById")
public class UserDeleteByIdController extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int ids = Integer.valueOf(id);
        Boolean b = userService.deleteById(ids);
        if (b){
            resp.sendRedirect("/all");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
