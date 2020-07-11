package cn.LysGroup.service;

import cn.LysGroup.domain.Orders;

import java.util.List;

public interface OrdersService {
    /**
     * 查询所有的订单信息
     * @return
     * @throws Exception
     * @param page
     * @param size
     */
    List<Orders> findAll(int page, int size) throws Exception;

    /**
     * 查询总记录数
     * @return
     */
    Integer findCount();

    /**
     * 通过id查询订单
     * @param id
     * @return
     */
    Orders findById(int id);
}
