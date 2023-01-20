package com.generic.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
      
	public int getRandomNo()
	{
		Random ran= new Random();
		int random =ran.nextInt(500);
		return random;
	}
	public String getSystemDate()
	{
		Date dt = new Date();
		String date=dt.toString();
		return date;
	}
	
	public String getSystemDateAndTimeInFormate()
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-mm-yyyy HH:mm:ss");
		Date systemdate = new Date();
		String getDateAndTime = dateformat.format(systemdate);
		System.out.println(getDateAndTime);
		return getDateAndTime.replaceAll(":","-");
	}
	
}
