package com.util;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringHandler {
	public StringHandler(){}

	public StringHandler(String proFilePath)
	{
//		ph=new PropertiesHandle(proFilePath);
	}
	public String HandlerInputStr(String str)
	{
		String myStr=str;
		if(("null").equals(str))
		{
			myStr="";
		}
		return myStr;
	}
	/**
	 * 
	 * @param regCheck
	 * proNanme of regex
	 * @param str
	 * text for validate
	 * @return
	 */
	public Boolean MatchText(String regCheck,String str)
	{
//		String b=ph.readValue(regCheck);
		Pattern regex = Pattern.compile(regCheck); 
		Matcher matcher = regex.matcher(str);
		return matcher.matches(); 
	}
	public Boolean StartWithText(String prefix,String str)
	{
		if(str!=null){
			return str.startsWith(prefix);
		}
		return false;
	}
	public Boolean EndWithText(String prefix,String str)
	{
		if(str!=null){
			return str.endsWith(prefix);
		}
		return false;
	}
	public Boolean ContainWithText(String prefix,String str)
	{
		if(str!=null){
			return str.contains(prefix);
		}
		return false;
	}
	public String[] SPTwo(String strhandle)
	{
		String[] arg=strhandle.split(";");
		String[] temp=new String[2];
		for(int i=0;i<arg.length;i++)
		{
			temp[i]=arg[i];
		}
		return temp;
	}
	public String ParaentXPath(String strhandle){
		String[] arg=strhandle.split("/");
		StringBuilder str=new StringBuilder();
		for(int i=1;i<arg.length-1;i++){
			str.append("/");
			str.append(arg[i]);
		}
		return str.toString();
	}
	/**
	 * 
	 * @return an email account
	 * abc(some character in random)@test.com
	 */
	public String MakeEmailAccount()
	{
		char char1=(char)(Math.random()*25+97);
		char char2=(char)(Math.random()*25+97);
		int char3=(int)(Math.random()*1000);
		char char4=(char)(Math.random()*25+97);
		char char5=(char)(Math.random()*25+97);
		char char6=(char)(Math.random()*25+97);
		String myemail="abc"+char1+char2+char3+char4+char5+char6+"@test.com";
		return myemail;
	}
	public String NamedByDate(){
		int y,m,d,h,mi,s,ran;   
		Calendar cal=Calendar.getInstance();   
		y=cal.get(Calendar.YEAR);   
		m=cal.get(Calendar.MONTH);   
		d=cal.get(Calendar.DATE);   
		h=cal.get(Calendar.HOUR_OF_DAY);   
		mi=cal.get(Calendar.MINUTE);   
		s=cal.get(Calendar.SECOND);
		ran=(int)(Math.random()*1000);
		return String.valueOf(y)+String.valueOf(m)+String.valueOf(d)+String.valueOf(h)+String.valueOf(mi)+String.valueOf(ran);
	}
}

