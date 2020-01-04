package com.explorati.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 13:56 2020/1/4 0004
 * @ Description ：商铺实体类
 */
@Data
public class Shop {
    //主键ID
    private Long shopId;
    //商铺名称
    private String shopName;
    //描述
    private String shopDesc;
    //具体位置
    private String shopAddr;
    //联系电话
    private String phone;
    //图片
    private String shopImg;
    //权重
    private Integer priority;
    //状态：-1.不可用 0.审核中 1.可用
    private Integer enableStatus;
    //创建时间
    private Date createTime;
    //修改时间
    private Date lastEditTime;
    //超级管理员给店家的建议
    private String advice;
    //区域ID
    private Area area;
    //商铺类别ID
    private ShopCategory shopCategory;
    //用户ID
    private PersonInfo owner;
}
