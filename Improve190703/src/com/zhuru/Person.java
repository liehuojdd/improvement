package com.zhuru;

public class Person {
	private ICar car;
	public Person(ICar onecar) {
		car=onecar;
	}
	public void drive() {
		//Dependence Inversion
		//强依赖，改动麻烦
		//Car toyota=new Car("TOYOTA");
		String a=car.GuaDang;
		String b=car.YouMen;		
		
	}
	//属性注入
	public void setCar(ICar onecar) {
		this.car=onecar;
	}
}
