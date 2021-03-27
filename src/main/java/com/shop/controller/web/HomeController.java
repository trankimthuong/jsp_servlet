package com.shop.controller.web;

import com.shop.model.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        UserModel userModel = new UserModel();
        userModel.setFullName("Hello world");
        request.setAttribute("model", userModel);
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }
}
