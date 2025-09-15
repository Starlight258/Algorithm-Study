import java.util.*;

class Solution {
    
    class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;
        
        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight=weight;
        }
        
        public int compareTo(final Edge o){
            return this.weight - o.weight;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<Edge> edges = new ArrayList<>();
        for (int i=0;i<costs.length;i++){
            edges.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
            edges.add(new Edge(costs[i][1], costs[i][0], costs[i][2]));
        }
        Collections.sort(edges);
        int total = 0;
        UnionFind unionFind = new UnionFind(n);
        for (Edge edge:edges){
            int from = edge.from;
            int to = edge.to;
            if (!unionFind.isConnected(from, to)){
                unionFind.union(from, to);
                total += edge.weight;
            }
        }
        
        return total;
    }
    
    class UnionFind{
        
        int[] parent;
        
        public UnionFind(int n){
            parent = new int[n+1];
            for (int i=1;i<=n;i++){
                parent[i]=i;
            }
        }
        
        public int find(int x){
            if (parent[x]!=x){
                return parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY){
                return false;
            }
            if (rootX != rootY){
                if (rootX < rootY){
                    parent[rootY] = rootX;
                } else {
                    parent[rootX] = rootY;
                }
            }
            return true;
        }
        
        public boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }
    // MST(최소 간선 트리)
}