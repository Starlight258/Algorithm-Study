import java.util.*;
class Solution {
    int m;
    boolean visited[];
    int cnt = 0;
    int answer = 104;
    void dfs(int node, int separateNode, ArrayList<ArrayList<Integer>> edges){
        cnt++;
        visited[node] = true;
        for (int i=0;i<edges.get(node).size();i++){
            int nextNode = edges.get(node).get(i);
             if (!visited[nextNode] && nextNode != separateNode){
                dfs(nextNode, separateNode, edges);
            }   
        }
    }
    public int solution(int n, int[][] wires) {
        visited = new boolean[n+1];
        // 1. 노드 별 연결된 노드 저장하기
        ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
        for (int i=0;i<=n;i++){
            edges.add(new ArrayList<Integer>());
        }
        for (int i=0;i<wires.length;i++){
            edges.get(wires[i][0]).add(wires[i][1]);
            edges.get(wires[i][1]).add(wires[i][0]);
        }
        
        // 2. 두 노드 선택 후 dfs
        for (int i=1;i<=n;i++){
            for (int j=i+1;j<=n;j++){
                if (!edges.get(i).contains(j)) continue;
                Arrays.fill(visited, false);
                int num1 = 0; int num2=0;
                
                cnt = 1;
                dfs(i, j, edges);
                num1 = cnt;
                
                cnt = 1;
                dfs(j, i, edges);
                num2 = cnt;
                
                answer = Math.min(Math.abs(num1 - num2), answer);
            }
        }
        
        
        return answer;
    }
}