package com.explorati.o2o.util;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 22:31 2020/1/10 0010
 * @ Description ：路径处理类
 */
public class PathUtil {
    //获取文件的分隔符
    private static String separator = System.getProperty("file.separator");

    //根据系统返回项目图片根路径
    public static String getImgBasePath() {
        //获取系统名称(不同系统存放在不同目录下)
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "E:/o2o_2.0/pic";
        } else {
            basePath = "home/explorati/image";
        }
        //替换分隔符
        basePath = basePath.replace("/", separator);
        return basePath;
    }

    //依据不同项目需求，返回商铺图片子路径
    public static String getShopImagePath(long shopId) {
        String imagePath = "/upload/item/shop/" + shopId + "/";
        return imagePath.replace("/", separator);
    }
}
