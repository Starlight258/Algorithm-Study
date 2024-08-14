import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static List<int[]>[] edges;
    static int[] dist;
    static long[] dp;
    static int n, m;
    static final int s = 1, t = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[a].add(new int[]{b, cost});
            edges[b].add(new int[]{a, cost});
        }

        dijkstra();

        dp = new long[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(go(s));
    }

    private static long go(int cur) {
        if (cur == t) {
            return 1;
        }
        if (dp[cur] != -1) {
            return dp[cur];
        }

        dp[cur] = 0;
        for (int[] next : edges[cur]) {
            int nextNode = next[0];
            if (dist[cur] > dist[nextNode]) {
                dp[cur] = (dp[cur] + go(nextNode));
            }
        }

        return dp[cur];
    }

    private static void dijkstra() {
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{t, 0});
        dist[t] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curCost = cur[1];

            if (dist[curNode] < curCost) {
                continue;
            }

            for (int[] next : edges[curNode]) {
                int nextNode = next[0];
                int nextCost = next[1];
                if (dist[nextNode] > dist[curNode] + nextCost) {
                    dist[nextNode] = dist[curNode] + nextCost;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
    }
}
