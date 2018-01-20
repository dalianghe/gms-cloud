package com.github.dalianghe.security.admin.rpc;

import com.alibaba.fastjson.JSONObject;
import com.github.dalianghe.security.admin.biz.MenuBiz;
import com.github.dalianghe.security.admin.biz.UserBiz;
import com.github.dalianghe.security.admin.entity.Menu;
import com.github.dalianghe.security.admin.entity.User;
import com.github.dalianghe.security.admin.vo.MenuTree;
import com.github.dalianghe.security.api.vo.user.UserInfo;
import com.github.dalianghe.security.common.utils.TreeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/1/20.
 */
@Controller
public class UserServiceImpl {

    @Autowired
    private UserBiz userBiz;
    @Autowired
    private MenuBiz menuBiz;

    @RequestMapping(value = "/user/username/{username}",method = RequestMethod.GET, produces="application/json")
    public  @ResponseBody UserInfo getUserByUsername(@PathVariable("username")String username) {
        UserInfo info = new UserInfo();
        User user = userBiz.getUserByUsername(username);
        BeanUtils.copyProperties(user,info);
        info.setId(user.getId().toString());
        return info;
    }

    @RequestMapping(value = "/user/un/{username}/menu/parent/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public String getMenusByUsername(@PathVariable("username") String username,@PathVariable("parentId")Integer parentId){
        int userId = userBiz.getUserByUsername(username).getId();
        /*try {
            if (parentId == null||parentId<0) {
                parentId = menuBiz.getUserAuthoritySystemByUserId(userId).get(0).getId();
            }
        } catch (Exception e) {
            return JSONObject.toJSONString(new ArrayList<MenuTree>());
        }*/
        return JSONObject.toJSONString(getMenuTree(menuBiz.getUserAuthorityMenuByUserId(userId), 13));
    }

    private List<MenuTree> getMenuTree(List<Menu> menus, int root) {
        List<MenuTree> trees = new ArrayList<MenuTree>();
        MenuTree node = null;
        for (Menu menu : menus) {
            node = new MenuTree();
            BeanUtils.copyProperties(menu, node);
            trees.add(node);
        }
        return TreeUtils.bulid(trees, root) ;
    }

}
