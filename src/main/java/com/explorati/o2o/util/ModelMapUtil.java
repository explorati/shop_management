package com.explorati.o2o.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 11:35 2020/1/15 0015
 * @ Description ：
 */
public class ModelMapUtil {

    public Map<String, Object> success(Object obj) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", true);
        return modelMap;
    }

    public static Map<String, Object> failed(String msg) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success",false);
        modelMap.put("errMsg", msg);
        return modelMap;
    }
}
