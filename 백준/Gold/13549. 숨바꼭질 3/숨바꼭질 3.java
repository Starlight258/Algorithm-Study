import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dist = new int[INF + 1];
        Arrays.fill(dist, INF);
        Queue<Integer> q = new ArrayDeque<>();
        dist[n] = 0;
        q.offer(n);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == k) {
                break;
            }
            if (dist[cur] == INF) {
                continue;
            }
            if (cur - 1 >= 0 && dist[cur - 1] > dist[cur] + 1) {
                dist[cur - 1] = dist[cur] + 1;
                q.offer(cur - 1);
            }
            if (cur + 1 <= INF && dist[cur + 1] > dist[cur] + 1) {
                dist[cur + 1] = dist[cur] + 1;
                q.offer(cur + 1);
            }
            if (cur * 2 <= INF && dist[cur * 2] > dist[cur]) {
                dist[cur * 2] = dist[cur];
                q.offer(cur * 2);
            }
        }
        System.out.println(dist[k]);
    }
    // bfs -> 최단거리
    // +, - 방향 가능 -> 큐 사용
    // dist
}
