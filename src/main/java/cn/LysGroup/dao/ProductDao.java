package cn.LysGroup.dao;

import cn.LysGroup.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {
    /**
     * 根据id查询产品
     * @param id
     * @return
     * @throws Exception
     */
    Product findById(String id) throws Exception;

    /**
     * 查询所有的产品信息
     * @return
     * @throws Exception
     */
    List<Product> findAll() throws Exception;

    /**
     * 保存产品
     * @param product
     */
    void save(Product product);
}
