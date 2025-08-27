import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        List<Integer> times = new ArrayList<>();
        PriorityQueue<Job> pq = new PriorityQueue<>((p1, p2)->{
            if (p1.time == p2.time){
                if (p1.requestTime == p2.requestTime){
                    return Integer.compare(p1.number, p2.number);
                }
                return Integer.compare(p1.requestTime, p2.requestTime);
            }
            return Integer.compare(p1.time, p2.time);
        });
        
        // 요청시간으로 오름차순 정렬하기
        Arrays.sort(jobs, (j1,j2)-> Integer.compare(j1[0], j2[0]));
        
        // 1초마다 작업 저장
        int curTime = jobs[0][0];
        int idx = 0;
        
        while (idx<jobs.length){
            while (jobs[idx][0]<=curTime){
                int[] job = jobs[idx];
                pq.offer(new Job(job[0], job[1], idx));
                idx++;
                if (idx>=jobs.length){
                    break;
                }
            }
            if (pq.isEmpty()){
                curTime++;
            } else {
                Job curJob = pq.poll();
                curTime += curJob.time;
                times.add(curTime - curJob.requestTime);   
            }
        }
        while (!pq.isEmpty()){
            Job curJob = pq.poll();
            curTime += curJob.time;
            times.add(curTime - curJob.requestTime);   
        }
        
        int total = 0;
        for (int time:times){
            total += time;
        }
        return total / times.size();
    }
    
    class Job {
        int requestTime;
        int time;
        int number;
        
        public Job(int requestTime, int time, int number){
            this.requestTime = requestTime;
            this.time = time;
            this.number = number;
        }
    }
    
    // 1. 1초마다 우선순위 큐에 Job 넣기 
    // 2. poll 해서 job 뽑기
    // 3. 종료시 종료시간 저장 후, 가장 우선순위 높은 job 뽑기
}