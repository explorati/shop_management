package com.explorati.o2o.service;

import com.explorati.o2o.BaseTest;
import com.explorati.o2o.dto.ShopExecution;
import com.explorati.o2o.entity.Area;
import com.explorati.o2o.entity.PersonInfo;
import com.explorati.o2o.entity.Shop;
import com.explorati.o2o.entity.ShopCategory;
import com.explorati.o2o.enums.ShopStateEnum;
import com.explorati.o2o.exceptions.ShopOperationException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 21:23 2020/1/14 0014
 * @ Description ：
 */
public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testModifyShop() throws ShopOperationException, FileNotFoundException {
        Shop shop = shopService.getByShopId(4L);
        shop.setShopName("Silky丝琪");
        File shopImg = new File("E:\\o2o\\Images\\理发1.jpg");
        InputStream is = new FileInputStream(shopImg);
        ShopExecution se = shopService.modifyShop(shop, is, "Lifa1.jpg");
        System.out.println(se.getShop().getShopImg());
    }

    @Test
    public void testAddShop() throws FileNotFoundException {
        Shop shop = new Shop();
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(1L);
        Area area = new Area();
        area.setAreaId(1);
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(1L);

        shop.setOwner(personInfo);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);

//        shop.setShopName("这厢有理");
//        shop.setShopDesc("给你一头精致的亮发");
//        shop.setShopAddr("三层东侧010室");
//        shop.setPhone("13131407890");
//        shop.setPriority(100);
//        shop.setAdvice("可用");
//        File shopImg = new File("E:\\o2o\\Images\\upload\\item\\shop\\3\\c9b7ca8e8ee6d4ba.jpg");

//        shop.setShopName("Clavin");
//        shop.setShopDesc("CK");
//        shop.setShopAddr("三层西侧030室");
//        shop.setPhone("13131431234");
////        shop.setShopImg("\\upload\\item\\shop\\3\\2019050522153690287.jpg");
//        shop.setPriority(99);
//        shop.setAdvice("审核中");
//        File shopImg = new File("E:\\o2o\\Images\\upload\\item\\shop\\3\\link.jpg");

        shop.setShopName("鑫艺理发");
        shop.setShopDesc("专注女士头发");
        shop.setShopAddr("二层东侧020室");
        shop.setPhone("13831418954");
//        shop.setShopImg("\\upload\\item\\shop\\3\\2019050522153690287.jpg");
        shop.setPriority(99);
        shop.setAdvice("审核中");
        File shopImg = new File("E:\\o2o\\Images\\upload\\item\\shop\\3\\link2.jpg");
        InputStream is = new FileInputStream(shopImg);
       ShopExecution se = shopService.addShop(shop, is, shopImg.getName());
       assertEquals(se.getState(), ShopStateEnum.CHECK.getState());
    }
}
