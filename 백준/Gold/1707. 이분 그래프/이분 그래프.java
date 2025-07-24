import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j <= v; j++) {
                graph.add(new ArrayList<>());
            }
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }
            int[] visited = new int[v + 1];
            boolean isDivisible = true;
            for (int j = 1; j <= v; j++) {
                if (visited[j] == 0) {
                    isDivisible = bfs(visited, j, graph);
                    if (!isDivisible) {
                        System.out.println("NO");
                        break;
                    }
                }
            }
            if (isDivisible) {
                System.out.println("YES");
            }
        }
    }

    private static boolean bfs(final int[] visited, final int v, final List<List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = 1;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            for (Integer next : graph.get(node)) {
                if (visited[next] == 0) {
                    visited[next] = -visited[node];
                    queue.offer(next);
                } else if (visited[next] == visited[node]) {
                    return false;
                }
            }
        }
        return true;
    }

}
