import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int max = 1_000_000;
        int[] dp = new int[max+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        for (int i=x;i<=y;i++){
            if (dp[i] == Integer.MAX_VALUE){
                continue;
            }
            if (i+n <= max){
                dp[i+n] = Math.min(dp[i+n], dp[i]+1);
            }
            if (i*2 <= max){
                dp[i*2] = Math.min(dp[i*2], dp[i]+1);
            }
            if (i*3 <= max){
                dp[i*3] = Math.min(dp[i*3], dp[i]+1);
            }
        }
        
        if (dp[y] == Integer.MAX_VALUE){
            return -1;
        }
        return dp[y];
    }
    // 자연수 x -> y로 변환
    // x + n, x*2, x*3
    // x -> y로 변환하는 필요한 최소 연산 횟수
    // dp[i] = x에서 i를 만들기 위한 최소 연산 횟수 -> dp
    // dp[i] = Math.min(dp[i], dp[i+n]);
}