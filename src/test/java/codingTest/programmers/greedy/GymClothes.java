package codingTest.programmers.greedy;

import java.util.ArrayList;

class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;
		ArrayList<Integer> lo = new ArrayList<Integer>();
		ArrayList<Integer> re = new ArrayList<Integer>();
		for (int a : lost) {
			lo.add(a);
		}
		for (int a : reserve) {
			re.add(a);
		}
		lo.sort(null);
		re.sort(null);
		for(int i=0; i< lo.size(); i++) {
			for(int j=0; j< re.size(); j++) {
				if(lo.get(i)==re.get(j)) {
					lo.remove(i--);
					re.remove(j--);
					answer++;
					break;
				}
			}
		}
		
		while(lo.size()!=0) {
			for(int i=0;i<re.size();i++) {
				if(lo.get(0) == re.get(i)-1) {
					re.remove(i);
					answer++;
				}else if(lo.get(0) == re.get(i)+1) {
					re.remove(i);
					answer++;
				}
			}
			lo.remove(0);
		}

		return answer;
	}
}

public class GymClothes {

	public static void main(String[] args) {
		int n = 3;
		int[] lost = { 3 };
		int[] reserve = { 1 };
		Solution s = new Solution();
		System.out.println(s.solution(n, lost, reserve));
	}

}
