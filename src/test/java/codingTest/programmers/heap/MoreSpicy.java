package codingTest.programmers.heap;


import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pr = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer x, Integer y) {
				if(x>y) {
					return 1;
				}else if(y>x) {
					return -1;
				}
				return 0;
			}
		});
        
        for(int a : scoville) {
        	pr.add(a);
        	System.out.println(pr);
        }
        
     
       
       while(!pr.isEmpty() && pr.peek()<K) {
    	   int a = pr.poll();
    	   if(!pr.isEmpty()) {
    		   pr.add(a+pr.poll()*2);
    		   answer++;
    	   }else {
    		   return -1;
    	   }
    	   
       }
        return answer;
    }	
}

public class MoreSpicy {

	public static void main(String[] args) {
		int[] scoville = {12,10,9,7,3,1};
		int K = 7;
		Solution s = new Solution();
		System.out.println(s.solution(scoville, K));
	}

}
	