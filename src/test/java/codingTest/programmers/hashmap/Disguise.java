package codingTest.programmers.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Solution2 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(int i=0; i<clothes.length ;i++) {
            for(int j=0; j<2 ;j++) {
                if(j==1) {
                    map.put(clothes[i][j], map.getOrDefault(clothes[i][j],0)+1);
                }
            }
        }
       Set<String> set = map.keySet();
       Iterator<String> it = set.iterator();
       int sum = map.get(it.next());
       while(it.hasNext()) {
           int i=map.get(it.next());

           sum = (sum+1)*i+sum;

       }
        return sum;
    }
}

public class Disguise {

}
