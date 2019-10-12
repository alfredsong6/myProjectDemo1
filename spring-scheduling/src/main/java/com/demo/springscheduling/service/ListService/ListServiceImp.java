package com.demo.springscheduling.service.ListService;

import com.demo.springscheduling.mapper.BrandMapper;
import com.demo.springscheduling.mapper.BranddMapper;
import com.demo.springscheduling.pojo.brand.Brand;
import com.demo.springscheduling.pojo.page.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in
 * @Modified :
 **/
@Service
@Slf4j
public class ListServiceImp implements ListService {
    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private BranddMapper branddMapper;//用于测试基于注解mapper的动态条件查询

    @Override
    public Brand getById(Integer id) {
        Brand brand = brandMapper.selectByPrimaryKey(id);
        return brand;
    }

    @Override
    public Brand getByConditation(Integer id) {
        System.out.println("注解mapper。。");
        Brand brand = branddMapper.getByConditation(id);
        return brand;
    }

    @Override
    public List<Brand> getByLetter(String letter) {
//        Example example = new Example(Brand.class);
//        example.createCriteria().andEqualTo(letter.toUpperCase());
//        List<Brand> brands = brandMapper.selectByExample(example);
        Brand brand = new Brand();
        brand.setLetterss(letter);
        List<Brand> brands = brandMapper.select(brand);
        log.debug("brands是通过搜索[{}]获取",letter);
        System.out.println(brands.size());
        return brands;
    }

    @Override
    public PageResult<Brand> queryByPageAndSort(Integer page, Integer rows, String key, String sortBy, Boolean desc) {
        PageHelper.startPage(page,rows);

        Example example = new Example(Brand.class);
        System.out.println(key);
        if(StringUtils.isNotBlank(key)){
            example.createCriteria().andEqualTo("letter",key);
        }
        if(StringUtils.isNotBlank(sortBy)){
            String orderByClause = sortBy + (desc ? " DESC":" ASC");
            String orderByClause1 = sortBy + (desc ? " DESC":" ASC");
            example.setOrderByClause(orderByClause);
            example.orderBy(sortBy).desc().orderBy(orderByClause).asc();

        }
        //Page<Brand> brandPage = (Page<Brand>)brandMapper.selectByExample(example);
        List<Brand> brands = brandMapper.selectByExample(example);
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
        System.out.println(pageInfo.toString());
        PageResult<Brand> pageResult = new PageResult<Brand>(pageInfo.getTotal(), pageInfo.getSize(), page,pageInfo.getList());
//        System.out.println("+++++"+brandPage.toString());
//        System.out.println(brandPage.getTotal()+"--"+brandPage.getPageSize());
//        System.out.println(brandPage.getTotal());
//        PageResult<Brand> pageResult = new PageResult<>(brandPage.getTotal(),brandPage.getPageSize(),page,brandPage);
        return pageResult;
    }
    //基于注解的动态条件查询（排序）
    @Override
    public List<Brand> getByLetterCondition(String letter, String desc, String sortBy) {
        List<Brand> byLetterCondition = branddMapper.getByLetterCondition(letter, desc, sortBy);

        return byLetterCondition;
    }
}
