package cn.LysGroup.dao;

import cn.LysGroup.domain.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {
    /**
     * 通过id查询member
     * @param id
     * @return
     */
    Member findById(int id);
}
