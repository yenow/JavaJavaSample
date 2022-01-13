package codingTest.programmers.stackqueue;

import java.util.Stack;

public class Top {
	public static int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		for (int i = 0; i < heights.length; i++) {
			answer[i] = 0;
		}

		Stack<Integer> temp = new Stack<Integer>();
		Stack<Integer> st = new Stack<Integer>();

		for (int h = heights.length - 1; h >= 0; h--) {

			if (st.empty()) {
				st.push(h);
				continue;
			} else {
				while (!st.empty()) {
					int a = st.pop();
					if (heights[a] < heights[h]) {
						answer[a] = h + 1;
					} else {
						temp.push(a);
					}
				}

				while (!temp.empty()) {
					st.push(temp.pop());
				}
				st.push(h);
			}

		}

		return answer;
	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		int[] heights = new int[] { 3, 9, 9, 3, 5, 7, 2 };

		/*
		 * st.push(1); st.push(2); System.out.print(st); if(st.pop()==2) {
		 * 
		 * } int i = st.pop(); System.out.print(st);
		 */

		int[] h = solution(heights);
		for (int i = 0; i < h.length; i++) {
			System.out.print(h[i] + " ");
		}

	}

}
