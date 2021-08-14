package com.yuanyuan.springdemo.publishlisten.enums;

/**
 * @author FAYUAN.PENG
 * @version \$Id: ActionEnum.java,  2021-08-01 23:06 FAYUAN.PENG Exp $$
 */
public enum ActionEnum {
    ADD(1),
    DEL(2);

    private int action;

    ActionEnum(int action) {
        this.action = action;
    }

    public int getAction() {
        return action;
    }}
