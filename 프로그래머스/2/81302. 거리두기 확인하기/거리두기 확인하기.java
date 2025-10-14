import java.util.*;

class Solution {
    
    private static int[] dy = {-1,0,1,0};
    private static int[] dx = {0,1,0,-1};
    
    private static int[] diay = {1, -1, 1, -1};
    private static int[] diax = {1, -1, -1, 1};
    
    private char[][] p;
    
    public int[] solution(String[][] places) {
        int n = places.length;
        int[] answer = new int[n];
        
        for (int cur=0;cur<n;cur++){
            String[] place = places[cur];
            p = new char[5][5];
            for (int i=0;i<5;i++){
                for (int j=0;j<5;j++){
                    p[i][j] = place[i].charAt(j);
                }
            }
                    
            // 확인하기
            // 거리 +1
            boolean hasNear = false;
            for (int i=0;i<5;i++){
                for (int j=0;j<5;j++){
                    if (p[i][j]=='P'){
                        if (findNear(i, j) || findNextNear(i,j) || findNextNear(i,j ) || findDiagonal(i, j)){
                            hasNear = true;
                            break;
                        };
                        
                    }
                }
                if (hasNear){
                    answer[cur] = 0;
                    break;
                }
            }
            if (!hasNear){
                answer[cur] = 1;
            }
        }
        return answer;
    }
    
    private boolean findNear(int y, int x){
        for (int i=0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny<0||nx<0||ny>=5||nx>=5) continue;
            if (p[ny][nx] == 'P'){
                return true;
            }
        }
        return false;
    }
    
     
    private boolean findNextNear(int y, int x){
        for (int i=0;i<4;i++){
            int ny = y + dy[i] * 2;
            int nx = x + dx[i] * 2;
            int my = y + dy[i];
            int mx = x + dx[i];
            if (ny<0||nx<0||ny>=5||nx>=5) continue;
            if (p[ny][nx] == 'P' && p[my][mx]=='O'){
                return true;
            }
        }
        return false;
    }
    
    private boolean findDiagonal(int y, int x){
        for (int i=0;i<4;i++){
            int ny = y + diay[i];
            int nx = x + diax[i];
            int my = y + diay[i];
            int mx = x;
            int oy = y;
            int ox = x + diax[i];
            if (ny<0||nx<0||ny>=5||nx>=5) continue;
            if (p[ny][nx] == 'P' && (p[oy][ox]=='O' || p[my][mx]=='O')){
                return true;
            }
        }
        return false;
    }
    
    // 거리두기 1
    // (r,c) -> (r+1, c), (r-1,c), (r, c+1), (r, c-1)
    // PXP
    // 파티션을 사이에 두고 앉은 경우 -> 거리 두기
    // P X
    // X P 
    // (r,c) - (r+1, c+1), (r-1, c-1), (r-1, c+1), (r+1, c-1) 
    
}