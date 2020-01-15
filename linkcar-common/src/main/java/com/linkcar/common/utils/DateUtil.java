package com.linkcar.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 版权：Copyright XXX. All Rights Reserved.
 * 描述详情：时间工具类
 * 创建者： ZShuai
 * 创建时间：2019/09/02
 */
public class DateUtil {

    public static final String YYMMDD_HMS_24 = "yyyy/MM/dd HH:mm:ss";
    public static final String YYMMDD_HMS_24_1 = "yyyy-MM-dd HH:mm:ss";


    public final static String format1 = "yyyy-MM-dd";
    public final static String format2 = "yyyy-MM-dd HH:mm:ss";
    public final static String format3 = "yyyyMMddHHmm";
    public final static String format4 = "yyyyMM";
    public final static String format5 = "yyyyMMdd";
    public final static String format6 = "yyyyMMddHHmmss";
    public final static String format7 = "yyyyMMddHHmmssSSS";
    /** 日期转化 */
    public final static long convertS2Date(String time){
        SimpleDateFormat df = new SimpleDateFormat(format2);
        try {
            return df.parse(time).getTime();
        } catch (ParseException pe) {
            return 0;
        }
    }

    /** 用于日期格式装换 */
    public final static String convertL2S1(Calendar cal){
        SimpleDateFormat df = new SimpleDateFormat(format1);
        return df.format(cal.getTime());
    }

    /** 用于日期格式装换 */
    public final static String convertL2S2(Calendar cal){
        SimpleDateFormat df = new SimpleDateFormat(format2);
        return df.format(cal.getTime());
    }

    /** 用于日期格式转换 */
    public final static long convertS3Date(String time){
        if(time == null) return 0;
        SimpleDateFormat df = new SimpleDateFormat(format3);
        try {
            return df.parse(time).getTime();
        } catch (ParseException pe) {
            return 0;
        }
    }

    /** 以日期格式命名文件 */
    public final static String convertS6Date(Date time){
        SimpleDateFormat df = new SimpleDateFormat(format6);
        return df.format(time);
    }

    /** 将日期类型转换为长整型 */
    public final static long converS6TDate(String time){
        if(time == null) return 0;
        SimpleDateFormat df = new SimpleDateFormat(format6);
        try {
            return df.parse(time).getTime();
        } catch (ParseException pe) {
            return 0;
        }
    }

    /** 得到当前的日期到月 */
    public final static String convertS4Date(){
        SimpleDateFormat df = new SimpleDateFormat(format4);
        return df.format(Calendar.getInstance().getTime());
    }

    /** 得到当前的日期到月 */
    public final static String convertS5Date(){
        SimpleDateFormat df = new SimpleDateFormat(format5);
        return df.format(Calendar.getInstance().getTime());
    }

    /** 得到日期时间 */
    public final static String converS5Date(long time){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        SimpleDateFormat df = new SimpleDateFormat(format5);
        return df.format(cal.getTime());
    }

    public static String getYesterday(){
        //系统昨天日期
        Calendar   calendar=Calendar.getInstance();
        calendar.roll(Calendar.DAY_OF_YEAR,-1);
        SimpleDateFormat df=new SimpleDateFormat(format5);
        return df.format(calendar.getTime()).toString();
    }

    public static String getToday(){
        //系统今天日期
        Calendar   calendar=Calendar.getInstance();
        calendar.roll(Calendar.DAY_OF_YEAR,0);
        SimpleDateFormat df=new SimpleDateFormat(format5);
        return df.format(calendar.getTime()).toString();
    }

    public static String getTime(){
        //系统今天日期
        Calendar   calendar=Calendar.getInstance();
        calendar.roll(Calendar.DAY_OF_YEAR,0);
        SimpleDateFormat df=new SimpleDateFormat(format6);
        return df.format(calendar.getTime()).toString();
    }

    public static String getTodayTimeSSS(){
        //系统今天日期
        Calendar   calendar=Calendar.getInstance();
        calendar.roll(Calendar.DAY_OF_YEAR,0);
        SimpleDateFormat df=new SimpleDateFormat(format7);
        return df.format(calendar.getTime()).toString();
    }

    public static String getTimeHHmmss(){
        //系统今天日期
        Calendar   calendar=Calendar.getInstance();
        calendar.roll(Calendar.DAY_OF_YEAR,0);
        SimpleDateFormat df=new SimpleDateFormat(format6);
        return df.format(calendar.getTime()).toString().substring(8, 14);
    }

    public static String getTodayFormat2(){
        //系统今天日期
        Calendar   calendar=Calendar.getInstance();
        calendar.roll(Calendar.DAY_OF_YEAR,0);
        SimpleDateFormat df=new SimpleDateFormat(format2);
        return df.format(calendar.getTime()).toString();
    }

