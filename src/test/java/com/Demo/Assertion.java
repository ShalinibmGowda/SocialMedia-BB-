package com.Demo;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class Assertion {
	
	@Test
	public void hardAssert1()
	{
		System.out.println("Teacher is teaching");
		System.out.println("Teacher is teaching Chemistry also");
		System.out.println("Taecher is teaching Bio also");
		assertEquals("a", "b", "teaching");
		System.out.println("Teacher cannot teach Maths");
	}
	
	@Test
	public void hardAssert2()
	{
		String a=null;
		assertNull(a);
		System.out.println("Bird is flying");
		System.out.println("Bird is eating");
	}
	
	@Test
	public void hardAssert3()
	{
		System.out.println("shalini is reading");
		System.out.println("omkar is running");
		System.out.println("anil is eating");
		System.out.println("");
		
	}

}
