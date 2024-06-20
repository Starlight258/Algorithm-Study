import java.util.*;
class Solution {
    class Node implements Comparable<Node>{
        int idx, cost;
        Node (int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
        public int compareTo(Node n){
            return this.cost - n.cost; // 비용 오름차순 
        }
    }
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for (int[] road:roads){
            list.get(road[0]).add(road[1]);
            list.get(road[1]).add(road[0]);
        }
        
        int[] dist = new int[n+1];
        for (int i=0;i<=n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        // 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(destination, 0));
        dist[destination]=0;
        
        while (!pq.isEmpty()){
            Node cur = pq.poll();
            if (dist[cur.idx] < cur.cost) continue;
        
            for (Integer next:list.get(cur.idx)){
                if (dist[next] > cur.cost+1){
                    dist[next] = cur.cost + 1;
                    pq.offer(new Node(next, dist[next]));
                }
            }
        }
        
        // 최단 거리 구하기
        for (int i=0;i<sources.length;i++){
            answer[i] = dist[sources[i]] == Integer.MAX_VALUE ? -1 : dist[sources[i]];
        }
        
        return answer;
    }
}