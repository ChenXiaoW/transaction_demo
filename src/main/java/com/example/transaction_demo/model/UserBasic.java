package com.example.transaction_demo.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author  chenw
 * @date  2020/6/2 14:58
 */
@Data
@ToString
@Accessors(chain = true)
public class UserBasic {

    private String userId;

    private String username;

    private Integer age;
}
