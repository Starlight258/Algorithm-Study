import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1=0, sum2=0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i=0;i<queue1.length;i++){
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        long goalSum = (sum1 + sum2) / 2;
        if ((long)(sum1 + sum2)%2==1) return -1;
        if (goalSum==sum1) return 0;
        System.out.println(queue1.length);
        while (true){
            answer++;
            if (answer>=3*queue1.length) return -1;
            if (sum1>goalSum){
                int e = q1.poll();
                sum1 -= e;
                q2.offer(e);
            } else{
                int e = q2.poll();
                q1.offer(e);
                sum1 += e;
            }
            if (sum1==goalSum) break;
        }
        return answer;
    }
}