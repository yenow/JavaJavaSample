package codingTest.programmers.stackqueue;

import java.util.LinkedList;
import java.util.Stack;

public class TruckStreet {
	class Truck {
		int legnth;
		int weight;

		public Truck(int legnth, int weight) {
			this.legnth = legnth;
			this.weight = weight;
		}
		
	}

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;

		LinkedList<Truck> ing = new LinkedList<Truck>();
		Stack<Integer> wait = new Stack<Integer>();

		
		for (int j = truck_weights.length - 1; j >= 0; j--) {
			wait.push(truck_weights[j]);
		}

		while (true) {

			answer++;
			
			for (int h = 0; h < ing.size(); h++) {
				ing.get(h).legnth = ing.get(h).legnth + 1;
				if (ing.get(h).legnth == bridge_length) {
					ing.remove();
					h=h-1;
				}
			}

			
			int sum = 0;
			for (int h = 0; h < ing.size(); h++) {
				sum = sum + ing.get(h).weight;
			}

			if (!wait.isEmpty()) {
				if ((sum + wait.peek()) <= weight) {
					Truck t = new Truck(0, wait.pop());
					ing.add(t);
				}
			}

			/*
			 * System.out.println(answer + " " + wait + " " + ing.peekFirst().weight + " "+
			 * ing.peekLast().weight);
			 */
			if (ing.peekFirst() == null && wait.isEmpty() == true) {
				break;
			}
		}
		return answer;
	}

	public static void main(String[] args) {

		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = { 10,10,10,10,10,10,10,10,10,10 };

		TruckStreet st = new TruckStreet();

		System.out.print(st.solution(bridge_length, weight, truck_weights));

	}

}
