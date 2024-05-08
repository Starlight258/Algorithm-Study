import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s:scoville){
            pq.add(s);
        }
        while (pq.size()>=2){
            int e1 = pq.poll();
            if (e1 >= K) break;
            int e2 = pq.poll();
            int sc = e1 + e2 * 2;
            pq.offer(sc);
            answer++;
        }
        if (!pq.isEmpty()){
            if (pq.poll() >= K) return answer; 
        }
        return -1;
    }
}