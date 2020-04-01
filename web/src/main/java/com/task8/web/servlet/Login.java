package com.task8.web.servlet;

import com.task8.model.Check;
import com.task8.model.Role;
import com.task8.model.User;
import com.task8.service.impl.CheckService;
import com.task8.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/Login")
public class Login extends HttpServlet {
 private UserService userService = (UserService) UserService.getInstance();
 private CheckService checkService = (CheckService) CheckService.getInstance();
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        Object authUser = rq.getSession().getAttribute("authUser");
        if (authUser == null) {
            try {
              //  rq.getRequestDispatcher("login").forward(rq, rs);
               rs.sendRedirect(rq.getContextPath() + "/registration.jsp");
            }
             catch (IOException e) {
                    throw new RuntimeException(e);
                }
              //  rs.sereforword("login", rq, rs);
        }
        try {
            rs.sendRedirect(rq.getContextPath() + "/");
          //  rs.sendRedirect(rq.getContextPath() +"/student");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) {
        String login = rq.getParameter("login");
        String password = rq.getParameter("password");
        User user = userService.login(login, password);
       if (user == null) {
            rq.setAttribute("error", "login or password invalid");
           try {
               rq.getRequestDispatcher("login.jsp").forward(rq,rs);
           } catch (ServletException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
        rq.setAttribute("user",user);
        rq.getSession().setAttribute("authUser", user);
        if (user.getRole()== Role.ADMIN){
            try {
                List<User> listUsers = userService.getUsersOfSystem();
                rq.setAttribute("users", listUsers);
                rq.getRequestDispatcher("admin.jsp").forward(rq,rs);
            } catch (IOException | ServletException e) {
                throw new RuntimeException(e);
            }
        }
        if (user.getRole()== Role.USERS){
            try {
                List<Check> listCheck = checkService.getChecks(user.getLogin());
                rq.setAttribute("listCheck", listCheck);
                rq.getRequestDispatcher("check.jsp").forward(rq,rs);
            } catch (IOException | ServletException e) {
                throw new RuntimeException(e);
            }
        }
       rq.setAttribute("user",user);
       rq.getSession().setAttribute("authUser", user);
        try {
            rq.getRequestDispatcher("check.jsp").forward(rq,rs);
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }
    }
} 