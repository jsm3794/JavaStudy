package quiz;

import myobj.myClass;

public class C09_Academy {

	/*
	 	1. 프로그래밍 반 학생들은
	 	   국어, 영어, 수학, C언어, 운영체제, 자료구조 점수가 있다
	 	   
	 	2. 네트워크 반 학생들은
	 	   국어, 영어, 리눅스, 네트워크, CCNA 점수가 있다
	 	   
	 	3. 머신러닝 반 학생들은
	 	   국어, 영어, 수학, 통계학, 파이썬, NO-SQL 점수가 있다
	 	   
	 	4. 100명의 학생을 랜덤으로 생성한다.
	 	   랜덤으로 생성되는 모든 학생들의 소속반, 과목별 점수, 이름이
	 	   모두 랜덤으로 생성되어야한다.
	 	   학생들의 학번은 중복없이 순차적으로 생성되어야 한다.
	 	   
	 	5. 성적표 출력 메서드를 통해 각 학생의
	 	   [학번/이름/과목별점수/총점/평균/등급]을 볼 수 있다.
	 */
	
	public static void main(String[] args) {
		myClass programmingClass = new myClass("프로그래밍", 100);
		programmingClass.genStudent();
		programmingClass.printScores();
		
		myClass networkClass = new myClass("네트워크", 100);
		networkClass.genStudent();
		networkClass.printScores();
		
		myClass machineLearningClass = new myClass("머신러닝", 100);
		machineLearningClass.genStudent();
		machineLearningClass.printScores();
	}
}
