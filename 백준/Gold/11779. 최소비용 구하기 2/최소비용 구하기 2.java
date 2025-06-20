import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 1_000_000_000;
    private static final List<List<Node>> graph = new ArrayList<>();
    private static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        d = new int[n + 1];
        Arrays.fill(d, INF);
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 다익스트라
        dijkstra(start, end);
    }

    private static void dijkstra(final int start, final int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0, new ArrayList<>(List.of(start))));
        d[start] = 0;
        while (!pq.isEmpty()) {
            Node wayPoint = pq.poll();
            int wayPointIndex = wayPoint.index;
            int wayPointDistance = wayPoint.distance;
            if (d[wayPointIndex] < wayPointDistance) {
                continue;
            }
            if (wayPointIndex == end) {
                System.out.println(d[end]);
                System.out.println(wayPoint.path.size());
                for (Integer node : wayPoint.path) {
                    System.out.print(node + " ");
                }
                System.out.println();
            }
            for (Node destination : graph.get(wayPointIndex)) {
                int destinationIndex = destination.index;
                int cost = d[wayPointIndex] + destination.distance;
                if (d[destinationIndex] > cost) {
                    d[destinationIndex] = cost;
                    ArrayList<Integer> addedPath = new ArrayList<>(wayPoint.path);
                    addedPath.add(destinationIndex);
                    pq.offer(new Node(destinationIndex, cost, addedPath));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        private final int index;
        private final int distance;
        private final List<Integer> path;

        public Node(final int index, final int distance) {
            this.index = index;
            this.distance = distance;
            this.path = new ArrayList<>();
        }

        public Node(final int index, final int distance, final List<Integer> path) {
            this.index = index;
            this.distance = distance;
            this.path = path;
        }

        @Override
        public int compareTo(final Node o) {
            return this.distance - o.distance;
        }
    }

}
