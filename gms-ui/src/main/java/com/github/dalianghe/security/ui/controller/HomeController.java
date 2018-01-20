package com.github.dalianghe.security.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by admin on 2018/1/20.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(Map<String,Object> map){
        return "index";
    }

}
