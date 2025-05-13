package com.rikkei.ss06.dao.Bai3;

import com.rikkei.ss06.model.ProductCart;
import com.rikkei.ss06.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductCartDaoImp implements ProductCartDao{
    @Override
    public List<ProductCart> findByUserId(int userId) {
        List<ProductCart> carts = new ArrayList<>();
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_cart_by_user(?)}");
            callSt.setInt(1, userId);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                ProductCart cart = new ProductCart();
                cart.setId(rs.getInt("id"));
                cart.setUserId(userId);
                cart.setQuantity(rs.getInt("quantity"));
                carts.add(cart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return carts;
    }

    @Override
    public boolean save(ProductCart cart) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call insert_product_cart(?,?,?)}");
            callSt.setInt(1, cart.getUserId());
            callSt.setInt(2, cart.getProductId());
            callSt.setInt(3, cart.getQuantity());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
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
            callSt = conn.prepareCall("{call delete_cart_item(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }
}
