package myobj.academy;

// 프로그래밍 반 학생들은 
// 국어, 영어, 수학, C언어, 운영체제, 자료구조 점수가 있다
public class ProgrammingStudent2 extends AcademyStudent {

	int kor;
	int eng;
	int math;
	int c;
	int op; // operator
	int ds; // data structure
	
	public ProgrammingStudent2() {
		super();
		kor = generateRandomScore();
		eng = generateRandomScore();
		math = generateRandomScore();
		c = generateRandomScore();
		op = generateRandomScore();
		ds = generateRandomScore();
	}
	
	@Override
	public int getTotal() {
		return kor + eng + math + c + op + ds;
	}
	
	@Override
	public double getAvg() {
		return getTotal() / 6.0;
	}
	
	@Override
	public String getGrade() {
		double avg = getAvg();
		if (avg >= 90) {
			return "A";
		} else if (avg >= 80) {
			return "B";
		} else if (avg >= 70) {
			return "C";
		} else if (avg >= 60) {
			return "D";
		} else {
			return "F";
		}
	}
	
	@Override
	public String getScores() {
		return String.format("국어: %d\n영어: %d\n수학: %d\n" 
				+ "C언어: %d\n운영체제: %d\n자료구조: %d\n", kor, eng, math, c, op, ds);
	}
}
