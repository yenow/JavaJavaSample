package codingTest.inflearn.chapter1;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * packageName : codingTest.inflearn.chapter1
 * fileName : FindString
 * author : 윤신영
 * date : 2022-01-09
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-09   윤신영     최초 생성
 */
public class FindString_1 {

    public static int findStringCount(String string, String character) {
        System.out.println("string.chars().count() : " + string.chars().count());
        AtomicInteger count = new AtomicInteger();

        String lowerCase = character.toLowerCase();
        String upperCase = character.toUpperCase();

        string.chars().forEach(value -> {
            if (value == lowerCase.charAt(0) || value == upperCase.charAt(0)) {
                count.getAndIncrement();
            }
        });

        return count.get();
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String string = in.next();
        String character = in.next();

        System.out.println(findStringCount(string,character));
    }
}
