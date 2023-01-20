package com.Demo;

import org.testng.annotations.Test;

public class SampleTest03_Testng {

	@Test(groups= {"smoke","regression"})
	public void create()
	{
		System.out.println("created successfully");
		System.out.println("Hassan");
	}
	
	@Test
	public void update()
	{
		System.out.println("updated successfully");
		System.out.println("mandya");
	}
	
	@Test
	public void delete()
	{
		System.out.println("deleted successfully");
		System.out.println("Manglore");
	}
}
