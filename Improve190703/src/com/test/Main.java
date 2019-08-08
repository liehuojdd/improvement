package com.test;

import jmeter.asser.TxtWriter;
import jmeter.encode.Encode64;

public class Main {

	public static void main(String[] args) {
		//System.out.println("Hello");
		//TxtWriter txtWriter=new TxtWriter("D:\\bak\\workspace\\improve190703\\new.txt");
//		TxtWriter txtWriter=new TxtWriter("./File/new.txt");
		
		Encode64 encode=new Encode64();
		String str=encode.Encode("hello");
		System.out.println(str);
		System.out.println(encode.Decode(str));


	}

}
