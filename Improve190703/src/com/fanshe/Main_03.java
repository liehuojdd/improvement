package com.fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.openqa.selenium.io.FileHandler;

public class Main_03 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		//Reflec test for Selenium fileHandler class
		Class<FileHandler> fileHandler=FileHandler.class;
		Constructor<?>[] constructors=fileHandler.getConstructors();
		for(int i=0;i<constructors.length;i++) {
			System.out.println("Constructors "+i+ constructors[i].getParameters());
		}
		
		Method[] methods=fileHandler.getMethods();
		for(Method method:methods) {
			System.out.println("Has method name:"+method.getName());
			Class<?>[] paramTypes=method.getParameterTypes();
			for(Class<?> paramType:paramTypes) {
				System.out.println("\t"+paramType.getName());
			}
			
		}
		//Call one of the method
		Method waitMethod=fileHandler.getMethod("wait", long.class,int.class);
		System.out.println("Call wait method: "+waitMethod);
	}

}
