package com.explorati.o2o.service;

import com.explorati.o2o.BaseTest;
import com.explorati.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 15:50 2020/1/7 0007
 * @ Description ：
 */
public class AreaServiceTest extends BaseTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void testGetAreaList() {
        List<Area> areaList = areaService.getAreaList();
        assertEquals("三层", areaList.get(0).getAreaName());
    }
}
