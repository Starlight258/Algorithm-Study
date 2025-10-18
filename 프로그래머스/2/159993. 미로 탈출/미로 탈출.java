import java.util.*;

class Solution {
    
    private static int[] dy = {-1,0,1,0};
    private static int[] dx = {0,1,0,-1};
    private static int n=0;
    private static int m=0;
    private static String[] map;
    
    private int[][] visited;
    
    public int solution(String[] map) {
        int answer = 0;
        n = map.length;
        m = map[0].length();
        this.map = map;
        visited = new int[n][m];
        int startY =0, startX=0;
        int leverY =0, leverX=0;
        
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (map[i].charAt(j) =='S'){
                    startY = i;
                    startX = j;
                }
                if (map[i].charAt(j) =='L'){
                    leverY = i;
                    leverX = j;
                }
            }
        }
        
        int f = bfs(startY, startX, 'L');
        if (f==0){
            return -1;
        }
        int l = bfs(leverY, leverX, 'E');
        if (l==0){
            return -1;
        }
        
        return f + l;
    }
    
    private int bfs(int startY, int startX, char target){
        visited = new int[n][m];
        visited[startY][startX] = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startY, startX});
        
        while (!q.isEmpty()){
            int[] node = q.poll();
            int y = node[0];
            int x = node[1];
            if (map[y].charAt(x) == target){
                return visited[y][x]-1;
            }
            for (int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny<0||nx<0||ny>=n||nx>=m) continue;
                if (visited[ny][nx]>0 || map[ny].charAt(nx) == 'X'){
                    continue;
                }
                q.offer(new int[]{ny, nx});
                visited[ny][nx] = visited[y][x]+1;
            }    
        }
        return 0;
    }
}