package com.fanshe;

import java.lang.reflect.*;

public class Main_01 {

	public static void main(String[] args) {

		Example_01 example = new Example_01("10", "20", "30");
		Class<? extends Example_01> exampleC = example.getClass();

		Constructor[] declaredConstructors = exampleC.getDeclaredConstructors();
		for (int i = 0; i < declaredConstructors.length; i++) {
			Constructor<?> constructor = declaredConstructors[i];
			System.out.println("Var args:" + constructor.isVarArgs());
			System.out.println("The arg type is:");
			Class[] parameterTypes = constructor.getParameterTypes();
			for (int j = 0; j < parameterTypes.length; j++) {
				System.out.println(" " + parameterTypes[j]);
			}
			System.out.println("Exception type is:");
			Class[] exceptionTypes = constructor.getExceptionTypes();
			for (int j = 0; j < exceptionTypes.length; j++) {
				System.out.println(" " + exceptionTypes[j]);
			}
			Example_01 example2 = null;
			while (example2 == null) {
				try {
					if (i == 2)
						example2 = (Example_01) constructor.newInstance();
					else if (i == 1)
						example2 = (Example_01) constructor.newInstance("7", 5);
					else {
						Object[] parameters = new Object[] { new String[] {
								"100", "200", "300" } };
						example2 = (Example_01) constructor
								.newInstance(parameters);
					}
				} catch (Exception e) {
					System.out.println("Throw exception when create job. do the setAccessible(true) ");
					constructor.setAccessible(true);
				}
			}
			if(example2!=null){
			example2.print();
			System.out.println();
			}
		}

	}

}
