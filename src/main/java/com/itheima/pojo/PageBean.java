package com.itheima.pojo;

import java.util.List;

/**
 * @Auther: 胡桃
 * @Date: 2022-11-15 19:52
 * @Description: com.itheima.pojo
 * @version: 1.0
 */
public class PageBean<T> {
    private Integer totalCount;
    private List<T> rows;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
