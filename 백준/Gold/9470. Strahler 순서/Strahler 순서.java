import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int k;
    static int m;
    static int p;
    static List<Integer>[] graph;
    static int[] inDegree;
    static int[] order; //순서
    static int[] count; // 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            graph = new ArrayList[m + 1];
            inDegree = new int[m + 1];
            order = new int[m + 1];
            count = new int[m + 1];
            for (int i = 0; i <= m; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < p; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                inDegree[b]++;
            }

            topologySort();
            System.out.println(k + " " + order[m]);
        }
    }

    private static void topologySort() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i <= m; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                order[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Integer next : graph[cur]) {
                if (order[next] < order[cur]) {
                    order[next] = order[cur];
                    count[next] = 1;
                } else if (order[next] == order[cur]) {
                    count[next]++;
                }

                if (--inDegree[next] == 0) {
                    q.offer(next);
                    if (count[next] > 1) {
                        order[next]++;
                    }
                }
            }
        }
    }
}
