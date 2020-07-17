package cn.LysGroup.dao;

import cn.LysGroup.domain.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    /**
     * 通过用户名查询users
     * @param username
     * @return
     * @throws Exception
     */
    UserInfo findByUsername(String  username) throws Exception;
}
