class Solution {
    
    private boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        n = computers.length;
        visited = new boolean[n];
        for (int i=0;i<n;i++){
            if (visited[i]){
                continue;
            }
            visited[i] = true;
            dfs(i, computers, n);
            answer++;
        }
        
        return answer;
    }
    
    void dfs(int node, int[][] computers, int n){
        for (int i=0;i<computers[node].length;i++){
            if (visited[i] || computers[node][i]==0) continue;
            visited[i] = true;
            dfs(i, computers, n);
        }
    }
    // 네트워크 
    // dfs 
    // connection 개수
}