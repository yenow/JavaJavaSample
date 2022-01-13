package codingTest.programmers.hashmap;

import java.util.HashMap;

class Solution {
     public boolean solution(String[] phone_book) {

        HashMap<Integer, String> map = new HashMap<Integer, String>();
        int j=0;
        for(String a : phone_book) {
            for(int i=0; i<map.size() ; i++) {
                String temp = map.get(i);
                if(temp.length() > a.length()) {
                    if(temp.substring(0, a.length()).equals(a)) {
                        return false;
                    }
                }else {
                    if(a.substring(0, temp.length()).equals(temp)) {
                        return false;
                    }
                }
            }
            map.put(j++, a);
        }

        return true;
    }
}

public class TelList {
	
}
