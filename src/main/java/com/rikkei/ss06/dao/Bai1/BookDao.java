package com.rikkei.ss06.dao.Bai1;

import com.rikkei.ss06.model.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAll();
    Book findById(int id);
    boolean update(Book book);
    boolean delete(int id);
    boolean save(Book book);
}
