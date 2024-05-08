import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s:scoville){
            pq.add(s);
        }
        while (!pq.isEmpty()){
            int e1 = pq.poll();
            if (e1 >= K) return answer;
            if (pq.size()==0) return -1; 
            int e2 = pq.poll();
            int sc = e1 + e2 * 2;
            pq.offer(sc);
            answer++;
        }
        return -1;
    }
}