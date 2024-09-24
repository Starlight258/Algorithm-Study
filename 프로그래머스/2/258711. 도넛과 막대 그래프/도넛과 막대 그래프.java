import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = {};
        int n = 1_000_000;
        int startPoint = 0;
        int[] indegree = new int[n];
        int[] outdegree = new int[n];
        
        for (int[] edge:edges){
            outdegree[edge[0]-1]++;
            indegree[edge[1]-1]++;
        }
        
        int stick = 0, eight = 0;
        for (int i=0;i<n;i++){
            if (outdegree[i]>=2){
                if (indegree[i]==0){
                    startPoint = i;                
                } else eight++;
            } else if (indegree[i]>0 && outdegree[i] == 0){
                stick++;
            }
        }
      
        answer = new int[]{startPoint+1, outdegree[startPoint]-stick-eight, stick, eight};
        return answer;
    }
}