package cn.LysGroup.dao;

import cn.LysGroup.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    /**
     * 通过用户名查询users
     * @param username
     * @return
     * @throws Exception
     */
    UserInfo findByUsername(String  username) throws Exception;

    /**
     * 查询所有用户
     * @return
     */
    List<UserInfo> findAll();

    /**
     * 保存用户
     * @param userInfo
     */
    void saveUser(UserInfo userInfo);
}
