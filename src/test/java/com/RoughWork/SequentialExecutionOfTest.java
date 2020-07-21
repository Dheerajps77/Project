package com.RoughWork;

import org.testng.annotations.Test;

public class SequentialExecutionOfTest {
	
	
	@Test(priority=-10)
	public void Test2()
	{
		System.out.println("Test2");
	}
	
	@Test(priority=5)
	public void Test4()
	{
		System.out.println("Test4");
	}
	
	@Test(priority=-15)
	public void Test1()
	{
		System.out.println("Test1");
	}
	
	@Test(priority=0)
	public void Test3()
	{
		System.out.println("Test3");
	}

}
