import java.util.*;

class Solution {
    
    class Edge implements Comparable<Edge>{
        int node;
        int cost;
        
        Edge(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
        
        public int compareTo(Edge edge){
            return this.cost - edge.cost;
        }
    }
    
    private static int INF = (int) 1e9;
    
    public int solution(int N, int[][] roads, int K) {
        int answer = 0;
        int[] dist = new int[N+1];
        List<List<Edge>> edges = new ArrayList<>();
        Arrays.fill(dist, INF);
        for (int i=0;i<=N;i++){
            edges.add(new ArrayList<>());
        }
        for (int[] road : roads){
            int a = road[0];
            int b = road[1];
            int c = road[2];
            edges.get(a).add(new Edge(b, c));
            edges.get(b).add(new Edge(a, c));
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[1] = 0;
        pq.offer(new Edge(1, 0));
        
        while (!pq.isEmpty()){
            Edge cur = pq.poll();
            int curNode = cur.node;
            int curCost = cur.cost;
            
            if (dist[curNode] < curCost){
                continue;
            }
            
            for (Edge next:edges.get(curNode)){
                int nextNode = next.node;
                int nextCost = next.cost;

                if (dist[nextNode] > dist[curNode] + nextCost){
                    dist[nextNode] = dist[curNode] + nextCost;
                    pq.offer(new Edge(nextNode, dist[nextNode]));
                }
            }
        }
        
        for (int i=1;i<=N;i++){
            if (dist[i] <= K){
                answer++;
            }
        }
        return answer;
    }
    // 최단거리경로 : 한 지점 : 다익스트라 
    // int[] dist = INF
    // 거리별 오름차순 
    // 처음 경로부터 PriorityQueue< -> 작은 가중치순대로 정렬,
    // 하나씩 가져오기
}