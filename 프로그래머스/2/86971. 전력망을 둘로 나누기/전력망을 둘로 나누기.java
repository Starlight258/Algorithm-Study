import java.util.*;
class Solution {
    int dfs(int node, boolean[] visited, boolean[][] graph, int n){
        visited[node] = true;
        int cnt=1;
        for (int nextNode=1;nextNode<=n;nextNode++){
            if (!visited[nextNode] && graph[node][nextNode]){
                cnt += dfs(nextNode, visited, graph, n);
            }
        }
        return cnt;
    }
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        boolean[][] graph = new boolean[n+1][n+1];
        // 1. 노드 별 연결된 노드 저장하기
        for (int[] wire:wires){
            graph[wire[0]][wire[1]] = true;
            graph[wire[1]][wire[0]] = true;
        }
        // 2. 두 노드 선택 후 dfs
        for (int[] wire:wires){
            int a = wire[0];
            int b = wire[1];
            graph[a][b] = graph[b][a] = false;
            
            boolean[] visited = new boolean[n+1];
            int cnt1 = dfs(a, visited, graph, n);
            int cnt2 = n - cnt1;
            
            answer = Math.min(answer, Math.abs(cnt1-cnt2));
            
            graph[a][b] = graph[b][a] = true;
        }

        return answer;
    }
}