package cn.LysGroup.service.impl;

import cn.LysGroup.dao.UserDao;
import cn.LysGroup.domain.Role;
import cn.LysGroup.domain.UserId_Ids;
import cn.LysGroup.domain.UserInfo;
import cn.LysGroup.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service("userService")
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserDao  dao;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 这是spring security 的登录权限控制，根据名称查询用户，然后交给框架去处理
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=null;
        try {
            userInfo = dao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象封装成UserDetails
        User user=new User(userInfo.getUsername(),userInfo.getPassword(),
                            userInfo.getStatusStr(),true,true,
                true,getAuthority(userInfo.getRoles()));
        return user;
    }

    /**
     * 返回一个权限信息
     * @param roles
     * @return
     */
    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list=new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll(int page,int size) {
        List<UserInfo> all=null;
        try {
            PageHelper.startPage(page,size);
            all = dao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    @Override
    public void saveUser(UserInfo userInfo) {
        String userInfoPassword = userInfo.getPassword();
        //将密码进行加密
        String encode = passwordEncoder.encode(userInfoPassword);
        userInfo.setPassword(encode);
        try {
            dao.saveUser(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserInfo findById(int id) {
        UserInfo userInfo=null;
        try {
             userInfo=dao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    @Override
    public void saveUser_Role(UserId_Ids userId_ids) {
        try {
            dao.saveUser_Role(userId_ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
