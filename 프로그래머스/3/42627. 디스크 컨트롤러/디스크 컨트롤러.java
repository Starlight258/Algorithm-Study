import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int time = 0;
        int pos = 0;
        int cnt = 0; // 작업 완료한 갯수
        while (cnt < jobs.length){ // 작업 다 완료되었을때까지
             while (pos < jobs.length && time >= jobs[pos][0]){
                pq.offer(jobs[pos++]);
            } 
            if (!pq.isEmpty()){ // 가능한 작업 있을때
                int[] job = pq.poll();
                time += job[1];
                cnt++;
                answer += time - job[0];
            } else{
                time = jobs[pos][0];
            }
            
        }

        answer /= jobs.length;
        return answer;
    }
}