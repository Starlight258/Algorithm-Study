import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];
        for (int i=0;i<lost.length;i++){
            arr[lost[i]-1] = -1;
        }
        for (int i=0;i<reserve.length;i++){
            arr[reserve[i]-1]++;
        }
        //2. 체육복 빌려주기
        Arrays.sort(lost);
        for (int i=0;i<lost.length;i++){
            int l = lost[i]-1;
            if (arr[l]!=-1) continue;
            if (l>0 && arr[l-1]>0){
                arr[l-1]--;
                arr[l]++;
            }
            else if (l+1<n&&arr[l+1]>0){
                arr[l+1]--;
                arr[l]++;
            }
        }
        //3. 정답
        for (int a:arr){
            if (a>=0) answer++;
        }
        return answer;
    }
}