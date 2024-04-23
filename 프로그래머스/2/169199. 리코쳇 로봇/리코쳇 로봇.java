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
    int dy[] = {-1, 0, 1, 0};
    int dx[] = {0, 1, 0, -1};
    int[][] mp;
    int[][] visited;
    void bfs(int y, int x, int goalY, int goalX){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x));
        visited[y][x] = 1;
        while (!queue.isEmpty()){
            Node here = queue.poll();
            y = here.y;
            x = here.x;
            if (y==goalY && x==goalX) break;
            for (int i=0;i<4;i++){
                int nextY = y;
                int nextX = x;
                while (true){
                    nextY += dy[i];
                    nextX += dx[i];
                    if (nextY<0||nextX<0||nextY>=mp.length||nextX>=mp[0].length||mp[nextY][nextX]==1){
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
        mp = new int[board.length][board[0].length()];
        visited = new int[board.length][board[0].length()];
        // 1. 입력받기
        int startX = 0;
        int startY = 0;
        int goalY = 0;
        int goalX = 0;
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length();j++){
                if (board[i].charAt(j) == 'D'){
                    mp[i][j] = 1;
                }
                if (board[i].charAt(j) == 'G'){
                    goalY = i;
                    goalX = j;
                }
                if (board[i].charAt(j) == 'R'){
                    startY = i;
                    startX = j;
                }
            }
        }
        //2. bfs 수행
        bfs(startY, startX, goalY, goalX);
        return visited[goalY][goalX]==0 ? -1 : visited[goalY][goalX]-1;
    }
}