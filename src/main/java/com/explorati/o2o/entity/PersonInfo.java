package com.explorati.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 11:25 2020/1/4 0004
 * @ Description ：用户实体类
 */
@Data
public class PersonInfo {
    //用户ID
    private Long userId;
    //用户名
    private String name;
    //头像
    private String profileImg;
    //邮箱
    private String email;
    //性别
    private String gender;
    //状态
    private Integer enableStatus;
    //用户类别：1.顾客 2.店家 3.超级管理员
    private Integer userType;
    //创建时间
    private Date createTime;
    //最后修改时间
    private Date lastEditTime;
}
