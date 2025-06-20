import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = (int) 1e9;
    private static int[][] graph;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[s][e] = Math.min(graph[s][e], cost);
        }

        floyd();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == INF) {
                    System.out.print("0 ");
                    continue;
                }
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void floyd() {
        for (int wayPoint = 1; wayPoint <= n; wayPoint++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    int wayPointDistance = graph[start][wayPoint] + graph[wayPoint][end];
                    graph[start][end] = Math.min(graph[start][end], wayPointDistance);
                }
            }
        }
    }
}
