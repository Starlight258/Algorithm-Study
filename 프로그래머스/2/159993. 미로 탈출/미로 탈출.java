import java.util.*;

class Solution {
    
    private static int[] dy = {-1,0,1,0};
    private static int[] dx = {0,1,0,-1};
    
    private int[][] visited;
    private int n;
    private int m;
    
    class Node {
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length();
        char[][] mp = new char[n][m];
        visited = new int[n][m];
        for (int i=0;i<n;i++){
            mp[i] = maps[i].toCharArray();
        }
        // 시작점 구하기
        int levY = 0;
        int levX = 0;
        int destY = 0;
        int destX = 0;
        boolean canMove = false;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (mp[i][j]=='L'){
                    levY = i;
                    levX = j;
                }
                if (mp[i][j]=='E'){
                    destY = i;
                    destX = j;
                }
                if (mp[i][j]=='S'){
                    visited[i][j] = 1;
                    canMove = bfs(i, j, mp, 'L');
                    if (!canMove){
                        return -1;   
                    }
                }
            }
        }
        answer += visited[levY][levX]-1;
        visited = new int[n][m];

        // bfs 수행
        canMove = bfs(levY, levX, mp, 'E');
        if (!canMove){
            return -1;
        }
        answer += visited[destY][destX];
        return answer;
    }
    
    private boolean bfs(int y, int x, char[][] mp, char goal){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(y, x));
        
        while (!q.isEmpty()){
            Node cur = q.poll();
            y = cur.y;
            x = cur.x;
            if (mp[y][x] == goal){
                return true;
            }

            for (int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny<0||nx<0||ny>=n||nx>=m || visited[ny][nx]>0) continue;
                if (mp[ny][nx] != 'X'){
                    visited[ny][nx] = visited[y][x]+1;
                    q.offer(new Node(ny, nx));
                }
            }
        }
        return false;
    }
    
    // 레버
    // 출발(S) -> 레버(L) -> 출구(E) 
    // 미로를 탈출하는데 필요한 최소 시간 (탈출할 수 없다면 -1)
}