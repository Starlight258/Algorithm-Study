import java.util.*;
class Solution {
    int dy[] = {-1,0,1,0};
    int dx[] = {0,1,0,-1};
    int cnt = 0;
    int dfs(int y, int x, int m, int n, int[][] picture, boolean[][] visited){
        visited[y][x] = true;
        int cnt = 1; 
        int color = picture[y][x];
        Stack<int[]> stk = new Stack<>();
        stk.push(new int[]{y, x});
        
        while (!stk.isEmpty()){
            int[] cur = stk.pop();
            y = cur[0];
            x = cur[1];
            for (int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny<0 || ny>=m || nx<0 || nx>=n) continue;
                if (!visited[ny][nx] && picture[ny][nx] == color){
                    stk.push(new int[]{ny, nx});
                    visited[ny][nx] = true;
                    cnt++;
                }      
            } 
        }
        return cnt;
    }
    public int[] solution(int m, int n, int[][] picture) {
        int maxCnt = 0;
        int repeatCnt = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (!visited[i][j] && picture[i][j]!=0){
                    maxCnt = Math.max(maxCnt, dfs(i, j, m, n, picture, visited));
                    repeatCnt++;
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = repeatCnt;
        answer[1] = maxCnt;
        
        return answer;
    }
}