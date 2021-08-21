package com.yuanyuan.jacksondemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author FAYUAN.PENG
 * @version \$Id: Person.java,  2021-08-15 15:33 FAYUAN.PENG Exp $$
 */
public class Person {

    @JsonProperty("holdName")
    private String name;

    @JsonIgnore
    private Integer internalIncome;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInternalIncome() {
        return internalIncome;
    }

    public void setInternalIncome(Integer internalIncome) {
        this.internalIncome = internalIncome;
    }
}
