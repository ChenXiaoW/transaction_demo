package com.example.transaction_demo.service.impl;

import com.example.transaction_demo.model.CompanyEmployee;
import com.example.transaction_demo.model.UserBasic;
import com.example.transaction_demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chenw
 * @title: UserServiceImplTest
 * @description: TODO
 * @date 2020/6/2 15:11
 */
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    void insert() {
        userService.insert();
    }

    @Test
    void  insert2(){
        CompanyEmployee companyEmployee = new CompanyEmployee().setCompanyId("8").setUserId("7");
        int i = userService.insertEmployee(companyEmployee);
        System.out.println("打印:"+i);

    }

    @Test
    void updateUserBasic() {
        UserBasic userBasic = new UserBasic().setUserId("7").setAge(1).setUsername("的撒旦");
        int i = userService.updateUserBasic(userBasic);
        System.out.println("打印:"+i);
    }

    @Test
    void inser3(){
        UserBasic userBasic = new UserBasic().setUserId("7").setAge(1).setUsername("一天");
        int i = userService.updateUserBasic2(userBasic);
        System.out.println("打印:"+i);
    }

    @Test
    void updateUserBasic3(){
        UserBasic userBasic = new UserBasic().setUserId("7").setAge(1).setUsername("一天");
        UserBasic userBasic1 = new UserBasic().setUserId("8").setAge(1).setUsername("09");
        UserBasic userBasic2 = new UserBasic().setUserId("2").setAge(1).setUsername("eqw");
        UserBasic userBasic3 = new UserBasic().setUserId("3").setAge(1).setUsername("1823");
        UserBasic userBasic4 = new UserBasic().setUserId("5").setAge(2).setUsername("回滚");
        UserBasic userBasic5 = new UserBasic().setUserId("qwe").setAge(4).setUsername("回滚");
        UserBasic userBasic6 = new UserBasic().setUserId("ew").setAge(3).setUsername("xc");
        UserBasic userBasic7 = new UserBasic().setUserId("yteyt").setAge(2).setUsername("回滚");
        UserBasic userBasic8 = new UserBasic().setUserId("fdf").setAge(5).setUsername("vb");
        UserBasic userBasic9 = new UserBasic().setUserId("gf").setAge(6).setUsername("回滚");
        List<UserBasic> userBasics = Arrays.asList(userBasic, userBasic1, userBasic2, userBasic3, userBasic4, userBasic5,userBasic6,userBasic7,userBasic8,userBasic9);
        userService.insertUserBasic2(userBasics);
    }
}