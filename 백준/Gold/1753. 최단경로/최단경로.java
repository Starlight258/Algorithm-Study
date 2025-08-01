import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 900_000_000;

    public static class Node implements Comparable<Node> {
        int number;
        int distance;

        public Node(final int number, final int distance) {
            this.number = number;
            this.distance = distance;
        }

        @Override
        public int compareTo(final Node o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        List<List<Node>> lines = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            lines.add(new ArrayList<>());
        }
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            Node node = new Node(v2, w);
            lines.get(v1).add(node);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(k, 0));
        int[] d = new int[v + 1];
        Arrays.fill(d, INF);
        d[k] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int number = node.number;
            int distance = node.distance;

            for (Node next : lines.get(number)) {
                int nextNumber = next.number;
                int nextDistance = next.distance;
                if (d[nextNumber] < distance) {
                    continue;
                }
                int di = d[number] + nextDistance;
                if (di < d[nextNumber]) {
                    d[nextNumber] = di;
                    pq.offer(new Node(nextNumber, d[nextNumber]));
                }
            }
        }
        for (int i = 1; i <= v; i++) {
            if (d[i] == INF) {
                System.out.println("INF");
                continue;
            }
            System.out.println(d[i]);
        }

    }

}
