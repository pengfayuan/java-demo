package com.yuanyuan.springdemo.publishlisten.listener;

import com.yuanyuan.springdemo.publishlisten.model.UserEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author FAYUAN.PENG
 * @version \$Id: UserEventListener.java,  2021-08-01 23:18 FAYUAN.PENG Exp $$
 */
@Component
@Slf4j
public class UserEventListener {

    @EventListener(classes = UserEvent.class, condition = "#userEvent.getAction()==1")
    public void listenUserAdd(UserEvent userEvent) {
        log.info("监听用户添加操作");
        log.info("用户信息：{}", userEvent);
    }

    @EventListener(classes = UserEvent.class, condition = "#userEvent.getAction()==2")
    public void listenUserDel(UserEvent userEvent) {
        log.info("监听用户删除操作");
        log.info("用户信息：{}", userEvent);
    }
}
