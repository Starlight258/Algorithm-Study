import java.util.*;
class Solution {
    int[] parent = new int[104];
    class Node implements Comparable<Node>{
        int nodeA;
        int nodeB;
        int dist;
        Node(int nodeA, int nodeB, int dist){
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.dist = dist;
        }
        public int compareTo(Node n){
            return this.dist - n.dist;
        }
        
    }
    int findParent(int x){
        if (x==parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }
    void unionParent(int a, int b){
        a = parent[a];
        b = parent[b];
        if (a<b) parent[b] = a;
        else parent[a] = b;
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<Node> graph = new ArrayList<Node>();
        for (int i=1;i<=n;i++) parent[i] = i;
        for (int i=0;i<costs.length;i++){
            graph.add(new Node(costs[i][0], costs[i][1], costs[i][2]));
        }
        Collections.sort(graph);
        for (int i=0;i<graph.size();i++){
            int a =graph.get(i).nodeA;
            int b = graph.get(i).nodeB;
            if (findParent(a) != findParent(b)){
                unionParent(a, b);
                answer += graph.get(i).dist;
            }
        }
        return answer;
    }
}