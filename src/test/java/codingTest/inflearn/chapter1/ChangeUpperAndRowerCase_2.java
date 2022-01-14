package codingTest.inflearn.chapter1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * packageName : codingTest.inflearn.chapter1
 * fileName : ChangeUpperAndRowerCase
 * author : 윤신영
 * date : 2022-01-11
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-11   윤신영     최초 생성
 */
public class ChangeUpperAndRowerCase_2 {

    static String solution (String input) {

        // Todo : 람다식으로 해결하는 방법은?

        String result = "";

        for(char letter : input.toCharArray()) {

            if (Character.isLowerCase(letter)) {
                result += String.valueOf(Character.toUpperCase(letter));
            } else {
                result += String.valueOf(Character.toLowerCase(letter));
            }
        }

        return result;
    }

    @DisplayName("대소문자 변환")
    @Test
    void main() {
        String input = "StuDY";
        String result = "sTUdy";

        System.out.println(solution(input));
        if (solution(input).equals(result)) {
            System.out.println("성공");
        }
        // assertEquals

    }
}
