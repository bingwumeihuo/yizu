package com.yizu.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 带有分页的结果集封装
 * total 总记录数
 * list 带有分页的结果集
 * @author 式神
 */
public class PageResult<E> implements Serializable{
    private long total;
    private List<E> list;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public PageResult(){

    }

    public PageResult(long total, List<E> list) {
        this.total = total;
        this.list = list;
    }
}
