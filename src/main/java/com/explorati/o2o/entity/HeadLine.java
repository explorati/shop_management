package com.explorati.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 13:24 2020/1/4 0004
 * @ Description ：头条实体类
 */
@Data
public class HeadLine {
    //头条ID
    private Long lineId;
    //名称
    private String lineName;
    //权重
    private Integer priority;
    //图片
    private String lineImg;
    //链接
    private String lineLink;
    //状态：0.不可用 1.可用
    private Integer enableStatus;
    //创建时间
    private Date createTime;
    //最后修改时间
    private Date lastEditTime;
}
