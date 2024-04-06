import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        int[] check = new int[n+1];
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i=0;i<lost.length;i++){
            check[lost[i]] = -1;
        }
        for (int i=0;i<reserve.length;i++){
            check[reserve[i]] += 1;   
            if (check[reserve[i]] == 0) answer++;
        }
        for (int i=0;i<lost.length;i++){
            int l = lost[i];
            if (l-1 >=0 && check[l-1] > 0){
                check[l-1] = 0;
                answer++;
            } 
            else if (l+1 <n && check[l+1]>0){
                check[l+1] = 0;
                answer++;
            }
        }
        return answer;
    }
}