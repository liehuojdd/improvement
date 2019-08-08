package com.zhuru;

class Chinese implements Human {
    public void sayHelloWorld(String name) {
         String helloWorld = "Chinese hello" + name;
         System.out.println(helloWorld);
    }
}
