package com.util;


import cn.hutool.core.date.DateUtil;
import com.service.user.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: PengMvc
 * @Date: 2022/05/31/15:11
 */
public class DateUtils {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private static int MONTH_STATIC = 12;

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

    /**
     * get String date
     * @param date
     * @param format
     * @return strDate
     */
    public  static String getStringDate(Date date,String format){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String strDate = null;
        try {
             strDate = simpleDateFormat.format(date);
        } catch (Exception e) {
            logger.error("get str date exception!",e);
        }
        return strDate;
    }

    /**
     * calculate second between date1 and date2
     * @return second
     */
    public static long calculateTwoDateSecond(Date startDate,Date endDate){

        // check param
        if(startDate == null || endDate == null){
            throw new NullPointerException("date is null");
        }
        // milliseconds
        long milliseconds = endDate.getTime() - startDate.getTime();

        return milliseconds/1000;
    }

    /**
     * get the next month of date
     * for example 2021/02/09 ->2021/03/09
     * @param effectiveDate
     * @return date
     * @throws ParseException
     */
    public static Date nextEffectiveDate(Date effectiveDate,String dateFormat) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        int year = DateUtil.year(effectiveDate);
        int nextMonth =  DateUtil.month(effectiveDate)+1+1;
        int day = DateUtil.dayOfMonth(effectiveDate);

        String time = DateUtil.formatTime(effectiveDate);
        int millisecond = DateUtil.millisecond(effectiveDate);
        if (nextMonth > MONTH_STATIC) {
            nextMonth = 1;
            year += 1;
        }
        String nextEffectiveDay = appendDate(year, nextMonth, day);
        if (!isValidDate(nextEffectiveDay)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(effectiveDate);
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, nextMonth);
            calendar.set(Calendar.DAY_OF_MONTH, 0);
            nextEffectiveDay = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        }
        nextEffectiveDay = nextEffectiveDay + " "+ time +":"+millisecond;
        return sdf.parse(nextEffectiveDay);
    }

    /**
     * append date
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String appendDate(int year, int month, int day) {
        StringBuilder dateStr = new StringBuilder();
        dateStr.append(year)
                .append('-')
                .append(month > 9 ? month : "0"+month)
                .append('-')
                .append(day > 9 ? day : "0"+day);
        return dateStr.toString();
    }

    /**
     * check date
     * @param dateStr
     * @return true or false
     */
    public static boolean isValidDate(String dateStr) {
        Boolean convertStatus = true;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            convertStatus = false;
        }
        return convertStatus;
    }
}
