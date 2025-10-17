import java.util.*;
class Solution {
    
    private static int[] dy = {-1,0,1,0};
    private static int[] dx = {0,1,0,-1};
    
    private int[][] visited;
    private int n = 0;
    private int m = 0;
    private String[] mapData;  // 이름 변경
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        visited = new int[n][m];
        this.mapData = maps;  // 올바른 할당
        
        // S 위치 찾기
        int startY = 0, startX = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mapData[i].charAt(j) == 'S') {
                    startY = i;
                    startX = j;
                }
            }
        }
        
        visited[startY][startX] = 1;
        int[] ret = bfs(startY, startX, 'L');
        int leverDist = ret[2];  // 거리는 인덱스 2
        if (leverDist == -1){
            return -1;
        }
        
        visited = new int[n][m];
        int y = ret[0];
        int x = ret[1];
        visited[y][x] = 1;
        int distance = bfs(y, x, 'E')[2];
        
        if (distance == -1) return -1;
        
        return leverDist + distance;
    }
    
    private int[] bfs(int y, int x, char target){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        
        while (!q.isEmpty()){
            int[] node = q.poll();
            y = node[0];
            x = node[1];
            for (int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny<0||nx<0||ny>=n||nx>=m) continue;
                if (visited[ny][nx]==0 && mapData[ny].charAt(nx)!='X'){
                    if (mapData[ny].charAt(nx) == target){
                        return new int[]{ny, nx, visited[y][x]};  // visited[y][x]가 현재까지 거리
                    }
                    q.offer(new int[]{ny, nx});
                    visited[ny][nx] = visited[y][x]+1;
                }
            }
        }
        return new int[]{-1, -1, -1};        
    }
}