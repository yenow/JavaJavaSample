package codingTest.inflearn.chapter1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * packageName : codingTest.inflearn.chapter1
 * fileName : Number_9
 * author : 윤신영
 * date : 2022-01-14
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-14   윤신영     최초 생성
 */
public class Number_9 {

    @Test
    void test() {
        assertEquals(208,solution("g0en2T0s8eSoft"));
        assertEquals(12345678,solution("1a2a3a4a5a6a7a8a"));
    }

    static int solution(String inputString) {

        List<String> list = new ArrayList<>();
        for (char word : inputString.toCharArray()) {

            if (Character.isDigit(word)) {
                list.add(String.valueOf(word));
            }
        }

        String numStr = "";
        for (String temp : list) {
            numStr += temp;
        }

        return numStr == "" ? 0 : Integer.parseInt(numStr);
    }
}
