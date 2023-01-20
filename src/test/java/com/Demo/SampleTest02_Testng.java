package com.Demo;

import org.testng.annotations.Test;

public class SampleTest02_Testng {
	
	@Test(groups="regression")
	public void create()
	{
		System.out.println("created successfully");
		System.out.println("Delhi");
	}
	
	@Test(groups="smoke")
	public void update()
	{
		System.out.println("updated successfully");
		System.out.println("ladak");
	}
	
	@Test(groups= {"smoke","regression"})
	public void delete()
	{
		System.out.println("deleted successfully");
		System.out.println("kerala");
	}

}
