package cn.LysGroup.service;

import cn.LysGroup.domain.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询所有的产品信息
     * @return
     * @throws Exception
     */
    List<Product> findAll() throws Exception;

    /**
     * 保存产品
     * @param product
     * @throws Exception
     */
    void save(Product product) throws Exception;
}
