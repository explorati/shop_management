package com.explorati.o2o.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 14:35 2020/1/4 0004
 * @ Description ：商品实体类
 */
@Data
public class Product {
    //主键ID
    private Long productId;
    //名称
    private String productName;
    //描述
    private String productDesc;
    //缩略图
    private String imgAddr;
    //原价
    private String normalPrice;
    //折扣价
    private String promotionPrice;
    //权重
    private Integer priority;
    //创建时间
    private Date createTime;
    //修改时间
    private Date lastEditTime;
    //状态：0.下架 1.在前端展示系统展示
    private Integer enableStatus;

    //商品详情图列表
    private List<ProductImg> productImgList;
    //商品类别ID
    private ProductCategory productCategory;
    //商铺ID
    private Shop shop;

}
