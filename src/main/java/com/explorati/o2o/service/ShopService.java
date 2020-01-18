package com.explorati.o2o.service;

import com.explorati.o2o.dto.ShopExecution;
import com.explorati.o2o.entity.Shop;

import java.io.InputStream;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 20:38 2020/1/14 0014
 * @ Description ：商铺Service层
 */
public interface ShopService {
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName);
}
