import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 1_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dist = new int[101];
        Arrays.fill(dist, -1);
        int[] link = new int[101];
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            link[s] = e;
        }
        Queue<Integer> q = new ArrayDeque<>();
        dist[1] = 0;
        q.offer(1);

        while (!q.isEmpty()) {
            Integer cur = q.poll();
            if (cur == 100) {
                break;
            }
            for (int i = 1; i <= 6; i++) {
                int v = cur + i;
                if (v > 100) {
                    continue;
                }
                if (link[v] != 0) {
                    v = link[v]; // 텔레포트
                }
                if (dist[v] != -1) { // 이미 간 거리는 패스
                    continue;
                }
                dist[v] = dist[cur] + 1; // 주사위
                q.offer(v);
            }
        }

        System.out.println(dist[100]);
    }

    // 1 -> 6 (주사위)
    // 6 -> 12 (주사위)
    // 12 -> 98 (사다리)
    // 98 -> 100 (주사위)

    // 1 -> 6 -> 80
    // 80 -> 86
    // 86 -> 92
    // 92 -> 98
    // 98 -> 100

    // 사다리로 올라갈 수도, 뱀으로 인해 내려갈 수도 있다. (다익스트라 최단 경로 X)
    // 모든 경우 -> 최단거리이므로 bfs?
    // bfs : 가장 작은 거리부터
    // dp? : dp[i] = Math.min(dp[i], dp[u]+1);
}
