package jungsuk.chapter14_ramdaStream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
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
}
