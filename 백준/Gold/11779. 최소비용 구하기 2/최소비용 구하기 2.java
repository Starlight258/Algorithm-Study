import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 1_000_000_000;

    static class Edge implements Comparable<Edge> {
        int v;
        int w;

        public Edge(final int v, final int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(final Edge o) {
            return this.w - o.w;
        }
    }

    private static int n;
    private static int m;
    private static int[] dist;
    private static int[] prev;
    private static List<List<Edge>> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dist = new int[n + 1];
        prev = new int[n + 1];
        Arrays.fill(dist, INF);
        m = Integer.parseInt(br.readLine());
        edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.get(u).add(new Edge(v, w));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
        System.out.println(dist[end]);

        showPath(end);
    }

    private static void showPath(final int end) {
        List<Integer> paths = new ArrayList<>();
        int c = end;
        while (c != 0) {
            paths.add(c);
            c = prev[c];
        }
        System.out.println(paths.size());
        Collections.reverse(paths);
        StringBuilder sb = new StringBuilder();
        for (Integer path : paths) {
            sb.append(path).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void dijkstra(final int start, final int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge curEdge = pq.poll();
            int curV = curEdge.v;
            if (dist[curV] != curEdge.w) {
                continue;
            }
            if (curV == end) {
                break;
            }
            for (Edge nextEdge : edges.get(curV)) {
                int curWeight = dist[curV] + nextEdge.w;
                int nextV = nextEdge.v;
                if (dist[nextV] > curWeight) {
                    dist[nextV] = curWeight;
                    pq.offer(new Edge(nextV, curWeight));
                    prev[nextV] = curV;
                }
            }
        }

    }

}
