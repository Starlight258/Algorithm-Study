import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        
        for (int i=1;i<n;i++){
            for (int j=0;j<=i;j++){
                if (j==0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]) + triangle[i][j];
                    continue;
                }
                if (i==j){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]) + triangle[i][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]); 
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                dp[i][j] += triangle[i][j];
            }
        }
        
        for (int i=0;i<n;i++){
            answer = Math.max(dp[n-1][i], answer);
        }
        return answer;
    }
    
    // dp[i+1][j] = Math.max(dp[i][j-1], dp[i][j]);
    // i depth에서 i+1 depth
    // 1.0 <- 0,0
    // 1,1 <-0,0
    // 2,0 <- 1,0
    // 2,1 <- 1,0, 1,1
    // 2,2 <- 1,1
    // 3,0 <- 2,0
    // 3,1 <- 2,0, 2,1
    // 3,2 <- 2,1, 2,2
    // 3,3 <- 2,2
    // dp[i][j] = dp[i-1][j-1]
    // 7
    // 3 8
    // 8 1 0
    // 2 7 4 4
    // 4 5 2 6 5
}