import java.util.*;

class Solution {
    
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};
    
    private static Map<Character, Integer> mp = Map.of('U', 0, 'D', 2, 'L', 3, 'R', 1);
    
    public int solution(String dirs) {
        int answer = 0;
        int n = 11;
        int y = 5;
        int x = 5;
        
        boolean[][][] visited = new boolean[n][n][4];
        
        for (char d:dirs.toCharArray()){
            int dir = mp.get(d);
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (ny<0||nx<0||ny>=n||nx>=n) continue;
            int prevY = y;
            int prevX = x;
            y = ny;
            x = nx;
            int odir = oppositeDir(dir);
            if (visited[ny][nx][odir] || visited[prevY][prevX][dir]) continue;
            visited[ny][nx][odir] = true;
            visited[prevY][prevX][dir] = true;
            answer++;
        }
        return answer;
    }
    
    private int oppositeDir(int dir){
        return (dir + 2) % 4;
    }
    // 움직임
    // 처음 걸어본 길의 길이 
    // visited[][][][] : 시작 y,x -> 종료 y,x
    // 방문시 시작 y,x -> 종료 y,x, 종료 y,x -> 시작 y,x
}