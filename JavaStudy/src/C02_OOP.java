
public class C02_OOP {

	/*
	 	# 객체 지향 프로그래밍 (Object Oriented Programming)
	 	
	 	- 변수와 함수들을 무분별하게 사용하다보니 정신이 없어서 생겨난 방식
	 	- 변수와 함수들을 세상에 실제로 존재하는 개념(객체)으로 묶어서 생각하면
	 	  프로그램의 유지보수 및 가독성 측면에서 도움이 된다
	 	- 객체 내부의 변수는 현재 상태를 나타내고
	 	  객체 내부의 함수(메서드)는 해당 객체의 기능 및 동작을 나타낸다
	 	  
	 	ex: 책
	 	
	 	- 책의 현재 상태를 변수로 표현한 것 :
	 	  현재 펼처진 페이지, 책의 최대 페이지, 책의 커버 재질,
	 	  작가 이름, 작가의 영어 이름, 책의 가격...
	 	- 책의 기능 및 동작을 메서드로 표현한 것 :
	 	  다음 페이지로 넘기기(현재 페이지 + 1), 원하는 페이지 펼치기, 첫 페이지로 가기
	 	  책의 원하는 페이지를 찢기... 등등
	 	  
	 	# 클래스 (Class)
	 	
	 	- 객체지향 프로그래밍에서 의미하는 객체를 프로그래밍 언어로 표현하는 문법
	 	- 클래스는 정의한 시점에는 실체가 없는 객체의 설계도이다
	 	- 클래스를 통해 만들어내는 실체를 인스턴스(instance)라고 부른다
	 */
	
	public static void main(String[] args) {
		
		// Book이라는 설계도를 통해 실체(인스턴스)를 찍어내야 사용할 수 있다
		// new를 통해 인스턴스를 찍어낼때마다 메모리상에 필요한 만큼의 공간을 확보한다
		Book b1 = new Book();
		Book b2 = new Book();
		Book b3 = new Book();
		
		b1.currentPage = 130;
		b2.currentPage = 13;
		b3.currentPage = 0;
		
		b1.totalPage = 200;
		b2.totalPage = 80;
		b3.totalPage = 1000;
		
		for (int i = 0; i < 1000; ++i) {
			b1.nextPage();
		}
		
		
		// 찍어낸 실체마다 변수의 현재 상태가 다르다
		System.out.println("책1의 현재 페이지: " + b1.currentPage);
		System.out.println("책1의 현재 페이지: " + b2.currentPage);
		System.out.println("책1의 현재 페이지: " + b3.currentPage);
		System.out.println();
		
		Cars car1 = new Cars("Jeep ", "Wrangler Sahara", "Orange");
		Cars car2 = new Cars("Porsche ", "Panamera", "Black");
		
		car1.accelerate(30);
		car1.brake(10);
		car1.stop();
		System.out.println();
		
		car2.accelerate(50);
		car2.brake(30);
		car2.stop();
		System.out.println();
		
		Cafe c1 = new Cafe();
		c1.changeName("빽다방");
		c1.addMenu("아메리카노", 10, 2000);
		c1.addMenu("빽사이즈 아메리카노", 20, 3000);
		c1.printCafeInfo();
		System.out.println();
		
		Cafe c2 = new Cafe();
		c2.changeName("얼음값500원카페");
		c2.addMenu("아메리카노", 10, 1800);
		// c2.printCafeInfo();
		System.out.println();
	}

}

//생각한 객체를 프로그래밍 언어로 표현한 것을 클래스라고 한다
class Book {
	int currentPage;
	int totalPage;
	int typeOfCover;
	String authorName;
	String authorEngName;
	
	// this : 나중에 생성될 인스턴스 자기 자신을 의미하는 키워드
	void nextPage() {
		if (currentPage < totalPage) {
			++currentPage;
		}
	}
}

/*
 	실제로 존재하는 객체를 하나 참조하여 클래스를 생성한 후 테스트를 해보세요
 	(책 금지, 변수 3개 이상, 메서드 2개 이상)
 */

class Cars {
	String brand;
	String model;
	String color;
	int speed;
	
	public Cars(String brand, String model, String color) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.speed = 0;
	}

	void accelerate(int increase) {
		speed += increase;
		System.out.println("현재 속도: " + speed);
	}
	
	void brake(int decrease) {
		speed -= decrease;
		System.out.println("현재 속도: " + speed);
	}
	
	void stop() {
		speed = 0;
		System.out.println(brand + "" + model + "가 정지함");
	}
}

class Cafe {
	// 나중에 인스턴스 생성시의 기본값을 설정해 놓을 수 있다
	String name = "기본이름카페";
	int area = 10;
	int seat = 20;
	int table = 5;
	CafeMenu[] menu = new CafeMenu[5];
	int menuCount = 0;
	
	// 매개변수명과 인스턴스변수명이 같은 경우 this를 활용해 구분해 줄 수 있다
	void changeName(String name) {
		this.name = name;
	}
	
	void printCafeInfo() {
		System.out.printf("카페이름: %s\n", this.name);
		System.out.printf("면적: %d평\n", this.area);
		System.out.printf("좌석수: %d석\n", this.seat);
		System.out.printf("테이블수: %d테이블\n", this.table);
		
		System.out.println("#### 메뉴판 ####");
		for (int i = 0; i < menu.length; ++i) {
			if (menu[i] != null) {
				System.out.printf("- %s : %d원(%dkcal)\n", 
						menu[i].name, menu[i].price, menu[i].calories);
			} else {
				System.out.println(menu[i]);
			}
		}
	}
	
	void addMenu(String name, int calories, int price) {
		CafeMenu toAdd = new CafeMenu();
		
		toAdd.name = name;
		toAdd.calories = calories;
		toAdd.price = price;
		
		this.menu[this.menuCount++] = toAdd;
	}
}

class CafeMenu {
	String name;
	int calories;
	int price;
}