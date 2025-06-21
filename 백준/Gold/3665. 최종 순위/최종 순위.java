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
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] indegree = new int[n + 1];
            String[] split = br.readLine().split(" ");
            List<Integer> scores = new ArrayList<>();
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            scores.add(0);
            for (String s : split) {
                scores.add(Integer.parseInt(s));
            }
            for (int i = 1; i <= n; i++) {
                Integer u = scores.get(i);
                for (int j = i + 1; j <= n; j++) {
                    Integer v = scores.get(j);
                    graph.get(u).add(v);
                    indegree[v]++;
                }
            }
            int m = Integer.parseInt(br.readLine());
            List<int[]> pairs = new ArrayList<>();
            StringTokenizer st;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                pairs.add(new int[]{a, b});
            }
            process(n, pairs, indegree, graph);
        }
    }

    private static void process(final int n, final List<int[]> pairs, final int[] indegree,
                                final List<List<Integer>> graph) {
        for (int[] pair : pairs) {
            int a = pair[0];
            int b = pair[1];
            if (graph.get(a).contains(b)) {
                graph.get(a).remove((Integer) b);
                indegree[b]--;
                graph.get(b).add(a);
                indegree[a]++;
            } else {
                graph.get(b).remove((Integer) a);
                indegree[a]--;
                graph.get(a).add(b);
                indegree[b]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        boolean ambiguous = false;
        for (int i = 0; i < n; i++) {
            if (queue.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            if (queue.size() > 1) {
                ambiguous = true;
            }
            int cur = queue.poll();
            result.add(cur);

            for (Integer adj : graph.get(cur)) {
                indegree[adj]--;
                if (indegree[adj] == 0) {
                    queue.offer(adj);
                }
            }
        }

        if (ambiguous) {
            System.out.println("?");
        } else {
            for (Integer node : result) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}
