package com.demo.springscheduling.controller;


import com.demo.springscheduling.commnons.ExcelUtiles;
import com.demo.springscheduling.pojo.User.UserDemo;
import com.demo.springscheduling.pojo.brand.Brand;
import com.demo.springscheduling.pojo.excel.SkuItem;
import com.demo.springscheduling.pojo.page.PageResult;
import com.demo.springscheduling.service.ListService.ExcelService;
import com.demo.springscheduling.service.ListService.ListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in now now
 * @Modified :
 **/
@RestController
@RequestMapping("page")
@Slf4j
public class HelloController {
    @Autowired
    private ListService listService;

    @PostMapping("date")
    public void date(@RequestBody UserDemo userDemo){
        System.out.println("jingqu");
        System.out.println(userDemo.toString());
        //System.out.println(userDemo.getTimeDay().getClass());
        System.out.println("jieshu");
    }

    @GetMapping("letter")
    public ResponseEntity<List<Brand>> getListBrandByLetter(@RequestParam(value = "letter") String le){
        List<Brand> lists = listService.getByLetter(le);

        return ResponseEntity.ok(lists);
    }

    @GetMapping("id")
    public ResponseEntity<Brand> getBrandById(@RequestParam(value = "id")Integer idd){
        Brand brand = listService.getById(idd);
        log.info("随意修改一部分，造成冲突");
        return ResponseEntity.ok(brand);
    }

    @GetMapping("zhujie")  //基于注解mapper的动态条件查询
    public ResponseEntity<Brand> getBrandByCondition(@RequestParam(value = "id")Integer idd){
        Brand brand = listService.getByConditation(idd);
        return ResponseEntity.ok(brand);
    }

    @GetMapping("condition")  //基于注解mapper的动态条件查询
    public ResponseEntity<List<Brand>> getByLetterCondition(
            @RequestParam(value = "letter",required = false)String letter,
            @RequestParam(value = "desc",defaultValue = "false")Boolean flag,
            @RequestParam(value = "sortBy",required = false)String sortBy){
        System.out.println(sortBy+"---"+flag);
        String desc = (flag ?"DESC" : "ASC");
        List<Brand> brands = listService.getByLetterCondition(letter, desc, sortBy);
        return ResponseEntity.ok(brands);
    }
    //分页，请求参数 需要用到的基本参数有，pagesize、rows、是否排序、过滤条件、
    //响应结果 ，总页数total、当前页、数据
    @GetMapping("pageList")
    public ResponseEntity<PageResult<Brand>> getPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "key", required = false) String key){
        System.out.println("得到请求参数："+page+"--"+rows+"---"+sortBy+"--"+desc+"--"+key);
        PageResult<Brand> brandPageResult = listService.queryByPageAndSort(page,rows,key,sortBy,desc);
        return ResponseEntity.ok(brandPageResult);
    }

    //excel导入与导出
    @Autowired
    private ExcelService excelService;

    @GetMapping("exportExcel")
    public void exportExcel(@RequestParam(value = "spuid") Integer spuid, HttpServletResponse response){
        List<SkuItem> skuItem = excelService.getSkuItem(spuid);

       /* try {
            String fileName = new String("demo信息表.xls".getBytes("utf-8"), "ISO-8859-1");
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setContentType("application/vnd.ms-excel;charset=gb2312");
            Workbook sheets = ExcelExportUtil.exportExcel(new ExportParams(), SkuItem.class, skuItem);
            sheets.write(response.getOutputStream());

        }catch (IOException e){
            e.printStackTrace();
        }*/

        String [] columnNames = {"id","spuid","title","images","price","index","ownSpec","enable","createTime","updateTime"};
        ExcelUtiles<SkuItem> utiles = new ExcelUtiles<>();
        try {


            utiles.exportExcel("用户导出", columnNames, skuItem, new FileOutputStream("E:/ceshi.xls"), ExcelUtiles.EXCEL_FILE_2003);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
