package com.rikkei.ss06.dao.Bai1;

import com.rikkei.ss06.model.Book;
import com.rikkei.ss06.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImp implements BookDao{
    @Override
    public List<Book> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Book> listBook = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_Book()}");
            ResultSet rs = callSt.executeQuery();
            listBook = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book();
                callSt.setInt(1, rs.getInt("Book_id"));
                callSt.setString(2, rs.getString("Book_title"));
                callSt.setString(3, rs.getString("Book_author"));
                callSt.setString(4, rs.getString("Book_genre"));
                callSt.setInt(5, rs.getInt("Book_quantity"));
                listBook.add(book);
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listBook;
    }

    @Override
    public Book findById(int id) {

        Connection conn = null;
        CallableStatement callSt = null;
        Book book = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_Book_ById(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            book = new Book();
            if (rs.next()) {
                book.setId(rs.getInt("Book_id"));
                book.setTitle(rs.getString("Book_title"));
                book.setAuthor(rs.getString("Book_author"));
                book.setGenre(rs.getString("Book_genre"));
                book.setQuantity(rs.getInt("Book_quantity"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return book;
    }

    @Override
    public boolean update(Book book) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call updateBook(?,?,?,?,?)}");
            callSt.setInt(1, book.getId());
            callSt.setString(2, book.getTitle());
            callSt.setString(3, book.getAuthor());
            callSt.setString(4, book.getGenre());
            callSt.setInt(5, book.getQuantity());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call deleteBook(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;

    }

        @Override
        public boolean save(Book book) {
            Connection conn = null;
            CallableStatement callSt = null;
            boolean result = false;
            try {
                conn = ConnectionDB.openConnection();
                callSt = conn.prepareCall("{call save(?,?,?,?)}");
                callSt.setString(1, book.getTitle());
                callSt.setString(2, book.getAuthor());
                callSt.setString(3, book.getGenre());
                callSt.setInt(4, book.getQuantity());
                callSt.executeUpdate();
                result = true;
            } catch (Exception e) {
                e.fillInStackTrace();
            } finally {
                ConnectionDB.closeConnection(conn, callSt);
            }
            return result;
        }
}
