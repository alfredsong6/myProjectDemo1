package com.demo.springscheduling.demoTest;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in
 * @Modified :
 **/
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Integer isReach;

    public String getIsReach(){
        if(isReach==0){
            return "否";
        }
        if (isReach==1){
            return "是";
        }
        return null;
    }
}
