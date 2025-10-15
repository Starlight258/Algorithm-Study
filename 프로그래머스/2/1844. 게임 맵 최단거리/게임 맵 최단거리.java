import java.util.*;

class Solution {
    
    private static int[] dy = {-1,0,1,0};
    private static int[] dx = {0,1,0,-1};
    
    public int solution(int[][] maps) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        int maxY = maps.length;
        int maxX = maps[0].length;
        int[][] visited = new int[maxY][maxX];
        visited[0][0] = 1;
        if (maps[0][0] == 0){
            return -1;
        }
        
        while (!q.isEmpty()){
            int[] node = q.poll();
            int y = node[0];
            int x = node[1];
            if (y==maxY-1 && x==maxX-1){
                break;
            }
            
            for (int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny<0||nx<0||ny>=maxY||nx>=maxX){
                    continue;
                }
                if (visited[ny][nx] > 0 || maps[ny][nx] == 0){
                    continue;
                }
                visited[ny][nx] = visited[y][x]+1;
                q.offer(new int[]{ny, nx});
            }
        }
        
        return visited[maxY-1][maxX-1] == 0 ? -1 : visited[maxY-1][maxX-1];
    }
}