    public static String getTodayFormat3(){
        //系统今天日期
        Calendar   calendar=Calendar.getInstance();
        calendar.roll(Calendar.DAY_OF_YEAR,0);
        SimpleDateFormat df=new SimpleDateFormat(format3);
        return df.format(calendar.getTime()).toString();
    }

    public static String getTimeStamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    /**
     * 20150325205625 转换成2015-03-25 20:56:25
     * @param time
     * @return
     */
    public static String getTimeString(String time){
        String date=time.substring(0, 4)+"-"+time.substring(4,6)+"-"+time.substring(6, 8)
                +" "+time.substring(8,10)+":"+time.substring(10,12)+":"+time.substring(12,14);
        return date;
    }

    /**
     * 2015-03-22 16:42:25 转日期 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date getTimeStamp1(String dateStr) {
        Date date = new Date();
        //注意format的格式要与日期String的格式相匹配
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(dateStr);
            //	System.out.println(date.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 20150322164225 转日期 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date getTimeStamp2(String time) {
        String dateStr=time.substring(0, 4)+"-"+time.substring(4,6)+"-"+time.substring(6, 8)
                +" "+time.substring(8,10)+":"+time.substring(10,12)+":"+time.substring(12,14);
        Date date = new Date();
        //注意format的格式要与日期String的格式相匹配
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(dateStr);
            //	System.out.println(date.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 计算两个日期之间相差的天数
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate,Date bdate) throws ParseException
    {
        SimpleDateFormat sdf=new SimpleDateFormat(format2);
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days))+1;
    }

    /**
     *字符串的日期格式的计算
     */
    public static int daysBetween(String smdate,String bdate) throws ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat(format2);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days))+1;
    }

    public static long getCurrentTime(){
        Date date = new Date();
        return date.getTime();
    }

    /**
     * 测试时间
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {

//    	String  smdate=DateUtil.getTodayFormat2();
//		String	bdate="2015-11-16 10:17:19";
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar cal = Calendar.getInstance();
//
//
//        cal.setTime(sdf.parse(smdate));
//        long time1 = cal.getTimeInMillis();
//        cal.setTime(sdf.parse(bdate));
//
//        long time2 = cal.getTimeInMillis();
//        long between_days=(time2-time1)/(1000*3600*24);
//
//        System.out.println(Integer.parseInt(String.valueOf(between_days)));


//		String  yesterday=getYesterday();
//		System.out.println("yesterday=============="+yesterday);
//		String  today=getToday();
//		System.out.println("today=================="+today);
//		String time =getTime();
//		System.out.println("today==time================"+time);
//
//		String time2 =getTimeHHmmss();
//		System.out.println("today==time2================"+time2);
//
//		String time3 =getTodayTimeSSS();
//		System.out.println("today==time3================"+time3);
//
//		String time4=getTodayFormat2();
//		System.out.println("today==time4================"+time4);



//		String dateStr = "2015-03-22 16:42:25";
//		Date date = new Date();
//		//注意format的格式要与日期String的格式相匹配
//		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		try {
//			date = sdf.parse(dateStr);
//			System.out.println(date.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
        String smdate ="2015-11-13 14:00:00";

        String bdate ="2015-11-14 13:00:00";
        SimpleDateFormat sdf=new SimpleDateFormat(format2);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        int num= Integer.parseInt(String.valueOf(between_days))+1;
        System.out.println("距离结束天数"+num);
    }

    /**
     * 将String类型转换成Date类型
     * 创建人：hebl
     * @param time
     * @return
     */
    public static Date getStringToDate(String time) {
        return getStringToDate(time, DateUtil.YYMMDD_HMS_24);
    }

    /**
     * 将String类型转换成Date类型
     * 创建人：hebl
     * @param time
     * @return
     */
    public static Date getStringToDate1(String time) {
        return getStringToDate(time, DateUtil.YYMMDD_HMS_24_1);
    }


    /**
     * 将String类型转换成Date类型
     * 创建人：yupeng
     * @param time 时间
     * @param DateModel 时间模版格式
     * @return Date
     */
    public static Date getStringToDate(String time, String DateModel) {
        if(time == null || "".equals(time)) {
            return null;
        } else {
            SimpleDateFormat sd = new SimpleDateFormat(DateModel);
            Date date = null;
            try {
                date = sd.parse(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        }
    }

    /**
     * 获取当前时间加减N分钟后的时间
     * 创建人：hebl
     * 创建时间：2018/7/30 15:23
     * @param minute 分钟
     * @param template 生成的时间模板
     * @return
     */
    public static String getDateAddMinute(int minute, String template) {
        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MINUTE, minute);
        return new SimpleDateFormat(template).format(lastDate.getTime());
    }



}
