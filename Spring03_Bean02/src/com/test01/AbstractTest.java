package com.test01;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class AbstractTest { // 추상 클래스
	public abstract String dayInfo(); // 추상 메소드
	
	public static AbstractTest getInstance() { // 일반 static 메소드
		
		GregorianCalendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(day) {
			case 1: return new Sunday();
			case 2: return new Monday();
			case 3: return new Tuesday();
			case 4: return new Wednesday();
			case 5: return new Thursday();
			case 6: return new Friday();
			case 7: return new Saturday();
		}
		
		return null;
	}
}
