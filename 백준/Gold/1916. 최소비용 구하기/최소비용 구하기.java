import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int idx;
        int cost;

        public Node(final int idx, final int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.offer(new Node(start, 0));
        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.idx == end) {
                System.out.println(cur.cost);
                return;
            }
            if (dist[cur.idx] < cur.cost) {
                continue;
            }
            for (int i = 0; i < list.get(cur.idx).size(); i++) {
                Node next = list.get(cur.idx).get(i);
                int cost = cur.cost + next.cost;
                if (cost < dist[next.idx]) {
                    dist[next.idx] = cost;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        System.out.println(dist[end]);
    }
}
