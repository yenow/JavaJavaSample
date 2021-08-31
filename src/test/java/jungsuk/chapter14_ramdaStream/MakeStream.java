package jungsuk.chapter14_ramdaStream;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MakeStream {

    /*
    @Title : 스트림(stream)
	@Content
	- 스트림이 나온 배경 : for문이랑 iterator는 코드가 너무 길고 알아보기 힘들고 재사용성도 떨어지기 때문
	                     또한
	- 스트림은 데이터 소스를 추상화하고, 데이터를 다루는데 자주 사용되는 메서드들을 정의해놓았다.
	- 데이터 소스를 추상화하였다는것은, 데이터 소스가 무엇이던간에 같은 방식으로 다룰 수 있게 되었다는 것과 코드의 재사용성이 높아진것을 의미한다.
	*/
    @Test
    public void l15_스트림() {
        String[] strArr = {"1","2","3","4","5"};
        List<String> list = Arrays.asList("1","2","3","4","5");

        //스트림 생성
        Stream<String> strStream1 = Arrays.stream(strArr);
        Stream<String> strStream2 = list.stream();

        // 출력
        strStream1.sorted().forEach(System.out::println);  // 아직 소스가 정렬되는건 아니라고한다.
        strStream2.sorted().forEach(System.out::println);
    }

    /*
    @Title : 스트림의 특징
	@Content
	1. 스트림은 데이터 소스를 변경하지 않는다.
	 - 스트림은 데이터 소스를 읽기만 할뿐, 데이터 소스를 변경하지 않는다. 필요하다면 정렬된 경과를 컬렉션이나 배열에 담아서 반환할 수 있다.

	2. 스트림은 일회용이다.

	3. 스트림은 작업을 내부 반복으로 처리한다.
	 - 스트림을 이용한 작업이 간결할 수 있는 비결중에 하나가 '내부반복'이다. 내부 반복이라는것은 반복문을을
	/
    @Test
    public void l16_스트림_특징() {
        String[] strArr = {"1","2","3","4","5"};
        List<String> list = Arrays.asList("1","2","3","4","5");

        //스트림 생성
        Stream<String> strStream1 = Arrays.stream(strArr);
        Stream<String> strStream2 = list.stream();

        // 출력
        strStream1.sorted().forEach(System.out::println);  // 아직 소스가 정렬되는건 아니라고한다.
        strStream2.sorted().forEach(System.out::println);
    }

    /* 스트림의 소스가 될 수 있는 대상은 배열, 컬렉션, 임의의 수 등 다양 */
    @Test
    public void 스트림만들기_컬렉션() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> intStream = list.stream();

        intStream.forEach((i)->{
            System.out.println(i);
        });
        // intStream.forEach(System.out::println);  // 스트림은 두번 사용할 수 없다.
    }


    @Test
    public void 스트림만들기_배열 () {

        Stream<String> strStream1 = Stream.of("1","2","3","4");
        Stream<String> strStream2 = Stream.of(new String[] {"a","b","c"});
        Stream<String> strStream3 = Arrays.stream(new String[]{"a","b","c"});

        //  int, long, double 과 같은 기본형 배열을 소스로 하는 스트림
        IntStream intStream1 = IntStream.of(1,2,3,4);
        IntStream intStream2 = Arrays.stream(new int[] {1,2,3,4});
    }

    @Test
    public void 스트림만들기_임의의수 () {
        
        // 난수의 범위는 그 자료형의 모든숫자
        IntStream intStream = new Random().ints();
        intStream.limit(5).forEach((i)->{
            System.out.println(i);
        });
    }

    @Test
    public void 스트림만들기_람다식 () {}

    /* iterate()와 generate()는 람다식을 매개변수로 받아서, 이 람다식에 의해 계산되는 값들을 요소로하는 무한스트림을 생성 */

    Stream<Integer> evenStream = Stream.iterate(0,n->n+2);
    Stream<Double> generateStream = Stream.generate(Math::random);
}
