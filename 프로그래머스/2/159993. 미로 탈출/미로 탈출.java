import java.util.*;
class Solution {
    class Pair{
        int y;
        int x;
        Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    int[][] visited = new int[104][104];
    int[] dy = {-1,0,1,0};
    int[] dx = {0,1,0,-1};
    
    void bfs(int[] start, String[] maps){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start[0], start[1]));
        visited[start[0]][start[1]] = 1;
        
        while (!queue.isEmpty()){
            Pair current = queue.poll();
            int y = current.y;
            int x = current.x;
            for (int i=0;i<4;i++){
                int ny = y+dy[i];
                int nx = x+dx[i];
                if (ny<0||nx<0||ny>=maps.length||nx>=maps[0].length()) continue;
                if (visited[ny][nx]>0 || maps[ny].charAt(nx)=='X') continue;
                visited[ny][nx] = visited[y][x]+1;
                queue.offer(new Pair(ny, nx));
            }
        }
    }
    public int solution(String[] maps) {
        int answer = 0;
        int[] start = new int[2];
        int[] end = new int[2];
        int[] lever = new int[2];
        
        for (int i=0;i<maps.length;i++){
            for (int j=0;j<maps[i].length();j++){
                if (maps[i].charAt(j) == 'S'){
                    start[0] = i; 
                    start[1] = j;
                }
                if (maps[i].charAt(j) == 'E'){
                    end[0] = i;
                    end[1] = j;
                }
                if (maps[i].charAt(j) == 'L'){
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }
        
        bfs(start, maps);
        
        answer = visited[lever[0]][lever[1]]-1;
        if (answer == -1){
            return -1;
        }
        
        for (int i=0;i<maps.length;i++){
            Arrays.fill(visited[i], 0);
        }
        
        bfs(lever, maps);
        
        if (visited[end[0]][end[1]] == 0){
            return -1;
        }
        answer += visited[end[0]][end[1]] -1;
        
        return answer;
    }
}