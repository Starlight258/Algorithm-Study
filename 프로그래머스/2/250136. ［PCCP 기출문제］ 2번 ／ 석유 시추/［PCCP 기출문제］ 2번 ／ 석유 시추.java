import java.util.*;

class Solution {

    int n, m;
    int[] dy = {-1,0,1,0};
    int[] dx = {0,1,0,-1};
    boolean[][] visited;
    int[] amounts;

    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        amounts = new int[m];
        
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (land[i][j]>0 && !visited[i][j]){
                    bfs(i, j, land);
                }
            }
        }
        int maxIdx = 0;
        for (int i=0;i<m;i++){
            if (amounts[maxIdx] < amounts[i]){
                maxIdx = i;
            }
        }
        return amounts[maxIdx];
    }
    
    private void bfs(int y, int x, int[][] land){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;
        int maxX = 0, minX = m, count=0;
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            y = cur[0];
            x = cur[1];
            count++;
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            for (int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny<0||nx<0||ny>=n||nx>=m || visited[ny][nx] || land[ny][nx]==0){
                    continue;
                }
                visited[ny][nx] = true;
                queue.add(new int[]{ny, nx});
            }
        }
        for (int j=minX;j<=maxX;j++){
            amounts[j] += count;
        }
    }
}