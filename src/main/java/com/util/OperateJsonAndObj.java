package com.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Author: PengMvc
 * @Date: 2022/07/15/11:15
 */
public class OperateJsonAndObj {

    /**
     * convert obj to objStr
     * @param obj
     * @return objStr
     * @throws JsonProcessingException
     */
    public static String objToJsonString(Object obj){
        ObjectMapper mapper = null;
        String jsonStr = null;
        try {
            mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("obj to jsonString exp!");
        }
    }

    /**
     * objStr to obj
     * @param jsonStr
     * @param obj
     * @return obj
     * @throws JsonProcessingException
     */
    public static Object jsonStringToObj(String jsonStr,Object obj) throws JsonProcessingException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonStr, Object.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("jsonString to obj exp");
        }
    }
}
