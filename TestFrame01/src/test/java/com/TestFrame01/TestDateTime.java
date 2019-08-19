package com.TestFrame01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateTime {

	public static void main(String[] args) {
		SimpleDateFormat format1=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		//Get Current Date
		//String format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		//long now2 = new Date().getTime();
		
		try {
			int iHour=1;
			int iMinute=27;
			int iSecond=23;
			String dateNow="8/12/2019 23:32:07";
			double timeStamp1=1566180477796d;
			long timeStamp2=1527767665;
			
			Date date1=format1.parse(dateNow);
			date1.setHours(date1.getHours()+iHour);
			date1.setMinutes(date1.getMinutes()+iMinute);
			date1.setSeconds(date1.getSeconds()+iSecond);
			String t=format1.format(date1);
			System.out.println("Date time:"+dateNow);
			System.out.println("After increase:"+iHour+":"+iMinute+":"+iSecond);
			System.out.println(t);
			
			System.out.println("timeStamp1:"+format1.format(timeStamp1));
			System.out.println("timeStamp2:"+format1.format(new Date(timeStamp2*1000)));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
