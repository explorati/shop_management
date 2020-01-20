package com.explorati.o2o.dao;

import com.explorati.o2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 22:33 2020/1/9 0009
 * @ Description ：商铺DAO
 */
public interface ShopDao {

    /**
     * 分页查询店铺，可输入的条件有：店铺名(模糊)、店铺状态、店铺类别、区域ID，owner
     *
     * @param shopCondition
     * @param rowIndex      从第几行开始取数据
     * @param pageSize      返回的条数
     * @return
     */
    List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex, @Param(
            "pageSize") int pageSize);

    /**
     * 根据shopId查询店铺
     *
     * @param shopId
     * @return
     */
    Shop queryByShopId(long shopId);

    /**
     * 新增店铺
     *
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺
     *
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
