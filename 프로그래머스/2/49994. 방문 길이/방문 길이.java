class Solution {
    final int[] dy = {-1,0,1,0};
    final int[] dx = {0,1,0,-1};
    public int solution(String dirs) {
        int answer = 0;
        int y = 5, x = 5;
        boolean[][][] visited = new boolean[11][11][4];
        for (char dir:dirs.toCharArray()){
            if (dir == 'U'){
                int ny = y+1;
                if (ny<0||ny>10) continue;
                y = ny;
                if (visited[y][x][0] || visited[y-1][x][1]) continue;
                visited[y][x][0] = true;
                visited[y-1][x][1] = true;
                answer++;
            } 
            if (dir=='D'){
                int ny = y-1;
                if (ny<0||ny>10) continue;
                y = ny;
                if (visited[y][x][1] || visited[y+1][x][0]) continue;
                 visited[y][x][1] = true;
                visited[y+1][x][0] = true;
                answer++;
            }
            if (dir=='L'){
                int nx = x-1;
                if (nx<0||nx>10) continue;
                x = nx;
                if (visited[y][x][2] || visited[y][x+1][3]) continue;
                visited[y][x][2] = true;
                visited[y][x+1][3] = true;
                answer++;
            }
            if (dir=='R'){
                int nx = x+1;
                if (nx<0||nx>10) continue;
                x = nx;
                if (visited[y][x][3] || visited[y][x-1][2]) continue;
                visited[y][x][3] = true;
                 visited[y][x-1][2] = true;
                answer++;
            }
        }
        
        return answer;
    }
}