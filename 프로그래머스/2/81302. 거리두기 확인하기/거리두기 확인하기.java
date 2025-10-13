import java.util.*;

class Solution {
    private int[] dy = {-1,0,1,0};
    private int[] dx = {0,1,0,-1};
    private char[][] p;
    
    public int[] solution(String[][] places) {
        int n = places.length;
        int[] answer = new int[n];
        // 배열
        p = new char[5][5];
        
        for (int c=0;c<n;c++){
             for (int i=0;i<5;i++){
                for (int j=0;j<5;j++){
                    p[i][j] = places[c][i].charAt(j);
                }
            }
            
            boolean isZero = false;
            for (int i=0;i<5;i++){
                for (int j=0;j<5;j++){
                    if (p[i][j]=='P'){
                        if (!bfs(i, j)){
                            isZero = true;
                            break;
                        }
                    }
                    if (isZero){
                        break;
                    }
                }
            }
            if (isZero){
                answer[c] = 0;
            } else {
                answer[c] = 1;
            }
        }
       
        
        return answer;
    }
    
    private boolean bfs(int sy, int sx){
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sy,sx});
    
        int[][] visited = new int[5][5];
        visited[sy][sx] = 1;
        
        // bfs
        while (!queue.isEmpty()){
            int[] node = queue.poll();
            int y = node[0];
            int x = node[1];
            if (visited[y][x]>2){
                continue;
            }
            
            for (int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (ny<0||nx<0||ny>=5||nx>=5){
                    continue;
                }
                if (visited[ny][nx]>0 || p[ny][nx]=='X'){
                    continue;
                }
                if (p[ny][nx]=='P'){
                    return false; // 거리두기 안지킴
                }
                visited[ny][nx] = visited[y][x]+1;
                queue.offer(new int[]{ny,nx});
            }
        }
        return true;
    }
    // 모든 좌표 bfs
    // 빈 테이블로만 이동 가능
    // 응시자마다 돌아가면서 순회 -> 거리 2 초과시 종료 -> 찾으면 0
}