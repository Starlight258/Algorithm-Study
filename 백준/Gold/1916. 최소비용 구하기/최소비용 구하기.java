import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = (int) 1e9;

    static class Edge implements Comparable<Edge> {

        int node;
        int weight;

        public Edge(final int node, final int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(final Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Edge>> edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.get(s).add(new Edge(e, cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        Queue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int node = edge.node;
            int weight = edge.weight;

            if (dist[node] < weight) {
                continue;
            }
            for (Edge next : edges.get(node)) {
                int nextNode = next.node;
                int nextWeight = next.weight;
                if (dist[nextNode] > dist[node] + nextWeight) {
                    dist[nextNode] = dist[node] + nextWeight;
                    pq.offer(new Edge(nextNode, dist[nextNode]));
                }

            }
        }
        System.out.println(dist[end]);
    }
}
