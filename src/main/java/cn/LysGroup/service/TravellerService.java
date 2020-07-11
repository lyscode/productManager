package cn.LysGroup.service;

import cn.LysGroup.domain.Traveller;

import java.util.List;

public interface TravellerService {
    /**
     * 根据id查询旅客
     * @param id
     * @return
     */
    List<Traveller> findById(int id);
}
