import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[] indegree;
    private static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        indegree = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 1; j < split.length - 1; j++) {
                int e1 = Integer.parseInt(split[j]);
                int e2 = Integer.parseInt(split[j + 1]);
                graph.get(e1).add(e2);
                indegree[e2]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            Integer node = queue.poll();
            sb.append(node).append("\n");
            for (Integer next : graph.get(node)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (count < n) {
            System.out.println("0");
        }
        System.out.println(sb);
    }
}
