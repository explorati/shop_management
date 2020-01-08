package com.explorati.o2o.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 12:04 2020/1/4 0004
 * @ Description ：本地账号实体类
 */
@Data
public class LocalAuth {
    //主键ID
    private Long localAuthId;
    //用户名
    private String username;
    //密码
    private String password;
    //创建时间
    private Date createTime;
    //最后修改时间
    private Date lastEditTime;
    //用户信息实体类
    private PersonInfo personInfo;
}
