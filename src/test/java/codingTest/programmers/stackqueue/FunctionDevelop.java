package codingTest.programmers.stackqueue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Solution3 {

	class ClearDay {
		int clearday;
		int index;

		public ClearDay(int clearday, int index) {
			super();
			this.clearday = clearday;
			this.index = index;
		}

	}

	public int[] solution(int[] progresses, int[] speeds) {

		Queue<Integer> qu = new LinkedList<Integer>();

		for (int i = 0; i < progresses.length; i++) {
			int j = 0;
			while (true) {
				progresses[i] = progresses[i]+speeds[i];
				j++;
				if (progresses[i] >= 100) {
					qu.add(j);
					break;
				}
			}
		}
		
		System.out.println(qu);
		ArrayList<Integer> ar = new ArrayList<Integer>();
		Iterator<Integer> it = qu.iterator();

		while (!qu.isEmpty()) {
			int cnt = 1;
			int day = qu.poll();
			while (!qu.isEmpty() && qu.peek() <= day) {
				qu.poll();
				cnt++;
			}
			ar.add(cnt);
		}
		
		System.out.println(ar);
		int[] answer = new int[ar.size()];
		for (int i = 0; i <answer.length ; i++) {
			answer[i] = ar.get(i);
		}

		return answer;
	}
}

public class FunctionDevelop {

	public static void main(String[] args) {
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };
		/* return [2,1] */
		Solution3 s = new Solution3();
		int[] a = s.solution(progresses, speeds);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}

}

/*
 * 실패코드, for문이 너무 많고, 시간초과 class Solution3 { public void spush(int i,
 * Stack<Integer> st){ Stack<Integer> temp = new Stack<Integer>();
 * while(!st.empty()) { if(i>st.peek()) { temp.push(st.pop()); }else {
 * st.push(i); while(!temp.empty()) { st.push(temp.pop()); } break; } }
 * if(st.empty()) { st.push(i); } }
 * 
 * public int[] solution(int[] progresses, int[] speeds) {
 * 
 * ArrayList<Integer> compl = new ArrayList<Integer>(); Stack<Integer> st = new
 * Stack<Integer>();
 * 
 * int j=0; while(true) {
 * 
 * int num=0; for(int i=0;i<progresses.length;i++) { progresses[i]+=speeds[i];
 * if(progresses[i]>=100) { spush(i,st); progresses[i]=0; speeds[i]=0; } }
 * 
 * while(!st.empty()){ if(st.peek() == j) { num++; j++; st.pop(); }else { break;
 * }
 * 
 * } if(!(num==0)) { compl.add(num); } if(j==speeds.length) { break; } } int[]
 * answer = new int[compl.size()]; for(int i=0;i<compl.size();i++) {
 * answer[i]=compl.get(i); } return answer; } }
 */