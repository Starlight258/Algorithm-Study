import java.util.*;

class Solution {
    
    class Node {
        int from;
        int to;
        int weight;
        Node(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<Node> nodes = new ArrayList<>();
        for (int[] cost:costs){
            nodes.add(new Node(cost[0], cost[1], cost[2]));
            nodes.add(new Node(cost[1], cost[0], cost[2]));
        }
        Collections.sort(nodes, (n1, n2)-> n1.weight - n2.weight);
        UF uf = new UF(n);
        for (Node node:nodes){
            int a = node.from;
            int b = node.to;
            if (!uf.isConnected(a, b)){
                uf.union(a, b);
                answer += node.weight;
            }
        }
        
        return answer;
    }
    
    class UF{
        int[] parent;
        UF (int n){
            parent = new int[n];
            for (int i=0;i<n;i++) parent[i] = i;
        }
        
        public void union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB){
                if (rootA<rootB){
                    parent[rootB] = rootA;
                } else {
                    parent[rootA] = rootB;
                }
            }
        }
        
        public int find(int node){
            if (parent[node]==node){
                return node;
            }
            return parent[node] = find(parent[node]);
        }
        
        public boolean isConnected(int a, int b){
            int rootA = find(a);
            int rootB = find(b);
            return rootA == rootB;
        }
    }
}