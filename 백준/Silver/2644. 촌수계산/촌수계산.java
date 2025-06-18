import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int[] visited;
    private static List<List<Integer>> graph;
    private static int a1;
    private static int a2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        a1 = Integer.parseInt(split[0]);
        a2 = Integer.parseInt(split[1]);
        m = Integer.parseInt(br.readLine());
        visited = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        bfs(a1);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Integer node : graph.get(cur)) {
                if (visited[node] == 0) {
                    queue.offer(node);
                    visited[node] = visited[cur] + 1;
                }
                if (cur == a2) {
                    System.out.println(visited[cur] - 1);
                    return;
                }
            }
        }
        System.out.println(-1);
    }


}
