package com.yuanyuan.springdemo.publishlisten.service.impl;

import com.yuanyuan.springdemo.publishlisten.enums.ActionEnum;
import com.yuanyuan.springdemo.publishlisten.model.User;
import com.yuanyuan.springdemo.publishlisten.model.UserEvent;
import com.yuanyuan.springdemo.publishlisten.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author FAYUAN.PENG
 * @version \$Id: UserServiceImpl.java,  2021-08-01 23:00 FAYUAN.PENG Exp $$
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService, ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void addUser() {
        User user = User.builder().name("fanfan").age(30).build();
        UserEvent userEvent = new UserEvent(user);
        userEvent.setUser(user);
        userEvent.setAction(ActionEnum.ADD.getAction());
        log.info("发布事件: {}", userEvent);
        applicationEventPublisher.publishEvent(userEvent);
    }

    @Override
    public void delUser() {
        User user = User.builder().name("yuanyuan").age(32).build();
        UserEvent userEvent = new UserEvent(user);
        userEvent.setUser(user);
        userEvent.setAction(ActionEnum.DEL.getAction());
        log.info("发布事件: {}", userEvent);
        applicationEventPublisher.publishEvent(userEvent);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
