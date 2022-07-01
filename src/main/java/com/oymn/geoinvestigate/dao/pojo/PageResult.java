package com.oymn.geoinvestigate.dao.pojo;

import java.util.List;

public class PageResult<T> {
    
    private Integer total;
    
    private List<T> data;

    public PageResult(Integer total, List<T> data) {
        this.total = total;
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
