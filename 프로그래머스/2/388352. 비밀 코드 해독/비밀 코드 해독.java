import java.util.*;

class Solution {
    private int answer = 0;
    private boolean[] visited;
    
    public int solution(int n, int[][] q, int[] ans) {
        visited = new boolean[n+1];
        backtracking(1, n, q, ans, new ArrayList<>());
        return answer;
    }
    
    private void backtracking(int start, int n, int[][] q, int[] ans, List<Integer> target){
        if (target.size()==5){
            validateTarget(n, ans, q, target);
            return;    
        }
        if (!target.isEmpty() && target.get(target.size()-1) > start){
            return;
        }
        
        for (int i=start;i<=n;i++){
            if (!visited[i]){
                target.add(i);
                visited[i] = true;
                backtracking(i+1, n,q,ans, target);
                visited[i] = false;
                target.remove(target.size()-1);
            }
        }
    }
    
    private void validateTarget(int n, int[] ans, int[][] q, List<Integer> target){
        int m = q.length;
        for (int i=0;i<m;i++){
            int sameCount = 0;
            int[] quest = q[i];
            for (int j=0;j<5;j++){
                if (target.contains(quest[j])){
                    sameCount++;
                }
            }
            if (sameCount != ans[i]){
                return;
            }
        }

        answer++;
    }
    
    
    
}
// 1~30 : 5개 30C5 = 괜춘, 완전탐색 + 백트래킹