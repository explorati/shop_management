package com.explorati.o2o.service;

import com.explorati.o2o.entity.Shop;
import com.explorati.o2o.entity.ShopCategory;

import java.util.List;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 22:32 2020/1/16 0016
 * @ Description ：
 */
public interface ShopCategoryService {

    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
