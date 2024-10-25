import java.util.*;

class Solution {
    List<List<Integer>> list;
    int min;
    
    public int solution(int n, int[][] wires) {
        list = new ArrayList<>(n+1);
        min = Integer.MAX_VALUE;
        for (int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for (int[] wire:wires){
            list.get(wire[0]).add(wire[1]);
            list.get(wire[1]).add(wire[0]);
        }
        // 완전탐색
        for (int[] wire:wires){
            int v1 = wire[0];
            int v2 = wire[1];
            
            list.get(v1).remove(Integer.valueOf(v2));
            list.get(v2).remove(Integer.valueOf(v1));
            boolean[] visited = new boolean[n+1];
            int cnt = dfs(visited, 1);
            min = Math.min(Math.abs((n-cnt)-cnt), min);
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }
        
        return min;
    }
    int dfs(boolean[] visited, int v){
        visited[v] = true;
       int cnt = 1;
        
        for (int next:list.get(v)){
            if (!visited[next]){
                cnt += dfs(visited, next);
            }
        }
        return cnt;
    }
}