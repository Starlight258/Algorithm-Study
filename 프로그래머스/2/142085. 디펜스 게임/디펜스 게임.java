import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        if (enemy.length<=k) return enemy.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> Integer.compare(a, b));
        int death = n;
        for (int i=0;i<enemy.length;i++){
            if (i<k){
                pq.offer(enemy[i]);
                answer++;
                continue;
            }
            if (!pq.isEmpty() && pq.peek() < enemy[i]){
                death-= pq.poll();
                pq.offer(enemy[i]);
            } else {
                death-= enemy[i];
            }
            if (death==0) return i+1;
            if (death<0){
                return i;
            }
            answer++;
        }
        return answer;
    }
}