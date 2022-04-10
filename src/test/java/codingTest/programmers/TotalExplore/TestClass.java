package codingTest.programmers.TotalExplore;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution {

	public int[] solution(int[] answers) {
		int[] score = new int[] { 0, 0, 0 };
		int[] student1 = { 1, 2, 3, 4, 5 };
		int[] student2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] student3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		for (int i = 0; i < answers.length; i++) {
			if (student1[i % 5] == answers[i]) {
				score[0]++;
			}
			if (student2[i % 8] == answers[i]) {
				score[1]++;
			}
			if (student3[i % 10] == answers[i]) {
				score[2]++;
			}
		}

		int max=0;
		int count=0;
		for(int i=0; i<score.length;i++) {
			if(max<score[i]) {
				max =score[i];
				count=1;
			}else if(max == score[i]){
				count++;
			}
		}
		
		int j=0;
		int[] answer = new int[count];	
		for(int i=0; i<score.length;i++) {
			if(max==score[i]) {
				answer[j++]=i+1;
			}
		}
		
		return answer;
	}
}

public class TestClass {

	public static void main(String[] args) {
		int[] answers = { 1, 2, 3, 4, 5 };
		Solution s = new Solution();
		Arrays.stream(s.solution(answers)).forEach(x -> System.out.print(x + " "));
	}

	@Test
	void test() {

	}
}
