package com.explorati.o2o.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 10:21 2020/1/15 0015
 * @ Description ：
 */
public class HttpServletRequestUtil {

    public static int getInt(HttpServletRequest request, String key) {
        try {
            return Integer.decode(request.getParameter(key));
        } catch (Exception e) {
            return -1;
        }
    }

    public static long getLong(HttpServletRequest request, String key) {
        try {
            return Long.valueOf(request.getParameter(key));
        } catch (Exception e) {
            return -1L;
        }
    }

    public static double getDouble(HttpServletRequest request, String key) {
        try {
            return Double.valueOf(request.getParameter(key));
        } catch (Exception e) {
            return -1d;
        }
    }

    public static boolean getBoolean(HttpServletRequest request, String key) {
        try {
            return Boolean.valueOf(request.getParameter(key));
        } catch (Exception e) {
            return false;
        }
    }

    public static String getStr(HttpServletRequest request, String key) {
        try{
            String result = request.getParameter(key);
            if(result != null) {
                //去掉左右两侧的空格
                result = result.trim();
            }
            if("".equals(result)) {
                result = null;
            }
            return result;
        }catch(Exception e){
            return null;
        }

    }
}
