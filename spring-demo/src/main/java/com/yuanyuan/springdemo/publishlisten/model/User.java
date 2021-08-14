package com.yuanyuan.springdemo.publishlisten.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author FAYUAN.PENG
 * @version \$Id: User.java,  2021-08-01 23:02 FAYUAN.PENG Exp $$
 */
@Data
@Builder
public class User {

    private String name;
    private int age;
}
