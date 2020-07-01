package com.example.transaction_demo.service.impl;

import com.example.transaction_demo.dao.UserDao;
import com.example.transaction_demo.model.CompanyEmployee;
import com.example.transaction_demo.model.UserBasic;
import com.example.transaction_demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert() {
        UserBasic userBasic = new UserBasic().setUserId("7").setAge(1).setUsername("chenw");
        CompanyEmployee companyEmployee = new CompanyEmployee().setCompanyId("7").setUserId("7");
        insertUserBasic(userBasic);

        try {
            int result = insertEmployee(companyEmployee);
        }catch (Exception e){
            System.out.println("异常捕获");
        }

        /*if(0 == result){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }*/
    }

    @Override
    /*@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)*/
    public void insertUserBasic(UserBasic userBasic) {
        //1.获取事务定义
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        //2.设置事务隔离级别，开启新事务
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        //3.获得事务状态
        TransactionStatus status = transactionManager.getTransaction(def);
        CompanyEmployee companyEmployee = new CompanyEmployee().setCompanyId("qeqwe").setUserId("ewqeq");
        userDao.insertEmployee(companyEmployee);
        userDao.insertUserBasic(userBasic);
        if(userBasic.getAge() == 2){

            System.out.println("事务回滚");
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            transactionManager.rollback(status);
        }else {
            transactionManager.commit(status);
        }
    }

    @Override
    @Transactional
    public int insertEmployee(CompanyEmployee companyEmployee) {
        System.out.println("打印1:"+new Date());
       // int i = 1/0;

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userDao.insertEmployee(companyEmployee);
        System.out.println("打印2:"+new Date());
        return 1;
    }

    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Override
    //@Transactional
    public int updateUserBasic(UserBasic userBasic) {
        //1.获取事务定义
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        //2.设置事务隔离级别，开启新事务
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        //3.获得事务状态
        TransactionStatus status = transactionManager.getTransaction(def);
        int i = 0;
        try {
          //  Thread.sleep(15000);
            i = userDao.updateUserBasic(userBasic);
        } catch (Exception e){
            log.error("异常{}",e);
            transactionManager.rollback(status);
        }

        transactionManager.commit(status);
        System.out.println("打印2:"+new Date());
        return i;
    }

    @Override
    public int updateUserBasic2(UserBasic userBasic) {
        System.out.println("打印1:"+new Date());
        int i = 0;
        i = userDao.updateUserBasic(userBasic);

        System.out.println("打印2:"+new Date());
        return i;
    }

    @Override
    public int insertUserBasic2(List<UserBasic> userBasics) {
        //1.获取事务定义
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();

        for(int i = 0;i<userBasics.size();i++){

            //2.设置事务隔离级别，开启新事务
            def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
            //3.获得事务状态
            TransactionStatus status = transactionManager.getTransaction(def);
            //insertUserBasic(userBasics.get(i));
            userDao.insertUserBasic(userBasics.get(i));
            CompanyEmployee companyEmployee = new CompanyEmployee().setCompanyId("qeqwe").setUserId("ewqeq");
            userDao.insertEmployee(companyEmployee);
            if(userBasics.get(i).getAge() %2 == 0){

                System.out.println("事务回滚"+userBasics.get(i).toString());
                //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                transactionManager.rollback(status);
            }else {
                transactionManager.commit(status);
            }
        }
        return 0;
    }

    @Override
    public UserBasic queryUser(UserBasic userBasic) {
        UserBasic userBasic1 = userDao.queryUser(userBasic);

        return userBasic1;
    }
}
