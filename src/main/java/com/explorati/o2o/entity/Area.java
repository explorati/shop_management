package com.explorati.o2o.entity;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 0:04 2020/1/4 0004
 * @ Description ：区域实体类
 */
@Data
public class Area {
    //ID
    private Integer areaId;
    //名称
    private String areaName;
    //权重
    private Integer priority;
    //创建时间
    private Date createTime;
    //更新时间
    private Date lastEditTime;
}
