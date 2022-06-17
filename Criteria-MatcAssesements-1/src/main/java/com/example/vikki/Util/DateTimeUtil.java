package com.example.vikki.Util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.hibernate.internal.build.AllowSysOut;

public class DateTimeUtil {
	static long startTime = System.currentTimeMillis()/1000;
	static long endTime = System.currentTimeMillis();
	
	public static void main(String[] args) {
		float sec = (endTime - startTime) / 1000F; System.out.println(sec + " seconds");
		
	}
	
	

}
