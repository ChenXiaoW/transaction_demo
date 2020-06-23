package com.example.transaction_demo.dao;

import com.example.transaction_demo.model.CompanyEmployee;
import com.example.transaction_demo.model.UserBasic;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author chenw
 * @title: UserDao
 * @description: TODO
 * @date 2020/6/2 15:01
 */
@Mapper
public interface UserDao {


    int insertEmployee(CompanyEmployee companyEmployee);

    int insertUserBasic (UserBasic userBasic);

    int updateUserBasic(UserBasic userBasic);

    UserBasic queryUser(UserBasic userBasic);

}
