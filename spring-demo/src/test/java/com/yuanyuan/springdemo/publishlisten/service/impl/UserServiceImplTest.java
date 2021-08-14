package com.yuanyuan.springdemo.publishlisten.service.impl;

import com.yuanyuan.springdemo.publishlisten.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author FAYUAN.PENG
 * @version \$Id: UserServiceImplTest.java,  2021-08-01 23:31 FAYUAN.PENG Exp $$
 */
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        userService.addUser();
    }

    @Test
    public void delUser() {
        userService.delUser();
    }
}