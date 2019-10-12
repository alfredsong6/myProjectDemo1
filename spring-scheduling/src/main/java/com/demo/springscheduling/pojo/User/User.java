package com.demo.springscheduling.pojo.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in
 * @Modified :
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private Integer age;
    private String title;
    private String dep;
}
