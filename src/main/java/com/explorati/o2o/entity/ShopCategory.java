package com.explorati.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 13:40 2020/1/4 0004
 * @ Description ：商铺类别实体类
 */
@Data
public class ShopCategory {
    //主键ID
    private Long shopCategoryId;
    //类别名称
    private String shopCategoryName;
    //描述
    private String shopCategoryDesc;
    //权重
    private Integer priority;
    //图片
    private String shopCategoryImg;
    //创建时间
    private Date createTime;
    //最后修改时间
    private Date lastEditTime;
    //上级ID
    private ShopCategory parent;
}
