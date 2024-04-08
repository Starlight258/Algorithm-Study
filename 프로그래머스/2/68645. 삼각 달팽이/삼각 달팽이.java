import java.util.*;
class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int[][] graph = new int[n][n];
        int num = 0;
        int nextY = 0;
        int nextX = 0;
        while (true){
            // 1. 아래로 내려가기
            for (int y=nextY,x=nextX;y<n;y++){
                if (graph[y][x]>0) break;
                graph[y][x] = ++num;
                nextY = y;
                nextX = x;
            }
            if (nextX+1>=n) break;
            nextX++;
            
            // 2. 오른쪽으로 쭉 가기
            for (int x=nextX, y= nextY;x<n;x++){
                if (graph[y][x]>0) break;
                graph[y][x] = ++num;
                nextY = y;
                nextX = x;
            }
            if (nextY-1<=0 || nextX-1<=0) break;
            nextY--; nextX--;
            
            // 3. 대각선으로 올라가기
            for (int x=nextX,y =nextY;y>=0;y--,x--){
                if (graph[y][x]>0) break;
                graph[y][x] = ++num;
                nextY = y;
                nextX = x;
            }
            nextY++;
            
            if (nextY>=n||nextX>=n||nextY<0||nextX<0) break;
            if (graph[nextY][nextX]>0) break;
        }
        // 정답 출력
        for (int i=0;i<n;i++){
            for (int j=0;j<=i;j++){
                answer.add(graph[i][j]);
            }
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
}