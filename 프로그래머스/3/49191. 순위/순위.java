class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] winGraph = new boolean[n+1][n+1];
        boolean[][] loseGraph = new boolean[n+1][n+1];
        for (int i=0;i<results.length;i++){
            int a = results[i][0];
            int b = results[i][1];
            winGraph[a][b] = true;
            loseGraph[b][a] = true;
        }
        for (int k=1;k<=n;k++){
            for (int i=1;i<=n;i++){
                for (int j=1;j<=n;j++){
                    if (winGraph[i][k] && winGraph[k][j]){
                        winGraph[i][j] = true;
                        loseGraph[j][i] = true;
                    }
                    if (loseGraph[i][k] && loseGraph[k][j]){
                        loseGraph[i][j] = true;
                        winGraph[j][i] = true;
                    }
                }
            }
        }
        for (int i=1;i<=n;i++){
            int tmpNumber = 0;
            for (int j=1;j<=n;j++){
                if (winGraph[i][j] || loseGraph[i][j]){
                    tmpNumber++;
                }
            }
            if (tmpNumber == n-1) answer++;
            
        }
        
        return answer;
    }
}