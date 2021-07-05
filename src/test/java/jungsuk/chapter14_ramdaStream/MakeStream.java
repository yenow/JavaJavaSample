package jungsuk.chapter14_ramdaStream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MakeStream {

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
