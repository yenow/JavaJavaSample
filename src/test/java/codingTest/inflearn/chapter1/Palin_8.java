package codingTest.inflearn.chapter1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : codingTest.inflearn.chapter1
 * fileName : Palin_10
 * author : 윤신영
 * date : 2022-01-14
 * description :
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 한다.
 * 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 * 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-14   윤신영     최초 생성
 */
public class Palin_8 {

    @Test
    void test() {
        assertEquals(true,solution("found7, time: study; Yduts; emit, 7Dnuof"));
        assertEquals(false,solution("found7, time: study; Yduts; emit, 7Dnuod"));
    }

    static boolean solution(String inputString) {
        boolean answer = true;

        StringBuffer stringBuffer = new StringBuffer(inputString);
        StringBuffer reverseString = stringBuffer.reverse();

        for (int i=0; i < inputString.length(); i++) {

            char inputWord = inputString.toCharArray()[i];
            char reverseWord = reverseString.toString().toCharArray()[i];
            if (Character.isAlphabetic(inputWord)
                    && Character.isAlphabetic(reverseWord)
                    && (Character.toLowerCase(inputWord) != Character.toLowerCase(reverseWord))) {
                answer = false;
                break;
            }
            // question : 하나는 알파벳이고 하나는 알파벳이 아니라면?
        }

        return answer;
    }

    static boolean solution2(String inputString) {
        inputString = inputString.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(inputString).reverse().toString();

        return inputString.equals(tmp);
    }
}
