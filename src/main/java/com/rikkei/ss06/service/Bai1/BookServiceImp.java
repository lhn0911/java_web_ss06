package com.rikkei.ss06.service.Bai1;

import com.rikkei.ss06.dao.Bai1.BookDao;
import com.rikkei.ss06.dao.Bai1.BookDaoImp;
import com.rikkei.ss06.model.Book;

import java.util.List;

public class BookServiceImp implements BookService{
    private final BookDao bookDao;

    public BookServiceImp() {
        bookDao = new BookDaoImp();
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookDao.findById(id);
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book);
    }

    @Override
    public boolean delete(int id) {
        return bookDao.delete(id);
    }

    @Override
    public boolean save(Book book) {
        return bookDao.save(book);
    }
}
