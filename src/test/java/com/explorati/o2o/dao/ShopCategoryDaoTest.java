package com.explorati.o2o.dao;

import com.explorati.o2o.BaseTest;
import com.explorati.o2o.entity.Shop;
import com.explorati.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 22:07 2020/1/16 0016
 * @ Description ：
 */
public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void testQueryShopCategory() {
        List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(new ShopCategory());
        for(ShopCategory shopCategory : shopCategoryList) {
            System.out.println(shopCategory.getShopCategoryName());
        }
        assertEquals(2, shopCategoryList.size());
    }
}
