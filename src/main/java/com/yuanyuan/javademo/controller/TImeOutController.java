package com.yuanyuan.javademo.controller;

import cn.hutool.core.thread.ThreadUtil;
import java.util.concurrent.TimeUnit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FAYUAN.PENG
 * @version \$Id: TImeOutController.java,  2021-03-11 8:52 FAYUAN.PENG Exp $$
 */
@RequestMapping("javademo/exception/v1")
@RestController
public class TImeOutController {

    @GetMapping("/timeout")
    public void timeout() {
        ThreadUtil.sleep(10, TimeUnit.MINUTES);
    }
}
