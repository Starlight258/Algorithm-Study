import java.util.*;

class Solution {
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int n=0, m=0;
    
    private static int bfs(String[] maps, int[] start, int[] end){
        int y = start[0], x = start[1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y ,x});
        int[][] visited = new int[n][m];
        visited[y][x] = 1;
        
        while (!q.isEmpty()){
            int[] cur = q.poll();
            y = cur[0]; x = cur[1];
            if (y == end[0] && x == end[1]){
                return visited[y][x];
            }
            for (int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny<0||nx<0||ny>=n||nx>=m) continue;
                if (maps[ny].charAt(nx) == 'X' || visited[ny][nx]>0) continue;
                q.add(new int[]{ny, nx});
                visited[ny][nx] = visited[y][x]+1;
            }
        }
        return -1;
    }
    public int solution(String[] maps) {
        int answer = 0;
        int[] start = {}, end = {}, lev = {};
        n = maps.length; m = maps[0].length();
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (maps[i].charAt(j) == 'S'){
                    start = new int[]{i, j};
                } else if (maps[i].charAt(j) == 'E'){
                    end = new int[]{i, j};
                } else if (maps[i].charAt(j) == 'L'){
                    lev = new int[]{i, j};
                }
            }
        }
        int a1 = bfs(maps, start, lev);
        int a2 = bfs(maps, lev, end);
        if (a1 == -1 || a2 == -1) return -1;
        return a1 + a2 - 2;
    }
}