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
    private static List<List<Integer>> graphs;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graphs = new ArrayList<>();
        visited = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graphs.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graphs.get(a).add(b);
            graphs.get(b).add(a);
        }

        int maxCount = 0;
        int answer = 0;
        int distinctCount = 0;
        bfs(1);
        for (int i = 1; i <= n; i++) {
            if (visited[i] > maxCount) {
                maxCount = visited[i];
                answer = i;
                distinctCount = 1;
            } else if (visited[i] == maxCount) {
                distinctCount++;
            }
        }
        System.out.println(answer + " " + (maxCount - 1) + " " + distinctCount);
    }

    private static void bfs(int start) {
        visited = new int[n + 1];
        visited[start] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            for (Integer next : graphs.get(node)) {
                if (visited[next] == 0) {
                    visited[next] = visited[node] + 1;
                    queue.offer(next);
                }
            }
        }
    }

}
