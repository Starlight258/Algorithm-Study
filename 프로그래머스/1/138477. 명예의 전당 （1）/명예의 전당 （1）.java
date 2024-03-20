import java.util.PriorityQueue;
import java.util.Collections;
import java.util.ArrayList;

class Solution {
    public int[] solution(int k, int[] score) {
        ArrayList<Integer> answer = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0;i<score.length;i++){
            pq.add(score[i]);
            
            if (pq.size()>k){
                pq.poll();
            }
            answer.add(pq.peek());
        }
        
        return answer.stream().mapToInt(x->x).toArray();
    }
}