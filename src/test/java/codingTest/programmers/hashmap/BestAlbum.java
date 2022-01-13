package codingTest.programmers.hashmap;

import java.util.*;

class Solution3 {
    public int[] solution(String[] genres, int[] plays) {   
        int flag=0;
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        for(int i=0; i< genres.length ; i++) {
            if(map.get(genres[i])==null) {
                 ArrayList<Integer> a = new ArrayList<Integer>();
                 a.add(i);
                 map.put(genres[i], a);
            }else {
                ArrayList<Integer> temp;
                temp = map.get(genres[i]);
                temp.add(i);
            }

            map2.put(genres[i], map2.getOrDefault(genres[i],0)+plays[i]);
        }

        // map("�帣��", ArrayList�� ��ȸ���� �ε��� ������ sort)
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while(it.hasNext()) {
            ArrayList<Integer> a =map.get(it.next()); 
            a.sort(new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    if(plays[o1]>plays[o2]) {
                        return -1;
                    }else if(plays[o1]<plays[o2]) {
                        return 1;
                    }else {
                        return 0;
                    }
                }

            });    

            if(a.size()<2) {
                flag++;
            }
        }
        ArrayList<String> songlist = new ArrayList<String>();


        // 
        Set<String> set2 = map2.keySet();
        Iterator<String> it2 = set2.iterator();

        // �帣�� ��ü ��ȸ�� ArrayList�����
        while(it2.hasNext()) {
            songlist.add(it2.next());

        }
        // �帣�� ��ü ��ȸ�� sort
        songlist.sort(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if(map2.get(o1)>map2.get(o2)) {
                    return -1;
                }else if(map2.get(o1)<map2.get(o2)) {
                    return 1;
                }else {
                    return 0;
                }
            }

        });



       int[] answer = new int[map2.size()*2-flag];


        int i =0;
        for(String a : songlist) {
            ArrayList<Integer> q = map.get(a);

            if(q.size()>1) {
                if(plays[q.get(0)]==plays[q.get(1)]) {
                    if(q.get(0)>q.get(1)) {
                        answer[i++] = q.get(1);
                        answer[i++] = q.get(0);

                    }else {
                        answer[i++] = q.get(0);
                        answer[i++] = q.get(1);

                    }
                }else {
                    answer[i++] = q.get(0);
                    answer[i++] = q.get(1);
                }
            }else if(q.size()==1) {
                answer[i++] = q.get(0);
            }
        }

        return answer;
    }
}

public class BestAlbum {

}
