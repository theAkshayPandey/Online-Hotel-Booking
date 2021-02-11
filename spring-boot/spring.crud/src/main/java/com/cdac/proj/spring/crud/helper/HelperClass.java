package com.cdac.proj.spring.crud.helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class HelperClass {

	
	public HashMap<String, LocalDateTime> convertDateTime(String checkin,String checkout)
	{
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
		LocalDateTime  checkin_date =  LocalDateTime.parse(checkin, inputFormatter).withHour(0).withMinute(0).withSecond(0).withNano(0);
		LocalDateTime  checkout_date = LocalDateTime.parse(checkout, inputFormatter).withHour(0).withMinute(0).withSecond(0).withNano(0);
		System.out.println(checkin_date.getClass());
		
		HashMap<String, LocalDateTime> date_dict = new HashMap<String, LocalDateTime>();
		date_dict.put("checkin", checkin_date);
		date_dict.put("checkout", checkout_date);

		
		return date_dict;
		
	}
}
