import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int[] wire:wires){
            mp.computeIfAbsent(wire[0], k -> new ArrayList<>()).add(wire[1]);
            mp.computeIfAbsent(wire[1], k -> new ArrayList<>()).add(wire[0]);
        }
        // 하나의 간선 골라서 간선 탐색하기 
        // k개, n-k 개
        for (int[] wire:wires){
            int a = wire[0];
            int b = wire[1];
            boolean[] visited = new boolean[n+1];
            // a 기준으로 순회
            visited[b] = true;
            int count = dfs(a, mp, n, visited);
            int diff = Math.abs(count - (n-count));
            answer = Math.min(diff, answer);
        }
        
        return answer;
    }
    
    int dfs(int cur, Map<Integer, List<Integer>> mp, int n, boolean[] visited){
        visited[cur] = true;
        int count = 1;
        
        for (Integer next:mp.get(cur)){
            if (visited[next]){
                continue;
            }    
            count += dfs(next, mp, n, visited);    
        }
        return count;
    }
}