package codingTest.programmers.binarySearch.entry;

import org.junit.jupiter.api.Test;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        long min = Integer.MAX_VALUE;
        long max = 0;
        for (long time : times) {
            min = Math.min(min, time);
            max = Math.max(max, time);
        }

        long minTime = n*min/times.length;
        long maxTime = n*max/times.length;
        long time = (minTime+maxTime)/2;

        while (true) {
            long num = getTime(times,time);
            long num2 = getTime(times,time-1);

            if (num >= n && num2 < n) {
                answer = time;
                break;
            } else if (num < n) {
                minTime = time;
                time = (minTime+maxTime)/2+1;
            } else {
                maxTime = time;
                time = (minTime+maxTime)/2;
            }
        }
        return answer;
    }

    long getTime(int[] times,long answer) {
        long sum = 0;
        for (long time : times) {
            sum += answer/time;
        }
        return sum;
    }
}

public class Entry {

    @Test
    void test() {
        System.out.println(new Solution().solution(6, new int[] {7,10}));
        System.out.println(new Solution().solution(100124124, new int[] {7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,7,10,10,20,20,50,}));
//        System.out.println(new Solution2().solution(6, new int[] {7,10}));
    }
}
