package com.yuanyuan.jacksondemo.model;

import cn.hutool.core.map.MapUtil;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Map;
import lombok.ToString;

/**
 * @author FAYUAN.PENG
 * @version \$Id: BillRequest.java,  2021-08-18 14:14 FAYUAN.PENG Exp $$
 */
@ToString
public class BillRequest {

    private int action;

    @JsonAnySetter
    private Map<String, Object> extendInfo = MapUtil.newHashMap();

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    @JsonAnyGetter
    public Map<String, Object> getExtendInfo() {
        return extendInfo;
    }

//    public void setExtendInfo(String k, Object v) {
//        extendInfo.put(k, v);
//    }

}
