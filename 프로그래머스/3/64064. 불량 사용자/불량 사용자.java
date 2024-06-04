import java.util.*;
class Solution {
    Set<String> answers = new HashSet<>();
    
    boolean check(String ban, String user){
        if (ban.length() != user.length()) return false;
        
        for (int i=0;i<ban.length();i++){
            if (ban.charAt(i)!='*' && ban.charAt(i)!=user.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    void dfs(int depth, List<List<Integer>> indexes, List<Integer> result, boolean[] visited){
        if (depth == indexes.size()){
            Collections.sort(result);
            String key = result.toString();
            if (!answers.contains(result)) answers.add(key);
            return;
        }
        
        for (int idx: indexes.get(depth)){
            if (visited[idx]) continue;
            
            visited[idx] = true;
            result.add(idx);
            dfs(depth+1, indexes, result, visited);
            result.remove(Integer.valueOf(idx));
            visited[idx] = false;
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        // 1.패턴 매칭 문자열 인덱스 저장
        List<List<Integer>> indexes = new ArrayList<>();
        for (int i=0;i<banned_id.length;i++){
            List<Integer> idx = new ArrayList<>();
            for (int j=0;j<user_id.length;j++){
                if (check(banned_id[i], user_id[j])){
                    idx.add(j);
                }
            }
            indexes.add(idx);
        }
        
        //2. 완전탐색
        boolean[] visited = new boolean[user_id.length];
        dfs(0, indexes, new ArrayList<>(), visited);
        
        //3. 정답 출력
        return answers.size();
    }
}