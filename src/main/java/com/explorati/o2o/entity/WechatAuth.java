package com.explorati.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 11:54 2020/1/4 0004
 * @ Description ：微信账号实体类
 */
@Data
public class WechatAuth {
    //主键ID
    private Long wechatAuthId;
    //openID
    private String openId;
    //创建时间
    private Date createTime;
    //用户信息实体类关联
    private PersonInfo personInfo;
}
