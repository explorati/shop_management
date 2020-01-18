package com.explorati.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 10:12 2020/1/16 0016
 * @ Description ：Shop相关页面路由Controller
 */
@Controller
@RequestMapping(value="shopadmin", method= RequestMethod.GET)
public class ShopAdminController {
    @RequestMapping(value="/shopoperation")
    public String shopOperation() {
        return "/shop/shopoperation";
    }
}
