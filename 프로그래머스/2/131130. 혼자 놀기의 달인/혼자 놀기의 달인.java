import java.util.*;
class Solution {
    boolean[] visited;
    int a, b;
    void dfs(int current, int[] cards, int cnt){
        visited[current] = true;
        int nextPos = cards[current]-1;
        if (visited[nextPos]){
            if (cnt>a){
                b = a;
                a = cnt;
            } else if (cnt>b) b = cnt;
            return;
        }
        dfs(nextPos, cards, cnt+1);
    }
    public int solution(int[] cards) {
        int answer = 0;
        visited = new boolean[cards.length];
        Arrays.fill(visited, false);
        a=0; b=0;
        for (int i=0;i<cards.length;i++){
            if (!visited[cards[i]-1]){
                dfs(i, cards,1);
            }
        }
        
        answer = a * b;
        return answer;
    }
}