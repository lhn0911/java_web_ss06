package com.rikkei.ss06.controller;

import com.rikkei.ss06.dao.Bai1.BookDao;
import com.rikkei.ss06.model.Book;
import com.rikkei.ss06.service.Bai1.BookService;
import com.rikkei.ss06.service.Bai1.BookServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookController", value = "/BookController")
public class BookController extends HttpServlet {
    private final BookService bookService;

    public BookController() {
        bookService = new BookServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userLogin") == null) {
            response.sendRedirect("LoginController");
            return;
        }
        String action = request.getParameter("action");
        if (action == null || action.equals("list")) {
            List<Book> books = bookService.findAll();
            request.setAttribute("books", books);
            request.getRequestDispatcher("view/Bai1/listBook.jsp").forward(request, response);
        } else if (action.equals("add")) {
            request.getRequestDispatcher("view/Bai1/formAdd.jsp").forward(request, response);
        } else if (action.equals("edit")) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                Book book = bookService.findById(id);
                request.setAttribute("book", book);
                request.getRequestDispatcher("view/Bai1/formEdit.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                response.sendRedirect("BookController");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action.equals("create")) {
                String title = request.getParameter("title");
                String author = request.getParameter("author");
                String genre = request.getParameter("genre");
                int quantity = Integer.parseInt(request.getParameter("quantity"));

                Book book = new Book();
                book.setTitle(title);
                book.setAuthor(author);
                book.setGenre(genre);
                book.setQuantity(quantity);

                bookService.save(book);


            } else if (action.equals("update")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String title = request.getParameter("title");
                String author = request.getParameter("author");
                String genre = request.getParameter("genre");
                int quantity = Integer.parseInt(request.getParameter("quantity"));

                Book book = new Book(id,title, author, genre, quantity);
                bookService.update(book);

            } else if (action.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                bookService.delete(id);
            }

            response.sendRedirect("BookController");

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}