package com.Demo;

import org.testng.annotations.Test;

public class SampleTest01_Testng {
	
	@Test(groups="smoke")
	public void create()
	{
		System.out.println("created successfully");
		System.out.println("Banglore");
	}
	
	@Test(groups={"regression","smoke"})
	public void update()
	{
		System.out.println("updated successfully");
		System.out.println("Mysore");
	}
	
	@Test(groups="regression")
	public void delete()
	{
		System.out.println("deleted successfully");
		System.out.println("Chennai");
	}

}
