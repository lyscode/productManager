package cn.LysGroup.dao;

import cn.LysGroup.domain.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersDao {
    /**
     * 查询所有订单信息
     * @return
     */
    List<Orders> findAll();

    /**
     * 查询总记录数
     * @return
     */
    Integer findCount();

    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    Orders findById(int id);

}
