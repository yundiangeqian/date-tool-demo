package com.cm.date.util;

import com.cm.date.constant.DateConstant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @description: 日期工具类
 * @author: caomian
 * @data: 2019/8/13 13:46
 */
public class DateTool {
    /**
     * 字符串转日期
     *
     * @param dateString 日期字符串
     * @param pattern    日期格式
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String dateString, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = sdf.parse(dateString);
        return date;
    }

    /**
     * 日期转字符串
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return
     */
    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String dateString = sdf.format(date);
        return dateString;
    }

    /**
     * 计算日期
     *
     * @param date      具体日期的字符串
     * @param dayCounts 日期推移天数，正数往后，负数向前
     * @return
     */
    private static Date calculateDate(Date date, int dayCounts) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, dayCounts);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获得以今天为基准的具体推算某天的日期
     *
     * @param pattern   日期格式
     * @param dayCounts 相隔天数   正数往后，负数向前
     * @return
     */
    public static Object getDate(String pattern, int dayCounts, String returnObjectFormat) throws ParseException {
        return getResult(null, pattern, dayCounts, returnObjectFormat);
    }

    /**
     * 根据具体时间，获得某天的日期
     *
     * @param pattern   日期格式
     * @param dayCounts 相隔天数   正数往后，负数向前
     * @return
     */
    public static Object getDate(String date, String pattern, int dayCounts, String returnObjectFormat) throws ParseException {
        return getResult(date, pattern, dayCounts, returnObjectFormat);
    }

    /**
     * 获得日期的返回结果
     *
     * @param date_string        具体日期的字符串
     * @param pattern            日期格式
     * @param dayCounts          推移天数
     * @param returnObjectFormat 返回对象的格式  Date/String
     * @return
     * @throws ParseException
     */
    private static Object getResult(String date_string, String pattern, int dayCounts, String returnObjectFormat) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        if (date_string == null) {
            date = new Date();
        } else {
            date = stringToDate(date_string, pattern);
        }
        String dateString = sdf.format(calculateDate(date, dayCounts));
        if (returnObjectFormat.equals(DateConstant.RETURN_DATE)) {
            return stringToDate(dateString, pattern);
        }
        return dateString;
    }

}
