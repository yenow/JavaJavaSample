package codingTest.programmers.skill_check.level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1 {

    class Solution {
        public int solution(int n) {
            int answer = 1;

            for (int start = 1; start <= (int) n/2 + 1; start++) {

                for (int end = 1; end <= (int) n/2 + 1; end++) {

                    if (end*end - start*start + end + start == n * 2) {
                        answer++;
                    }
                }
            }

            return answer;
        }
    }

    class Solution2 {
        public int solution(int n) {
            int answer = 1;

            for (int start = 1; start <= (int) n/2 + 1; start++) {

                for (int end = start + 1; end <= (int) n/2 + 1; end++) {
                    if (end*end - start*start + end + start == n * 2) {
                        answer++;
                        break;
                    } else if (end*end - start*start + end + start > n * 2) {
                        break;
                    }
                }
            }

            return answer;
        }
    }

    @Test
    void test() {
        Solution2 solution = new Solution2();
        Assertions.assertThat(solution.solution(15)).isEqualTo(4);

    }
}
