package codingTest.programmers.greedy.makeBigNumber;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Stack;


class Solution {
    public String solution(String number, int k) {
        return remove(number,k);
    }

    String remove(String number, int k) {
        if (k == 0) return number;

        String result = "";
        for (int i = 0; i < number.length() - 1; i++) {

            if (number.substring(i, i+1).compareTo(number.substring(i+1, i+2)) < 0) {
                result = number.substring(0, i) + number.substring(i+1);
                break;
            }

            if (i == number.length() - 2) {
                result = number.substring(0, i+1);
                break;
            }
        }
        return remove(result, k-1);
    }
}

class Solution3 {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}

public class makeBigNumber {

    @Test
    void test() {
        System.out.println(new Solution().solution(" 1000000", 2));
        System.out.println(new Solution().solution(" 1000000", 5));

        Assertions.assertThat(new Solution().solution("1924", 2)).isEqualTo("94");
        Assertions.assertThat(new Solution().solution("654321", 5)).isEqualTo("6");
        Assertions.assertThat(new Solution().solution("1231234", 3)).isEqualTo("3234");
        Assertions.assertThat(new Solution().solution("4177252841", 4)).isEqualTo("775841");
    }

    @Test
    void test2() {
//        String str = "1000000000000000000000000000000";
//        System.out.println(Integer.parseInt(str));

        String str2 = "1000001";
        System.out.println(str2.substring(6,7));
        System.out.println(str2.substring(0,str2.length()-1));

    }
}


class Solution2 {
    public String solution(String number, int k) {
        return remove(number,k);
    }

    String remove(String number, int k) {
        if (k == 0) return number;

        BigInteger max = new BigInteger("0");
        for (int i=0; i < number.length(); i++) {
            String temp = number.substring(0, i) + number.substring(i+1);
            BigInteger bigInteger = new BigInteger(temp.trim());
            max = bigInteger.compareTo(max) > 0 ? bigInteger : max;
        }
        return remove(String.valueOf(max), k-1);
    }
}