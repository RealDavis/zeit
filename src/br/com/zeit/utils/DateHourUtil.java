package br.com.zeit.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateHourUtil {
	
	public static LocalDate strToDBFormat(String data) {
		LocalDate date = null;
		if(data != null && !data.isEmpty()) {
			date = LocalDate.parse(data);
		}
		return date;
	}
	
	public static String dateToStr(LocalDate date) {
		String dateFormated = "";
		if(date != null) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/MM/yyyy");
			dateFormated = date.format(dtf);
		}
		
		return dateFormated;
	}
	
	public static LocalTime strToHour(String hour) {
		LocalTime hourDT = null;
		if(hour != null && !hour.isEmpty()) {
			String[] hourArray = hour.split(":");
			hourDT = hourDT.of(Integer.parseInt(hourArray[0]), Integer.parseInt(hourArray[1]));
		}
		return hourDT;
	}
	
}
