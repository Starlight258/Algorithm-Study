import java.util.*;

class Solution {
    
    final int dy[] = {-1,0,1,0};
    final int dx[] = {0,1,0,-1};
    
    public int[] solution(String[][] places) {
        List<Integer> answer = new ArrayList<>();
        for (String[] place:places){
            answer.add(isValid(place) ? 1:0);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    private boolean isValid(String[] place){
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                if (place[i].charAt(j)=='P'){
                    if (bfs(place, i, j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean bfs(String[] place, int y, int x){
        Queue<int[]> q = new LinkedList<>();
        int n = place.length;
        int m = place[0].length();
        int[][] visited = new int[n][m];
        q.offer(new int[]{y, x, 0});
        visited[y][x] = 1;
        while (!q.isEmpty()){
            int[] cur = q.poll();
            y = cur[0];
            x = cur[1];
            int distance = cur[2];
            if (distance>2) continue;
            
            for (int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                int ndistance = distance+1;
                if (ny<0||nx<0||ny>=n||nx>=m || visited[ny][nx]>0) continue;
                if (place[ny].charAt(nx) == 'P'){
                    if (distance<2){
                        return true;
                    } 
                     continue;
                }
                if (place[ny].charAt(nx)=='X') continue;    
                q.offer(new int[]{ny, nx, ndistance});
                visited[ny][nx] = 1;
            }
        }
        return false;
    }
}