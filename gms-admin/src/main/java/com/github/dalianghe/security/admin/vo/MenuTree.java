package com.github.dalianghe.security.admin.vo;

import com.github.dalianghe.security.common.vo.TreeNode;
import lombok.Data;
import lombok.ToString;

/**
 * Created by Ace on 2017/6/12.
 */
@Data
@ToString
public class MenuTree extends TreeNode {
    String icon;
    String title;
    String href;
    boolean spread = false;

    public MenuTree() {
    }

    public MenuTree(int id, String name, int parentId) {
        this.id = id;
        this.parentId = parentId;
        this.title = name;
    }
    public MenuTree(int id, String name, MenuTree parent) {
        this.id = id;
        this.parentId = parent.getId();
        this.title = name;
    }

}
