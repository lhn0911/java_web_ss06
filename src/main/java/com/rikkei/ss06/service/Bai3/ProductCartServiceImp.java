package com.rikkei.ss06.service.Bai3;

import com.rikkei.ss06.dao.Bai3.ProductCartDao;
import com.rikkei.ss06.dao.Bai3.ProductCartDaoImp;
import com.rikkei.ss06.dao.Bai3.ProductDaoImp;
import com.rikkei.ss06.model.ProductCart;

import java.util.List;

public class ProductCartServiceImp implements ProductCartService{
    private final ProductCartDao productCartDao;

    public ProductCartServiceImp() {
        productCartDao = new ProductCartDaoImp();
    }
    @Override
    public List<ProductCart> findByUserId(int userId) {
        return productCartDao.findByUserId(userId);
    }

    @Override
    public boolean save(ProductCart cart) {
        return productCartDao.save(cart);
    }

    @Override
    public boolean delete(int id) {
        return productCartDao.delete(id);
    }
}
