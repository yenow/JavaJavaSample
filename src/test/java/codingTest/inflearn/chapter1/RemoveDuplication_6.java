package codingTest.inflearn.chapter1;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * packageName : codingTest.inflearn.chapter1
 * fileName : RemoveDuplication
 * author : 윤신영
 * date : 2022-01-13
 * description :
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
 * 입력 - 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
 * 출력 - 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-13   윤신영     최초 생성
 */
public class RemoveDuplication_6 {

    public static void main(String[] args){
        String input = "ksekkset";
        String result = "kset";

        if (result.equals(solution(input))) {
            System.out.println("성공");
        }
        System.out.println(solution(input));
    }

    private static String solution(String input) {
        String answer = "";
        Set<String> set = new HashSet<>();

        for (char word : input.toCharArray()) {
            String temp = String.valueOf(word);

            if (!set.contains(temp)) {
                answer += temp;
                set.add(temp);
            }
        }

        return answer;
    }
}
