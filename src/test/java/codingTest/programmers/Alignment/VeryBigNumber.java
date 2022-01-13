package codingTest.programmers.Alignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution2 {
    public String solution(int[] numbers) {
        String answer = "";
        
        // ���ڹ迭�� ���ڸ���Ʈ�� ����
        List<String> list = new ArrayList<String>();
        for(int i=0; i<numbers.length; i++) {
        	list.add(Integer.toString(numbers[i]));
        }
        
        // �����۾�
        list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String first = o1+o2;
				String second = o2+o1;
				
				for(int i=0; i<first.length(); i++) {
					if(first.charAt(i) > second.charAt(i)) {
						return -1;
					}else if(first.charAt(i) < second.charAt(i)) {
						return 1;
					}
				}
				
				return 0;
			}
		});
        
        int zeroCount = 0;
        for(String str : list) {
        	if(str.equals("0")) {
        		zeroCount++;
        	}
        	answer = answer + str;
        }
        if(zeroCount == list.size()) {
        	return "0";
        }
        return answer;
    }
}

public class VeryBigNumber {
	
	int[] a1 = new int[3];
	
	public static void main(String[] args) {
		int[] numbers = {44,45,445,4,444,43,443,424,425,453,435,5,6,7,8,9,499,4,4,4,4,4};  // 0 �Ǵ� ���� ������ ����
		int[] numbers2 = {44,45,445,4,444}; 
		Solution2 s = new Solution2();
		String answer = s.solution(numbers);
		System.out.println(answer);
		String answer2 = s.solution(numbers2);
		System.out.println(answer2);
	}
}
