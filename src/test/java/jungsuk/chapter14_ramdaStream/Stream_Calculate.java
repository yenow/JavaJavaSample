package jungsuk.chapter14_ramdaStream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
        filterStream.filter(i -> i%2==0).filter(i -> i==2).forEach(value -> System.out.print(value + " "));
        blank();

        // sorted
        // 스트림을 정렬할때 사용, 지정된 Comparator로 정렬(int값을 반환하는 람다식을 사용하는것도 가능),
        // Comparator를 지정하지 않으면 기본정렬 기준으로 정렬(요소가 comparable를 구현한 클래스여야한다.)
        Stream.of("dd|","absd|","hthw|","gd|","mb|").sorted().forEach(System.out::print);  // 기본정렬
        Stream.of("dd|","absd|","hthw|","gd|","mb|").sorted(Comparator.naturalOrder());  //  기본정렬
        Stream.of("dd|","absd|","hthw|","gd|","mb|").sorted((s1,s2) -> s1.compareTo(s2));  //  람다식도 가능
        Stream.of("dd|","absd|","hthw|","gd|","mb|").sorted(String::compareTo);
        blank();
    }

    void blank() {
        System.out.println();
        System.out.println("-----------------");
    }
}
