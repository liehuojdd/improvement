package com.TestFrame01;

import com.util.Email;

public class EmailTest {

	public static void main(String[] args) {
		Email email=new Email("zhangweiming@yeah.net", "D:\\hw.jpg");
		email.send("Mark email", "This is my context");

	}

}
