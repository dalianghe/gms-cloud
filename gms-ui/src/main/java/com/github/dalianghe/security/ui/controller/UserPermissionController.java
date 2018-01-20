package com.github.dalianghe.security.ui.controller;
import com.github.dalianghe.security.ui.rpc.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 2018/1/20.
 */
@Controller
public class UserPermissionController{

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/user/menu",method = RequestMethod.GET)
    @ResponseBody
    public String getUserMenu(@RequestParam(defaultValue = "-1") Integer parentId){
        return userService.getMenusByUsername("admin",parentId);
    }

}
