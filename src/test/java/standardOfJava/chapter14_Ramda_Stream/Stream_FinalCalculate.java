package standardOfJava.chapter14_Ramda_Stream;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class Stream_FinalCalculate {

    @Test
    public void example() {
        System.out.println(IntStream.of(1,2,3).reduce((a, b) -> a+b));
        System.out.println(IntStream.of(1,2,3).reduce(1,(a,b) -> a+b));

        int count = IntStream.of(1,2,3).reduce(0,(a,b) -> a+1);     // count()
        int sum = IntStream.of(1,2,3).reduce(0,(a,b) -> a+b);       // sum()
        int max = IntStream.of(1,2,3).reduce(Integer.MIN_VALUE,(a,b) -> a > b ? a : b);       // max()
        int min = IntStream.of(1,2,3).reduce(Integer.MAX_VALUE,(a,b) -> a < b ? a : b);       // min()
    }
}
