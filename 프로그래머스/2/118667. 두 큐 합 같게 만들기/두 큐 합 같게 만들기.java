import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum = 0;
        long sum1=0; 
        int n = queue1.length;
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        for (int i=0;i<n;i++){
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum += queue1[i] + queue2[i];
            sum1 += queue1[i];
        }
        if (sum%2==1) return -1;
        long sum2 = sum-sum1;
        sum /= 2; // 각각 만족해야하는 sum
        if (sum1==sum) return 0;
        while (sum1 != sum || sum2!=sum){
            if (answer>n*3) return -1;
            if (sum1>sum){
                int e1 = q1.poll();
                q2.offer(e1);
                sum1 = sum1 - e1;
                sum2 = sum2 + e1;
                answer++;
                if (sum1 == sum2) break;
            }
            else{
                 int e2 = q2.poll();
                 q1.offer(e2);
                 sum2 = sum2 - e2;
                 sum1 = sum1 + e2;
                answer++;
                if (sum1 == sum2) break;
            }
            if (sum1 == sum2) break;
        }
        
        return answer;
    }
}