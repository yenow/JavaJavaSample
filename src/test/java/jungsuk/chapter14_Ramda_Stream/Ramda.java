package jungsuk.chapter14_Ramda_Stream;



import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

import org.junit.jupiter.api.Test;

//@SpringBootTest
public class Ramda {

	@Test
	public void l1_람다식_작성하기() {

		/*
		@Title : 람다식 작성하는법
		@Content : 메서드에서 이름과 반환타입을 제거하고 매개변수 선언부와 몸통{} 사이에 '->'를 추가하면된다.
		*/

		// 반환문이 있는 메서드의경우, return문 대신 '식(expression)'으로 대신할 수 있다.
		FunctionEx f = (int a, int b) -> { return a > b ? a : b; };
		FunctionEx f2 = (int a, int b) ->  a > b ? a : b;

		// 람다식에 선언된 매개변수의 타입은 추론이 가능한 경우는 생략할 수 있다.
		FunctionEx f3 = (a, b) -> a > b ? a : b;

		// 매개변수가 하나면 괄호()를 생략할 수 있다.
		// {}안의 문장이 하나일때는 {}를 생략가능하다. 하지만 return이 있을경우는 생략 불가능하다.
		Consumer<Integer> c = i -> System.out.println(i+", ");
	}

	@Test
	public void l2_람다식은_익명객체() {

		/*
		@Title : 람다식은_익명객체
		@Content :
		- 자바에서 모든 메서드는 클래스 안에 포함되어야한다. 람다식은 익명객체에 포함된다.
		- @FunctionalInterface 어노테이션을 사용함으로 람다식을 사용할 수 있는 인터페이스를 만들수 있다.
		- 람다형을 다루기위한 인터페이스를 '함수형인터페이스' 라고 부른다.
		*/

		// 다음 두개의 객체는 동일하다.
		FunctionEx f = (int a, int b) ->  a > b ? a : b;

		FunctionEx f2 = new FunctionEx() {
			@Override
			public int test(int a, int b) {
				return a > b ? a : b;
			}
		};

	}

	@Test
	public void l4_function_패키지() {

		/*
		@Title : function_패키지
		@Content :
		- 대부분의 메서드는 비슷하게 매개변수가 1,2개가거나 반환타입이 있다. java.util.function 패키지에 일반적으로
		  자주 쓰이는 형식의 메서드를 함수형 인터페이스로 미리 정의해 놓았다.
		*/

		// 기본적인 함수형 인터페이스(람다식) 사용법
		Supplier<Integer> supplier = () -> (int)(Math.random()*100) + 1;
		Consumer<Integer> consumer = i -> System.out.println(i+", ");
		Predicate<Integer> predicate = i -> i%2 == 0;
		Function<Integer, Integer> function = i -> i/10*10;
		Runnable runnable = () -> { System.out.println("Runnable"); };
		UnaryOperator<Integer> unaryOperator = i -> i/10*10;   // Function과 비슷하다. 매개변수 타입과 반환타입이 일치한다.
		
		List<Integer> list = new ArrayList<>();

		// 람다식 실행
		makeRandomList(supplier, list);
		consumer.accept(1);
		System.out.println(predicate.test(1));
		System.out.println(function.apply(102));
		runnable.run();
		System.out.println(unaryOperator.apply(1));


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

	/*
	@Content :
	- 람다식이 하나의 메서드만 호출하는 경우에는 '메서드참조(method reference)'라는 방법으로 람다식을 간략히 할 수 있다.
	*/
	@Test
	public void l13_메서드_참조() {

		// 기존 방식
		Function<String, Integer> f = (String s) -> Integer.parseInt(s);

		// 생략된 방식, 생략된 부분은 generic을 통해서 알수 있다.
		Function<String, Integer> f2 = Integer::parseInt;

	}

	/*
	@Content :
	- 생성자를 호출하는 람다식도 메서드 참조로 변환할 수 있다.
	*/
	@Test
	public void l14_생성자의_메서드_참조() {

		class MyClass {   // 테스트 내부 클래스
			int i;

			public MyClass(int i) {
				this.i = i;
			}

			public int getI() {
				return i;
			}
		}

		// 기존 방식
		Function<Integer, MyClass>  f = (x) -> new MyClass(x);

		// 생략된 방식
		Function<Integer, MyClass> f2 = MyClass::new;

		// 배열생성시
		Function<Integer, int[]> f3 = int[]::new;

		System.out.println(f2.apply(10).getI());
	}
	
	static <T> void makeRandomList(Supplier<T> s ,List<T> list) {
		for (int i=0; i<10; i++) {
			list.add(s.get());		
		}
	}

}

@FunctionalInterface
interface FunctionEx {

	public int test(int a, int b);

	boolean equals(Object obj);  // equals는 Object에 있는 메서드라 에러가 나지 않는듯
}
