package cn.gloryroad;

import java.util.Calendar;
import java.util.Date;

public class dateutil {

    //格式化输出日期
    public static String format(java.util.Date date,String format){
        String result="";
        try {
            if (date!=null){
                java.text.DateFormat df=new java.text.SimpleDateFormat(format);
                result=df.format(date);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    // return year
    public static int getyear(java.util.Date date){
        java.util.Calendar c=java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.YEAR);
    }
    //return month
    public static int getmonth(java.util.Date date){
        java.util.Calendar c=java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.MONTH)+1;
    }
    //return day
    public static int getday(java.util.Date date){
        java.util.Calendar c=java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.DAY_OF_MONTH);
    }
    //return hour
    public static int gethour(java.util.Date date){
        java.util.Calendar c=java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.HOUR_OF_DAY);
    }
    //return minute
    public static int getminute(java.util.Date date){
        java.util.Calendar c=java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.MINUTE);
    }
    //return second
    public static int getsecond(java.util.Date date){
        java.util.Calendar c=java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.SECOND);
    }

}
