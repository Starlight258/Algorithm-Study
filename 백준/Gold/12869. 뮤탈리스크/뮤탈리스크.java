import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] scvs;
    static int[][][] dp;
    static int[][] cases = {
            {-9, -3, -1},
            {-9, -1, -3},
            {-3, -9, -1},
            {-3, -1, -9},
            {-1, -9, -3},
            {-1, -3, -9}
    };

    private static int dfs(int s1, int s2, int s3) {
        if (s1 == 0 && s2 == 0 && s3 == 0) {
            return 0;
        }

        if (dp[s1][s2][s3] != Integer.MAX_VALUE) {
            return dp[s1][s2][s3];
        }

        for (int i = 0; i < cases.length; i++) {
            int ns1 = Math.max(0, s1 + cases[i][0]);
            int ns2 = Math.max(0, s2 + cases[i][1]);
            int ns3 = Math.max(0, s3 + cases[i][2]);
            dp[s1][s2][s3] = Math.min(dp[s1][s2][s3],
                    1 + dfs(ns1, ns2, ns3));
        }
        return dp[s1][s2][s3];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        scvs = new int[3];
        for (int i = 0; i < n; i++) {
            scvs[i] = Integer.parseInt(st.nextToken());
        }

        // dp 수행
        dp = new int[61][61][61];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        System.out.println(dfs(scvs[0], scvs[1], scvs[2]));
    }
}
