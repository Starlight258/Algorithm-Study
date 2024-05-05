import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        // 무조건 원소 넣기
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        // 무조건 첫번째 원소와 현재 원소 비교하기
        for (int i=0;i<enemy.length;i++){
            if (i<k){
                pq.offer(enemy[i]);
                continue;
            }
            // 현재 원소가 더 크다면 무조건 원소에 저장하기
            if (enemy[i]>pq.peek()){
                answer += pq.poll();
                pq.offer(enemy[i]);
                
            // 현재 원소가 더 작다면 answer에 더하기
            } else answer += enemy[i];
            
            if (answer > n){
                return i;
            }
        }
        return enemy.length;
    }
}