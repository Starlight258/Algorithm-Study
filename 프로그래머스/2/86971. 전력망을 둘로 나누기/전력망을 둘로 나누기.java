class Solution {
    int dfs(int node, boolean[][] graph, boolean[] visited, int n){
        int cnt = 1;
        visited[node] = true;
        for (int i=1;i<=n;i++){
            if (!visited[i] && graph[node][i]){
                visited[i] = true;
                cnt += dfs(i, graph, visited, n);
            }
        }
        return cnt;
    }
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        // 1. 정점별 연결 정보 저장
        boolean[][] graph = new boolean[n+1][n+1];
        for (int[] wire : wires){
            graph[wire[0]][wire[1]] = true;
            graph[wire[1]][wire[0]] = true;
        }
        
        // 2. 두 노드 선택 후 dfs
        for (int[] wire:wires){
            boolean[] visited = new boolean[n+1];
            int a = wire[0]; 
            int b = wire[1];
            // 간선 제거
            graph[a][b] = graph[b][a] = false;
            // dfs 수행
            int cnt1 = dfs(a, graph, visited, n);
            int cnt2 = n - cnt1;
            answer = Math.min(answer, Math.abs(cnt1- cnt2));
            // 간선 복원
            graph[a][b] = graph[b][a] = true;
        }
        return answer;
    }
}