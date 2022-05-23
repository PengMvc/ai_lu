package com.until;

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
}


