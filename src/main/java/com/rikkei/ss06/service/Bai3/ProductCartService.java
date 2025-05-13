package com.rikkei.ss06.service.Bai3;

import com.rikkei.ss06.model.ProductCart;

import java.util.List;

public interface ProductCartService {
    List<ProductCart> findByUserId(int userId);
    boolean save(ProductCart cart);
    boolean delete(int id);
}
