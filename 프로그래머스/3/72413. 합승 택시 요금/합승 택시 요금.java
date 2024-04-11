import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int INF = 987654321;
        int[][] graph = new int[n+1][n+1];
        for (int i=1;i<=n;i++){
            Arrays.fill(graph[i], INF);
        }
        for (int i=1;i<=n;i++){
            graph[i][i] = 0;
        }
        for (int i=0;i<fares.length;i++){
            graph[fares[i][0]][fares[i][1]] = fares[i][2];
            graph[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        
        for (int k=1;k<=n;k++){
            for (int i=1;i<=n;i++){
                for (int j=1;j<=n;j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                }
            }
        }
        answer = graph[s][a] + graph[s][b];
        for (int i=1;i<=n;i++){
            if (i==s) continue;
            if (graph[s][i] == INF || graph[i][a] == INF || graph[i][b]==INF) continue;
            answer = Math.min(answer, graph[s][i] + graph[i][a] + graph[i][b]);
        }
        return answer;
    }
}