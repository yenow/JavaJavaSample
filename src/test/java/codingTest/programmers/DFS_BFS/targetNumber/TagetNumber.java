package codingTest.programmers.DFS_BFS.targetNumber;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        calculate(list, 0, numbers, 0);

        for(int i : list) {
            if (target == i) answer++;
        }

        return answer;
    }

    void calculate(List<Integer> list, int result, int[] numbers, int index) {

        if (numbers.length-1 == index) {
            list.add(result + numbers[index]);
            list.add(result - numbers[index]);
        } else {
            calculate(list, result + numbers[index], numbers, index+1);
            calculate(list, result - numbers[index], numbers, index+1);
        }
    }
}

public class TagetNumber {

    @Test
    void test() {
        System.out.println(new Solution().solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(new Solution().solution(new int[]{4, 1, 2, 1}, 2));
    }
}
