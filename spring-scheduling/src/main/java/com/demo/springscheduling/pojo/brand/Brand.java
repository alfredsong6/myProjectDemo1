package com.demo.springscheduling.pojo.brand;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in
 * @Modified :
 **/
@Table(name="tb_brand")
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String image;
    @Column(name = "letter")
    private String letterss;

}
