
package codingTest.programmers.Alignment.KNumber;

import java.util.Arrays;

class Solution {

	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for (int m = 0; m < commands.length; m++) {
			int[] arr = new int[commands[m][1] - commands[m][0] + 1];
			arr = Arrays.copyOfRange(array, commands[m][0] - 1, commands[m][1]);
			Arrays.sort(arr);
			answer[m] = arr[commands[m][2] - 1];
		}

		return answer;
	}
}

public class KNumber {
	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		/*
		 * int[] array1 = { 1, 5, 2, 6, 3, 7, 4 }; array1 = Arrays.copyOfRange(array1,
		 * 0, 4); Arrays.stream(array1).forEach(x -> System.out.println(x));
		 */

		Solution s = new Solution();
		Arrays.stream(s.solution(array, commands)).forEach(x -> System.out.println(x));

	}
}
