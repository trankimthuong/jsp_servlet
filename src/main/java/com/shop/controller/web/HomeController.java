package com.shop.controller.web;

import com.shop.model.UserModel;
import com.shop.service.ICategoryService;
import com.shop.service.INewService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet {
    @Inject
    private ICategoryService categoryService;

    @Inject
    private INewService newService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Long code = 1L;
        request.setAttribute("news", newService.findByCategoryId(code));
        request.setAttribute("categories", categoryService.findAll());
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }
}
