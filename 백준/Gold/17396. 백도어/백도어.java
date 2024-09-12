import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] views = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<List<int[]>> edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            edges.get(a).add(new int[]{b, t});
            edges.get(b).add(new int[]{a, t});
        }

        long[] dist = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Long.MAX_VALUE;
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1])); // 거리 오름차순
        pq.offer(new long[]{0, 0});
        dist[0] = 0;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int curNode = (int) cur[0];
            if (curNode == n - 1) {
                break;
            }
            long curCost = cur[1];

            if (dist[curNode] < curCost) {
                continue;
            }

            for (int[] next : edges.get(curNode)) {
                int nextNode = next[0];
                if (views[nextNode] == 1 && nextNode != n - 1) {
                    continue;
                }
                int nextCost = next[1];
                if (dist[nextNode] > curCost + nextCost) {
                    dist[nextNode] = curCost + nextCost;
                    pq.offer(new long[]{nextNode, dist[nextNode]});
                }
            }
        }

        System.out.println(dist[n - 1] == Long.MAX_VALUE ? -1 : dist[n - 1]);
    }
}
