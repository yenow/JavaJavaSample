package codingTest.programmers.totalExplore.test2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public int solution(String numbers) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length(); i++) {
            String number = numbers.substring(i, i+1);
            list.add(Integer.parseInt(number));
        }

        recursive(list, numbers, 2, numbers.length());

        for (Integer num : list) {

            set.add(num);
        }

        for (Integer num : set) {
            if (isPrimeNumber(num)) {
                answer++;
            }
        }
        return answer;
    }

    void recursive(List<Integer> list, String numbers, int index, int maxIndex) {

        if (index > maxIndex) {
            return ;
        } else {

            int listSize = list.size();
            for (int i = 0; i < listSize; i++) {
                for (int j = 0; j < numbers.length(); j++) {
                    String number = numbers.substring(j, j+1);
                    long count = numbers.chars().filter(value -> value == number.charAt(0)).count();
                    String elementNumber = list.get(i).toString();

                    if (elementNumber.chars().filter(value -> value == number.charAt(0)).count() <= count - 1) {
                        list.add(Integer.parseInt(elementNumber+number));
                    }
                }
            }

            recursive(list, numbers,index + 1, maxIndex);
        }
    }


    boolean isPrimeNumber(int num) {
        if (num == 1 || num == 0) {
            return false;
        } else if (num == 2) {
            return true;
        }

        for (int i=2; i <= (int) Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

public class findPrimeNumber {

    @Test
    void test() {
        Solution solution = new Solution();
        String numbers = "172";
        System.out.println("정답 :" + solution.solution(numbers));
    }
}


class Solution2 {
    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int count = 0;
        while(set.iterator().hasNext()){
            int a = set.iterator().next();
            set.remove(a);
            if(a==2) count++;
            if(a%2!=0 && isPrime(a)){
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int n){
        if(n==0 || n==1) return false;
        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
            if(n%i==0) return false;
        }
        return true;
    }

    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        //if (n == 0) System.out.println(prefix);
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);

    }

}