package com.explorati.o2o.dao;

import com.explorati.o2o.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 21:58 2020/1/16 0016
 * @ Description ：商铺类别Dao
 */
public interface ShopCategoryDao {

    List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
}
