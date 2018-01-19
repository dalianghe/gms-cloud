package com.github.dalianghe.security.admin.biz;

import com.github.dalianghe.security.admin.entity.User;
import com.github.dalianghe.security.admin.mapper.UserMapper;
import com.github.dalianghe.security.common.biz.BaseBiz;
import org.springframework.stereotype.Service;

@Service
public class UserBiz extends BaseBiz<UserMapper , User> {

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    public User getUserByUsername(String username){
        User user = new User();
        user.setUsername(username);
        return mapper.selectOne(user);
    }

}
