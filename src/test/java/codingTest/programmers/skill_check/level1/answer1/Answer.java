package codingTest.programmers.skill_check.level1.answer1;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

class Solution {

    public String solution(int a, int b) {
        String answer = "";
        LocalDate localDate = LocalDate.of(2016, a, b);
        return localDate.getDayOfWeek().toString().substring(0, 3);
    }
}

public class Answer {

    @Test
    void test1() {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, 24));
    }

    @Test
    void test2() {
        LocalDate localDate = LocalDate.of(2016, 1, 1);
        System.out.println(localDate.getDayOfWeek());
        System.out.println(DayOfWeek.MONDAY);
        System.out.println(DayOfWeek.MONDAY.toString());
    }
}
