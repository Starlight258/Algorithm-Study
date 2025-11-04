import java.util.*;

class Solution {
    
    private final static int[] dy = {-1,0,1,0};
    private final static int[] dx = {0,1,0,-1};
    
    private boolean[][] visited;
    private int answer = 0;
    private int n = 0;
    private int m = 0;
    private int minm = 0;
    private int maxm = 0;
    private int[] lines;
    
    public int solution(int[][] land) {        
        n = land.length; // 세로 길이 5
        m = land[0].length; // 가로 길이 8
        lines = new int[501];
        visited = new boolean[501][501];
        minm = m-1;
        maxm = 0;
        
        for (int i=0;i<n;i++){
            int count = 0;
            for (int j=0;j<m;j++){
                if (visited[i][j] || land[i][j]==0) continue;
                if (land[i][j]==1){
                    count = bfs(land, i, j);     
                }
                for (int k=minm;k<=maxm;k++){
                    lines[k] += count;
                }
                minm = m-1;
                maxm = 0;
            }            
        }
        
        for (int i=0;i<m;i++) {
            answer = Math.max(answer, lines[i]);
        }
      
        return answer;
    }
    
    private int bfs(int[][] land, int startY, int startX){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startY, startX});
        visited[startY][startX] = true;
        int count = 1;
        
        while (!q.isEmpty()){
            int[] node = q.poll();
            int y = node[0];
            int x = node[1];
            maxm = Math.max(maxm, x);
            minm = Math.min(minm, x);
            
            for (int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny<0||nx<0||ny>=n||nx>=m){
                    continue;
                }
                if (visited[ny][nx] || land[ny][nx]==0){
                    continue;
                }
                visited[ny][nx] = true;
                count++;
                q.offer(new int[]{ny, nx});
            }
        }
        return count;
    }
    
    private int dfs(int y, int x, int[][] land){
        int count = 1;
        visited[y][x] = true;
        maxm = Math.max(maxm, x);
        minm = Math.min(minm, x);
        
        for (int i=0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny<0||nx<0||ny>=n||nx>=m) continue;
            if (visited[ny][nx] || land[ny][nx] == 0) continue;
            if (land[ny][nx]==1){
                count += dfs(ny, nx, land);
            }
        }
        return count;
    }
    // 세로 길이 n, 가로 길이 m
    // 가장 많은 석유를 뽑을 수 있는 시추관의 위치
    // 500 * 500 * 500 = 250_000
    // 가로 (y, x) -> (0, 0) ~ (0, n-1) : 한칸씩 시추함
    // (0,0) (1,0)~(4,0)
    // 그냥 완전 탐색해서 
}