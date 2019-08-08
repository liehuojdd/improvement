package com.fanshe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;;

public class AttrFun {

	public static void main(String[] args) throws Exception{
//		Class<?> userClass=new User().getClass();
//		Class<?> userClass = Class.forName("reflec.User");
//		User user=userClass.newInstance();
//		Class<? extends User> userClass = new User().getClass();
		Class<User> userClass=User.class;
		User user=userClass.newInstance();
		
		Field fields[]=userClass.getDeclaredFields();
		//For field.get(user)
		//class reflec.AttrFun cannot access a member of class reflec.User with modifiers "private"
		Field.setAccessible(fields, true);
		for(Field field:fields) {
			System.out.println("Name:"+field.getName()+"\tAttrbute:"+field.get(user)+"\tType"+field.getType());
		}
		
		System.out.println("Methods:");
		Method[] methods=userClass.getDeclaredMethods();
		for(Method method:methods) {
			System.out.println(method.getName()+"\treturn type:"+method.getReturnType().getName());
			Class<?>[] paramTypes=method.getParameterTypes();
			for(Class<?> paramType:paramTypes) {
				//From this line, you can findout getDeclaredMethod("setName",String.class)
				//not getDeclaredMethod("setName")
				System.out.println("\t"+paramType.getName()+"\t");
			}
		}
		Method getMethod=userClass.getDeclaredMethod("getName");
		getMethod.setAccessible(true);
		System.out.println("Call getName function:"+getMethod.invoke(user));
		//java.lang.NoSuchMethodException
//		Method setMethod = userClass.getDeclaredMethod("setName");
		Method setMethod = userClass.getDeclaredMethod("setName",String.class);
		setMethod.setAccessible(true);
		System.out.println("Call setMethod function:"+setMethod.invoke(user, "mark"));
		System.out.println("After change setMethod:"+user);
	}

}
