package com.fanshe;

/*
 * Url:https://www.cnblogs.com/zhaoguhong/p/6937364.html
 * */

import java.lang.reflect.Constructor;

public class Main_02 {

	public static void main(String[] args) throws Exception {
		System.out.println("Get class 3 ways:");
		System.out.println(User.class);
		System.out.println(new User().getClass());
		System.out.println(Class.forName("reflec.User"));
		
		System.out.println("The functions:");
		Class<User> userClass=User.class;
		System.out.println("Get full name- "+userClass.getName());
		System.out.println("Get name- "+userClass.getSimpleName());
		//The method newInstance() from the type Class<User> is deprecated since version 9
		System.out.println("Create instance- "+userClass.newInstance());
		
		System.out.println("Constructor test:");
		Constructor<?>[] constructors=userClass.getConstructors();
		for(int i=0;i<constructors.length;i++) {
			System.out.println("Number is "+i);
			Class<?> parameterTypesClass[]=constructors[i].getParameterTypes();
			for(int j=0;j<parameterTypesClass.length;j++) {
				System.out.println(parameterTypesClass[j].getName()+"\t");
			}
		}
		//Using constructor, create new instance.
		System.out.println("Use constructor 1 "+constructors[0].newInstance("Mark",1));
		System.out.println("Use constructor 2 "+constructors[1].newInstance());
		
	}

}

