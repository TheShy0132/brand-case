package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;

import java.util.List;

/**
 * @Auther: 胡桃
 * @Date: 2022-11-14 19:35
 * @Description: com.itheima.service.impl
 * @version: 1.0
 */
public interface BrandService {
    List<Brand> selectAll();

    void add(Brand brand);

    void deleteByIds(int[] ids);

    PageBean<Brand> selectPage(int currentPage, int size);

    PageBean<Brand> selectByPageAndCondition(int currentPage, int size, Brand brand);
}
