package quiz;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class D03_Jiphap {

	/*
	 	1. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 합집합을 Set으로 반환하는 메서드
	 	   [1, 2, 3] + [2, 3, 4, 5] => [1, 2, 3, 4, 5]
	 	   
	 	2. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 교집합을 Set으로 반환하는 메서드
	 	   [1, 2, 3] 교 [2, 3, 4, 5] => [2, 3]
	 	   
	 	3. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 차집합을 Set으로 반환하는 메서드
	 	   [1, 2, 3] - [2, 3, 4, 5] => [1]
	 	   [2, 3, 4, 5] - [1, 2, 3] => [4, 5]
	 */
	
	public static Collection<Integer> union(Collection<Integer> a, Collection<Integer> b) {
		Collection<Integer> unionSet = new HashSet<>(a);
		unionSet.addAll(b);
		return unionSet;
	}
	
	public static Collection<Integer> intersection(Collection<Integer> a, Collection<Integer> b) {
		Collection<Integer> intersectionSet = new HashSet<>(a);
		intersectionSet.retainAll(b);
		return intersectionSet;
	}
	
	public static Collection<Integer> difference(Collection<Integer> a, Collection<Integer> b) {
		Collection<Integer> differenceSet = new HashSet<>(a);
		differenceSet.removeAll(b);
		return differenceSet;
	}
	
	public static void main(String[] args) {
		
		Set<Integer> a = new HashSet<>();
		a.add(1);
		a.add(2);
		a.add(3);
		
		Set<Integer> b = new HashSet<>();
		b.add(2);
		b.add(3);
		b.add(4);
		b.add(5);
		
		System.out.printf("합집합: %s + %s => %s\n", a, b, union(a, b));
		System.out.printf("교집합: %s 교 %s => %s\n", a, b, intersection(a, b));
		System.out.printf("차집합: %s - %s => %s\n", a, b, difference(a, b));
		System.out.printf("차집합: %s - %s => %s\n", b, a, difference(b, a));
	}
}
