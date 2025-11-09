import java.util.*;

class Solution {
    
    private static int[] dy = {-1,0,1,0};
    private static int[] dx = {0,1,0,-1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        int[][] visited = new int[n][m];
        
        while (!q.isEmpty()){
            int[] node = q.poll();
            int y = node[0];
            int x = node[1];
            for (int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny<0||nx<0||ny>=n||nx>=m) continue;
                if (visited[ny][nx]>0) continue;
                if (maps[ny][nx]==0) continue;
                q.offer(new int[]{ny, nx});
                visited[ny][nx] = visited[y][x]+1;
            }
        }
        
        if (visited[n-1][m-1]==0){
            return -1;
        }
        
        return visited[n-1][m-1]+1;
    }
    // 최단경로 : bfs
}