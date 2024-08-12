import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static int[] times;
    static List<List<Integer>> adj;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            times = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            indegree = new int[n + 1];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj.get(a).add(b);
                indegree[b]++;
            }

            int w = Integer.parseInt(br.readLine());

            topologySort(w);
        }
    }

    private static void topologySort(int w) {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[n + 1]; // 현재 점 기준 최대시간

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                result[i] = times[i];
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Integer next : adj.get(cur)) {
                result[next] = Math.max(result[next], result[cur] + times[next]);
                if (--indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        System.out.println(result[w]);
    }
}
