import java.util.*;
class pNode { 
    int x;
    int y;
    pNode (int y, int x){
        this.y = y;
        this.x = x;
    }
}
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int dy[] = {-1, 0, 1, 0};
        int dx[] = {0, 1, 0, -1};
        Queue<pNode> stk = new LinkedList<>();
        int n = maps.length; //y
        int m = maps[0].length; //x
        int[][] visited = new int[n][m];
        visited[0][0] = 1;
        stk.offer(new pNode(0, 0));
        while (!stk.isEmpty()){
            int x = stk.peek().x;
            int y = stk.peek().y;
            stk.poll();
            answer++;
            for (int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny<0 || ny>=n || nx<0 || nx>=m) continue;
                if (visited[ny][nx] == 0 && maps[ny][nx]==1){
                    stk.offer(new pNode(ny, nx));
                    visited[ny][nx] = visited[y][x] + 1;
                } 
            }
        }
        return visited[n-1][m-1]==0 ? -1 : visited[n-1][m-1];
    }
}