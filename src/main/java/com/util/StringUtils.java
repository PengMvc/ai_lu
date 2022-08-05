package com.util;

/**
 * 操作String的工具类
 * @Author PengMvc
 * @Date 2022/5/23 22:54
 **/
public class StringUtils {

    /**
     * if str == null or ""
     * return false
     * @param str
     * @return
     */
    public static Boolean isBlank(String str){
        if(str == null || "".equals(str)){
            return true;
        }
        return false;
    }

    /**
     * if str1 or str2 null throws npe
     * if eq return true
     * else return false
     * @param str1
     * @param str2
     * @return   true or flase
     */
    public static Boolean isEqual(String str1,String str2){
        if(str1 == null || str2 == null){
            throw new NullPointerException("存在字符串为null");
        }

        if(str1.equals(str2)){
            return true;
        }
      return false;
    }
}


