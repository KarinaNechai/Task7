package com.task8.web.servlet;

import com.task8.model.User;
import com.task8.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {
    private UserService userService = (UserService) UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        Object authUser = rq.getSession().getAttribute("authUser");
        List<User> listUsers = userService.getUsersOfSystem();
        rq.setAttribute("users", listUsers);
        rq.getRequestDispatcher("admin.jsp").forward(rq, rs);
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String userLoginDel = rq.getParameter("Delete");
        String userLoginUpdate = rq.getParameter("Update");
        String userLoginSave = rq.getParameter("Save");
        if (userLoginDel!=null)
        {
            userService.deleteUser( userLoginDel);
            rq.setAttribute("users", userService.getUsersOfSystem());
            rq.getRequestDispatcher("admin.jsp").forward(rq, rs);
        }
        if (userLoginUpdate!=null)
        {
            rq.setAttribute("userUpdate",userService.getUser(userLoginUpdate));
            rq.getRequestDispatcher("admin.jsp").forward(rq, rs);
        }
        if (userLoginSave!=null)
        {
            userService.updateUser(userService.getUser(userLoginSave));
            rq.setAttribute("users", userService.getUsersOfSystem());
            rq.getRequestDispatcher("admin.jsp").forward(rq, rs);
        }
        if (rq.getParameter("Logout")!=null)
        {
            rq.getSession().setAttribute("authUser", null);
            rq.setAttribute("users", null);
            rq.getRequestDispatcher("login.jsp").forward(rq, rs);
        }
    }
}

