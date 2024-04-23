import java.util.*;
class Solution {
    class Node {
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    int n, m, sx, sy, gx, gy;
    char[][] mp;
    int[][] visited;
    int dy[] = {-1, 0, 1, 0};
    int dx[] = {0, 1, 0, -1};
    void bfs(int y, int x, int goalY, int goalX){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x));
        visited[y][x] = 1;
        while (!queue.isEmpty()){
            Node here = queue.poll();
            y = here.y;
            x = here.x;
            if (y==gy && x==gx) break;
            for (int i=0;i<4;i++){
                int nextY = y;
                int nextX = x;
                for (int j=0;j<Math.max(n, m);j++){
                    nextY += dy[i];
                    nextX += dx[i];
                    if (nextY<0||nextX<0||nextY>=mp.length||nextX>=mp[0].length||mp[nextY][nextX]=='D'){
                        nextY -= dy[i];
                        nextX -= dx[i];
                        break;
                    } 
                }
                if (visited[nextY][nextX]==0){
                    queue.offer(new Node(nextY, nextX));
                    visited[nextY][nextX] = visited[y][x]+1;
                }
            }
        }
    }
    public int solution(String[] board) {
        int answer = 0;
        n = board.length;
        m = board[0].length();
        mp = new char[n][m];
        visited = new int[n][m];
        // 1. 입력받기
        for (int i=0;i<board.length;i++){
            mp[i] = board[i].toCharArray();
            for (int j=0;j<board[i].length();j++){
                if (board[i].charAt(j) == 'G'){
                    gy = i;
                    gx = j;
                }
                if (board[i].charAt(j) == 'R'){
                    sy = i;
                    sx = j;
                }
            }
        }
        //2. bfs 수행
        bfs(sy, sx, gy, gx);
        return visited[gy][gx]==0 ? -1 : visited[gy][gx]-1;
    }
}