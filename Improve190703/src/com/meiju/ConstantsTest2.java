package com.meiju;

public class ConstantsTest2 {
	enum Constants2{
		Constants_A,Constants_B
	}
	public void doit2(Constants2 c) {
		switch(c) {
		case Constants_A:
			System.out.println("Constants_A");
			break;
		case Constants_B:
			System.out.println("Constants_B");
			break;
		}
	}
	public static void main(String[] args) {
		ConstantsTest2 constantsTest=new ConstantsTest2();
		constantsTest.doit2(ConstantsTest2.Constants2.Constants_A);
	}
}
