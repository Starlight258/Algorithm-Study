import java.util.*;
class Solution {
    boolean[] visited;
    PriorityQueue<Integer> pq;
    void dfs(int current, int[] cards, int cnt){
        visited[current] = true;
        int nextPos = cards[current]-1;
        if (visited[nextPos]){
            pq.offer(cnt);
            return;
        }
        dfs(nextPos, cards, cnt+1);
    }
    public int solution(int[] cards) {
        int answer = 0;
        visited = new boolean[cards.length];
        Arrays.fill(visited, false);
        pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for (int i=0;i<cards.length;i++){
            if (!visited[cards[i]-1]){
                dfs(i, cards,1);
            }
        }
        
        if (pq.size()<2) return 0;
        answer = pq.poll() * pq.poll();
        return answer;
    }
}