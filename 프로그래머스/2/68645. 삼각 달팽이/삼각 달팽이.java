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
            while (nextY<n && graph[nextY][nextX]==0){
                graph[nextY][nextX] = ++num;
                nextY++;
            }
            nextY--; nextX++;
            
            // 2. 오른쪽으로 쭉 가기
            while (nextX<n && graph[nextY][nextX]==0){
                graph[nextY][nextX] = ++num;
                nextX++;
            }
            nextY--; nextX-=2;
            
            // 3. 대각선으로 올라가기
            while (nextY>=0 && nextX>=0 && graph[nextY][nextX]==0){
                graph[nextY][nextX] = ++num;
                nextY--; nextX--;
            }
            nextY+=2; nextX++;
            
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