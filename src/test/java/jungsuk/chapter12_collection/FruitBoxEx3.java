package jungsuk.chapter12_collection;

import java.util.ArrayList;

class Fruit		          { public String toString() { return "Fruit";}}
class Apple extends Fruit { public String toString() { return "Apple";}}
class Grape extends Fruit { public String toString() { return "Grape";}}

class Juice {
	String name;

	Juice(String name)	     { this.name = name + "Juice"; }
	public String toString() { return name;		 }
}

class Juicer {
//	static Juice makeJuice(FruitBox<? extends Fruit> box) {  // 와일드 카드 적용
//		String tmp = "";
//		
//		for(Fruit f : box.getList()) 
//			tmp += f + " ";
//		return new Juice(tmp);
//	}
	
	// 지네릭 메서드
	static <T extends Fruit> Juice makeJuice(FruitBox<T> box) {
		String tmp = "";
		for(Fruit f : box.getList()) {
			tmp += f + " ";
		}
		
		return new Juice(tmp);
	}
	
}

class FruitBoxEx3 {
	public static void main(String[] args) {
		
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();   // Fruit를 상속하는 클래스를 타입으로하는 객체를 담을 수 있음.
		FruitBox<Apple> appleBox = new FruitBox<Apple>();

		fruitBox.add(new Apple());  
		fruitBox.add(new Grape());  
		appleBox.add(new Apple());
		appleBox.add(new Apple());

		// 지네릭 메소드 타입을 생략이 가능함, 컴파일러가 대입된 타입을 추정할수 있음. 
		System.out.println(Juicer.<Fruit>makeJuice(fruitBox));   // 지네릭 메서드의 경우 이렇게 타입변수에 타입을 대입해도됨
		System.out.println(Juicer.makeJuice(appleBox));
			
		
	}  // main
}

class FruitBox<T extends Fruit> extends Box<T> {}

class Box<T> {
//class FruitBox<T extends Fruit> {
	//  static T item;  에러 : 모든객체에 대해 동일하게 동작해야하는 static 멤버에게 타입변수 T 적용 불가능
	//  T[] itemArr = new T[10];  타입변수 T로 배열 선언까지는 되어도, 배열 생성은 불가능
	
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item);      }
	T get(int i)     { return list.get(i); }
	ArrayList<T> getList() { return list;  }
	int size()       { return list.size(); }
	public String toString() { return list.toString();}
}
