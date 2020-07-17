package cn.LysGroup.service;

import cn.LysGroup.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {
    /**
     * 查询所有的用户
     * @return
     */
    List<UserInfo> findAll(int page,int size);

    /**
     * 保存用户
     * @param userInfo
     */
    void saveUser(UserInfo userInfo);
}
