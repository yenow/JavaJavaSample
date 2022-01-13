package codingTest.inflearn.chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * packageName : codingTest.inflearn.chapter1
 * fileName : ReverseSpecificLetter
 * author : 윤신영
 * date : 2022-01-12
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-12   윤신영     최초 생성
 */
public class ReverseSpecificLetter {

    public static void main(String[] args){
        String input = "a#b!GE*T@S";
        String result = "S#T!EG*b@a";

        if (result.equals(solution(input))) {
            System.out.println("성공");
        }
        System.out.println(solution(input));
        System.out.println(solution("inpu&&t"));
    }

    private static String solution(String input) {

        String result = "";

        Stack<String> stack = new Stack<>();

        for (char word :  input.toCharArray()) {

            String temp = String.valueOf(word);
            if (temp.matches("[a-zA-Z]")) {
                stack.push(temp);
            }
        }

        for (char word :  input.toCharArray()) {

            String temp = String.valueOf(word);
            if (temp.matches("[a-zA-Z]")) {
                result = result + stack.pop();
            } else {
                result = result + temp;
            }
        }

        return result;
    }
}
