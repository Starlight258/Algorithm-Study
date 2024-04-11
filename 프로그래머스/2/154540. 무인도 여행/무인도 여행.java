import java.util.*;
class Solution {
    boolean visited[][];
    int dy[] = {-1,0,1,0};
    int dx[] = {0,1,0,-1};
    int dfs(int y, int x, String[] maps){
        visited[y][x] = true;
        int sum = Integer.parseInt(maps[y].charAt(x)+"");
        for (int i=0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny<0||nx<0||ny>=maps.length||nx>=maps[0].length()) continue;
            if (!visited[ny][nx] && maps[ny].charAt(nx) != 'X'){
                sum += dfs(ny, nx, maps);
            }
        }
        return sum;
    }
    public int[] solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();
        visited = new boolean[maps.length][maps[0].length()];
        for (int i=0;i<maps.length;i++){
            for (int j=0;j<maps[i].length();j++){
                if (!visited[i][j] && maps[i].charAt(j) != 'X'){
                    answer.add(dfs(i, j, maps));
                }
            }
        }
        Collections.sort(answer);
        if (answer.isEmpty()) answer.add(-1);
        return answer.stream().mapToInt(x->x).toArray();
    }
}