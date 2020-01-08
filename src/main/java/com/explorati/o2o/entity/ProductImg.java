package com.explorati.o2o.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 14:25 2020/1/4 0004
 * @ Description ：商品详情图实体类
 */
@Data
public class ProductImg {
    //ID
    private Long productImgId;
    //商品详情图地址
    private String imgAddr;
    //商品详情图描述
    private String imgDesc;
    //权重
    private Integer priority;
    //创建时间
    private LocalDateTime createTime;
    //商品ID
    private Long productId;
}
