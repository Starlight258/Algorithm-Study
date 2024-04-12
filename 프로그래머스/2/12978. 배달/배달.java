import java.util.*;
class Solution {
    class Node implements Comparable<Node>{
        int idx;
        int dist;
        Node(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }
        public int compareTo(Node n){
            return this.dist - n.dist;
        }
        
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
        for (int i=0;i<=N;i++){
            list.add(new ArrayList<Node>());
        }
        for (int i=0;i<road.length;i++){
            list.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
            list.get(road[i][1]).add(new Node(road[i][0], road[i][2]));
        }
        int d[] = new int[N+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(1, 0));
        while (!pq.isEmpty()){
            Node node = pq.poll();
            int now = node.idx;
            int dist = node.dist;
            if (d[now]<dist) continue;
            for (int i=0;i<list.get(now).size();i++){
                int cost = d[now] + list.get(now).get(i).dist;
                if (cost < d[list.get(now).get(i).idx]){
                    d[list.get(now).get(i).idx] = cost;
                    pq.offer(new Node(list.get(now).get(i).idx, cost));
                }
            }
        }
        for (int i=1;i<=N;i++){
            if (d[i] <= K) answer++;
        }
        return answer;
    }
}