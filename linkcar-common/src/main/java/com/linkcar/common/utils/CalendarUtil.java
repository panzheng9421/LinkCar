package com.linkcar.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {

    public static final String YYYY_MM = "yyyy-MM";

    public static final String YYYYMM = "yyyyMM";

    public static final String YYYYMMDD = "yyyyMMdd";

    /**
     * 获取当前时间
     */
    public static String getNowTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dft = new SimpleDateFormat(YYYYMMDD);
        String lastMonth = dft.format(cal.getTime());
        return lastMonth;
    }

    /**
     * 判断当天是否为本月第一天
     *
     * @return
     */
    public static boolean isFirstDayOfMonth() {
        boolean flag = false;
        Calendar calendar = Calendar.getInstance();
        int today = calendar.get(Calendar.DAY_OF_MONTH);
        if (1 == today) {
            flag = true;
        }
        return flag;
    }

    /**
     * 获取当前月份最后一天
     *
     * @return
     * @throws ParseException
     */
    public static String getMaxMonthDate() {
        SimpleDateFormat dft = new SimpleDateFormat(YYYYMMDD);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        // calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dft.format(calendar.getTime());
    }

    /**
     * 描述:获取下一个月的第一天.
     *
     * @return
     */
    public static String getPerFirstDayOfMonth() {
        SimpleDateFormat dft = new SimpleDateFormat(YYYYMMDD);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return dft.format(calendar.getTime());
    }

    /**
     * 获取第一天
     *
     * @param interval
     * @return
     */
    public static Date getFirstDayOfMonth(int interval) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, interval);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 描述:获取上个月的最后一天.
     *
     * @return
     */
    public static String getLastMaxMonthDate() {
        SimpleDateFormat dft = new SimpleDateFormat(YYYYMMDD);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dft.format(calendar.getTime());
    }

    /**
     * 获取上一个月
     *
     * @return
     */
    public static String getLastMonth() {
        return getLastMonth(YYYYMM);
    }

    /**
     * 获取上一个月
     *
     * @return
     */
    public static String getLastMonth(String format) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        SimpleDateFormat dft = new SimpleDateFormat(format);
        String lastMonth = dft.format(cal.getTime());
        return lastMonth;
    }

    /**
     * 开始月的第一天
     *
     * @param beginMonth
     * @return
     */
    public static Date getByBeginMonth(String beginMonth) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return dft.parse(beginMonth + "-01 00:00:00");
        } catch (ParseException e) {
            throw new RuntimeException("类型转换异常");
        }
    }

    /**
     * 结束月的最后一天
     *
     * @param endMonth
     * @return
     */
    public static Date getByEndMonth(String endMonth) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dft.parse(endMonth + "-01 23:59:59:999"));
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            return calendar.getTime();
        } catch (ParseException e) {
            throw new RuntimeException("类型转换异常");
        }
    }

    /**
     * 开始月的第一天
     *
     * @param beginMonth
     * @return
     */
    public static String getStrByBeginMonth(String beginMonth) {
        return beginMonth + "-01 00:00:00";
    }

    /**
     * 结束月的最后一天
     *
     * @param endMonth
     * @return
     */
    public static String getStrByEndMonth(String endMonth) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dft.parse(endMonth + "-01 23:59:59:999"));
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            return dft.format(calendar.getTime());
        } catch (ParseException e) {
            throw new RuntimeException("类型转换异常");
        }
    }

    public static String getDateTime(String timeStr, int date) {
        SimpleDateFormat dft = new SimpleDateFormat("HH:mm");
        try {
            Date dt1 = dft.parse(timeStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dt1);
            calendar.add(Calendar.MINUTE, date);
            return dft.format(calendar.getTime());
        } catch (ParseException e) {
            throw new RuntimeException("日期转换异常:" + timeStr);
        }
    }

    public static Date getDateTimeByAddMinute(int addMinute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, addMinute);
        return calendar.getTime();
    }

    public static String getDateTimeHhmm(Date date) {
        SimpleDateFormat dft = new SimpleDateFormat("HH:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return dft.format(calendar.getTime());
    }

    public static boolean compare(String sourceOld, String sourceNew) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");//创建日期转换对象HH:mm:ss为时分秒，年月日为yyyy-MM-dd
        try {
            Date dt1 = df.parse(sourceOld);//将字符串转换为date类型
            Date dt2 = df.parse(sourceNew);
            return dt1.getTime() > dt2.getTime();//比较时间大小,如果dt1大于dt2
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
