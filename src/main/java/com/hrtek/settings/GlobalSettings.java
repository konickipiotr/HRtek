package com.hrtek.settings;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

public class GlobalSettings {

	public static String agent = "Agent";
	public static String coordinator = "Coordinator";
	public static String boss = "Boss";
	public static String admin = "Admin";
	
	public static String hrtekRoot = "/HRtekfiles";
	public static String hrtekWorkersDir = "/WorkersData/";
	
	public static int lockupminue = 5; //zablokowana edycja danych an tyle minut
	public static int numoffirstletters = 3; //filtrowanie po x pierwszych literach
	
}
