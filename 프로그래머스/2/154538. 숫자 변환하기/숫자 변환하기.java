import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int dp[] = new int[1000001];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[x] = 0;
        if (x*2 < 1000001) dp[x*2] = 1;
        if (x*3 < 1000001) dp[x*3] = 1;
        if(x+n < 1000001) dp[x+n] = 1;
        
        for (int i=x;i<1000001;i++){
            if (i*2<1000001 && dp[i] !=Integer.MAX_VALUE) dp[i*2] = Math.min(dp[i*2], dp[i] + 1);
            if (i*3<1000001 && dp[i] != Integer.MAX_VALUE) dp[i*3] = Math.min(dp[i*3], dp[i]+1);
            if (i+n<1000001 && dp[i] != Integer.MAX_VALUE) dp[i+n] = Math.min(dp[i+n], dp[i]+1);
        }
                                         
        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
}