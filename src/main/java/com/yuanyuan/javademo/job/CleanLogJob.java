package com.yuanyuan.javademo.job;

import org.springframework.stereotype.Component;

/**
 * @author FAYUAN.PENG
 * @version \$Id: CleanLogJob.java,  2021-01-24 22:00 FAYUAN.PENG Exp $$
 */
@Component
public class CleanLogJob {

    public void cleanLog() {
        System.out.println("clean log...");
    }
}
