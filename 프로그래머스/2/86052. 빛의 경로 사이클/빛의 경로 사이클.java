import java.util.*;

class Solution {
    static int R, C;
    static int[] dr={-1,0,1,0}, dc={0,1,0,-1};
    static boolean[][][] visited;
    
    public int[] solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();
        R = grid.length;
        C = grid[0].length();
        visited = new boolean[R][C][4];
        for (int i=0;i<R;i++){
            for (int j=0;j<C;j++){
                for (int d=0;d<4;d++){
                    if(!visited[i][j][d]){
                        answer.add(light(grid, i, j, d));
                    }
                }
            }
        }
        
        return answer.stream().sorted().mapToInt(i->i).toArray();
    }
    
    private int light(String[] grid, int r, int c, int d){
        int count = 0;
        while (true){
            if (visited[r][c][d]) break;
            count++;
            visited[r][c][d] = true;
            
            if (grid[r].charAt(c) == 'L'){
                d = (d + 3) % 4;
            } else if (grid[r].charAt(c)=='R'){
                d = (d+1)%4;
            }
            
            r = (r+dr[d]+R)%R;
            c = (c+dc[d]+C)%C;
        }
        return count;
    }
}