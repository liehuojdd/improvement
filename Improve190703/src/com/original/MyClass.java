package com.original;

import sun.net.www.content.text.Generic;

public class MyClass{
	//Waring: The value of the field MyClass.age is not used
	private int age;
	//Illegal modifier for the method SayAge;
	//default char SayAge() {
	final char SayAge() {
		this.age=1;
		return 20;
	}
	
	public void showKeyValue1(Generic obj){
	    //Log.d("泛型测试","key value is " + obj.getKey());
	}
}