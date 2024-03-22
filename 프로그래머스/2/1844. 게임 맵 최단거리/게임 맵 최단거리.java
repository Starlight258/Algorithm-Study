import java.util.*;
class Pair { 
    int y;
    int x;
    
    Pair (int y, int x){
        this.y = y;
        this.x = x;
    }
}
class Solution {
    int dy[] = {-1, 0, 1, 0};
    int dx[] = {0, 1, 0, -1};
    Queue<Pair> stk = new LinkedList<>();
    int[][] visited = new int[104][104];
    
    public int solution(int[][] maps) {
        int n = maps.length; 
        int m = maps[0].length; 
        visited[0][0] = 1;
        stk.offer(new Pair(0, 0));
        
        while (!stk.isEmpty()){
            Pair here = stk.poll();
            int y = here.y;
            int x = here.x;
            if (y==n-1 && x==m-1){
                return visited[n-1][m-1];
            }
            
            for (int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny<0 || ny>=n || nx<0 || nx>=m) continue;
                if (visited[ny][nx] == 0 && maps[ny][nx]==1){
                    stk.offer(new Pair(ny, nx));
                    visited[ny][nx] = visited[y][x] + 1;
                } 
            }
        }
        
        return -1;
    }
}