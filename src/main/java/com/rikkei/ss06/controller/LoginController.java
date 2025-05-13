package com.rikkei.ss06.controller;

import com.rikkei.ss06.model.User;
import com.rikkei.ss06.service.Bai2.UserService;
import com.rikkei.ss06.service.Bai2.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
    private final UserService userService;

    public LoginController() {
        userService = new UserServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/Bai2/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.login(username, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userLogin", user);
            response.sendRedirect("view/Bai1/listBook.jsp");
        } else {
            request.setAttribute("error", "Invalid username or password");
            doGet(request, response);
        }

    }
}