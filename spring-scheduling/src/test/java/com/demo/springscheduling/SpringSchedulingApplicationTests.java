package com.demo.springscheduling;

import com.demo.springscheduling.demoTest.Person;
import com.demo.springscheduling.demoTest.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSchedulingApplicationTests {

    //intValue 、parseInt、valueOf
    @Test
    public void contextLoads() throws Exception{
        User user = new User(1, "zhangsan", 16, 0);
        Person person = new Person();
        BeanUtils.copyProperties(person,user);
        System.out.println(user.getIsReach());
        System.out.println(person.getIsReach());
        System.out.println(person.getHeight());
    }


}
