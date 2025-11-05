import java.util.*;

class Solution {
    
    private final int[] dy = {-1,0,1,0};
    private final int[] dx = {0,1,0,-1};
    private  int n;
    private  int m;
    private  boolean[][] visited;
    private  char[][] mp;
    
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];
        mp = new char[n][m];
        
        for (int i=0;i<n;i++){
            mp[i] = maps[i].toCharArray();
        }
        
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (mp[i][j] == 'X' || visited[i][j]){
                    continue;
                }
                visited[i][j] = true;
                int result = dfs(i, j, mp);
                if (result==0){
                    result = -1;
                }
                answer.add(result);
            }
        }
        
        Collections.sort(answer);
        
        if (answer.isEmpty()){
            answer.add(-1);
        }
   
        return answer.stream().mapToInt(x->x).toArray();
    }
    
    private int dfs(int y, int x, char[][] maps){
        int count = maps[y][x] - '0';
        for (int i=0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny<0||nx<0||ny>=n||nx>=m) continue;
            if (visited[ny][nx]){
                continue;
            }
            if (maps[ny][nx] == 'X'){
                continue;
            }
            visited[ny][nx] = true;
            count += dfs(ny, nx, maps);
        }
        return count;
    }
    // bfs -> 저장
    // 정렬
}