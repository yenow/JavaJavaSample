package codingTest.programmers.graph.farNode;


import org.junit.jupiter.api.Test;

import java.util.*;


class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] arr = new int[n];

        Set<Integer> set = new HashSet<>();
        set.add(1);
        List<Integer> start = new ArrayList<>();
        start.add(1);

        bfs(edge,arr,start,set,1);

        int max=0;
        for (int value : arr) {
            if (value > max) {
                max = value;
                answer = 1;
            } else if (value == max) {
                answer++;
            }
        }

        return answer;
    }

    void bfs(int[][] edge, int[] arr, List<Integer> start, Set<Integer> set, int distance) {
        List<Integer> nextNode = new ArrayList<>();

        for (int node : start) {

            for (int[] arcs : edge) {
                if (arcs[0] == node && !set.contains(arcs[1])) {
                    set.add(arcs[1]);
                    arr[arcs[1]-1] = distance;
                    nextNode.add(arcs[1]);

                } else if (arcs[1] == node && !set.contains(arcs[0])) {
                    set.add(arcs[0]);
                    arr[arcs[0]-1] = distance;
                    nextNode.add(arcs[0]);
                }
            }
        }

        if (set.size() == arr.length)  return;
        bfs(edge,arr,nextNode,set, distance+1);
    }

}

public class FarNode {

    @Test
    void test() {
        System.out.println(new Solution().solution(6, new int[][] {{3, 6},{4, 3},{3,2},{1,3},{1,2},{2,4},{5,2} }));

    }

    @Test
    void test2() {
        int[][] a = new int[][] {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
//        System.out.println(a[1][1]);
//        System.out.println(a[0][0]);

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(4);

        for (int t : list.stream().mapToInt(value -> value).toArray()) {
            if (t == 1) {
                list.remove(Integer.valueOf(t));
            }
            System.out.println(t);
        }
        System.out.println(list);


//        list.remove(3);
//        list.remove(Integer.valueOf(3));
//        System.out.println(list);

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
//        for (int t : stack) {
//            System.out.println(t);
//        }
//        System.out.println(stack);
    }

    @Test
    void test3() {
        int[] nextNode = new int[3];
        nextNode[0] = 1;
        System.out.println(nextNode[0]);
        for (int i : nextNode) {
            System.out.println(i);
        }
    }
}



