package com.explorati.o2o.enums;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 19:31 2020/1/14 0014
 * @ Description ：商铺状态枚举类
 */
public enum ShopStateEnum {

    CHECK(0, "审核中"),
    OFFLINE(-1, "非法店铺"),
    SUCCESS(1, "操作成功"),
    PASS(2, "通过认证"),
    INNER_ERROR(-1001, "系统内部错误"),
    NULL_SHOPID(-1002, "ShopId为空"),
    NULL_SHOP(-1003, "shop信息为空"),
    NULL_SHOP_OWNER(-1004, "shop店主信息为空"),
    NULL_SHOP_NAME(-1005, "shop名称为空");

    //状态值
    private int state;
    //状态信息
    private String stateInfo;

    ShopStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    //根据传入状态值返回枚举值
    public static ShopStateEnum stateOf(int state) {
        for(ShopStateEnum stateEnum : values()) {
            if(stateEnum.getState() == state) {
                return stateEnum;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
