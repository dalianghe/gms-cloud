package com.github.dalianghe.security.admin;

import com.github.dalianghe.security.admin.biz.UserBiz;
import com.github.dalianghe.security.admin.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserBiz userBiz;

    @Test
    public void testUser() throws Exception{
        User user = userBiz.getUserByUsername("admin");
        System.out.println(user.toString());
    }

}
