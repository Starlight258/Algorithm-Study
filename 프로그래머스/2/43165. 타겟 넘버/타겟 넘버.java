class Solution {
    
    private int n;
    private boolean[] visited;
    private int answer = 0;
    
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        visited = new boolean[n];
        dfs(-1, 0, numbers, target);
        
        return answer;
    }
    
    // 완전탐색
    private void dfs(int index, int sum, int[] numbers, int target){
        if (index == n-1){
            if (sum == target){
                answer++;
            }
            return;
        }
        
        int next = index+1;
        dfs(next, sum + numbers[next], numbers, target);
        dfs(next, sum - numbers[next], numbers, target);
        visited[next] = true;
    }
}