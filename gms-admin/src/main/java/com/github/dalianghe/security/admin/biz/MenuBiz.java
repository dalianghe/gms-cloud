package com.github.dalianghe.security.admin.biz;

import com.github.dalianghe.security.admin.entity.Menu;
import com.github.dalianghe.security.admin.mapper.MenuMapper;
import com.github.dalianghe.security.common.biz.BaseBiz;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2018/1/20.
 */
@Service
public class MenuBiz extends BaseBiz<MenuMapper , Menu> {

    /**
     * 获取用户可以访问的菜单
     * @param id
     * @return
     */
    public List<Menu> getUserAuthorityMenuByUserId(int id){
        return mapper.selectAuthorityMenuByUserId(id);
    }

}
