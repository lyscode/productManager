package cn.LysGroup.service.impl;

import cn.LysGroup.dao.ProductDao;
import cn.LysGroup.domain.Product;
import cn.LysGroup.service.ProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao dao;
    @Override
    public List<Product> findAll(int page,int size) throws Exception {
        //分页查询
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        dao.save(product);
    }
}
