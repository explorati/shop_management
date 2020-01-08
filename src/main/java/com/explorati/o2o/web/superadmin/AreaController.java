package com.explorati.o2o.web.superadmin;

import com.explorati.o2o.VO.AreaVO;
import com.explorati.o2o.entity.Area;
import com.explorati.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 15:55 2020/1/7 0007
 * @ Description ：
 */
@Controller
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "listarea", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listArea() {
        Map<String, Object> modelMap = new HashMap<>();
        List<Area> list = new ArrayList<>();
//        AreaVO areaVO = new AreaVO();
//        areaVO.setCode(0);
        try {
            list = areaService.getAreaList();
//            areaVO.setData(list);
//            areaVO.setMsg("success");
            modelMap.put("rows", list);
            modelMap.put("total", list.size());
        } catch (Exception e) {
            e.printStackTrace();
//            areaVO.setCode(-1);
//            areaVO.setMsg(e.getMessage());
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        return modelMap;
    }
}
