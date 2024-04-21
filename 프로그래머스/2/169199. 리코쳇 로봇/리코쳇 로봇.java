import java.util.*;

class Solution {
    static int n, m, sx, sy, ex, ey;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static int bfs(){
        Queue<int[]> q = new LinkedList<int[]>();
        visit[sx][sy] = true;
        q.add(new int[]{sx, sy, 0});

        while(!q.isEmpty()){
            int[] point = q.poll();

            int x = point[0];
            int y = point[1];
            int dist = point[2];

            if(x==ex && y==ey) return dist;

            for(int i=0;i<4;i++){
                int nextX = x;
                int nextY = y;

                for(int k=1;k<=Math.max(n, m);k++){
                    nextX+=dx[i];
                    nextY+=dy[i];

                    if(nextX<0 || nextX>=n || nextY<0 || nextY>=m || map[nextX][nextY] =='D') {
                        nextX-=dx[i];
                        nextY-=dy[i];
                        break;
                    }
                }

                if(visit[nextX][nextY]) continue;

                visit[nextX][nextY] = true;
                q.add(new int[]{nextX, nextY, dist+1});
            }
        }

        return -1;
    }

    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();

        map = new char[n][m];
        visit = new boolean[n][m];

        for(int i=0;i<n;i++) {
            map[i] = board[i].toCharArray();
            for(int j=0;j<m;j++) {
                if(map[i][j] == 'R'){
                    sx = i;
                    sy = j;
                }
                else if(map[i][j] == 'G'){
                    ex = i;
                    ey = j;
                }
            }    
        }

        return bfs();
    }
}