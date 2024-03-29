import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> hm = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<priorities.length;i++){
            hm.put(i, priorities[i]);
            pq.offer(priorities[i]);
            q.offer(i);
        }
        while (!pq.isEmpty()){
            int pri = pq.poll();
            while (!q.isEmpty()){
                int idx = q.poll();
                if (pri == hm.get(idx)){
                    cnt++;
                    if (idx == location) return cnt;
                    break;
                } else {
                    q.offer(idx);
                }
            }
        }
       
        return answer;
    }
}