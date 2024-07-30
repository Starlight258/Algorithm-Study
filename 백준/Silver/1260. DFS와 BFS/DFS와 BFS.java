import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int v;
    static int[] visited;
    static List<List<Integer>> edges;
    static StringBuilder sb;

    private static void dfs(int cur) {
        visited[cur] = 1;
        sb.append(cur).append(" ");
        for (Integer next : edges.get(cur)) {
            if (visited[next] == 0) {
                dfs(next);
            }
        }
    }

    private static void bfs() {
        Queue<Integer> pq = new LinkedList<>();
        pq.add(v);
        visited[v] = 1;
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(" ");

            for (Integer next : edges.get(cur)) {
                if (visited[next] == 0) {
                    visited[next] = visited[cur] + 1;
                    pq.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges.get(a).add(b);
            edges.get(b).add(a);
        }
        for (List<Integer> edge : edges) {
            Collections.sort(edge);
        }
        visited = new int[n + 1];
        sb = new StringBuilder();
        //dfs
        dfs(v);
        System.out.println(sb);

        // bfs
        Arrays.fill(visited, 0);
        sb = new StringBuilder();
        bfs();
        System.out.println(sb);
    }
}
