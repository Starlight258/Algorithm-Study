class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int dp[][] = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for (int y=1;y<triangle.length;y++){
            for (int x=0;x<triangle[y].length;x++){
                if (x==0) dp[y][x] = dp[y-1][x] + triangle[y][x];
                else if (x==y) dp[y][x] = dp[y-1][x-1] + triangle[y][x];
                else {
                    dp[y][x] = Math.max(dp[y-1][x-1], dp[y-1][x]) + triangle[y][x];
                }
            }
        }
        for (int i=0;i<triangle.length;i++){
            answer = Math.max(answer, dp[triangle.length-1][i]);
        }
        return answer;
    }
}