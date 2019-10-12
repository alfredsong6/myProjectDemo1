package com.demo.springscheduling.service.ListService;

import com.demo.springscheduling.mapper.ExcelMapper;
import com.demo.springscheduling.pojo.excel.SkuItem;
import lombok.extern.slf4j.Slf4j;
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
public class ExcelServiceImp implements ExcelService{

    @Autowired
    private ExcelMapper excelMapper;

    @Override
    public List<SkuItem> getSkuItem(Integer spu_id) {
        Example example = new Example(SkuItem.class);
        example.createCriteria().andEqualTo("spu_id",spu_id);
        List<SkuItem> skuItems = excelMapper.selectByExample(example);
        System.out.println("你大爷  我也要修改");
        log.info("随意修改一部分，造成冲突");
        System.out.println("还行");
        return skuItems;
    }
}
