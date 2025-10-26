class Solution {
    private boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i=0;i<n;i++){
            if (!visited[i]){
                dfs(i, computers, n);
                answer++;
            }
        }
        return answer;
    }
    
    void dfs(int node, int[][] computers, int n){
        for (int i=0;i<n;i++){
            int computer =  computers[node][i];
            if (computer==0 || visited[i]){
                continue;
            } 
            visited[i] = true;
            dfs(i, computers, n);
        }
    }
    // dfs로 풀기
}