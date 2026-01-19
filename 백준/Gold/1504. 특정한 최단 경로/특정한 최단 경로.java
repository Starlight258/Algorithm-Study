import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = Integer.MAX_VALUE;
    /*
            방향성이 없는 그래프가 주어진다. 세준이는 1번 정점에서 N번 정점으로 최단 거리로 이동하려고 한다.
            또한 세준이는 두 가지 조건을 만족하면서 이동하는 특정한 최단 경로를 구하고 싶은데,
            그것은 바로 임의로 주어진 두 정점은 반드시 통과해야 한다는 것이다.

            세준이는 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다.
            하지만 반드시 최단 경로로 이동해야 한다는 사실에 주의하라.
            1번 정점에서 N번 정점으로 이동할 때, 주어진 두 정점을 반드시 거치면서 최단 경로로 이동하는 프로그램을 작성하시오.
             */
    /*
    1 -> a -> b -> 도착지
    시작점에서 도착점까지 최단거리 : 다익스트라
     */
    private static boolean canReach = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        List<List<Node>> edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.get(a).add(new Node(b, c));
            edges.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int distance1 = 0;
        int d1 = dijkstra(n, edges, 1, a);
        if (d1 == INF) {
            distance1 = d1;
        } else {
            distance1 += d1;
            int d2 = dijkstra(n, edges, a, b);
            if (d2 == INF) {
                distance1 = d2;
            } else {
                distance1 += d2;
                int d3 = dijkstra(n, edges, b, n);
                if (d3 == INF) {
                    distance1 = d3;
                } else {
                    distance1 += d3;
                }
            }
        }

        int distance2 = 0;
        d1 = dijkstra(n, edges, 1, b);
        if (d1 == INF) {
            distance2 = d1;
        } else {
            distance2 += d1;
            int d2 = dijkstra(n, edges, b, a);
            if (d2 == INF) {
                distance2 = d2;
            } else {
                distance2 += d2;
                int d3 = dijkstra(n, edges, a, n);
                if (d3 == INF) {
                    distance2 = d3;
                } else {
                    distance2 += d3;
                }
            }
        }

        if (distance1 < distance2 && distance2 != INF) {
            System.out.println(distance1);
        } else if (distance1 == INF || distance2 == INF) {
            System.out.println(-1);
        } else {
            System.out.println(distance2);
        }
    }

    private static int dijkstra(final int n, final List<List<Node>> edges, final int start, final int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] d = new int[n + 1];
        Arrays.fill(d, INF);
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int edge = cur.edge;
            int distance = cur.distance;
            for (Node next : edges.get(edge)) {
                int nextEdge = next.edge;
                int nextDistance = next.distance + distance;
                if (d[nextEdge] < nextDistance) {
                    continue;
                }
                pq.offer(new Node(nextEdge, nextDistance));
                d[nextEdge] = nextDistance;
            }
        }

        return d[end];
    }

    public static class Node implements Comparable<Node> {
        int edge;
        int distance;

        public Node(final int edge, final int distance) {
            this.edge = edge;
            this.distance = distance;
        }

        @Override
        public int compareTo(final Node o) {
            return this.distance - o.distance;
        }
    }

}
