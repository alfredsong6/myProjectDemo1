package com.demo.springscheduling;

import com.demo.springscheduling.demoTest.Person;
import com.demo.springscheduling.demoTest.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

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

    @Test
    public void testb(){
        Date date = new Date();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime n2 = now.minusDays(-2);
        Duration between = Duration.between(now, n2);
        System.out.println(between.toDays());
        Period between1 = Period.between(now.toLocalDate(), n2.toLocalDate());
        System.out.println(between1.getDays());

        System.out.println("---------------");
        Date date1 = null;
        try {
            date1 = DateUtils.parseDate("2019-12-11", "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date1);
        Date truncate = DateUtils.truncate(date1, Calendar.YEAR);
        System.out.println(truncate);
        System.out.println("---------------");
        String s = DateFormatUtils.format(date1, "yyyy年mm月dd日");
        System.out.println(s);

        System.out.println("---------------");
        BigDecimal b1 = BigDecimal.valueOf(0.02);
        BigDecimal b2 = BigDecimal.valueOf(0.003);
        System.out.println(b1.add(b2));
        System.out.println(0.01+0.04);
        System.out.println((int) Math.floor(1.23));
    }


}
