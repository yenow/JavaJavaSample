package codingTest.inflearn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Chapter2 {

    @Test
    void example() {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i=0; i<n; i++) {
              a[i] = in.nextInt();
        }
        for (int i=0; i<n; i++) {
              b[i] = in.nextInt();
        }
        System.out.println();
    }

    @Test
    @DisplayName("큰 수 출력하기")
    void test() {
        /* 문제 : 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램 */
        int[] arrays = {7, 3, 9, 5, 6, 12};
        test1_solution(arrays);
    }

    void test1_solution(int[] arrays) {

        for (int i = 0; i < arrays.length; i++) {
            if (i == 0) {
                System.out.printf("%d ", arrays[i]);
            } else {

                if (arrays[i] > arrays[i - 1]) {
                    System.out.printf("%d ", arrays[i]);
                }
            }
        }
    }

    @Test
    @DisplayName("보이는 학생")
    void test2() {
        /*
        문제 : 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
              선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
        입력 : 130 135 148 140 145 150 150 153  /  출력 : 5
        */
        int[] arrays = {130, 135, 148, 140, 145, 150, 150, 153};
        System.out.println(test2_MySolution(arrays));
    }

    int test2_MySolution(int[] arrays) {
        int result = 0;

        int max = 0;
        for (int size : arrays) {
            if (size > max) {
                result++;
                max = size;
            }
        }

        return result;
    }

    @Test
    @DisplayName("가위바위보")
    void test3() {
        /*
        문제 : A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
              가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
        입력 : 130 135 148 140 145 150 150 153  /  출력 : 5
        */
        int[] a = {1,2,1,2,1};
        int[] b = {1,2,3,2,2};
        System.out.println(test3_MySolution(a,b));
    }

    String test3_MySolution(int[] a, int[] b) {
        String result = "";

        for (int i=0; i< a.length; i++) {
            if (a[i] == b[i]) result += "D";
            else if (a[i]==1 && b[i]==3) result += "A";
            else if (a[i]==2 && b[i]==1) result += "A";
            else if (a[i]==3 && b[i]==2) result += "A";
            else result += "B";
        }

        return result;
    }
}
