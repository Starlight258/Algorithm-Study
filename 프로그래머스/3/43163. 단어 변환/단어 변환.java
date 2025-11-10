import java.util.*;

class Solution {
    
    private int n;
    private int answer;
    private boolean[] visited;
    private boolean hasAnswer = false;
    
    public int solution(String begin, String target, String[] words) {
        n = words.length;
        answer = n;
        visited = new boolean[n];
        List<String> list = new ArrayList<>();
             
        dfs(begin, list, 0, target, words);
        
        if (!hasAnswer){
            return 0;
        }
        
        return answer;
    }
    
    private void dfs(String cur, List<String> ways, int start, String target, String[] words){
        if (ways.size()==n){
            return;
        }
        if (cur.equals(target)){
            answer = Math.min(answer, ways.size());
            hasAnswer = true;
            return;
        }
        for (int i=0;i<words.length;i++){
            String next = words[i];
            if (visited[i]) continue;
            // begin -> words 돌면서 한단어 차이나면 그 다음 depth로
            if (isDiffOne(cur, next)){
                ways.add(cur);
                visited[i]= true;
                dfs(next, ways, i+1, target, words);
                ways.remove(ways.size()-1);   
                visited[i]= false;
            }
        }
    }
    
    private boolean isDiffOne(String a, String b){
        char[] ar = a.toCharArray();
        char[] br = b.toCharArray();
        int count = 0;
        for (int i=0;i<ar.length;i++){
            if (ar[i] != br[i]){
                count++;
                if (count>1) break;
            }
        }
        if (count!=1) return false;
        return true;
    }
        
    // begin -> target : 가장 짧은 변환 과정
    // 50P50 = 너무 많음, 근데 백트래킹이라면 괜찮을지도 ? 
    // begin -> words 돌면서 한단어 차이나면 그 다음 depth로
    // target 찾으면 단계 반환
    // 가장 적은 단계 횟수 return -> 완전 탐색
}