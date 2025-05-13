package com.rikkei.ss06.dao.Bai3;

import com.rikkei.ss06.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();
    Product findById(int id);
}
