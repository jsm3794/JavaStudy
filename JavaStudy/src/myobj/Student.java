package myobj;

import java.util.Random;

public class Student {

	int id;
	String name;
	
	int kor, eng, math, 
	c_lan, os, dataStructure, 
	linux, network, ccna, 
	statistics, python, nosql;
	int total;
	double average;
	String grade;
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void genRanScores() {
		Random ran = new Random();
		this.kor = ran.nextInt(101);
		this.eng = ran.nextInt(101);
		this.math = ran.nextInt(101);
		this.c_lan = ran.nextInt(101);
		this.os = ran.nextInt(101);
		this.dataStructure = ran.nextInt(101);
		this.linux = ran.nextInt(101);
		this.network = ran.nextInt(101);
		this.ccna = ran.nextInt(101);
		this.statistics = ran.nextInt(101);
		this.python = ran.nextInt(101);
		this.nosql = ran.nextInt(101);
		this.total = kor + eng + math + c_lan + os + dataStructure 
				+ linux + network + ccna + statistics + python + nosql;
		this.average = total / 13;
	}
	
	public void setGrade() {
		if (average >= 90) {
			this.grade = "A";
		} else if (average >= 80) {
			this.grade = "B";
		} else if (average >= 70) {
			this.grade = "C";
		} else if (average >= 60) {
			this.grade = "D";
		} else {
			this.grade = "F";
		}
	}
	
	@Override
	public String toString() {
		return id + " / " + name + " / " + kor + " / " + eng + " / " + math 
				+ " / " + c_lan + " / " + os + " / " + dataStructure 
				+ " / " + linux + " / " + network + " / " + ccna 
				+ " / " + statistics + " / " + python + "  /" + nosql
				+ " / " + total + " / " + String.format("%.2f", average) 
				+ " / " + grade;
	}
}