package cn.LysGroup.dao;

import cn.LysGroup.domain.UserId_Ids;
import cn.LysGroup.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    /**
     * 通过id查询用户的详细信息
     * @param id
     * @return
     */
    UserInfo findById(int id);

    /**
     * 给用户添加角色
     * @param userId_ids
     */
    void saveUser_Role(UserId_Ids userId_ids);
}
