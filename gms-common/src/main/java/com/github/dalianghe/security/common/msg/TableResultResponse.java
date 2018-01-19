package com.github.dalianghe.security.common.msg;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-14 22:40
 */
@Data
@ToString
public class TableResultResponse<T> {
    int total;
    List<T> rows;

    public TableResultResponse(int total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public TableResultResponse() {
    }

    TableResultResponse<T> total(int total){
        this.total = total;
        return this;
    }
    TableResultResponse<T> total(List<T> rows){
        this.rows = rows;
        return this;
    }

}
