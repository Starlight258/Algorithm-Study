import java.util.*;
class Solution {
    int[] visited;
    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    void bfs(int n){
        Queue<Integer> q = new LinkedList<Integer>();
        visited = new int[n+1];
        q.offer(1);
        visited[1] = 1;
        while (!q.isEmpty()){
            int now = q.poll();
            for (int i=0;i<list.get(now).size();i++){
                int next = list.get(now).get(i);
                if (visited[next] == 0){
                    visited[next] = visited[now] + 1;
                    q.offer(next);
                }
            }
            
        }
    }
        
    public int solution(int n, int[][] edge) {
        for (int i=0;i<=n;i++){
            list.add(new ArrayList<Integer>());
        }
        for (int i=0;i<edge.length;i++){
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        bfs(n);
        int maxDist = 0;
        int cnt = 0;
        for (int i=1;i<=n;i++){
            if (maxDist < visited[i]){
                maxDist = visited[i];
                cnt = 1;
            } 
            else if (maxDist == visited[i]){
                cnt++;
            }
        }
        
        return cnt;
    }
}