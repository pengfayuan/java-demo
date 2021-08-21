package com.yuanyuan.jacksondemo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author FAYUAN.PENG
 * @version \$Id: Student.java,  2021-08-16 11:03 FAYUAN.PENG Exp $$
 */
@Data
public class Student {

    @JsonCreator
    public Student(@JsonProperty("name") String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
