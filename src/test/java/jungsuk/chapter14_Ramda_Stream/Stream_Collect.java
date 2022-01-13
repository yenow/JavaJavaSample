package jungsuk.chapter14_Ramda_Stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_Collect {

    @Test
    public void testCollect() {
        Stream<String> stream = Stream.of("a","ab","abc","abcd");
        Stream<String> stream2 = Stream.of("a","ab","abc","abcd");
        Stream<String> stream3 = Stream.of("a","ab","abc","abcd");
        Stream<String> stream4 = Stream.of("a","ab","abc","abcd");

        List<String> list = stream.collect(Collectors.toList());        //  toList
        ArrayList<String> list2 = stream2.collect(Collectors.toCollection(ArrayList::new));     //  toCollection
        String[] array = stream3.toArray(String[]::new);    // 배열
        Map<String,String> map = stream4.collect(Collectors.toMap(s -> s.toUpperCase(), s -> s.toLowerCase()));     // map

        System.out.println(list);
        System.out.println(list2);
        Arrays.stream(array).forEach(System.out::println);
        System.out.println(map);
    }
}
