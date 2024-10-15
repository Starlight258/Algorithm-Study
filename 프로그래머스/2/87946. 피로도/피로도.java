import java.util.*;

class Solution {
    private int n;
    private boolean[] visited;
    private int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new boolean[n];
        dfs(0, 0, k, dungeons);
        
        return answer;
    }
    private void dfs(int index, int count, int fatigue, int[][] dungeons){
        answer = Math.max(answer, count);
        
        for (int i=0;i<dungeons.length;i++){
            if (visited[i]) continue;
            if (fatigue >= dungeons[i][0]){
                visited[i] = true;
                dfs(i, count+1, fatigue-dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
    }
}

// XX 게임 - 피로도 시스템
// 일정 피로도를 사용해서 던전 탐험
// 최소 필요 피로도, 소모 피로도
// 탐험할 수 있는 최대 던전 수 구하기
// dp가 아닌 이유 : 순서가 정해지지 않았기 때문 -> 모든 순서 고려 : 완전탐색