package com.rikkei.ss06.service.Bai3;

import com.rikkei.ss06.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
}
