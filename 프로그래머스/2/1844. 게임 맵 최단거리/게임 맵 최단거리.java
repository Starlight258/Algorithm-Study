import java.util.*;
class Solution {
    int dy[]={-1,0,1,0};
    int dx[]={0,1,0,-1};
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            for (int i=0;i<4;i++){
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny<0||nx<0||ny>=maps.length||nx>=maps[0].length) continue;
                if (visited[ny][nx]==0 && maps[ny][nx]==1){
                    visited[ny][nx] = visited[y][x]+1;
                    q.offer(new int[]{ny, nx});
                }
            }
            answer = visited[maps.length-1][maps[0].length-1];
            answer= answer==0?-1:answer;
        }
        return answer;
    }
}