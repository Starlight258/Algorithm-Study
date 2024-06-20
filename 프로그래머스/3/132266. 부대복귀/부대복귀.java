import java.util.*;
class Solution {
    class Node implements Comparable<Node>{
        int idx;
        int cost;
        Node (int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
        public int compareTo(Node n){
            return this.cost - n.cost;
        }
    }
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        List<List<Integer>> edges = new ArrayList<>();
        for (int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }
        for (int[] road:roads){
            edges.get(road[0]).add(road[1]);
            edges.get(road[1]).add(road[0]);
        }
        int[] dist = new int[n+1];
        for (int i=0;i<=n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        // 다익스트라 알고리즘
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(destination, 0));
        dist[destination] = 0;
        
        while (!pq.isEmpty()){
            Node cur = pq.poll();
            
            if (dist[cur.idx] < cur.cost) continue;
            
            for (Integer next:edges.get(cur.idx)){
                if (dist[next] > cur.cost + 1){
                    dist[next] = cur.cost + 1;
                    pq.offer(new Node(next, dist[next]));
                }
            }
        }
        
        // source만큼 정답 구하기
        for (int i=0;i<sources.length;i++){
            answer[i] = dist[sources[i]] == Integer.MAX_VALUE ? -1 : dist[sources[i]];
        }
        return answer;
    }
}