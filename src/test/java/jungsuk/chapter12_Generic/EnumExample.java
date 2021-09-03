package jungsuk.chapter12_Generic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/*
관련있는 상수들의 집합, 어떤 클래스가 상수만으로 이루어져 있다면, 굳이 클래스로 만들 필요가 없음 -> enum으로 만들면 됨.

*/

enum Level {
	Basic(1),Silver(2),Gold(3);   // 열거형의 변수명 자체가, 문자열 값이 되는듯
	
	private int value;
	
	private Level(int i) {   
		//  접근 제어자를 private로 해야함
		//  이유 : enum은 고정된 상수들의 집합으로서, 런타임이 아니라 컴파일타임에 모든 값을 알고 있어야한다. 즉 다른 패키지나 클래스에서 동적으로 값을 줄 수 없기때문이다.
		this.value = i;
	}

	public int getValue() {
		return value;
	}

}

public class EnumExample {
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void sampletEnum() {

		//System.out.println(Day.JAN);
		//System.out.println(Day.JAN.getValue());
		System.out.println(Level.Basic);
		System.out.println(Level.Basic.getValue());
	}
}


// enum이랑 같다. 하지만 enum이 가독성이 뛰어나다
class Day {
	public static Day JAN = new Day(1);
	
	private int value;

	
	public Day(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}