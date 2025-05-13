package com.rikkei.ss06.controller;

import com.rikkei.ss06.model.Product;
import com.rikkei.ss06.model.ProductCart;
import com.rikkei.ss06.service.Bai3.ProductCartService;
import com.rikkei.ss06.service.Bai3.ProductCartServiceImp;
import com.rikkei.ss06.service.Bai3.ProductService;
import com.rikkei.ss06.service.Bai3.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/ProductController")
public class ProductController extends HttpServlet {
    private final ProductService productService;
    private final ProductCartService productCartService;

    public ProductController() {
        productService = new ProductServiceImp();
        productCartService = new ProductCartServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productService.findAll();
        request.setAttribute("products", list);
        request.getRequestDispatcher("view/Bai3/listProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        int userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());
        int quantity = 1;
        ProductCart cart = new ProductCart(0, userId, productId, quantity);
        productCartService.save(cart);
        response.sendRedirect("ProductController");
    }
}