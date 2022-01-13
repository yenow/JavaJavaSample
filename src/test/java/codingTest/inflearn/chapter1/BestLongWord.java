package codingTest.inflearn.chapter1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * packageName : codingTest.inflearn.chapter1
 * fileName : BestLongWord
 * author : 윤신영
 * date : 2022-01-11
 * description : 3번째 예제
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-11   윤신영     최초 생성
 */
public class BestLongWord {

    static String solution (String input) {
        String result = "";
        String[] str = input.split(" ");
        // Arrays.stream(str).forEach(System.out::println);

        int maxLength = 0;
        for (String word : str) {

            if (maxLength < word.length()) {
                maxLength = word.length();
                result = word;
            }
        }

        return result;
    }

    static String solution2 (String input) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;

        while ((pos=input.indexOf(" ")) != -1) {
            //  pos=input.indexOf(" ")값은 pos값이랑 동일

            if (m < pos) {
                answer = input.substring(0,pos);
                m = pos;
            }
            input = input.substring(pos+1);
        }

        if (input.length() > m) {
            answer = input;
        }

        return answer;
    }

    @DisplayName("문장속 가장 긴 단어찾기")
    @Test
    void main() {
        String input = "it is time to study";
        String result = "study";

        if (result.equals(solution(input))) {
            System.out.println("성공");
        }

        System.out.println("solution2 : " + solution2(input));
    }
}
