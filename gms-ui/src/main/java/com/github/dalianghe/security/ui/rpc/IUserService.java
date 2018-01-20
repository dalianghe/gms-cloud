package com.github.dalianghe.security.ui.rpc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 2018/1/20.
 */
@FeignClient("admin-back")
public interface IUserService {

    @RequestMapping(value = "/user/un/{username}/menu/parent/{parentId}", method = RequestMethod.GET)
    public String getMenusByUsername(@PathVariable("username") String username, @PathVariable("parentId") Integer parentId);

}
