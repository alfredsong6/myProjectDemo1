package com.demo.springscheduling.service.ListService;

import com.demo.springscheduling.pojo.excel.SkuItem;

import java.util.List;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in
 * @Modified :
 **/
public interface ExcelService {

    List<SkuItem> getSkuItem(Integer spu_id);
}
