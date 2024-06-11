import java.util.*;
class Solution {
    public boolean checkWord(String s1, String s2){
        int cnt = 0;
        for (int i=0;i<s1.length();i++){
            if (s1.charAt(i) != s2.charAt(i)) cnt++;
            if (cnt>1) return false; 
        }
        return true;
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        // bfs 수행
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[words.length];
        Arrays.fill(visited, 0);
        int targetIdx = -1;
        for (int i=0;i<words.length;i++){
            if (checkWord(words[i], begin)){
                q.add(i);
                visited[i] = 1;
            }
            if (words[i].equals(target)){
                targetIdx = i;
            }
        }
        if (targetIdx<0) return 0;
        
        
        while (!q.isEmpty()){
            int cur = q.poll();
            
            if (cur==targetIdx) break;
            for (int i=0;i<words.length;i++){
                if (i==cur) continue;
                if (visited[i]==0 && checkWord(words[i], words[cur])){
                    q.add(i);
                    visited[i] = visited[cur]+1;
                }
            }
        }
        
        // 정답        
        return visited[targetIdx];
    }
}