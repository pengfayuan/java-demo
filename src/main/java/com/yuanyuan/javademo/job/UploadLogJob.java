package com.yuanyuan.javademo.job;

import org.springframework.stereotype.Component;

/**
 * @author FAYUAN.PENG
 * @version \$Id: UploadLogJob.java,  2021-01-24 22:31 FAYUAN.PENG Exp $$
 */
@Component
public class UploadLogJob extends SuperJob {

    public void uploadLog() {
        System.out.println("upload log...");
    }
}
