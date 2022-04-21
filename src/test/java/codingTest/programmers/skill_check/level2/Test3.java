package codingTest.programmers.skill_check.level2;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

// 실패...
public class Test3 {
    class Solution {
        public int solution(String s) {
            int answer = Integer.MAX_VALUE;

            for (int size = 1; size <= s.length() /2; size++) {
                String newStr = getNewString(s,size);
                if(answer > newStr.length()) answer = newStr.length();
            }
            return answer;
        }

        public String getNewString(String s, int size) {
            Queue<String> queue = new LinkedList<>();

            for (int i=0; i<s.length(); i=i+size) {
                int endIndex = Math.min(i + size, s.length());
                queue.add(s.substring(i, endIndex));
            }
            queue.add("");
//            System.out.println("queue = " + queue);

            String newStr = "";
            int num = 1;
            String prev = "";
            while (!queue.isEmpty()) {
                String next = queue.poll();
                if (prev.equals(next)) {
                    num++;
                } else {
                    if (num == 1 || num == 0) {
                    newStr += prev;
                    } else {
                        newStr += num + prev;
                    }
                    prev = next;
                    num = 1;
                }
            }

            return newStr;
        }
    }

    @Test
    void test() {
        String input = "aabbaccc";
        Solution solution = new Solution();
        System.out.println(solution.solution(input));

    }
}
