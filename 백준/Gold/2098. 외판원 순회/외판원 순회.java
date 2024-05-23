import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 987654321;

    static int n;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(tsp(0, 1));

    }

    private static int tsp(int here, int visited) {
        if (visited == (1 << n) - 1) {
            return map[here][0] != 0 ? map[here][0] : INF;
        }

        if (dp[here][visited] != -1) {
            return dp[here][visited];
        }

        int ret = INF;
        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) != 0) {
                continue;
            }
            if (map[here][i] == 0) {
                continue;
            }

            ret = Math.min(ret, tsp(i, visited | (1 << i)) + map[here][i]);
        }

        return dp[here][visited] = ret;
    }
}
