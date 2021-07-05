package jungsuk.chapter14_ramdaStream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class BasicRamda {
	
	public static void main(String[] args) {
		
		/* 기본적인 함수형 인터페이스(람다식) 사용법 */
		Supplier<Integer> s = () -> (int)(Math.random()*100) + 1;		
		Consumer<Integer> c = i -> System.out.println(i+", ");
		Predicate<Integer> p = i -> i%2 == 0;
		Function<Integer, Integer> f = i -> i/10*10; 
		Runnable r = () -> { System.out.println("Runnable"); };
		UnaryOperator<Integer> u = i -> i/10*10;   // Function과 비슷하다. 매개변수 타입과 반환타입이 일치한다.		
		
		List<Integer> list = new ArrayList<>();
		makeRandomList(s, list);
		
		c.accept(1);
		System.out.println(p.test(1));
		System.out.println(f.apply(102));
		r.run();
		
		/* Predicate 결합 */
		Predicate<Integer> p1 = i -> i%2 == 0;
		Predicate<Integer> p2 = i -> i%2 == 0;
		
		Predicate<Integer> p3 = p1.and(p2);  // or, negate 등등
		System.out.println(p3.test(1));
		
		// isEquals
		String str1 = "123";
		String str2 = "123";
		Predicate<String> pp = Predicate.isEqual(str1);    // isEquals는 두 대상을 비교하는 Predicate를 만들 때 사용한다.
		Boolean b1 = pp.test(str2);
		Boolean b2 = Predicate.isEqual(str1).test(str2);
		System.out.println( b1 );
		System.out.println( b2 );
		
		
	}
	
	static <T> void makeRandomList(Supplier<T> s ,List<T> list) {
		for (int i=0; i<10; i++) {
			list.add(s.get());		
		}
	}
	
}
