package com.example.transaction_demo.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author chenw
 * @title: CompanyEmployee
 * @description: TODO
 * @date 2020/6/2 14:58
 */
@Data
@Accessors(chain = true)
public class CompanyEmployee {
    private String userId;

    private String companyId;


}
