package com.demo.springscheduling.pojo.excel;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in
 * @Modified :
 **/
@Entity
@Data
@Table(name = "tb_sku")
public class SkuItem implements Serializable {
    private Integer id;
    private Integer spu_id;
    private String title;
    private String images;
    private Integer price;
    @Column(name = "indexes")
    private String index;
    private String own_spec;
    private Integer enable;
    @Column(name = "create_time")
    private String createDate;
    @Column(name = "last_update_time")
    private String lastUpdateDate;
}
