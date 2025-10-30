class Solution {
    public int solution(int[][] info, int n, int m) {
        int total = info.length;
        int[][] dp = new int[total][m];
        int INF = 120;
        int answer = INF;
        for (int i=0;i<total;i++){
            for (int j=0;j<m;j++){
                dp[i][j] = INF;
            }
        }
        dp[0][0] = info[0][0];
        // 처음에 b가 가질 수 있다면 a는 0
        if (info[0][1] < m){
            dp[0][info[0][1]] = 0;
        }
        
        if (total==1){
            if (info[0][1]<m){
                return 0;
            }
            return info[0][0];
        }
        
        for (int i=1;i<total;i++){
            for (int j=0;j<m;j++){
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+info[i][0]);
                if (j+info[i][1] < m){
                    dp[i][j+info[i][1]] = Math.min(dp[i][j+info[i][1]], dp[i-1][j]);
                }
            }
            
        }
        
        for (int j=0;j<m;j++){
            answer = Math.min(answer, dp[total-1][j]);
        }
        
        if (answer<n){
            return answer;
        }
        
        return -1;
    }
    
    // a도둑, b도둑
    
    // dp[i][j] : i 물건까지 고려했을 때 b의 흔적이 j라면, a가 가지는 최소 흔적
    // A가 가짐 : dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + info[i][0]);
    // B가 가짐 : dp[i][j+info[i][1]] =  Math.min(dp[i][j+info[i][1]], dp[i-1][j]);
    
}