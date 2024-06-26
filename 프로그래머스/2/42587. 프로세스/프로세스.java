import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<priorities.length;i++){
            q.offer(priorities[i]);
        }
    
        while (!q.isEmpty()){
            for(int i=0;i<priorities.length;i++){
                if (q.peek() == priorities[i]){
                    answer++;
                    if (i == location){
                        return answer;
                    }
                    q.poll();
                }
            }
        }
        
       
        return answer;
    }
}