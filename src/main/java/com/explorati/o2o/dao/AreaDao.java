package com.explorati.o2o.dao;

import com.explorati.o2o.entity.Area;

import java.util.List;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 22:20 2020/1/4 0004
 * @ Description ：区域DAO
 */
public interface AreaDao {
    /**
     * 列出区域列表
     * @return areaList
     */
    List<Area> queryArea();
}
