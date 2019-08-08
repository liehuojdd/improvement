package com.original;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AssertType {

	public static void main(String[] args) throws Exception{
		SubClass subClass=new SubClass();
		Field[] fields=subClass.getClass().getFields();
		for(Field f: fields) {
			Class<?> classType=f.getType();
			//Primitive: yuan shi de 
			if (!classType.isPrimitive() && classType == String.class) {
				System.out.println("String");
			}
		}
		Method method=subClass.getClass().getDeclaredMethod("DoSomeThing");
		Field bField=subClass.getClass().getDeclaredField("b");
		method.setAccessible(true);
		bField.setAccessible(true);
		//class com.original.AssertType cannot access a member of class com.original.SubClass with modifiers "private"
		method.invoke(subClass);
		System.out.println(bField.get(subClass));

	}
	

}
