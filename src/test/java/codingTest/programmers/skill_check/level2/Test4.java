package codingTest.programmers.skill_check.level2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 2차월 배열 계산
* */
public class Test4 {

    class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int rowSize1 = arr1.length;
            int colSize1 = arr1[0].length;

            int rowSize2 = arr2.length;
            int colSize2 = arr2[0].length;

            int[][] answer = new int[rowSize1][colSize2];

            for (int row=0; row < rowSize1; row++) {

                for (int col=0; col < colSize2; col++) {

                    int[] temp = new int[colSize1];
                    for (int t=0; t<colSize1; t++) {
                        temp[t] = arr2[t][col];
                    }

                    int result = calculate(arr1[row],temp);
                    answer[row][col] = result;
                }
            }


            return answer;
        }

        private int calculate(int[] arr1, int[] arr2) {
            int sum = 0;
            for (int i=0; i<arr1.length; i++) {
                sum += arr1[i] * arr2[i];
            }
            return sum;
        }
    }

    @Test
    void test() {
        Solution solution = new Solution();
        int[][] arr1 = {{1,4},{3,2},{4,1}};
        int[][] arr2 = {{3,3},{3,3}};
        int[][] result  = solution.solution(arr1, arr2);
        Arrays.stream(result).forEach(ints -> System.out.println(ints[0] + " " + ints[1]));
    }
}
