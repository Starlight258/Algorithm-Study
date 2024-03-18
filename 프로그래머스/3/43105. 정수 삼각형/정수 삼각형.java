import java.util.Arrays;
class Solution {  
    
    public int solution(int[][] tri) {
        int answer = 0;
        int length = tri.length;
        int[][] dp = new int[length][length];
        dp[0][0] = tri[0][0];
        for (int i=1;i<length;i++){ //0-4
            for (int j=0;j<=i;j++){
                if (j==0) dp[i][j] = dp[i-1][j] + tri[i][j];
                else if (i==j){
                    dp[i][j] = dp[i-1][j-1] + tri[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + tri[i][j];
                }
            }
        }
        for (int i=0;i<length;i++){
            answer = Math.max(answer, dp[length-1][i]);
        }
        return answer;
    }
}