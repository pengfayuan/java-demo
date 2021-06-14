package com.yuanyuan.javademo.thread.common;

import cn.hutool.core.collection.CollUtil;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author FAYUAN.PENG
 * @version \$Id: ShareResource.java,  2021-01-17 16:42 FAYUAN.PENG Exp $$
 */
public class ShareResource {

    public static final int RESOURCE_MAX_LIMIT = 1;

    public List<String> list = CollUtil.newArrayList();

    public Lock lock = new ReentrantLock();

    public Condition condition = lock.newCondition();

}
