package codingTest.programmers.heap.test3;

import org.junit.jupiter.api.Test;

import java.util.*;


public class Test3 {

    class Solution {
        public int[] solution(String[] operations) {
            int[] answer = {};

            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o1 > o2 ? -1 : 1);

            for (String operation : operations) {
                String op = operation.split(" ")[0];
                Integer num = Integer.parseInt(operation.split(" ")[1]);

                if (op.equals("D")) {
                    if (num == 1) {
                        if (!priorityQueue.isEmpty())  priorityQueue.remove();
                    } else {
                        if (!priorityQueue.isEmpty()) priorityQueue.remove(priorityQueue.stream().min(Comparator.naturalOrder()).get());
                    }
                } else {
                    priorityQueue.offer(num);
                }

            }

            int max = priorityQueue.stream().max(Comparator.naturalOrder()).orElse(0);
            int min = priorityQueue.stream().min(Comparator.naturalOrder()).orElse(0);

            return new int[]{ max, min };
        }
    }

    @Test
    void test() {
        String[] list = {"I 16","D 1"};
        String[] list2 = {"I 7","I 5","I -5","D -1"};

        int[] result = new Solution().solution(list);
        System.out.println(result[0] + " " + result[1]);

        int[] result2 = new Solution().solution(list2);
        System.out.println(result2[0] + " " + result2[1]);
        // operations
    }

    @Test
    void test2() {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o1 >= o2 ? -1 : 1);
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);

        System.out.println(priorityQueue);

        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue2.add(1);
        priorityQueue2.add(2);
        priorityQueue2.add(3);

        System.out.println(priorityQueue2);
        System.out.println(priorityQueue2.stream().max(Comparator.naturalOrder()));
        priorityQueue2.remove(priorityQueue2.stream().max(Comparator.naturalOrder()).get());
        System.out.println(priorityQueue2.poll());
        System.out.println(priorityQueue2.poll());
        System.out.println(priorityQueue2.poll());

    }
}
