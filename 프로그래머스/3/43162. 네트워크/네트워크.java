import java.util.*;

class Solution {
    List<List<Integer>> list;
    boolean[] visited;
    void dfs(int e){
        for (Integer l:list.get(e)){
            if (!visited[l]){
                visited[l] = true;
                dfs(l);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // 1. 원소별 인접리스트 저장하기
        list = new ArrayList<>();
        for (int i=0;i<computers.length;i++){
            list.add(new ArrayList<>());
            for (int j=0;j<computers[i].length;j++){
                if (i!=j && computers[i][j]==1) list.get(i).add(j);
            }
        }
        //2. dfs 수행
        visited = new boolean[computers.length];
        for (int i=0;i<computers.length;i++){
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
}