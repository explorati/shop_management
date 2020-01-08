package com.explorati.o2o.service.impl;

import com.explorati.o2o.dao.AreaDao;
import com.explorati.o2o.entity.Area;
import com.explorati.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 15:46 2020/1/7 0007
 * @ Description ：
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
