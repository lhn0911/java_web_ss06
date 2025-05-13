package com.rikkei.ss06.dao.Bai3;

import com.rikkei.ss06.model.ProductCart;

import java.util.List;

public interface ProductCartDao {
    List<ProductCart> findByUserId(int userId);
    boolean save(ProductCart cart);
    boolean delete(int id);
}
