import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] cost;
    static int[][] dp;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cost = new int[n][n];
        dp = new int[1 << n][n]; // visited, current

        for (int i = 0; i < 1 << n; i++) {
            Arrays.fill(dp[i], -1);
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(tsp(1, 0));
    }

    private static int tsp(final int visited, final int current) {
        if (visited == (1 << n) - 1) { // 모든 도시를 방문했으면
            if (cost[current][0] == 0) { // 비용이 없으면 방문 못한것임
                return INF;
            }
            return cost[current][0];
        }

        if (dp[visited][current] != -1) {
            return dp[visited][current];
        }

        int min = INF;
        for (int next = 0; next < n; next++) {
            if ((visited & (1 << next)) == 0 && cost[current][next] != 0) {
                int newVisited = visited | (1 << next);
                min = Math.min(min, tsp(newVisited, next) + cost[current][next]);
            }
        }
        return dp[visited][current] = min;
    }
}
