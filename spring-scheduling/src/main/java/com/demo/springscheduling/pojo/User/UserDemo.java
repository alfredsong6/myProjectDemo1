package com.demo.springscheduling.pojo.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in
 * @Modified :
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDemo {
    private Integer id;
    private String name;
    //@DateTimeFormat(pattern = "yyyy-MM")
    private String timeDay;

}
