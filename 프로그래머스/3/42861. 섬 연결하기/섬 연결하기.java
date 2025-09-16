import java.util.*;

class Solution {
    
    public class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;
        
        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        public int compareTo(final Edge o){
            return this.cost - o.cost;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<Edge> edges = new ArrayList<>();
        for (int[] cost:costs){
            edges.add(new Edge(cost[0], cost[1], cost[2]));
            edges.add(new Edge(cost[1], cost[0], cost[2]));
        }
        
        UnionFind unionFind = new UnionFind(n);
        Collections.sort(edges);
        
        for (Edge edge:edges){
            int from = edge.from;
            int to = edge.to;
            
            if (!unionFind.isConnected(from, to)){
                unionFind.union(from, to);
                answer += edge.cost;
            }
        }
        return answer;
    }
    
    class UnionFind {
        
        int[] parent;
        
        UnionFind(int size){
            this.parent = new int[size];
            for (int i=0;i<size;i++){
                parent[i] = i;
            }
        }
        
        public int find(int x){
            if (parent[x]!=x){
                return parent[x] = find(parent[x]);
            }
            
            return x;
        }
        
        public boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY){
                return false;
            }
            
            if (rootX < rootY){
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
            }
            return true;
        }
        
        public boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }
    // 모든 섬(노드) 연결 -> MST
    // 크루스칼 : union find 
}