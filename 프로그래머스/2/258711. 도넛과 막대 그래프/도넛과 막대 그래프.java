import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = {};
        int n = 1;
        int startPoint = 1;
        // 출발점 찾기
        for (int[] edge:edges){
            n = Math.max(n, Math.max(edge[0], edge[1]));
        }
        // 정점별 indegree 수 구하기
        int[] indegree = new int[n+1];
        int[] outdegree = new int[n+1];
        
        // 총 그래프 수
        for (int[] edge:edges){
            outdegree[edge[0]]++;
            indegree[edge[1]]++;
        }
        for (int i=1;i<=n;i++){
            if (outdegree[i]>=2 && indegree[i]==0){
                startPoint = i;
                break;
            }
        }
        // 개수 구하기
        boolean[] notUsed = new boolean[n+1];
        Arrays.fill(notUsed, true);
        int total = outdegree[startPoint];
        for (int[] edge:edges){
            if (edge[0] == startPoint){
                indegree[edge[1]]--;
            }
            notUsed[edge[0]] = false;
            notUsed[edge[1]] = false;
        }
        
        int stick = 0, eight = 0;
        for (int i=1;i<=n;i++){
            if (notUsed[i]) continue;
            if (indegree[i]==2 && outdegree[i]==2){
                eight++;
                continue;
            } 
            if (outdegree[i] == 0){
                stick++;
                continue;
            }
        }
       
        answer = new int[]{startPoint, total-stick-eight, stick, eight};
        return answer;
    }
}