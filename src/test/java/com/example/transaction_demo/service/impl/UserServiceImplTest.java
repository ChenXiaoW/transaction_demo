package com.example.transaction_demo.service.impl;

import com.example.transaction_demo.model.CompanyEmployee;
import com.example.transaction_demo.model.UserBasic;
import com.example.transaction_demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}