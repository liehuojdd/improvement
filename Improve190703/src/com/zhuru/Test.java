package com.zhuru;


public class Test {

	public static void main(String[] args) {
		HumanFactory humanFactory = new HumanFactory();
        Human human1 = humanFactory.getHuman("chinese");
        human1.sayHelloWorld("张三");

        Human human2 = humanFactory.getHuman("american");
        human2.sayHelloWorld("Jack");//Spring framework
		
		Car toyota=new Car("TOYOTA");
		Person boy=new Person(toyota);
		boy.drive();

	}

}
