package com.yuanyuan.javademo.job;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author FAYUAN.PENG
 * @version \$Id: CleanLogJobTest.java,  2021-01-24 22:05 FAYUAN.PENG Exp $$
 */
@SpringBootTest
public class CleanLogJobTest {
    @Autowired
    private CleanLogJob job;

    @Test
    void cleanLog() {
        job.cleanLog();
    }
}