import java.util.*;

class Solution {
    
    public class UF {
        int[] parent;

        public UF(int n){
            parent = new int[n];
            for (int i=0;i<n;i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            if (parent[x] != x){
                return parent[x] = find(parent[x]);
            }
            return x;
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY){
                return;
            }
            if (rootX < rootY){
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        UF uf = new UF(n);
        for (int[] computer:computers){
            for (int i=0;i<n;i++){
                if (computer[i]==0){
                    continue;
                }
                for (int j=i+1;j<n;j++){
                    if (computer[j]==1){
                        uf.union(i, j);
                    }
                }
            }
        }
        
        Set<Integer> answers = new HashSet<>();
        for (int i=0;i<n;i++){
            answers.add(uf.find(i));
        }
        return answers.size();
    }
    
    // union find -> 같은 집합에 있을 경우 같은 루트 노드 가진다.
}