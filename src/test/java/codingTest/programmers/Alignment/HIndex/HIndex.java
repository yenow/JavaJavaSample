package codingTest.programmers.Alignment.HIndex;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        for (int i = 0; i < citations.length; i++) {
            int max = citations[i];

            for (int j = i + 1 ; j < citations.length; j++) {
                if (max < citations[j]) {
                    max = citations[j];
                    citations[j] = citations[i];
                    citations[i] = max;
                }
            }
        }

        for (int h = 1; h <= citations.length; h++) {
            int maxCount = 0;
            int minCount = 0;

            for (int citation : citations) {
                if (citation >= h) {
                    maxCount++;
                } else {
                    minCount++;
                }
            }

            if (maxCount >= h && minCount < h) {
                answer = h;
            }
        }
        return answer;
    }
}

class Solution2 {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        return max;
    }

    public int solution2(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++){
            int smaller = Math.min(citations[i], citations.length-i);
            answer = Math.max(answer, smaller);
        }
        return answer;
    }
}

public class HIndex {

    @Test
    void test() {
        int [] citations = { 3, 0, 6, 1, 5};
        int [] citations2 = {5, 6, 7, 8, 9};
        Assertions.assertThat(new Solution().solution(citations)).isEqualTo(3);
        Assertions.assertThat(new Solution2().solution2(citations2)).isEqualTo(5);
    }
}
