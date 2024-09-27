import java.util.*;

class Solution {
    private static int[] dy = {-1,0,1,0};
    private static int[] dx = {0,1,0,-1};
    
    private static int bfs(String[] board, int[] start, int[] dest){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 1});
        int n = board.length, m = board[0].length();
        int[][] visited = new int[n][m];
        visited[start[0]][start[1]] = 1;
        
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0], x= cur[1];
            for (int i=0;i<4;i++){
                int ny = y, nx = x;
                while (true){
                    ny += dy[i];
                    nx += dx[i];
                    if (ny<0||nx<0||ny>=n|nx>=m || board[ny].charAt(nx) == 'D'){
                        ny -= dy[i];
                        nx -= dx[i];
                        break;
                    } 
                }
                if (ny==dest[0] && nx == dest[1]){
                    return cur[2];
                }
                if (visited[ny][nx]>0) continue;
                visited[ny][nx] = 1;
                q.add(new int[]{ny, nx, cur[2]+1});
            } 
        }
        return -1;
    }
    public int solution(String[] board) {
        int answer = 0;
        int[] start = {}; int[] dest = {};
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length();j++){
                if (board[i].charAt(j) == 'R'){
                    start = new int[]{i, j};
                } else if (board[i].charAt(j) == 'G'){
                    dest = new int[]{i, j};
                }
            }
        }
        return bfs(board, start, dest);
    }
}