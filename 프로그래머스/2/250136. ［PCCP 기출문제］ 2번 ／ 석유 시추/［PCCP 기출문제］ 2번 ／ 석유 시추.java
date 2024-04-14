import java.util.*;
class Solution {
    class Node{
        int x;
        int y;
        Node(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
    int dy[] = {-1,0,1,0};
    int dx[] = {0,1,0,-1};
    int[] oilPosition = new int[504];
    void bfs(int y, int x, int n, int m, int[][] land, boolean[][] visited){
        int start = x;
        int end = x;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(y, x));
        visited[y][x] = true;
        int oilAmount = 0;
        while (!q.isEmpty()){
            Node node = q.poll();
            y = node.y;
            x = node.x;
            oilAmount += land[y][x];
            start = Math.min(start, x);
            end = Math.max(end, x);
            for (int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny<0||nx<0||ny>=n||nx>=m) continue;
                if (!visited[ny][nx] && land[ny][nx]==1){
                    visited[ny][nx] = true;
                    q.offer(new Node(ny, nx));
                }
            }
        }
        for (int k=start;k<=end;k++){
            oilPosition[k] += oilAmount;     
        }
        
    }

    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        boolean[][] visited = new boolean[n+1][m+1];
        int oilAmount = 0;
        Arrays.fill(oilPosition, 0);
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (land[i][j]==1 && !visited[i][j]){
                    bfs(i, j, n, m, land, visited);
                }
            }
        }
        int maxPosition = 0;
        int maxOil = 0;
        for (int i=0;i<m;i++){
            maxOil = Math.max(maxOil, oilPosition[i]);
        }
        
        return maxOil;
    }
}