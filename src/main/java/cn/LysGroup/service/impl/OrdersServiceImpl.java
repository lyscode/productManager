package cn.LysGroup.service.impl;

import cn.LysGroup.dao.OrdersDao;
import cn.LysGroup.domain.Orders;
import cn.LysGroup.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao dao;
    @Override
    public List<Orders> findAll(int page, int size) throws Exception {
        //执行分页，每页显示五条信息,只能放在要执行语句的上一句，才能起到分页的效果
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public Integer findCount() {
        return dao.findCount();
    }

    @Override
    public Orders findById(int id) {
        return dao.findById(id);
    }

}
