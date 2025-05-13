package com.rikkei.ss06.controller;

import com.rikkei.ss06.model.User;
import com.rikkei.ss06.service.Bai2.UserService;
import com.rikkei.ss06.service.Bai2.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/RegisterController")
public class RegisterController extends HttpServlet {
    private final UserService userService;

    public RegisterController() {
        userService = new UserServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/Bai2/register.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        User newUser = new User(0, username, password, email, phone);
        if (userService.register(newUser)) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("error", "Registration failed");
            doGet(request, response);
        }
    }
}