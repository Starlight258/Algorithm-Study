import java.util.*;
class Solution {
    
    List<String> candi = new ArrayList<>();
    
    void dfs(boolean[] visited, int start, int depth, int limit, String[][] relation){
        if (depth == limit){
            // key 저장하기
            List<Integer> list = new ArrayList<>();
            String key = "";
            for (int i=0;i<visited.length;i++){
                if (visited[i]){
                    key += String.valueOf(i); // 인덱스로 저장
                    list.add(i);
                }
            }
            
            // 유일성 검사하기
            Map<String, Integer> map = new HashMap<>();
            
            for (int i=0;i<relation.length;i++){
                String s = "";
                for (Integer j:list){
                    s += relation[i][j]; // key부분 가져오기
                }
                
                if (map.containsKey(s)){ // 중복될 경우 리턴
                    return;
                } else{
                    map.put(s, 0);
                }
            }
            
            // 최소성 검사하기
            for (String c:candi){
                int count = 0;
                for (int i=0;i<list.size();i++){
                    String subKey = String.valueOf(list.get(i));
                    if (c.contains(subKey)){
                        count++;
                    }
                }
                if (count==c.length()) return; //최소성 만족X
            }
            candi.add(key);
            
            return;
        }
        
        for (int i=start;i<visited.length;i++){
            if (visited[i]) continue;
            
            visited[i] = true;
            dfs(visited, i+1, depth+1, limit, relation); 
            visited[i] = false;
        }
    }
    
    public int solution(String[][] relation) {
        int answer = 0;
        
        // 완전탐색 수행
        for (int i=0;i<relation[0].length;i++){
            boolean[] visited = new boolean[relation[0].length];
            dfs(visited, 0, 0, i+1, relation);
        }
        
        answer = candi.size();
        return answer;
    }
}