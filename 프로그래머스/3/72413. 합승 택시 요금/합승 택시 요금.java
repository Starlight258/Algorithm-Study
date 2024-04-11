import java.util.*;
class Solution {
    class Node implements Comparable<Node>{
        int index;
        int dist;
        Node(int index, int dist){
            this.index = index;
            this.dist = dist;
        }
        public int compareTo(Node n){
            return this.dist - n.dist;
        }
    }
    ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    int[] dijkstra(int start, int n){
        int[] d = new int[n+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while (!pq.isEmpty()){
            Node node = pq.poll();
            int dist = node.dist;
            int now = node.index;
            if (d[now] < dist) continue;
            for (int i=0;i<graph.get(now).size();i++){
                int cost = d[now] + graph.get(now).get(i).dist;
                if (cost < d[graph.get(now).get(i).index]){
                    d[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
        return d;
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int INF = 987654321;
        for (int i=0;i<=n;i++){
            graph.add(new ArrayList<Node>());
        }
        for (int i=0;i<fares.length;i++){
            graph.get(fares[i][0]).add(new Node(fares[i][1], fares[i][2]));
            graph.get(fares[i][1]).add(new Node(fares[i][0], fares[i][2]));
        }
        
        int[] fromS = dijkstra(s, n);
        int[] fromA = dijkstra(a, n);
        int[] fromB = dijkstra(b, n);
        
        answer = fromS[a] + fromS[b];
        for (int i=1;i<=n;i++){
            if (i==s) continue;
            answer = Math.min(answer, fromS[i] + fromA[i] + fromB[i]);
        }
        return answer;
    }
}