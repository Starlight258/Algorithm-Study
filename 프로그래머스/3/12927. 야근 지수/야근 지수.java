import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        //1. 최대값 구하기
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<works.length;i++){
            pq.offer(works[i]);
        }
        int maxWork = pq.peek(); 
        int secondWork = 0;
        int workTime = n;
        //2. 두번째 값으로 만들기
        while (!pq.isEmpty()){
            maxWork = pq.poll();
            secondWork = pq.poll();
            if (maxWork == secondWork){
                secondWork--;
                workTime--;
            }
            while (workTime>0 && maxWork>secondWork){
                maxWork--;
                workTime--;
            }
            if (workTime==0){
                pq.offer(maxWork);
                pq.offer(secondWork);   
                break;
            }
            // workTime이 남은 경우
            else {
                pq.offer(maxWork);
                pq.offer(secondWork); 
            }
        }
        //3. 정답 출력
        if (pq.peek()<=0) return 0;
        while (!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }
        return answer;
    }
}