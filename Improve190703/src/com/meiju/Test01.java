package com.meiju;

public class Test01 {
	public enum WeekDayEnum { Mon, Tue, Wed, Thu, Fri, Sat, Sun }
	
	public static void doit2(WeekDayEnum c) {
		switch(c) {
		case Mon:
			System.out.println("Mon");
		case Tue:
			System.out.println("Tue");
		}
		
	}
	
	public static void main(String[] args) {
		//Test01.doit2(Test01.WeekDayEnum.Tue);
		System.out.println(NewsRSSFeedEnum.LATIMES_TOP_STORIES.getRssURL());
	}

}
