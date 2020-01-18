package com.explorati.o2o.dto;

import com.explorati.o2o.entity.Shop;
import com.explorati.o2o.enums.ShopStateEnum;
import lombok.Data;

import java.util.List;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 19:25 2020/1/14 0014
 * @ Description ：店铺执行类(传递给前端的值)
 */
@Data
public class ShopExecution {
    //结果状态
    private int state;

    //状态标识
    private String stateInfo;

    //店铺数量
    private int count;

    //操作的shop增删改店铺的时候用到
    private Shop shop;

    //shop列表(查询店铺列表的时候使用)
    private List<Shop> shopList;

    public ShopExecution(int state) {
        this.state = state;
    }

    //店铺操作失败的时候使用的构造器(只返回状态和状态信息)
    public ShopExecution(ShopStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    //店铺操作成功的时候使用的构造器(将店铺信息也返回)
    public ShopExecution(ShopStateEnum stateEnum, Shop shop) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }

    //店铺操作成功的时候使用的构造器(将店铺信息列表返回)
    public ShopExecution(ShopStateEnum stateEnum, List<Shop> shopList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopList = shopList;
    }

}
