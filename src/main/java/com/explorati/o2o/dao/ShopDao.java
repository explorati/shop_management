package com.explorati.o2o.dao;

import com.explorati.o2o.entity.Shop;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 22:33 2020/1/9 0009
 * @ Description ：商铺DAO
 */
public interface ShopDao {
    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
