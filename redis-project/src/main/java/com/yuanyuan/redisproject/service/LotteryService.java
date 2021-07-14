package com.yuanyuan.redisproject.service;

import java.util.List;
import java.util.Set;

/**
 * @author FAYUAN.PENG
 * @version \$Id: LotteryService.java,  2021-07-13 15:47 FAYUAN.PENG Exp $$
 */
public interface LotteryService {

    List<String> randomLottery(Integer count);

    Set<String> listAllUser();

    Long getCount();
}
