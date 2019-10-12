package com.demo.springscheduling.mapper;

import com.demo.springscheduling.pojo.brand.Brand;
import com.demo.springscheduling.pojo.page.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in
 * @Modified :
 **/
@Mapper
public interface BranddMapper {
    @SelectProvider(type = BrandProvider.class,method="getByConditation")
    Brand getByConditation(Integer id);


    @SelectProvider(type = BrandProviderByCondition.class,method="getByLetterCondition")
    List<Brand> getByLetterCondition(String letter,String desc,String sortBy);

    PageResult<Brand> queryByPageAndSort(Integer page, Integer rows, String key, String sortBy, Boolean desc);

    class BrandProvider{
        public String getByConditation(Integer id){
            String sql = "select * from tb_brand";
            if(id!=null){
                sql = sql +" where id = #{id}";
            }
            return sql;
        }
    }
    class BrandProviderByCondition{
        public String getByLetterCondition(String letter,String desc,String sortBy){
            String sql = "select * from tb_brand";

            if(letter!=null){
                sql+=" where letter = #{letter}";
            }
            if(sortBy!=null){

                sql+=" order by #{sortBy} #{desc}";
            }
            System.out.println(sql);
            return sql;
        }
    }

}
