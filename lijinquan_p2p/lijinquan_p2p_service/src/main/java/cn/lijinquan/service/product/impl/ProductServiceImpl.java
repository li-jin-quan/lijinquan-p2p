package cn.lijinquan.service.product.impl;

import cn.lijinquan.domain.Product;
import cn.lijinquan.service.product.IProductService;
import dao.product.IProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lijinquan on 2019/5/7.
 */
@Service
public class ProductServiceImpl implements IProductService {


    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }
}
