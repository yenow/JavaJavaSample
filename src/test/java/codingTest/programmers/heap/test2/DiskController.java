package codingTest.programmers.heap.test2;


import org.junit.jupiter.api.Test;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        List<int[]> list = new ArrayList<>();
        list.addAll(Arrays.asList(jobs));

        List<Integer> timeList = new ArrayList<>();
        int time = 0;

        for (int i=0; i<jobs.length; i++) {

            int minTime = Integer.MAX_VALUE;
            int requestTime = 0;
            int removeIndex = 0;

            for (int j=0; j<list.size(); j++) {
                if (list.get(j)[0] <= time && list.get(j)[1] < minTime) {
                    minTime = list.get(j)[1];
                    requestTime = list.get(j)[0];
                    removeIndex = j;
                }
            }

            if (minTime == Integer.MAX_VALUE) {
                time++;
                i = i-1;
            } else {
                time += minTime;
                timeList.add(time - requestTime);
                list.remove(removeIndex);
            }

        }


        for (Integer num : timeList) {
            answer += num;
        }
        return answer/jobs.length;
    }
}

public class DiskController {

    @Test
    void test() {
        int[][] example = {
            {0,3}
            ,{1,9}
            ,{2,6}
        };

        System.out.println(new Solution().solution(example));
    }
    
    @Test
    void test2() {
        Integer[] sample = {1,2,3,4,5,6};
        Arrays.sort(sample, Collections.reverseOrder());
        Arrays.stream(sample).forEach(value -> System.out.println("value = " + value));

        Integer[] sample2 = {1,2,3,4,5,6};
        Arrays.sort(sample2, (o1, o2) -> o1 > o2 ? -1 : 1);     // 음수를 리턴하면 자리를 바꾸는구나
        Arrays.stream(sample2).forEach(value -> System.out.println("value = " + value));
    }
}


class Solution2 {
    public static int solution(int[][] jobs) {

        Arrays.sort(jobs, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0] <= o2[0]){
                    return -1;
                }
                return 1;
            }
        });

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[1] < o2[1]){
                    return -1;
                }
                return 1;
            }
        });

        int time = 0;
        int index = 0;
        float answer = 0;

        while(true){
            while(index < jobs.length && jobs[index][0] <= time){
                queue.offer(jobs[index]);
                index ++;
            }
            if(queue.size() == 0){
                time = jobs[index][0];
                continue;
            }
            int[] job = queue.poll();
            time += job[1];
            answer += time - job[0];
            if(index == jobs.length && queue.size() == 0){
                break;
            }
        }

        answer /= jobs.length;
        return (int)answer;
    }
}


class Solution3 {
    public int solution(int[][] jobs) {
        int answer =0;
        int currentTime = 0;
        int allTime = 0;
        int visitedNum = 0;
        boolean[] isVisited = new boolean[jobs.length];
        PriorityQueue<Job> heap = new PriorityQueue();

        Arrays.sort(jobs,(job1,job2)->{
            if(job1[0]==job2[0])
                return Integer.compare(job1[1],job2[1]);
            else
                return Integer.compare(job1[0],job2[0]);
        });

        isVisited[0] = true;
        heap.add(new Job(jobs[0][0],jobs[0][1]));
        currentTime+=jobs[0][0];
        visitedNum++;

        while(!heap.isEmpty() || visitedNum != jobs.length){

            if(!heap.isEmpty()){
                Job currentJob = heap.poll();
                currentTime += currentJob.jobTime;
                allTime += (currentTime - currentJob.start);
            }
            else
                currentTime++;

            for(int i =0; i<jobs.length; i++){
                if(isVisited[i]) continue;
                if(currentTime>=jobs[i][0]){
                    isVisited[i] = true;
                    heap.add(new Job(jobs[i][0],jobs[i][1]));
                    visitedNum++;
                }
            }
        }

        answer = allTime / jobs.length;
        return answer;
    }
}

class Job implements Comparable<Job>{

    int start;
    int jobTime;

    Job(int start,int jobTime){
        this.start = start;
        this.jobTime = jobTime;
    }

    @Override
    public int compareTo(Job job){
        if(this.jobTime>job.jobTime)
            return 1;
        else
            return -1;
    }

}
