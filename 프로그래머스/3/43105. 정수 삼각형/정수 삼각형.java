import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;

        for (int i=1;i<n;i++){
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for (int j=1;j<i;j++){
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
        }
        
        for (int i=0;i<n;i++){
            answer = Math.max(triangle[n-1][i], answer);
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