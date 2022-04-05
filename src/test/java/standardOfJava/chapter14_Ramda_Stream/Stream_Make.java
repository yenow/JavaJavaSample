package standardOfJava.chapter14_Ramda_Stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Stream_Make {

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
	 - 스트림을 이용한 작업이 간결할 수 있는 비결중에 하나가 '내부반복'이다. 내부 반복이라는것은 반복문을 메서드의 내부에 숨겼다는 것을 의미한다
	 - forEach() 스트림에 정의된 메서드 중의 하나로 매개변수에 대입된 람다식을 데이터 소스의 모든 요소에 적용한다.
	 
	4. 지연된 연산
	 - 최종연산이 수행되기 전까지는 중간 연산이 수행되지 않는다.
	 - distinct()나 sort()같은 중간 연산을 호출해도 즉각적인 연산이 수행되지 않는다. 
	 
	 5. Stream<Integer>와 IntStream 
	 - 요소의 타입이 T인 스트림은 Stream<T>이지만, 오토박싱&언박싱으로 인한 비효율을 줄이기 위해 데이터 소스를 기본형으로 다루는
	   IntStream, LognStream 등이 제공된다.(더 효율적)
	   
	 6. 병렬 스트림
	  - 내부적으로 Java에서 fork & join 프레임웍을 이용해서 자동적으로 연산을 병렬로 수행
	  - parallel() 메서드 호출
	  -  
     */
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

        // 병렬 스트림 예시
        int sum = Arrays.stream(strArr).parallel().mapToInt(s -> s.length()).sum();
        System.out.println("sum : " + sum);
    }

    /*
    @Title : l17_스트림만들기_컬렉션
	@Content
	- 스트림의 소스가 될 수 있는 대상은 배열, 컬렉션, 임의의 수 등 다양하다.
     */
    @Test
    public void l17_스트림만들기_컬렉션() {

        // 컬렉션의 최고 조상에 stream() 메서드가 정의되어 있다.  ex) Stream<T> Collection.stream()
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> intStream = list.stream();

        // forEach()는 지정된 작업을 스트림의 모든 요소에 대해 수행한다.
        intStream.forEach(System.out::println);   //  스트림의 모든 요소 출력
        // intStream.forEach(System.out::println);   //  에러, 스트림이 닫혔다.
    }

    /*
    @Title : l18_스트림만들기_배열
	@Content
     */
    @Test
    public void l18_스트림만들기_배열() {

        // 배열스트림 만드는 방법
        Stream<String> strStream1 = Stream.of("a","b","c");
        Stream<String> strStream2 = Stream.of(new String[] {"a","b","c"});
        Stream<String> strStream3 = Arrays.stream(new String[] {"a","b","c"});
        Stream<String> strStream4 = Arrays.stream(new String[] {"a","b","c"},0,3);

        IntStream intStream1 = IntStream.of(1,2,3,4,5);
        int[] ints = new int[] {1,2,3,4,5};
        IntStream intStream2 = IntStream.of(ints);
        IntStream intStream3 = Arrays.stream(ints);
    }

    /*
    @Title : l19_스트림만들기_난수
	@Content
	난수의 범위
	 - Integer.MIN_VALUE <= ints() <= Integer.MAX_VALUE
	 - Long.MIN_VALUE <= longs() <= Long.MAX_VALUE
	 - 0.0 <= doubles() <= 1.0
     */
    @Test
    public void l19_스트림만들기_난수() {

        // Random 클래스에 난수로 이루어진 스트림을 반환하는 메서드
        IntStream intStream = new Random().ints();  // 매개변수가 없으면 무한 스트림
        LongStream longStream = new Random().longs();  // 매개변수가 없으면 무한 스트림
        DoubleStream doubleStream = new Random().doubles();  // 매개변수가 없으면 무한 스트림

        // 유한스트림으로 변경
        IntStream intStream2 = new Random().ints().limit(5);  // 유한스트림
        LongStream longStream2 = new Random().longs().limit(5);
        DoubleStream doubleStream2 = new Random().doubles().limit(5);

        // 값의 범위내에서 난수 유한스트림
        IntStream intStream3 = new Random().ints(1,10).limit(5);
        LongStream longStream3 = new Random().longs(1,10).limit(5);

        intStream3.forEach(System.out::println);
        longStream3.forEach(System.out::println);
    }

    /*
    @Title : l20_스트림만들기_특정범위의정수
	@Content
	    - IntStream과 LongStream은 지정된 범위의 연속된 정수를 생성해서 반환하는 range()와 rangeClosed() 메서드를 가지고 있다.
	    - range()는 경계의 끝인 end가 범위에 포함되지 않고, rangeClosed()의 경우는 포함된다.
     */
    @Test
    public void l20_스트림만들기_특정범위의정수() {
        IntStream intStream = IntStream.range(1,5);
        IntStream intStream2 = IntStream.rangeClosed(1,5);

        intStream.forEach(System.out::println);
        intStream2.forEach(System.out::println);

    }

    /*
    @Title : l21_스트림만들기_람다식
	@Content
	    - Stream 클래스의 iterate()와 generate()메서드는 람다식을 매개변수로 받아서, 이 람다식에 의해 계산되는 값들을 요소로하는 무한 스트림 생성	  
	    - 위 두 함수는 기본형 스트림 타입의 참조변수로 사용할수 없다 (IntStream으로 반환 불가능)
     */
    @Test
    public void l21_스트림만들기_람다식 () {
        // iterate()의 첫번째 매개변수는 seed값으로 시작값을 지정한다.
        Stream<Integer> evenStream = Stream.iterate(0, n->n+2).limit(5);

        // generate()는 이전 결과를 이용해서 다음요소를 계산하지는 않는다. 또한 매개변수 타입이  Supplier<T>로 매개변수가 없는 람다식만 허용이 된다.
        Stream<Double> randowStream = Stream.generate(Math::random).limit(5);

        evenStream.forEach(System.out::println);
        randowStream.forEach(System.out::println);
    }

    /*
    @Title : l22_스트림만들기_파일과빈스트림
	@Content
	    - java.nio.file.Files는 파일을 다루는데 필요한 유용한 메서드들을 제공한다.
	    - list()는 지정된 디렉토리에 있는 파일의 목록을 소스로 하는 스트림을 생성해서 반환한다.
     */
    @Test
    public void l22_스트림만들기_파일과빈스트림 () {
//        Path path = FileSystems.getDefault().getPath("logs", "access.log");
//        try {
//            Stream<Path> list = Files.list(path);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 빈스트림
        Stream emptyStream = Stream.empty();
        long count = emptyStream.count();
        System.out.println(count);
    }
}
