package codingTest.programmers.skill_check.level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


// https://tech.kakao.com/2017/11/14/kakao-blind-recruitment-round-3/#%EC%9E%85%EC%B6%9C%EB%A0%A5-%EC%98%88%EC%A0%9C-2
public class Test2 {
    class Solution {
        public String[] solution(String[] files) {
            String[] answer = {};

            Arrays.sort(files,(o1,o2) -> {
                int index1 = getNumberIndex(o1);
                String head1 = o1.substring(0, index1).toLowerCase();
                String notHead1 = o1.substring(index1);
                String number1 = notHead1.substring(0, getNotNumberIndex(notHead1));


                int index2 = getNumberIndex(o2);
                String head2 = o2.substring(0, index2).toLowerCase();
                String notHead2 = o2.substring(index2);
                String number2 = notHead2.substring(0, getNotNumberIndex(notHead2));

                if (head1.equals(head2)) {
                    int num1 = Integer.parseInt(number1);
                    int num2 = Integer.parseInt(number2);
                    return num1 >= num2 ? 1 : -1;

                } else {

                    return head1.compareTo(head2);
                }
            });

            return files;
        }

        public int getNumberIndex(String str) {
            int index = 0;
            for (char c : str.toCharArray()) {
                if (Character.isDigit(c)) return index;
                else index++;
            }

            return index;
        }

        public int getNotNumberIndex(String str) {
            int index = 0;
            for (char c : str.toCharArray()) {
                if (!Character.isDigit(c)) return index;
                else index++;
            }

            return index;
        }
    }

    @Test
    void test() {
//        String[] input = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
//        String[] result = new Solution().solution(input);
//        Arrays.stream(result).forEach(s -> System.out.print(s + " "));

//        Assertions.assertThat(new Solution().solution(input)).contains("img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png");
        String[] input2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        String[] result2 = new Solution().solution(input2);
        Arrays.stream(result2).forEach(s -> System.out.print(s + " "));
//        Assertions.assertThat(new Solution().solution(input2)).contains("A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat");
    }

    @Test
    void test2() {
        String str = "agdasdg1121";
        int index = new Solution().getNumberIndex(str);
        System.out.println(str.substring(0,index));

        String str1 = "0011";
        System.out.println(Integer.parseInt(str1));

    }
}
