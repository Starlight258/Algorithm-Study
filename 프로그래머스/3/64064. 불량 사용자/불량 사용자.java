import java.util.*;
class Solution {
    Set<List<Integer>> answers = new HashSet<>();
    
    boolean check(String ban, String user){
        if (ban.length() != user.length()) return false;
        
        int pos = -1;
        for (char b:ban.toCharArray()){
            pos++;
            if (b == '*'){
                continue;
            }
            if (b != user.charAt(pos)) return false;
        }
        return true;
    }
    
    void dfs(int depth, List<List<Integer>> indexes, List<Integer> result, boolean[] visited){
        if (depth == indexes.size()){
            Collections.sort(result);
            if (!answers.contains(result)) answers.add(new ArrayList<>(result));
            return;
        }
        for (int i=0;i<indexes.get(depth).size();i++){
            if (visited[indexes.get(depth).get(i)]) continue;
            
            visited[indexes.get(depth).get(i)] = true;
            result.add(indexes.get(depth).get(i));
            dfs(depth+1, indexes, result, visited);
            result.remove(indexes.get(depth).get(i));
            visited[indexes.get(depth).get(i)] = false;
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        // 1.패턴 매칭 문자열 인덱스 저장
        List<List<Integer>> indexes = new ArrayList<>();
        for (int i=0;i<banned_id.length;i++){
            indexes.add(new ArrayList<Integer>());
        }
        
        for (int i=0;i<banned_id.length;i++){
            for (int j=0;j<user_id.length;j++){
                if (check(banned_id[i], user_id[j])){
                    indexes.get(i).add(j);
                }
            }
        }
        
        //2. 완전탐색
        boolean[] visited = new boolean[user_id.length];
        dfs(0, indexes, new ArrayList<>(), visited);
        
        //3. 정답 출력
        return answers.size();
    }
}