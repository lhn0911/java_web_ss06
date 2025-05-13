package com.rikkei.ss06.service.Bai3;

import com.rikkei.ss06.dao.Bai3.ProductDao;
import com.rikkei.ss06.dao.Bai3.ProductDaoImp;
import com.rikkei.ss06.model.Product;

import java.util.List;

public class ProductServiceImp implements ProductService{
    private final ProductDao productDao;

    public ProductServiceImp() {
        productDao = new ProductDaoImp();
    }
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }
}
