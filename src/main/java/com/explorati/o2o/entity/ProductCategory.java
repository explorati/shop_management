package com.explorati.o2o.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 14:18 2020/1/4 0004
 * @ Description ：商品类别实体类
 */
@Data
public class ProductCategory {
    //主键ID
    private Long productCategoryId;
    //类别名称
    private String productCategoryName;
    //权重
    private Integer priority;
    //创建时间
    private Date createTime;
    //商铺ID
    private Long shopId;
}
