package com.telcom.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

public class SystemUtil {
	
	/**
	 * 获取系统当前时间
	 * @return
	 */
	public static Timestamp getCurrentTime(Date date)
	{
		SimpleDateFormat formatTimestamp = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String str = formatTimestamp.format(date);
		Timestamp time = Timestamp.valueOf(str);
		return time;
	}

	public static String getTimeRandom()
	{ 
		String val = "";
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = format.format(date);
		Integer random = (int) (100000*Math.random());
		val = time.substring(2,time.length())+random.toString();
		return val; 
	}
	
	public static void main(String[] args) {
		
		String[] we = {"121","333","weqw"};
		for (int i = 0; i < we.length; i++);
			System.out.println("i love you");
		System.out.println("werewe");
	}

	
	public static String getLoginParam(HttpSession session,String param){
		if(Constant.SESSION_LASTLOGIN.equals(param)){
			return ((Timestamp)(session.getAttribute(param))).toString();
		}else{
			return  (String) session.getAttribute(param);
		}
		
	}
	public static String getDateString(Date data){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(data);
	}
	public static Date getStringDate(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dd=null;
		try {
			dd = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dd;
	}

	/**
	 * 距今日期
	 * 
	 * @param today
	 * @param upDay
	 * @return
	 */
	public static String lastDayUpToToday(Date today, int upDay) {
		// today = "20120809";
		// 至今upDay天的日期
		String lastDate = "";
		if (today == null)
			return null;
		else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(today);
			calendar.add(Calendar.DATE, upDay);
			lastDate = getDateString(calendar.getTime());
		}
		return lastDate;
	}

}
