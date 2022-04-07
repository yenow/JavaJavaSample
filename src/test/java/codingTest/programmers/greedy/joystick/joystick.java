package codingTest.programmers.greedy.joystick;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution {
    public int solution(String name) {
        String startName = "";
        for (int t = 0; t < name.length(); t++) {
            startName += "A";
        }
        return Math.min(searchToNext(startName,name,0,0, true), searchToPrev(startName,name,0,0, true));
    }

    int getCount(char character) {
        if (character <= 'N') {
            return character - 'A';
        } else {
            return 'Z' + 1 - character;
        }
    }

    int searchToNext(String startName, String objectName, int count, int index, boolean canBack) {
        int nextIndex = (index + 1) % objectName.length();
        int prevIndex = index - 1 < 0 ? objectName.length() - 1 : index - 1;

        if (startName.charAt(index) != objectName.charAt(index)) {
            count += getCount(objectName.charAt(index));
            char[] chars = startName.toCharArray();
            chars[index] = objectName.charAt(index);
            startName = String.valueOf(chars);
        }

        if (startName.compareTo(objectName) == 0) return count;
        else count++;

        if (canBack && objectName.charAt(index) != 'A' && objectName.charAt(nextIndex) == 'A') {
            return Math.min(searchToPrev(startName,objectName,count,prevIndex, false), searchToNext(startName,objectName,count,nextIndex, true));
        }

        return searchToNext(startName,objectName,count,nextIndex, canBack);
    }

    int searchToPrev(String startName, String objectName, int count, int index, boolean canBack) {
        int nextIndex = (index + 1) % objectName.length();
        int prevIndex = index - 1 < 0 ? objectName.length() - 1 : index - 1;

        if (startName.charAt(index) != objectName.charAt(index)) {
            count += getCount(objectName.charAt(index));
            char[] chars = startName.toCharArray();
            chars[index] = objectName.charAt(index);
            startName = String.valueOf(chars);
        }

        if (startName.compareTo(objectName) == 0) return count;
        else count++;

        if (canBack && objectName.charAt(index) != 'A' && objectName.charAt(prevIndex) == 'A') {
            return Math.min(searchToPrev(startName,objectName,count,prevIndex, true), searchToNext(startName,objectName,count,nextIndex, false));
        }

        return searchToPrev(startName,objectName,count,prevIndex, canBack);
    }
}

public class joystick {

    @Test
    void test() {
//        System.out.println(new Solution().solution( "JEROEN"));
//        System.out.println(new Solution().solution("JAN"));
        System.out.println(new Solution().solution("BBBBAAAABA"));
//        System.out.println(new Solution().solution("ABABABAAYERYBBAAAAB"));
//        System.out.println(new Solution().solution("ABQWRTUTTJQQBAQWRQAA"));
    }

    @Test
    void characterTest() {
        char char1 = 'a';
        char char2 = 'z';

        for (int i = char1; i < char2; i++) {
            System.out.printf("%s = %d   " , (char) i , i - char1);
        }

        System.out.println();

        for (int i = char2; i > char1; i--) {
            System.out.printf("%s = %d   " , (char) i, char2 + 1 - i);
        }
    }
    
    @Test
    void stringBuilderTest() {
        StringBuilder ab = new StringBuilder("AB");
        ab.replace(0, 1, "B");
        System.out.println("ab = " + ab);
        System.out.println(ab.substring(0,1));
        System.out.println(ab.substring(1,2));


        StringBuilder aa = new StringBuilder("AA");
        StringBuilder aa2 = new StringBuilder("AA");
        StringBuilder aa3 = new StringBuilder("AA3");
        System.out.println(aa.compareTo(aa2));
        System.out.println(aa.compareTo(aa3));

    }
}
