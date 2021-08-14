package com.yuanyuan.springdemo.publishlisten.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * @author FAYUAN.PENG
 * @version \$Id: UserEvent.java,  2021-08-01 22:56 FAYUAN.PENG Exp $$
 */
@Data
@ToString
public class UserEvent extends ApplicationEvent {

    private int action;
    private User user;

    public UserEvent(Object source) {
        super(source);
    }

}
