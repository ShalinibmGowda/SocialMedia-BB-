package com.Demo;

import org.testng.annotations.Test;

public class Practice_Testng {
	
	@Test
	public void create()
	{
		System.out.println("create project done");
	}
	
	@Test(invocationCount = 3 )
	public void update()
	{
		System.out.println("update project done");
	}
	
	@Test(priority = 1,dependsOnMethods = "update")
	public void delete()
	{
		System.out.println("delete project");
	}

}
