package com.explorati.o2o.dao;

import com.explorati.o2o.BaseTest;
import com.explorati.o2o.entity.Area;
import com.explorati.o2o.entity.PersonInfo;
import com.explorati.o2o.entity.Shop;
import com.explorati.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 23:00 2020/1/9 0009
 * @ Description ：商铺DAO测试类
 */
public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testQueryByShopId() {
        long shopId = 3;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println("areaId: " + shop.getArea().getAreaId());
        System.out.println("areaName: " + shop.getArea().getAreaName());
    }

    @Test
    public void testInsertShop(){
        Shop shop = new Shop();
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(1L);
        Area area = new Area();
        area.setAreaId(3);
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(1L);

        shop.setOwner(personInfo);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("这厢有理");
        shop.setShopDesc("给你一头精致的亮发");
        shop.setShopAddr("三层东侧010室");
        shop.setPhone("13131437890");
        shop.setShopImg("\\upload\\item\\shop\\28\\2017100216561472866.jpg");
        shop.setCreateTime(new Date());
        shop.setPriority(100);
        shop.setEnableStatus(1);
        shop.setAdvice("可用");

        int result = shopDao.insertShop(shop);
        assertEquals(1, result);
    }

    @Test
    public void testUpdateShop(){
        Shop shop = new Shop();
        Area area = new Area();

        area.setAreaId(2);
        shop.setShopId(1L);
        shop.setArea(area);
        shop.setLastEditTime(new Date());


        int result = shopDao.updateShop(shop);
        assertEquals(1, result);
    }
}
