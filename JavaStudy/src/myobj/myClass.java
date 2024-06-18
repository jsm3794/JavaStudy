package myobj;

import java.util.Random;

public class myClass {

	public String className;
	public Student[] students;
	int studentId;
	
	public myClass(String className, int studentNum) {
		this.className = className;
		this.students = new Student[studentNum];
		this.studentId = 1;
	}
	
	public void genStudent() {
		Random ran = new Random();
		for (int i = 0; i < students.length; i++) {
			students[i] = new Student(studentId++, "학생" + studentId);
			
			students[i].genRanScores();
		}
	}
	
	public void printScores() {
		System.out.println(className + "반 성적표");
		System.out.println("학번/이름/과목별점수/총점/평균/등급");
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println();
	}
}
