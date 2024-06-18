import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class D07_Comperator {

	/*
	 	# Comparable
	 	
	 	- 이 인터페이스를 구현한 클래스는 크기 비교가 가능해진다
	 	- compareTo() 메서드를 구현해두면 크기 비교가 필요한 상황에서
	 	  해당 메서드를 호출해 크기를 비교할 수 있게 된다
	 	  
	 	# Comparator
	 	
	 	- 이 인터페이스를 구혆나 클래스는 크기 비교의 기준이 된다
	 	- 
	 */
	
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		List<String> conturies = new ArrayList<>();
		
		Collections.addAll(nums, 88, 89, 90, 15, 10, 11, 12, 13, 1, 99);
		Collections.sort(nums);
		
		System.out.println(nums);
		
		List<Grape> grapes = new ArrayList<>();
		
		grapes.add(new Grape("김씨네농장", 33, 5.8, "A+"));
		grapes.add(new Grape("박씨네농장", 28, 8.1, "B+"));
		grapes.add(new Grape("이씨네농장", 40, 6.5, "A-"));
		grapes.add(new Grape("최씨네농장", 35, 7.7, "A"));
		grapes.add(new Grape("최씨네농장", 20, 8.8, "B"));
		
		// sort()를 할 수 있으려면 리스트에 속한
		// 모든 요소들의 Comparable이 구현되어 있어야 한다
		// Collections.sort(grapes);
		
		// Comparator를 함께 전달하면 Comparable의 CompareTo() 대신
		// Comparator의 compare()를 사용하여 정렬한다
		Collections.sort(grapes, new 포도분류기_농장이름기준());
		
		// Comparator를 구현받은 익명의 분류기를 전달한다
		Collections.sort(grapes, new Comparator<Grape>() {
			@Override
			public int compare(Grape g1, Grape g2) {
				if (g1.sweet == g2.sweet) {
					return 0;
				} else if (g1.sweet > g2.sweet) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		
		System.out.println(grapes);
	}
}

// Comparable 인터페이스를 구현한 클래스는 각 인스턴스까리의 크기 비교가 가능해진다
// (-> 정렬이 가능해진다)
class Grape implements Comparable<Grape> {
	String farm;
	int qty;
	double sweet;
	String grade;
	
	public Grape(String farm, int qty, double sweet, String grade) {
		this.farm = farm;
		this.qty = qty;
		this.sweet = sweet;
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return String.format("[%s/%d알/%.1f/%s]\n", farm, qty, sweet, grade);
	}
	
	@Override
	public int compareTo(Grape g) {
		// 현재 인스턴스와 매개변수로 전달받은 인스턴스를 비교하였을 떄
		// 어떤 것이 더 크다고 판정할것인지 정해야 한다
		
		// 두 인스턴스의 크기가 같다 : 0을 리턴
		// 현재 인스턴스의 크기가 더 크다 : 1을 리턴
		// 매개변수 인스턴스의 크기가 더 크다 : -1을 리턴
		
		// 예시: 포도알 개수를 기준으로 두 포도의 크기를 비교
		if (this.qty == g.qty) {
			if (this.sweet == g.sweet) {
				return 0;
			} else if (this.sweet > g.sweet) {
				return 1;
			} else {
				return -1;
			}
		} else if (this.qty > g.qty) {
			return 1;
		} else {
			return -1;
		}
	}
}

// 내림차순 정력 : 큰게 먼저나오는 것
// 오름차순 정력 : 작은게 먼저나오는 것
class 포도분류기_농장이름기준 implements Comparator<Grape> {
	
	@Override
	public int compare(Grape g1, Grape g2) {
		// 왼쪽것이 더 클 클 때 : 1
		// 오른쪽 것이 더 클 클 때 : -1
		// 두 인스턴스의 크기가 같을 때 : 0
		if (g1.sweet == g2.sweet) {
			return 0;
		} else if (g1.sweet > g2.sweet) {
			return -1;
		}
		return 0;
	}
}

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


