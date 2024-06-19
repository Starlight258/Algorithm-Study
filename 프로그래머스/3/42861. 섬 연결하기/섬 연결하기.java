import java.util.*;
class Solution {
    int[] parent;
    
    class Node implements Comparable<Node>{
        int x;
        int y;
        int cost;
        Node (int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        public int compareTo(Node n){
            return Integer.compare(this.cost, n.cost);
        }
    }
        
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<Node> list = new ArrayList<>();
        for (int[] cost:costs){
            list.add(new Node(cost[0], cost[1], cost[2]));
        }
        // 비용 오름차순으로 정렬
        Collections.sort(list);
        
        // 크루스칼
        parent = new int[n];
        for (int i=0;i<n;i++){
            parent[i] = i;
        }
        // find 후 사이클 없으면 union
        for (Node node:list){
            if (find(node.x) != find(node.y)){
                union(node.x, node.y);
                answer += node.cost;
            }
        }
        return answer;
    }
    
    public int find(int x){
        if (parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public void union(int x, int y){
        x = parent[x];
        y = parent[y];
        if (x>y) parent[x] = y;
        else parent[y] = x;
    }
}