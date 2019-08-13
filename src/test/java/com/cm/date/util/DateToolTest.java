package com.cm.date.util;

import com.cm.date.constant.DateConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DateToolTest {
    private static final Logger logger = LoggerFactory.getLogger(DateToolTest.class);

    @Test
    public void stringToDate() {
        try {
            Date date = DateTool.stringToDate("2019-8-13 14:51:26", DateConstant.DATE_PATTERN);
            logger.info("字符串转日期:{}", date);
        } catch (ParseException e) {
            logger.error("字符串转日期解析异常：{}", e.getMessage());
        }
    }

    @Test
    public void dateToString() {
        String dateString = DateTool.dateToString(new Date(), DateConstant.DATE_PATTERN);
        logger.info("日期转字符串:{}", dateString);
    }

    @Test
    public void getDate() {
        Object object = null;
        try {
            object = DateTool.getDate(DateConstant.DATE_PATTERN, 1, DateConstant.RETURN_STRING);
            logger.info("明天:{}", object);
        } catch (ParseException e) {
            logger.error("明天日期解析异常：{}", e.getMessage());
        }

        try {
            object = DateTool.getDate(DateConstant.DATE_PATTERN, -1, DateConstant.RETURN_STRING);
            logger.info("昨天:{}", object);
        } catch (ParseException e) {
            logger.error("昨天日期解析异常：{}", e.getMessage());
        }

        try {
            object = DateTool.getDate(DateConstant.DATE_PATTERN, 0, DateConstant.RETURN_STRING);
            logger.info("今天:{}", object);
        } catch (ParseException e) {
            logger.error("今天日期解析异常：{}", e.getMessage());
        }

        try {
            object = DateTool.getDate(DateConstant.DATE_PATTERN, 1, DateConstant.RETURN_DATE);
            logger.info("明天:{}", object);
        } catch (ParseException e) {
            logger.error("明天日期解析异常：{}", e.getMessage());
        }

        try {
            object = DateTool.getDate(DateConstant.DATE_PATTERN, -1, DateConstant.RETURN_DATE);
            logger.info("昨天:{}", object);
        } catch (ParseException e) {
            logger.error("昨天日期解析异常：{}", e.getMessage());
        }

        try {
            object = DateTool.getDate(DateConstant.DATE_PATTERN, 0, DateConstant.RETURN_DATE);
            logger.info("今天:{}", object);
        } catch (ParseException e) {
            logger.error("今天日期解析异常：{}", e.getMessage());
        }


        try {
            object = DateTool.getDate("2018-10-12 20:20:36", DateConstant.DATE_PATTERN, 1, DateConstant.RETURN_DATE);
            logger.info("指定日期的后一天:{}", object);
        } catch (ParseException e) {
            logger.error("指定日期的后一天日期解析异常：{}", e.getMessage());
        }

        try {
            object = DateTool.getDate("2018-10-12 20:20:36", DateConstant.DATE_PATTERN, -1, DateConstant.RETURN_DATE);
            logger.info("指定日期的前一天:{}", object);
        } catch (ParseException e) {
            logger.error("指定日期的前一天日期解析异常：{}", e.getMessage());
        }

        try {
            object = DateTool.getDate("2018-10-12 20:20:36", DateConstant.DATE_PATTERN, 0, DateConstant.RETURN_DATE);
            logger.info("指定日期的当天:{}", object);
        } catch (ParseException e) {
            logger.error("指定日期的当天日期解析异常：{}", e.getMessage());
        }

        try {
            object = DateTool.getDate("2018-10-12 20:20:36", DateConstant.DATE_PATTERN, 1, DateConstant.RETURN_STRING);
            logger.info("指定日期的后一天:{}", object);
        } catch (ParseException e) {
            logger.error("指定日期的后一天日期解析异常：{}", e.getMessage());
        }

        try {
            object = DateTool.getDate("2018-10-12 20:20:36", DateConstant.DATE_PATTERN, -1, DateConstant.RETURN_STRING);
            logger.info("指定日期的前一天:{}", object);
        } catch (ParseException e) {
            logger.error("指定日期的前一天日期解析异常：{}", e.getMessage());
        }

        try {
            object = DateTool.getDate("2018-10-12 20:20:36", DateConstant.DATE_PATTERN, 0, DateConstant.RETURN_STRING);
            logger.info("指定日期的当天:{}", object);
        } catch (ParseException e) {
            logger.error("指定日期的当天日期解析异常：{}", e.getMessage());
        }

    }
}