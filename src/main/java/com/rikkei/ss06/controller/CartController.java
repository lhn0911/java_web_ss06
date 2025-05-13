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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CartController", value = "/CartController")
public class CartController extends HttpServlet {
    private final ProductService productService;
    private final ProductCartService productCartService;

    public CartController() {
        productService = new ProductServiceImp();
        productCartService = new ProductCartServiceImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getSession().getAttribute("userId").toString());
        List<ProductCart> carts = productCartService.findByUserId(userId);
        List<Map<String, Object>> cartDetails = new ArrayList<>();
        double total = 0;

        for (ProductCart cart : carts) {
            Product product = productService.findById(cart.getProductId());
            double amount = product.getPrice() * cart.getQuantity();
            total += amount;
            Map<String, Object> item = new HashMap<>();
            item.put("cart", cart);
            item.put("product", product);
            item.put("amount", amount);
            cartDetails.add(item);
        }

        request.setAttribute("cartDetails", cartDetails);
        request.setAttribute("total", total);
        request.getRequestDispatcher("view/Bai3/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cartId = Integer.parseInt(request.getParameter("cartId"));
        productCartService.delete(cartId);
        response.sendRedirect("CartController");
    }
}