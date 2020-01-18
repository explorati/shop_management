package com.explorati.o2o.web.shopadmin;

import com.explorati.o2o.dto.ShopExecution;
import com.explorati.o2o.entity.Area;
import com.explorati.o2o.entity.PersonInfo;
import com.explorati.o2o.entity.Shop;
import com.explorati.o2o.entity.ShopCategory;
import com.explorati.o2o.enums.ShopStateEnum;
import com.explorati.o2o.service.AreaService;
import com.explorati.o2o.service.ShopCategoryService;
import com.explorati.o2o.service.ShopService;
import com.explorati.o2o.util.CodeUtil;
import com.explorati.o2o.util.HttpServletRequestUtil;
import com.explorati.o2o.util.ModelMapUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 10:15 2020/1/15 0015
 * @ Description ：商铺管理操作Controller
 */
@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/registershop", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> registerShop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap();
        //验证码的验证
        if(!CodeUtil.checkVerifyCode(request)) {
            ModelMapUtil.failed("验证码错误");
        }
        //1.接收并转换相应的参数
        String shopStr = HttpServletRequestUtil.getStr(request, "shopStr");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        try {
            shop = mapper.readValue(shopStr, Shop.class);
        } catch (Exception e) {
            return ModelMapUtil.failed(e.getMessage());
        }
        CommonsMultipartFile shopImg = null;
        CommonsMultipartResolver commonsMultipartResolver =
                new CommonsMultipartResolver(request.getSession().getServletContext());
        if (commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        } else {
            return ModelMapUtil.failed("上传图片不能为空");
        }
        //2.注册店铺
        if (shop != null && shopImg != null) {
            PersonInfo owner = new PersonInfo();
            //SESSION TODO
            owner.setUserId(1L);
            shop.setOwner(owner);
//            ShopExecution se = shopService.addShop(shop, ImageUtil.transferCommonsMultipartFileToFile(shopImg));
            ShopExecution se = null;
            try {
                se = shopService.addShop(shop, shopImg.getInputStream(), shopImg.getOriginalFilename());
                if (se.getState() == ShopStateEnum.CHECK.getState()) {
                    modelMap.put("success", true);
                } else {
                    return ModelMapUtil.failed(se.getStateInfo());
                }
            } catch (IOException e) {
                return ModelMapUtil.failed(e.getMessage());
            }
            //3.返回结果
            return modelMap;
        } else {
            return ModelMapUtil.failed("请输入店铺信息");
        }
    }

    @RequestMapping(value="/getshopinitinfo", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getShopInitinfo() {
        Map<String, Object> modelMap = new HashMap<>();
        List<ShopCategory> shopCategoryList = new ArrayList<>();
        List<Area> areaList = new ArrayList<>();
        try{
            shopCategoryList = shopCategoryService.getShopCategoryList(new ShopCategory());
            areaList = areaService.getAreaList();
            modelMap.put("success", true);
            modelMap.put("shopCategoryList", shopCategoryList);
            modelMap.put("areaList", areaList);
        }catch(Exception e) {
           ModelMapUtil.failed(e.getMessage());
        }
        return modelMap;
    }

//    private static void inputStreamToFile(InputStream ins, File file) {
//        try (OutputStream os = new FileOutputStream(file)) {
//            byte[] buffer = new byte[1024];
//            int byteRead = 0;
//            while ((byteRead = ins.read(buffer)) != -1) {
//                os.write(buffer, 0, byteRead);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("调用inputStreamToFile产生异常：" + e.getMessage());
//        } finally {
//            try {
//                if (ins != null) {
//                    ins.close();
//                }
//            } catch (Exception e) {
//                throw new RuntimeException("inputStreamToFile关闭io产生异常：" + e.getMessage());
//            }
//        }
//    }
}



