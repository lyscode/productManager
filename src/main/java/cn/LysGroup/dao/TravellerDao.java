package cn.LysGroup.dao;

import cn.LysGroup.domain.Traveller;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravellerDao {
    /**
     * 根据id查询旅客
     * @param id
     * @return
     */
    List<Traveller> findById(int id);
}
