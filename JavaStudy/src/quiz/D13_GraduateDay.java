package quiz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class D13_GraduateDay {

	/*
	 	사용자가 수업을 시작하는 날짜와 수업을 받아야 하는 날을 입력하면
	 	수업을 쉬는 날을 모두 출력해주고
	 	수업이 종료되는 날짜도 알려주는 프로그램을 만들어보세요
	 	
	 	쉬는날 - 토, 일, 공휴일(대체 휴일 포함)
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Calendar startDate = Calendar.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (EEEE)");
		
		System.out.print("수업을 시작하는 날짜 입력 > ");
		String startDateStr = sc.nextLine();
		
		System.out.print("수업을 받아야하는 총 일수 입력 > ");
		int totalDays = sc.nextInt();
		
		String[] date = startDateStr.split("-");
		startDate.set(Integer.valueOf(date[0]), 
				Integer.valueOf(date[1]) - 1, Integer.valueOf(date[2]));
		
		int[][] holidays = {{Calendar.JANUARY, 1}, {Calendar.MARCH, 1}, {Calendar.MAY, 5}, 
				{Calendar.MAY, 6}, {Calendar.JUNE, 6}, {Calendar.AUGUST, 15}, 
				{Calendar.SEPTEMBER, 16}, {Calendar.SEPTEMBER, 17}, {Calendar.SEPTEMBER, 18}, 
				{Calendar.OCTOBER, 3}, {Calendar.OCTOBER, 9}, {Calendar.DECEMBER, 25}};
		setHolidays(startDate, holidays);
		
		// 쉬는 날 출력
		while (totalDays > 0) {
			int dayOfWeek = startDate.get(Calendar.DAY_OF_WEEK);
			if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
				System.out.println("쉬는 날: " + sdf.format(startDate.getTime()));
			}
			startDate.add(Calendar.DAY_OF_MONTH, 1);
			totalDays--;
		}
		
		// 수업 종료 날짜 출력
		startDate.add(Calendar.DAY_OF_MONTH, -1);
		startDate.add(Calendar.DAY_OF_MONTH, totalDays);
		System.out.println("수업 종료 날짜: " + sdf.format(startDate.getTime()));
	}

	private static void setHolidays(Calendar startDate, int[][] holidays) {
		for (int i = 0; i < holidays.length; i++) {
			
		}
		
	}

}
