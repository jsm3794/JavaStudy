package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
	연습1: 복숭아 클래스를 정의해보세요
	      복숭아는 가격, 등급, 무게, 농장이름을 필드로 가지고 있습니다
	      (등급은 +, -를 매길 수 있음)
	       
	연습2: 복숭아를 크기 비교가 가능한 객체로 만들어보세요 (무게 기준)
	
	연습3: 복숭아를 리스트에 넣고 등급기준으로 내림차순 정렬하고, 
	      등급이 같은 경우 가격 기준으로 내림차순 정렬해보세요
	       
	연습4: 복숭아를 농장이름순으로 오름차순 정렬하고 농장이름이 같은 경우
	      등급 기준으로 내림차순 정렬 해주세요
*/

public class D07_Peach {

	public static void main(String[] args) {
		List<Peach> peaches = new ArrayList<>();
		
		peaches.add(new Peach("A 농장", 1000, 150.0, "+"));
		peaches.add(new Peach("B 농장", 1300, 180.0, "-"));
		peaches.add(new Peach("C 농장", 1800, 130.0, "+"));
		peaches.add(new Peach("D 농장", 1600, 110.0, "-"));
		
		Collections.sort(peaches, new Comparator<Peach>() {

			@Override
			public int compare(Peach o1, Peach o2) {
				int gradeCompare = o2.grade.compareTo(o1.grade);
				if (gradeCompare == 0) {
					return Integer.compare(o2.price, o1.price);
				}
				return gradeCompare;
			}
		});
		
		System.out.println();
		for(Peach peach : peaches) {
			System.out.println(peaches);
		}
		
		Collections.sort(peaches, new Comparator<Peach>() {

			@Override
			public int compare(Peach o1, Peach o2) {
				int farmCompare = o1.farm.compareTo(o2.farm);
				if (farmCompare == 0) {
					return o2.grade.compareTo(o1.grade);
				}
				return farmCompare;
			}
		});
		
		System.out.println();
		for(Peach peach : peaches) {
			System.out.println(peaches);
		}
	}
}

class Peach implements Comparable<Peach> {

	String farm;
	int price;
	double weight;
	String grade;
	
	public Peach(String farm, int price, double weight, String grade) {
		this.farm = farm;
		this.price = price;
		this.weight = weight;
		this.grade = grade;
	}
	
	@Override
	public int compareTo(Peach p) {
		return Double.compare(weight, p.weight);
	}
	
	@Override
		public String toString() {
		return String.format("[%s/%.2f/%.2f/%s]\n", farm, price, weight, grade);
		}
}

class PeachFarm implements Comparator<Peach> {

	@Override
	public int compare(Peach o1, Peach o2) {
		int farmCompare = o1.farm.compareTo(o2.farm);
		if (farmCompare == 0) {
			return o2.grade.compareTo(o1.grade);
		}
		return farmCompare;
	}

	
	
}
