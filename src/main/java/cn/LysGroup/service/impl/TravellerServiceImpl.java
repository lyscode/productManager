package cn.LysGroup.service.impl;

import cn.LysGroup.dao.TravellerDao;
import cn.LysGroup.domain.Traveller;
import cn.LysGroup.service.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravellerServiceImpl implements TravellerService {
    @Autowired
    private TravellerDao dao;
    @Override
    public List<Traveller> findById(int id) {
        return dao.findById(id);
    }
}
