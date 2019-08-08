package com.original;

import java.util.ArrayList;
import java.util.List;

public class FanXing {

	public static void main(String[] args) {
		List arrayList=new ArrayList();
		arrayList.add("abc");
		arrayList.add(100);
		for(int i=0;i<arrayList.size();i++) {
			//String item=(String)arrayList.get(i);
			//System.out.println(item);
		}
		
		List<String> stringArrayList = new ArrayList<String>();
		List<Integer> integerArrayList = new ArrayList<Integer>();

		Class classStringArrayList = stringArrayList.getClass();
		Class classIntegerArrayList = integerArrayList.getClass();
		if(classStringArrayList.equals(classIntegerArrayList)){
			System.out.println("FanXing test");
		}

	}

}
