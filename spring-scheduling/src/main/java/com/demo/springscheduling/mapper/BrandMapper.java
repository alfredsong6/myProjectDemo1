package com.demo.springscheduling.mapper;

import com.demo.springscheduling.pojo.brand.Brand;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import sun.rmi.runtime.Log;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in
 * @Modified :
 **/

public interface BrandMapper extends Mapper<Brand> {

    @Select("select * from tb_brand where name like '%'+#{name}+'%'")
    List<Brand> getMyBrand(String Name);
}
