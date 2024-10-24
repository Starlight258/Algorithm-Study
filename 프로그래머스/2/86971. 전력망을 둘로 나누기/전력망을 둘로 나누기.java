import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<List<Integer>> graph;
    static int min;
 
    public int solution(int n, int[][] wires) {
        // 두 번째 코드의 리스트 초기화 방식 사용
        graph = new ArrayList<>(n + 1);
        min = Integer.MAX_VALUE;
 
        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
 
        // 양방향 간선 추가
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
 
        // 각 간선을 끊어보며 최소 차이 계산
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
 
            boolean[] visited = new boolean[n + 1];
 
            // 해당 간선을 그래프에서 제거
            graph.get(v1).remove(Integer.valueOf(v2));
            graph.get(v2).remove(Integer.valueOf(v1));
 
            int cnt = dfs(1, visited); // 임의의 시작점에서 dfs 탐색
 
            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min, diff);
 
            // 그래프에 다시 간선 추가
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
 
        return min;
    }
 
    static int dfs(int v, boolean[] visited) {
        visited[v] = true;
        int cnt = 1;
 
        for (int next : graph.get(v)) {
            if (!visited[next]) {
                cnt += dfs(next, visited);
            }
        }
 
        return cnt;
    }
}