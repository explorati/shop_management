package com.explorati.o2o.service;

import com.explorati.o2o.dto.ShopExecution;
import com.explorati.o2o.entity.Shop;
import com.explorati.o2o.exceptions.ShopOperationException;

import java.io.InputStream;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 20:38 2020/1/14 0014
 * @ Description ：商铺Service层
 */
public interface ShopService {
    /**
     * 新增店铺
     *
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     */
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;

    /**
     * 通过店铺id获取店铺信息
     *
     * @param shopId
     * @return
     */
    Shop getByShopId(long shopId);

    /**
     * 更新店铺信息，包括对图片的处理
     *
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     */
    ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
}
