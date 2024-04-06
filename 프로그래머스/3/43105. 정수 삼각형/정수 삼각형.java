class Solution {
    public int solution(int[][] dp) {
        int answer = 0;
        for (int y=1;y<dp.length;y++){
            dp[y][0] += dp[y-1][0];
            dp[y][y] += dp[y-1][y-1];
            for (int x=1;x<dp[y].length-1;x++){
                dp[y][x] += Math.max(dp[y-1][x-1], dp[y-1][x]);
            }
        }
        for (int i=0;i<dp.length;i++){
            answer = Math.max(answer, dp[dp.length-1][i]);
        }
        return answer;
    }
}