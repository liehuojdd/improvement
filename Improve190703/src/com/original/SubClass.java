package com.original;

import java.lang.reflect.Field;

public class SubClass extends MyClass {
	public String name="mark";
	public Integer a=1;
	private String b="abc";
	public Character c='3';
	public char[] name2= new char[]{'m','a','r','k'}; 
	public char name3='m';
	//Cannot override the final method from MyClass
	//public char SayAge() {
	//	super.SayAge();
	//}
	public void SayHello() {
		String name="mark";
		Integer a=1;
		Character c='3';
		char[] name2= new char[]{'m','a','r','k'}; 
		char name3='m';
		MyLabel:for(int i=0;i<3;i++) {
			if(i==4) {
				break MyLabel;
			}
		}
		//Incompatible conditional operand types String and Character
		//System.out.println(name instanceof Character);
		System.out.println();
	}
	private void DoSomeThing() {
		System.out.println("Something");
	}
}
