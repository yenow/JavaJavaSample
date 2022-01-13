package codingTest.programmers.stackqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

class Solution4 {
	
	public int solution(int[] priorities, int location) {
		LinkedList<Integer> qu = new LinkedList<Integer>(); 
		ArrayList<Integer> ar = new ArrayList<Integer>();
		//ArrayList<Integer> qu = new ArrayList<Integer>();
		int maxIndex=0;
		
		for (int i = 0; i<priorities.length; i++) {
			ar.add(priorities[i]);
			
			if(priorities[i]==priorities[location]) {
				qu.add(i);
			}
			
			if(priorities[location] < priorities[i]) {
				maxIndex = i;
			}
		}
		System.out.println(maxIndex);
		System.out.println(qu);
		ar.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2)
					return -1;
				else
					return 1;
			}
		});
		
		System.out.println(ar);
		
		for(int i=0; i< qu.size(); i++) {
			if( qu.peek() < maxIndex) {
				qu.add(qu.poll());
			}
		}
		
		System.out.println(qu);
		
		int answer=1;
		for(int i = 0; i < ar.size(); i++) {
			if(ar.get(i) == priorities[location])
				break;
			else
				answer++;
		}
		
		while(!qu.isEmpty()) {
			if( qu.peek() == location) 
				break;
			else {
				qu.pollFirst();
				answer++;
			}
		}
		System.out.println(qu);
		return answer;
	}
	
}

public class Printer {

	public static void main(String[] args) {
		int[] priorities = { 1,7, 2, 9, 1, 2, 1,7,3 ,9,6, 6 };
		Solution4 s = new Solution4();
		System.out.println(s.solution(priorities, 7));
	}

}

/*
 * 실패작 int max = 0;
 * 
 * public int solution(int[] priorities, int location) { int answer = 1;
 * Stack<Object> pr = new Stack<Object>(); for (int i = 0; i <
 * priorities.length; i++) { pr.push(new Printer(priorities[i], i)); if
 * (priorities[i] > priorities[max]) { max = i; } } pr.sort(new
 * Comparator<Object>() {
 * 
 * @Override public int compare(Object o1, Object o2) { Printer p1 = (Printer)
 * o1; Printer p2 = (Printer) o2; if (p1.priority > p2.priority) { return 1; }
 * else if (p1.priority < p2.priority) { return -1; } else { int t1 =
 * p1.location; int t2 = p2.location; if (t1 < max) { t1 = t1 +
 * priorities.length;
 * 
 * } if (t2 < max) { t2 = t2 + priorities.length;
 * 
 * } if (t1 - max < t2 - max) return 1; else return -1;
 * 
 * } } });
 * 
 * 
 * for (int i = 0; i < priorities.length; i++) { System.out.print(" " +
 * ((Printer)pr.pop()).location); }
 * 
 * 
 * while (!pr.empty()) { Printer p = new Printer(); p = (Printer) pr.pop(); if
 * (p.location == location) { break; } else { answer++; }
 * 
 * }
 * 
 * return answer; }
 */


/*
class Solution4 {

	class Printer {
		int priority;
		int location;
		int max;

		public Printer() {
		}

		public Printer(int priority, int location) {
			this.priority = priority;
			this.location = location;
		}

		public int getMax() {
			return max;
		}

		public void setMax(int max) {
			this.max = max;
		}

	}

	public int solution(int[] priorities, int location) {
		int answer = 1;
		Stack<Object> pr = new Stack<Object>();

		for (int i = 0; i < priorities.length; i++) {
			Printer temp = new Printer(priorities[i], i);
			for (int j = priorities.length - 1; j >= 0; j--) {
				if (priorities[j] > priorities[i]) {
					temp.setMax(j);
					break;
				}
			}
			pr.push(temp);
		}

		pr.sort(new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				Printer p1 = (Printer) o1;
				Printer p2 = (Printer) o2;

				if (p1.priority > p2.priority) {
					return 1;
				} else if (p1.priority < p2.priority) {
					return -1;
				} else {

					int n1 = 0, n2 = 0;
					int t1 = p1.max - p1.location;
					int t2 = p2.max - p2.location;

					if (t1 > 0)
						n1 = p1.location + priorities.length;
					else
						n1 = p1.location;

					if (t2 > 0)
						n2 = p2.location + priorities.length;
					else
						n2 = p1.location;

					if (n1 < n2)
						return 1;
					else
						return -1;

				}
			}

		});

		for (int i = 0; i < priorities.length; i++) {
			System.out.print(" " + ((Printer) pr.pop()).location);
		}

		// location 순서 알아내기
		while (!pr.empty()) {
			Printer p = new Printer();
			p = (Printer) pr.pop();
			if (p.location == location) {
				break;
			} else {
				answer++;
			}

		}

		return answer;
	}
}
*/