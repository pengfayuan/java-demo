package com.yuanyuan.javademo.job;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author FAYUAN.PENG
 * @version \$Id: UploadLogJobTest.java,  2021-01-24 23:03 FAYUAN.PENG Exp $$
 */
@SpringBootTest
public class UploadLogJobTest {
    @Autowired
    private UploadLogJob job;

    @Test
    void uploadLog() {
        job.uploadLog();
    }
}