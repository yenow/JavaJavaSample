package codingTest.programmers.skill_check.level1.answer2;

import org.junit.jupiter.api.Test;

import java.util.Stack;

class Solution {
    public int solution(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return 45 - sum;
    }
}

public class Answer {

    @Test
    void test1() {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {1,2,3,4,6,7,8,0}));
    }
}
