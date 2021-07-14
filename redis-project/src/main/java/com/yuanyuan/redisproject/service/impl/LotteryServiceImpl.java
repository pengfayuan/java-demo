package com.yuanyuan.redisproject.service.impl;

import com.yuanyuan.redisproject.service.LotteryService;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

/**
 * @author FAYUAN.PENG
 * @version \$Id: LotteryServiceImpl.java,  2021-07-13 15:50 FAYUAN.PENG Exp $$
 */
@Service
public class LotteryServiceImpl implements LotteryService {

    public static final String KEY = "activity:lottery";
    @Autowired
    private RedisTemplate redisTemplate;

    @PostConstruct
    public void initData() {
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add(KEY, "我爱罗");
        setOperations.add(KEY, "宇智波佐助");
        setOperations.add(KEY, "宇智波斑");
        setOperations.add(KEY, "宇智波鼬");
        setOperations.add(KEY, "漩涡鸣人");
        setOperations.add(KEY, "旗木卡卡西");
        setOperations.add(KEY, "千手柱间");
        setOperations.add(KEY, "千手扉间");
        setOperations.add(KEY, "猿飞日斩");
        setOperations.add(KEY, "波风水门");
        setOperations.add(KEY, "千手纲手");
        setOperations.add(KEY, "春野樱");
        setOperations.add(KEY, "自来也");
        setOperations.add(KEY, "大蛇丸");
        setOperations.add(KEY, "迈特凯");
        setOperations.add(KEY, "李洛克");
        setOperations.add(KEY, "桃地再不斩");
        setOperations.add(KEY, "天天");
        setOperations.add(KEY, "油女志乃");
    }

    @Override
    public List<String> randomLottery(Integer count) {
        SetOperations setOperations = redisTemplate.opsForSet();
        return setOperations.pop(KEY, count);
    }

    @Override
    public Set<String> listAllUser() {
        SetOperations setOperations = redisTemplate.opsForSet();
        return setOperations.members(KEY);
    }

    @Override
    public Long getCount() {
        SetOperations setOperations = redisTemplate.opsForSet();
        return setOperations.size(KEY);
    }
}
