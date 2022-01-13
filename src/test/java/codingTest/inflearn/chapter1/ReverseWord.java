package codingTest.inflearn.chapter1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * packageName : codingTest.inflearn.chapter1
 * fileName : ReverseWord
 * author : 윤신영
 * date : 2022-01-12
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-12   윤신영     최초 생성
 */
public class ReverseWord {

    public static void main(String[] args){
//        String[] inputs = {"3","good","Time","Big"};
//        String[] results = {"doog","emiT","giB"};
        String input = "good";
        String result = "doog";

        if (result.equals(solution(input))) {
            System.out.println("성공");
        }

        System.out.println(solution2(input));
    }

    private static String solution(String input) {

        String result = "";
        for (char word :  input.toCharArray()) {
            result = String.valueOf(word) + result;
        }

        return result;
    }

    private static String solution2(String input) {
        String answer = new StringBuilder(input).reverse().toString();

        /*
        * StringBuilder를 사용하는 이유,
        * String을 사용하면 새로운 문자가 나올때마다 객체를 생성해야함 -> 메모리 소모가 큼
        * */

        return answer;
    }
}
