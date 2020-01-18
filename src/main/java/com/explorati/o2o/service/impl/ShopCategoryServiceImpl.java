package com.explorati.o2o.service.impl;

import com.explorati.o2o.dao.ShopCategoryDao;
import com.explorati.o2o.entity.Shop;
import com.explorati.o2o.entity.ShopCategory;
import com.explorati.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 22:33 2020/1/16 0016
 * @ Description ：
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
        return shopCategoryDao.queryShopCategory(shopCategoryCondition);
    }
}
