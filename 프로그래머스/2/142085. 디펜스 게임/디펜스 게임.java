import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int sum = 0;        
        
        for (int i=0;i<enemy.length;i++){
            if (i<k){
                pq.offer(enemy[i]);
                continue;
            }

            if (enemy[i]>pq.peek()){
                sum += pq.poll();
                pq.offer(enemy[i]);                
            } else sum += enemy[i];
            
            if (sum > n){
                return i;
            }
        }
        return enemy.length;
    }
}