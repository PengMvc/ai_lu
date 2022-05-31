package com.until;


import com.service.user.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: PengMvc
 * @Date: 2022/05/31/15:11
 */
public class DateUtil {
    private String str="yyyy-MM-dd HH:mm:ss";
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * return date of format
     * @param date
     * @param format
     * @return Date
     * @throws ParseException
     */
    public static Date formatDate(Date date,String format)  {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date formateDate= null;
        try {
            String strDate = simpleDateFormat.format(date);
            formateDate = simpleDateFormat.parse(strDate);
        } catch (Exception e) {
            logger.error("format date exception!",e);
        }
        return formateDate;
    }

}
