package com.explorati.o2o.dao;

import com.explorati.o2o.BaseTest;
import com.explorati.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 22:47 2020/1/4 0004
 * @ Description ：区域DAO测试类
 */
public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea(){
        List<Area> areaList = areaDao.queryArea();
        assertEquals(3, areaList.size());
    }
}
