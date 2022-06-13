package com.until;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import org.apache.commons.collections4.CollectionUtils;

/**
 * operate bean
 */
public class BeanUtil {

    public static void copyDeclaredFields(Object dest, Class[] destClasses, Object src, Class[] srcClasses) {
        try {
            for(int i = 0; i < destClasses.length; i++) {
                Class destClass = destClasses[i];
                for(Field srcField : srcClasses[i].getDeclaredFields()) {
                    try {
                        srcField.setAccessible(true);
                        Field destField = destClass.getDeclaredField(srcField.getName());
                        destField.setAccessible(true);
                        destField.set(dest, srcField.get(src));
                    } catch(NoSuchFieldException ignored) {
                    }
                }
            }
        } catch(IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object getProperty(Object bean, String name) {
        String methodNameSuffix = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        Method method;
        Class<?> c = bean.getClass();
        try {
            method = c.getMethod("get" + methodNameSuffix);
        } catch(NoSuchMethodException e) {
            try {
                method = c.getMethod("is" + methodNameSuffix);
            } catch(NoSuchMethodException e1) {
                try {
                    Field field = c.getField(name);
                    return field.get(bean);
                } catch(NoSuchFieldException e2) {
                    return null;
                } catch(IllegalAccessException e2) {
                    throw new RuntimeException(e);
                }
            }
        }
        try {
            return method.invoke(bean);
        } catch(IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

  public static <T> T copyBeanFromNew(Object from,Class<T> clazz) {
        return copyBeanFromNew(from, clazz, null);
    }

    /**
     * 将from对象copy至clazz生成类的对象 忽略属性为ignores
     * @param from
     * @param clazz
     * @param ignores
     * @param <T>
     * @return
     */
    public static <T> T copyBeanFromNew(Object from,Class<T> clazz,String... ignores) {
        T obj = getT(clazz);
        org.springframework.beans.BeanUtils.copyProperties(from,obj,ignores);
        return obj;
    }

    /**
     * 获取一个对象的所在类
     * @param clazz
     * @param <T>
     * @return
     */
    private static <T> T getT(Class<T> clazz) {
        T obj;
        try {
            obj = clazz.newInstance();
        } catch (InstantiationException var4) {
            throw new RuntimeException(var4);
        } catch (IllegalAccessException var5) {
            throw new RuntimeException(var5);
        }
        return obj;
    }

    public static <T> Map<String,T> setMap(Map<String, T> paramMap, Class<T> clazz,Object... keysAndValues){
        for (int i = 0; i < keysAndValues.length ; i += 2) {
            paramMap.put((String)keysAndValues[i],clazz.cast(keysAndValues[i+1]));
        }
        return paramMap;
    }

    public static <T> Map<String,T> setMapNotNull(Map<String, T> paramMap, Class<T> clazz,Object... keysAndValues){
        for (int i = 0; i < keysAndValues.length ; i += 2) {
            Object value = keysAndValues[i + 1];
            if (value != null)
                paramMap.put((String)keysAndValues[i],clazz.cast(value));
        }
        return paramMap;
    }

    public static <T> Map<String,T> setMapFromNew(Class<T> clazz, Object... keysAndValues){
        return setMap(Maps.<String,T>newHashMap(), clazz, keysAndValues);
    }

    public static <T> Map<String,T> setMapFromNewNotNull(Class<T> clazz, Object... keysAndValues){
        return setMapNotNull(Maps.<String,T>newHashMap(), clazz, keysAndValues);
    }

    public static <T> List<T> copyBeanFromNewList(List<?> origin,Class<T> clazz,String... ignores) {
        List<T> newArrayList = Lists.newArrayList();
        for (Object f : origin) {
            newArrayList.add(copyBeanFromNew(f, clazz, ignores));
        }
        return newArrayList;
    }

    public static <T> List<Map<String, T>> setMapList(List<Map<String, T>> origin, Class<T> clazz,Object... keysAndValues) {
        for (Map<String, T> f : origin) {
            setMap(f, clazz, keysAndValues);
        }
        return origin;
    }

     public static <T> List<T> getListOrEmpty(List<T> collect) {
        return CollectionUtils.isEmpty(collect) ? Collections.emptyList() : collect;
    }
}
