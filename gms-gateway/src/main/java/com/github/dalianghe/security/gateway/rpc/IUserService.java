package com.github.dalianghe.security.gateway.rpc;

import com.github.dalianghe.security.api.vo.user.UserInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 2018/1/20.
 */
@FeignClient("admin-back")
public interface IUserService {

    @RequestMapping(value = "/user/username/{username}", method = RequestMethod.GET)
    public UserInfo getUserByUsername(@PathVariable("username") String username);

}
