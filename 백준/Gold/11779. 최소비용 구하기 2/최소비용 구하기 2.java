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

    static class Node implements Comparable<Node> {
        int edge;
        int cost;

        public Node(final int edge, final int cost) {
            this.edge = edge;
            this.cost = cost;
        }

        @Override
        public int compareTo(final Node o) {
            return Integer.compare(cost, o.cost);
        }
    }

    private static int n;
    private static int m;
    private static int[] dist;
    private static int[] prev;
    private static List<List<Node>> nodes;
    private static int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dist = new int[n + 1];
        prev = new int[n + 1];
        Arrays.fill(dist, INF);
        m = Integer.parseInt(br.readLine());
        nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            nodes.get(s).add(new Node(e, cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstraPsS(start);
        System.out.println(dist[end]);

        int curEdge = end;
        List<Integer> path = new ArrayList<>();
        while (curEdge != 0) {
            path.add(curEdge);
            curEdge = prev[curEdge];
        }
        Collections.reverse(path);
        System.out.println(path.size());
        StringBuilder sb = new StringBuilder();
        for (Integer p : path) {
            sb.append(p).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void dijkstraPsS(final int start) {
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int curEdge = curNode.edge;
            if (dist[curEdge] != curNode.cost) {
                continue;
            }
            for (Node next : nodes.get(curEdge)) {
                int cost = dist[curEdge] + next.cost;
                int nextEdge = next.edge;
                if (dist[nextEdge] > cost) {
                    dist[nextEdge] = cost;
                    pq.offer(new Node(nextEdge, dist[nextEdge]));
                    prev[nextEdge] = curEdge;
                }
            }
        }

    }

    // 다익스트라
    // int[] dist : INF
    // if (dist[i] < dist[u]+w) dist[i] = dist[u]+w

}
