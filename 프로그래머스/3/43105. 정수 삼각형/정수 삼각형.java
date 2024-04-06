import java.util.*;
class Solution {
    public int solution(int[][] dp) {
        int answer = 0;
        for (int y=dp.length-2;y>=0;y--){
            for (int x=0;x<dp[y].length;x++){
                dp[y][x] += Math.max(dp[y+1][x], dp[y+1][x+1]);
            }
        }
        return dp[0][0];
    }
}