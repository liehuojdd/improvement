package com.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test0709_DateYesterday {

	public static void main(String[] args) {
		Date date=new Date();
		System.out.println(date.getTime());
		Date date1=new Date(24);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		SimpleDateFormat sdf=new SimpleDateFormat();
		String current=sdf.format(System.currentTimeMillis());
		System.out.println(current);
		
		Date dNNow=new Date();
		Calendar calendars=Calendar.getInstance();
		calendars.setTime(dNNow);
		calendars.add(Calendar.DAY_OF_MONTH, -1);
		Date dBefore=calendars.getTime();
		
		String defaultStartDate=df.format(dBefore);
		System.out.println(defaultStartDate);
		
	}

}
