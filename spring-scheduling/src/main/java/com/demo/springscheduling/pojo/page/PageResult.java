package com.demo.springscheduling.pojo.page;

import lombok.Data;

import java.util.List;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in
 * @Modified :
 **/
@Data
public class PageResult<T> {
    private Long totalPage;
    private int pageSize;
    private int currentPage;
    private List<T> brands;


    public PageResult(Long totalPage, int pageSize, int currentPage, List<T> brands) {
        this.totalPage = totalPage;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.brands = brands;
    }
}
