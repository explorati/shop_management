package com.explorati.o2o.service.impl;

import com.explorati.o2o.dao.ShopDao;
import com.explorati.o2o.dto.ShopExecution;
import com.explorati.o2o.entity.Shop;
import com.explorati.o2o.enums.ShopStateEnum;
import com.explorati.o2o.exceptions.ShopOperationException;
import com.explorati.o2o.service.ShopService;
import com.explorati.o2o.util.ImageUtil;
import com.explorati.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Date;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 20:41 2020/1/14 0014
 * @ Description ：店铺Service实现类
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) {
        //空值判断(其余各个字段的判断先省略)
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        if (shop.getOwner() == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP_OWNER);
        }
        if (shop.getShopName() == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP_NAME);
        }
        try {
            //给店铺信息赋初始值
            //状态默认为审核中
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            shop.setPriority(50);
            shop.setAdvice("审核中");
            //添加店铺信息
            int effectedNum = shopDao.insertShop(shop);
            if (effectedNum <= 0) {
                throw new ShopOperationException("店铺创建失败");
            } else {
                if (shopImgInputStream != null) {
                    //存储图片
                    try {
                        addShopImg(shop, shopImgInputStream, fileName);
                    } catch (Exception e) {
                        throw new ShopOperationException("addShopImg error: " + e.toString());
                    }
                    //更新店铺图片地址
                    effectedNum = shopDao.updateShop(shop);
                    if (effectedNum <= 0) {
                        throw new ShopOperationException("更新图片地址失败");
                    }
                }
            }
        } catch (Exception e) {
            throw new ShopOperationException("addShop error: " + e.toString());
        }
        //若都执行成功，则返回审核状态，并将店铺信息返回
        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }

    //存储图相关逻辑
    private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {
        //生成图片存储子路径
        String path = PathUtil.getShopImagePath(shop.getShopId());
        //存储图片并返回相对路径
        String relativeAddr = ImageUtil.generateThumbnail(shopImgInputStream, fileName, path);
        //更新shopImg字段
        shop.setShopImg(relativeAddr);
//        ImageUtil.generateThumbnail(shopImg, PathUtil.getShopImagePath(shop.getShopId()));
    }
}
