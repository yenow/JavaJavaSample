package codingTest.inflearn.chapter1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BestShortDIstance_10 {
    final String inputString = "teachermode";
    final String outputString = "10121012210";

    @Test
    void test() {
        Assertions.assertThat(solution(inputString,'e')).isEqualTo(outputString);
    }

    String solution(String inputString, char character) {
        StringBuilder result= new StringBuilder();

        char[] chars = inputString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int step = 0;

            while (true) {

                if (i+step < chars.length && chars[i+step] == character) {
                    break;
                } else if (i-step >= 0 && chars[i-step] == character) {
                    break;
                }
                step++;
            }

            result.append(Integer.toString(step));
        }

        return result.toString();
    }


}
