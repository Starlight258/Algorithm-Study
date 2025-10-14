import java.util.*;

class Solution {
    
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};
    
    private boolean[][][] visited;
    private final Map<Character, Integer> map = Map.of('U', 2, 'D', 0, 'L',3,'R',1);
    
    public int solution(String dirs) {
        int answer = 0;
        int y = 5;
        int x = 5;
        visited = new boolean[11][11][4];
        for (char dir:dirs.toCharArray()){
            int ny = y, nx = x;
            int d = map.get(dir);
            ny += dy[d];
            nx += dx[d];
            
            if (ny<0||nx<0||ny>10||nx>10){
                continue;
            } 
            if (!(visited[y][x][d] || visited[ny][nx][nextDir(d)])){
                answer++;
            }
            visited[y][x][d] = true;
            y = ny;
            x = nx;
        }
        
        return answer;
    }
    
    private int nextDir(int dir){
        return (dir + 2) % 4;
    }
    // 방문배열 : visited[y][x][방향]
    // 방향: 0(위), 1(오른), 2(아래), 3(왼)
    // 상하좌우 이동, 넘어갈 경우 stop
}