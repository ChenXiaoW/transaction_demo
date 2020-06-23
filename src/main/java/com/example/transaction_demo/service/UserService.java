package com.example.transaction_demo.service;

import com.example.transaction_demo.model.CompanyEmployee;
import com.example.transaction_demo.model.UserBasic;

/**
 * @author chenw
 * @title: UserService
 * @description: TODO
 * @date 2020/6/2 15:06
 */
public interface UserService {

    void insert();

    void insertUserBasic(UserBasic userBasic);

    int insertEmployee(CompanyEmployee companyEmployee);

    int updateUserBasic(UserBasic userBasic);

    int updateUserBasic2(UserBasic userBasic);

    UserBasic queryUser(UserBasic userBasic);
}
