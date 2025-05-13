package com.rikkei.ss06.dao.Bai3;

import com.rikkei.ss06.model.ProductCart;

import java.util.List;

public class ProductCartDaoImp implements ProductCartDao{
    @Override
    public List<ProductCart> findByUserId(int userId) {
        return List.of();
    }

    @Override
    public boolean save(ProductCart cart) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
