import java.util.*;

class Solution {
    
    class UF {
        
        int[] parent;
        
        UF (int n){
            parent = new int[n];
            for (int i=0;i<n;i++){
                parent[i] = i;
            }
        }
        
        public void union(int a, int b){
            int pa = find(a);
            int pb = find(b);
            if (pa != pb){
                if (pa<pb){
                    parent[pb] = pa;
                } else {
                    parent[pa] = pb;
                }
            }
        }
        
        private int find(int node){
            if (parent[node]!=node){
                return parent[node] = find(parent[node]);
            }
            
            return node;
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        UF uf = new UF(n);
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (computers[i][j]==1){
                     uf.union(i, j);
                }
            }
        }
                
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<n;i++){
            set.add(uf.find(i));
        }
        
        return set.size();
    }
}