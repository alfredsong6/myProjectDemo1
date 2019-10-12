package com.demo.springscheduling.service.ListService;

import com.demo.springscheduling.pojo.brand.Brand;
import com.demo.springscheduling.pojo.page.PageResult;

import java.util.List;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in
 * @Modified :
 **/

public interface ListService {
    Brand getById(Integer id);

    Brand getByConditation(Integer id); //基于注解mapper 的动态条件查询

    List<Brand> getByLetter(String letter);

    PageResult<Brand> queryByPageAndSort(Integer page, Integer rows, String key, String sortBy, Boolean desc);

    List<Brand> getByLetterCondition(String letter,String desc,String sortBy);
}
