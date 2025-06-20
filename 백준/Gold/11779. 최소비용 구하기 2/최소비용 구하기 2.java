import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 1_000_000_000;
    private static final List<List<Node>> graph = new ArrayList<>();
    private static int[] d;
    private static int[] prevCity;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        d = new int[n + 1];
        prevCity = new int[n + 1];
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
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while (!pq.isEmpty()) {
            Node wayPoint = pq.poll();
            int wayPointIndex = wayPoint.index;
            int wayPointDistance = wayPoint.distance;
            if (d[wayPointIndex] < wayPointDistance) {
                continue;
            }
            for (Node destination : graph.get(wayPointIndex)) {
                int destinationIndex = destination.index;
                int cost = d[wayPointIndex] + destination.distance;
                if (d[destinationIndex] > cost) {
                    d[destinationIndex] = cost;
                    pq.offer(new Node(destinationIndex, cost));
                    prevCity[destinationIndex] = wayPointIndex;
                }
            }
        }
        System.out.println(d[end]);
        // 거리 역추적
        Stack<Integer> stk = new Stack<>();
        int cur = end;
        stk.add(cur);
        while (prevCity[cur] != 0) {
            cur = prevCity[cur];
            stk.push(cur);
        }
        System.out.println(stk.size());
        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }
    }

    private static class Node implements Comparable<Node> {
        private final int index;
        private final int distance;

        public Node(final int index, final int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(final Node o) {
            return this.distance - o.distance;
        }
    }

}
