import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] winGraph = new boolean[n+1][n+1];
        boolean[][] loseGraph = new boolean[n+1][n+1];
        for (int i=0;i<=n;i++){
            Arrays.fill(winGraph[i], false);
            Arrays.fill(loseGraph[i], false);
        }

        for (int i=0;i<results.length;i++){
            winGraph[results[i][0]][results[i][1]] = true;
            loseGraph[results[i][1]][results[i][0]] = true;
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
                if (winGraph[i][j]) tmpNumber++;
                else if (loseGraph[i][j]) tmpNumber++;
            }
            if (tmpNumber==n-1) answer++;
        }
        return answer;
    }
}