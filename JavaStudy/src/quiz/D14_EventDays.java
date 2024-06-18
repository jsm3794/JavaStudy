package quiz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class D14_EventDays {

	/*
	 	실행하면 오늘부터 앞으로 1년간의 이벤트 날짜를 모두 출력해주는 
	 	프로그램을 만들어주세요
	 	
	 	1+1 이벤트 : 매 월 18일
	 	20% 할인 이벤트 : 홀수번째 주 금요일
	 	구매시 아메리카노 무료 이벤트 : 매주 화요일
	 	
	 	※ 이벤트 날짜가 겹치는 날에는 모든 이벤트를 출력해줘야 한다
	 */
	
	public static void main(String[] args) {
		
		Calendar today = Calendar.getInstance();
		Calendar oneYear = Calendar.getInstance();
		oneYear.add(Calendar.YEAR, 1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
		
		while (today.before(oneYear)) {
			StringBuilder events = new StringBuilder();
			
			// 1+1 이벤트 : 매 월 18일
			if (today.get(Calendar.DAY_OF_MONTH) == 18) {
				events.append("1+1 이벤트 ");
			}
			
			// 20% 할인 이벤트 : 홀수번째 주 금요일
			if (today.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
				int weekOfMonth = today.get(Calendar.WEEK_OF_MONTH);
				if (weekOfMonth % 2 == 1) {
					events.append("20% 할인 이벤트 ");
				}
			}
			
			// 구매시 아메리카노 무료 이벤트 : 매주 화요일
			if (today.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
				events.append("구매시 아메리카노 무료 이벤트 ");
			}
			
			if (events.length() > 0) {
				String dayOfWeek = today.getDisplayName(
						Calendar.DAY_OF_WEEK, 
						Calendar.LONG, 
						Locale.KOREAN);
				System.out.printf("%s (%s): %s\n", sdf.format(today.getTime()), dayOfWeek, events.toString().trim();
			}
			
			today.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		
	}
}
