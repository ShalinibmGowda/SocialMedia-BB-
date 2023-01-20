package com.Demo;

import org.testng.annotations.Test;

public class SampleTest {
	public static void main(String[] args) {
		System.out.println("hi");
	}
	
	@Test(invocationCount = 2)
	public void gmail() {
		System.out.println("gmail is working");
	}
	@Test(dependsOnMethods = "gmail")
	public void username()
	{
		System.out.println("username is taking");
	}
	@Test(enabled = false)
	public void password()
	{
		System.out.println("password is taking");
	}

}
