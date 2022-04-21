package codingTest.programmers.totalExplore.test3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test3 {

    class Solution {
        public int[] solution(int brown, int yellow) {
            int total = brown+yellow;
            for (int row=3; row <= (int) Math.sqrt(total); row++) {
                if (total % row == 0) {
                    int col = total/row;
                    if (row * 2 + (col-2) * 2 == brown) return row > col ? new int[] {row, col} : new int[] {col, row};
                }
            }
            return new int[] {0,0};
        }
    }

    @Test
    void test() {
        Solution solution = new Solution();

        Assertions.assertThat(solution.solution(10, 2)).contains(4,3);
        Assertions.assertThat(solution.solution(8, 1)).contains(3,3);
        Assertions.assertThat(solution.solution(24, 24)).contains(8,6);
    }

    @Test
    void test2() {
        Assertions.assertThat(new int[] {4,3}).contains(4,3);
    }
}
