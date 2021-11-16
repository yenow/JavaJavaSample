package jungsuk.chapter14_Ramda_Stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_Calculate {

    /*
    @Title : l23_스트림의연산
	@Content
	    - 복잡한 작업을 간단히 처리할수 있음
	    - 중간연산과 최종연산으로 분류
	    - 중간연산은 연속해서 연결할수 있지만, 최종 연산은 연산을 수행하므로 단 한번만 가능
	*/
    @Test
    public void l23_스트림의연산() {
        Stream<String> stream = Arrays.stream(new String[]{"1","2","3"});
        stream.distinct().limit(5).sorted().forEach(System.out::println);

        // 모든 중간 연산의 결과는 스트림이지만, 연산전의 스트림과 같은것은 아니다.
        //Stream<String> stream2 = Arrays.stream(new String[]{"1","2","3"});
        //Stream<String> sortStream = stream2.sorted();
        //Stream<String> distinctStream = stream2.distinct();
    }

    /*
    @Title : l24_중간연산
	@Content
	*/
    @Test
    public void l24_중간연산() {
        // distinct()  :  중복을 제거
        // filter(Predicate<T> predicate)  :  조건에 안맞는 요소 제외
        // limit(long maxSize) : 스트림의 일부를 잘라낸다
        // skip(long n) : 스트림의 일부를 건너뛴다
        // peek(Consumer<T> action) : 스트림의 요소에 작업 수행
        // sort() : 스트림의 요소를 정렬
    }

    /*
    @Title : l25_중간연산
	@Content
	*/
    @Test
    public void l25_최종연산() {
        /* 종류 */
        // forEach()  :  각 요소에 지정된 작업 수행
        // count()  :  스트림의 요소 개수
        // max(),min()  :  최대, 최소 값 반환
        // findAny(), findFirst()  :  스트림의 요소 하나를 반환
        // allMatch,anyMatch,noneMatch
        // toArray()  :  스트림의 모든 요소를 배열로 반환

        // 핵심
        // reduce()  :  스트림의 모든 요소를 하나씩 줄여가면서 계산한다.
        // collect()  :  스트림의 요소를 수집한다. 주로 요소를 그룹화하거나 분할한 결과를 컬렉션에 담아 반환하는데 사용한다.
    }

    /*
    @Title : l26_중간연산
    @Content
    */
    @Test
    public void l26_중간연산() {
        // skip
        // 요소를 건너뜀
        Stream<Integer> skipStream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9,10,11});
        skipStream.skip(3).limit(5).forEach(value -> System.out.print(value + " "));
        blank();

        // distinct
        // 중복요소를 제거
        IntStream distinctStream = Arrays.stream(new int[]{1,2,1,2,3,4,5,1,2,});
        distinctStream.distinct().forEach(value -> System.out.print(value + " "));
        blank();

        // filter
        // 매개변수로 Predicate를 필요로함 ,필터를 다른조건으로 여러번 사용하는것도 가능
        IntStream filterStream = Arrays.stream(new int[]{1,2,1,2,3,4,5,1,2,});
        filterStream.filter(i -> i%2 == 0).filter(i -> i==2).forEach(value -> System.out.print(value + " "));
        blank();

        // sorted
        // 스트림을 정렬할때 사용, 지정된 Comparator로 정렬(int값을 반환하는 람다식을 사용하는것도 가능),
        // Comparator를 지정하지 않으면 기본정렬 기준으로 정렬(요소가 comparable를 구현한 클래스여야한다.)
        Stream.of("dd|","absd|","hthw|","gd|","mb|").sorted().forEach(System.out::print);  // 기본정렬
        System.out.println();
        Stream.of("dd|","absd|","hthw|","gd|","mb|").sorted(Comparator.naturalOrder()).forEach(System.out::print);  //  기본정렬
        System.out.println();
        Stream.of("dd|","absd|","hthw|","gd|","mb|").sorted((s1,s2) -> s1.compareTo(s2)).forEach(System.out::print);  //  람다식도 가능
        System.out.println();
        Stream.of("dd|","absd|","hthw|","gd|","mb|").sorted(String::compareTo).forEach(System.out::print);
        System.out.println();
        Stream.of("dd|","absd|","hthw|","gd|","mb|").sorted(Comparator.reverseOrder()).forEach(System.out::print);  // 역순
        System.out.println();
        Stream.of("dd|","absd|","hthw|","gd|","mb|").sorted(String.CASE_INSENSITIVE_ORDER).forEach(System.out::print);  // 대소문자 구분 안함
        System.out.println();
        Stream.of("dd|","absd|","hthw|","gd|","mb|").sorted(String.CASE_INSENSITIVE_ORDER.reversed()).forEach(System.out::print);  // 대소문자 구분 안함
        System.out.println();
        Stream.of("dd|","absd|","hthw|","gd|","mb|").sorted(Comparator.comparing(String::length)).forEach(System.out::print);  // 길이 순 정렬
        System.out.println();
        Stream.of("dd|","absd|","hthw|","gd|","mb|").sorted(Comparator.comparingInt(String::length)).forEach(System.out::print);  // no오토박싱
        blank();
    }

    /*
    @Title : l29_중간연산_Comparator메서드
    @Content
        - JDK1.8부터 Comparator 인터페이스에 디폴트 메서드가 많이 추가되었다. 이 메서드들을 이용하면 정렬이 쉬워진다.
    */
    @Test
    public void l29_중간연산_Comparator메서드() {
        // comparing()
        // example.StreamEx1.java 참고
        Comparator<String> comparator = ((a,b) -> (a.length()+1) - b.length());
        System.out.println(comparator.compare("abc","absdbs"));     // 이 메서드의 결과는 Comparator의 객체에
        Comparator<String> comparator2 = (a,b) -> (a.length()+1-b.length()+1);

        /*
        *  Comparator 인터페이스에 대해서
        *  1. Comparator 인터페이스는 함수형 인터페이스로 람다식이랑 같다. 하나의 메서드만 가지고 있다. -> 람다식이 사용 가능하다.
        *  2. Comparator 인터페이스의 메서드는 compare(a, b)이다.
        * */

        /*  comparing 작동원리
        *   1. sort() 함수는 매개변수로 Comparator 인터페이스를 구현한 클래스를 받는다.
        *   2. (요소가 Comparable을 상속받을때) comparing(Function keyExtractor)이라는 디폴트 메서드를 사용하면, 인자값으로 받은 메서드를 각 인덱스마다 실행하여 값을 비교해준다.
        *   3. (요소가 Comparable을 상속받지 않는다면) 정렬기준을 직접 만들어야한다.
        *      정렬기준은 매개변수 두번째 인자로, Comparator 인터페이스를 구현한 클래스(람다식)를 넣어주면된다.
        */

        /*
        * 비교대상이 기본형일경우
        *  - comparingInt() 메서드를 상요하면 오토박싱과 언박싱 과정이 사라져서 더 효율적이라고한다.
        *
        * 정렬대상을 추가할때
        *  - thenComparing() 메서드를 사용하면된다.
        * */
    }

    /*
    @Title : l30_중간연산_map
    @Content
        - 스트림의 요소에 저장된 값 중에서 원하는 필드만 뽑아내거나 특정형태로 변환해야 할 때가 있다. 이때 사용하는 것이 map이다.
        - 선언부 | Stream<R> map(Function<? super T, ? extends R> mapper);
        - 매개변수 T타입을 R타입으로 변한해서 반환하는 함수를 지정해야한다.
    */
    @Test
    public void l30_중간연산_map() {

        Stream.of("1","2","3","4","5").map(Integer::parseInt).forEach(System.out::println);
    }

    void blank() {
        System.out.println();
        System.out.println("-----------------");
    }

    @Test
    public void l32_중간연산_peek() {

        String[] strArr = { "1", "100", "ab", "한글", "한글과 english" };

        Stream.of(strArr).filter(s -> s.length() > 2)
                .peek(System.out::println)
                .map(s -> s.toUpperCase())
                .peek(System.out::println)
                .forEach(System.out::println);
    }

    @Test
    public void l33_중간연산_flatMap() {

        Stream<String[]> strArrStream = Stream.of(new String[] {"abc","def","ghi"}, new String[] {"ABC","DEF","GHI"});

//        Stream<Stream<String>> strStream = strArrStream.map(Arrays::stream);
        Stream<String> strStream = strArrStream.flatMap(Arrays::stream);
    }
}

