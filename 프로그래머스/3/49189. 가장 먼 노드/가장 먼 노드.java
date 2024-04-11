import java.util.*;
class Solution {
    class Node implements Comparable<Node> {
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
    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int d[] = new int[n+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        for (int i=0;i<=n;i++) graph.add(new ArrayList<Integer>());
        for (int i=0;i<edge.length;i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.offer(1);
        d[1] = 0;
        while (!pq.isEmpty()){
            int now = pq.poll();
            for (int i=0;i<graph.get(now).size();i++){
                int cost = d[now] + 1;
                if (cost < d[graph.get(now).get(i)]){
                    d[graph.get(now).get(i)] = cost;
                    pq.offer(graph.get(now).get(i));
                }
            }
        }
        int maxDist = 0;
        int cnt=1;
        for (int i=1;i<=n;i++){
            if (maxDist < d[i]){
                cnt = 0;
                maxDist = d[i];
            }
            if (maxDist == d[i]){
                cnt++;
            }
        }
        return cnt;
    }
}